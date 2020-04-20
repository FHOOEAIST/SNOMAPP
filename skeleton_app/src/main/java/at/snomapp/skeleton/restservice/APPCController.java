package at.snomapp.skeleton.restservice;

import at.snomapp.skeleton.APPC.APPCEntry;
import at.snomapp.skeleton.APPC.APPCTree;
import at.snomapp.skeleton.APPC.Entry;
import at.snomapp.skeleton.importer.CSVImporter;
import at.snomapp.skeleton.importer.Importer;
import at.snomapp.skeleton.repo.APPCRepo;
import at.snomapp.skeleton.repo.EntryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/APPC")
public class APPCController {

    private APPCRepo readingrepo;
    private EntryRepo writingrepo;

    @Autowired
    public APPCController(APPCRepo readingrepo, EntryRepo writingrepo) {
        this.readingrepo = readingrepo;
        this.writingrepo = writingrepo;
    }

    @GetMapping("/all")
    Iterable<APPCEntry> getWholeTree(){
        return readingrepo.findAll();
    }

    @GetMapping("/find")
    Entry findEntry(@RequestParam String description){
        return readingrepo.findByDescription(description);
    }

    @PostMapping("/import")
    void importAPPC(@RequestBody String filename){
        writingrepo.deleteAll();
        Importer importer = new CSVImporter();

        try {
            APPCTree tree = importer.importTree(filename);
            Iterable<Entry> roots = tree.getRoots();
            for (Entry root : roots) {
                writingrepo.save(root);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
