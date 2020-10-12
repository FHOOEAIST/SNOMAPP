package at.snomapp.skeleton.restservice;

import at.snomapp.skeleton.domain.appc.APPCEntry;
import at.snomapp.skeleton.domain.appc.APPCTree;
import at.snomapp.skeleton.domain.appc.AxisEntry;
import at.snomapp.skeleton.domain.appc.Entry;
import at.snomapp.skeleton.importer.Importer;
import at.snomapp.skeleton.importer.impl.CSVImporter;
import at.snomapp.skeleton.importer.impl.StringCSVImporter;
import at.snomapp.skeleton.repo.APPCRepo;
import io.swagger.client.JSON;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Optional;
import java.util.Set;


@RestController
@RequestMapping("/APPC")
// controller providing endpoints for importing and retrieving APPCData
public class APPCController {

    private final APPCRepo repo;


    @Autowired
    public APPCController(APPCRepo repo) {
        this.repo = repo;
    }

    @DeleteMapping
    // flushes data bank
    // to be used for debugging only
    // remove from release version
    void clearDB(){
        repo.deleteAll();
    }

    @GetMapping("entry/{id}")
    Entry readByIdentity(@PathVariable Long id){
        Optional<Entry> byId = repo.findById(id);
        return byId.orElse(null);
    }

    @GetMapping("entry")
    Iterable<Entry> readByDisplayName(@RequestParam(required = false) String displayName) {
        if (displayName == null) {
            // all entries
            return repo.findAll();
        } else {
            // return exact name match
            return repo.findAllByDisplayNameContainingIgnoreCase(displayName);
        }
    }

    @GetMapping("/getEntriesByName")
    public String entryToJsonString (@RequestParam(required = false) String displayName){
        Iterable<Entry> entries = readByDisplayName(displayName);
        APPCTree tree = new APPCTree(null);
        JSONArray jsonArray = new JSONArray();
        for(Entry entry : entries){
            jsonArray.add(tree.entryToJsonString(entry));
        }
        return jsonArray.toJSONString();
    }

    private static class ImportResults{
        private boolean worked;
        private String errorMessage;

        public ImportResults(boolean worked, String errorMessage) {
            this.worked = worked;
            this.errorMessage = errorMessage;
        }

        public boolean isWorked() {
            return worked;
        }

        public void setWorked(boolean worked) {
            this.worked = worked;
        }

        public String getErrorMessage() {
            return errorMessage;
        }

        public void setErrorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
        }
    }

    @PostMapping("/import")
    @ResponseStatus(HttpStatus.CREATED)
    // imports an APPCtree from a given filename into the neo4j database.
    // clears data bank if valid file given
    ImportResults importAPPC(@RequestBody String filename){
        try {
            String decodedPath = URLDecoder.decode(filename, StandardCharsets.UTF_8.name());
            File importFile = new File(decodedPath);
            if(importFile.isFile()){
                // file found on device
                repo.deleteAll();
                Importer importer = new CSVImporter();
                APPCTree tree = importer.importTree(decodedPath);

                // save version
                if (tree.getVersion() != null){
                    repo.save(new APPCEntry("Version", tree.getVersion()));
                }

                Iterable<Entry> roots = tree.getRoots();
                for (Entry root : roots) {
                    repo.save(root);
                }

                return new ImportResults(true, null);
            }else{
                return new ImportResults(false, "File not found");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return new ImportResults(false, "Encoding of given filepath invalid");
        } catch (Exception e) {
            e.printStackTrace();
            return new ImportResults(false, "Something went wrong during import, DB cleared");
        }
    }

    @PostMapping("/importString")
    @ResponseStatus(HttpStatus.CREATED)
    // imports an APPCTree from given string containing the entire code
    // clears database if contents are not empty
    ImportResults importAPPCString(@RequestBody String contents){
        try {
            String decodedContents = URLDecoder.decode(contents, StandardCharsets.UTF_8.name());
            if(! (decodedContents == null) && !decodedContents.isEmpty() ){
                // contents sent
                repo.deleteAll();
                Importer importer = new StringCSVImporter();
                APPCTree tree = importer.importTree(decodedContents);

                // save version
                if (tree.getVersion() != null){
                    repo.save(new APPCEntry("Version", tree.getVersion()));
                }

                Iterable<Entry> roots = tree.getRoots();
                for (Entry root : roots) {
                    repo.save(root);
                }

                return new ImportResults(true, null);
            }else{
                return new ImportResults(false, "File not found");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return new ImportResults(false, "Encoding of given filepath invalid");
        } catch (Exception e) {
            e.printStackTrace();
            return new ImportResults(false, "Something went wrong during import, DB cleared");
        }
    }

    @GetMapping("roots")
    // return just the tree roots
    Iterable<Entry> readRoots(){
        Entry anatomy = repo.findByDisplayName("Anatomy");
        Entry laterality = repo.findByDisplayName("Laterality");
        Entry modality = repo.findByDisplayName("Modality");
        Entry procedure = repo.findByDisplayName("Procedures");

        return Arrays.asList(anatomy, laterality, modality, procedure);
    }

    // needs tweaking if multiple languages are supported
    @GetMapping
    // returns whole tree saved in Data bank
    public APPCTree getTree(){
        APPCTree tree = new APPCTree("en");

        Entry anatomy = repo.findByDisplayName("Anatomy");
        reconstructTree(anatomy);
        Entry laterality = repo.findByDisplayName("Laterality");
        reconstructTree(laterality);
        Entry modality = repo.findByDisplayName("Modality");
        reconstructTree(modality);
        Entry procedure = repo.findByDisplayName("Procedures");
        reconstructTree(procedure);

        tree.setAnatomy((AxisEntry) anatomy);
        tree.setLaterality((AxisEntry) laterality);
        tree.setModality((AxisEntry) modality);
        tree.setProcedure((AxisEntry) procedure);

        // get version
        Entry version = repo.findByDisplayName("Version");
        tree.setVersion( version.getCode() );

        return tree;
    }

    // workaround to get the entire tree
    // if can be replaced by cypher query, definitely replace
    void reconstructTree(Entry entry){
        Set<Entry> children = entry.getChildren();
        if(children != null) {
            for (Entry child : children) {
                Optional<Entry> fullchild = repo.findById(child.getId());
                if (fullchild.isPresent()) {
                    Set<Entry> grandchildren = fullchild.get().getChildren();
                    if (grandchildren != null) {
                        for (Entry grandchild : grandchildren) {
                            child.addChild(grandchild);
                        }
                    }
                }
                reconstructTree(child);
            }
        }
    }

}
