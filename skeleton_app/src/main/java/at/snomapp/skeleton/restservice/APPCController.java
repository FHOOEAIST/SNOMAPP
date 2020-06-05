package at.snomapp.skeleton.restservice;

import at.snomapp.skeleton.appc.APPCEntry;
import at.snomapp.skeleton.appc.APPCTree;
import at.snomapp.skeleton.appc.AxisEntry;
import at.snomapp.skeleton.appc.Entry;
import at.snomapp.skeleton.importer.CSVImporter;
import at.snomapp.skeleton.importer.Importer;
import at.snomapp.skeleton.repo.APPCRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;


@RestController
@RequestMapping("/APPC")
// controller providing endpoints for importing and retreiving APPCData
public class APPCController {

    private APPCRepo repo;


    @Autowired
    public APPCController(APPCRepo readingrepo) {
        this.repo = readingrepo;
    }

    @DeleteMapping
    // flushes databank
    // to be used for debugging only
    // remove from release version
    void clearDB(){
        repo.deleteAll();
    }


    @GetMapping("/find")
    // finds a node based on the displayName
    Entry findEntry(@RequestParam String displayName){
        System.out.println("Mep");
        return repo.findByDisplayName(displayName);
    }

    @PostMapping("/import")
    // imports an APPCtree from a given filename into the neo4j database.
    // clears databank first one ach call
    void importAPPC(@RequestBody String filename){
        repo.deleteAll();
        Importer importer = new CSVImporter();

        try {
            APPCTree tree = importer.importTree(filename);
            Iterable<Entry> roots = tree.getRoots();
            for (Entry root : roots) {
                repo.save(root);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // needs tweeking if multiple languages are supported
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
                            child.addChild((APPCEntry) grandchild);
                        }
                    }
                }
                reconstructTree(child);
            }
        }
    }




}
