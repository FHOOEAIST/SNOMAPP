package at.snomapp.skeleton.restservice;

import at.snomapp.skeleton.domain.appc.APPCEntry;
import at.snomapp.skeleton.domain.appc.APPCTree;
import at.snomapp.skeleton.domain.appc.AxisEntry;
import at.snomapp.skeleton.domain.appc.Entry;
import at.snomapp.skeleton.importer.Importer;
import at.snomapp.skeleton.importer.impl.CSVImporter;
import at.snomapp.skeleton.importer.impl.StringCSVImporter;
import at.snomapp.skeleton.repo.APPCRepo;
import net.minidev.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Optional;
import java.util.Set;

/**
 * controller providing endpoints for importing and retrieving APPC Data
 */
@RestController
@RequestMapping("/appc")
public class APPCController {

    private final APPCRepo repo;

    @Autowired
    public APPCController(APPCRepo repo) {
        this.repo = repo;
    }

    /**
     * Flushes database.
     */
    @DeleteMapping
    void clearDB(){
        repo.deleteAll();
    }

    /**
     * Get an entry by id.
     * @param id Id of APPC Element.
     * @return APPC Entry.
     */
    @GetMapping("entry/{id}")
    Entry readByIdentity(@PathVariable Long id){
        Optional<Entry> byId = repo.findById(id);
        return byId.orElse(null);
    }

    /**
     * Get an APPC entry by display name.
     * @param displayName of APPC.
     * @return Iterable of APPC Entries.
     */
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

    /**
     * Get APPC entries by display-name
     * @param displayName of APPC.
     * @return APPC Entry as JSON string.
     */
    @GetMapping("/get-entries-by-name")
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

    /**
     * Imports an APPC tree from a given filename into the neo4j database.
     * Clears database if valid file is given.
     * Obsolete because of new import mechanism, but left in because it makes manual imports via e.g. postman simpler.
     * @param filename
     * @return
     */
    @PostMapping("/import")
    @ResponseStatus(HttpStatus.CREATED)
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
                    repo.save(new APPCEntry("Version", tree.getVersion(), null));
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

    /**
     * Imports an APPCTree from given string containing the entire code
     * Clears database if contents are not empty.
     * @param contents
     * @return
     */
    @PostMapping("/import-string")
    @ResponseStatus(HttpStatus.CREATED)
    ModelAndView importAPPCString(@RequestBody String contents){
        ModelAndView mv = new ModelAndView("startPage");
        try {
            String decodedContents = URLDecoder.decode(contents, StandardCharsets.UTF_8.name());
            if(! (decodedContents == null) && !decodedContents.isEmpty() ){
                // contents sent
                Importer importer = new StringCSVImporter();
                APPCTree tree = importer.importTree(decodedContents);

                if(tree.getAnatomy() == null
                        || tree.getModality() == null
                        || tree.getLaterality() == null
                        || tree.getProcedure() == null){
                    mv.addObject(new ImportResults(false, "one or more axis of the given code were not constructed"));
                }else {
                    // valid tree
                    repo.deleteAll();
                    // save version
                    if (tree.getVersion() != null) {
                        repo.save(new APPCEntry("Version", tree.getVersion(), null));
                    }

                    Iterable<Entry> roots = tree.getRoots();
                    for (Entry root : roots) {
                        repo.save(root);
                    }

                    mv.addObject("result", new ImportResults(true, null));
                }

            }else{
                mv.addObject("result", new ImportResults(false, "File not found"));
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            mv.addObject("result", new ImportResults(false, "Encoding of given filepath invalid"));
        } catch (Exception e) {
            e.printStackTrace();
            mv.addObject("result", new ImportResults(false, "Something went wrong during import, DB cleared"));
        }
        return mv;
    }

    /**
     * @return the 4 root nodes.
     */
    @GetMapping("roots")
    Iterable<Entry> readRoots(){
        Entry anatomy = repo.findByDisplayName("Anatomy");
        Entry laterality = repo.findByDisplayName("Laterality");
        Entry modality = repo.findByDisplayName("Modality");
        Entry procedure = repo.findByDisplayName("Procedures");

        return Arrays.asList(anatomy, laterality, modality, procedure);
    }

    /**
     * Needs tweaking if multiple languages are supported.
     *
     * @return whole tree saved in database.
     */
    @GetMapping("get-tree")
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

    /**
     * Workaround to get the entire tree.
     * @param entry
     */
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
