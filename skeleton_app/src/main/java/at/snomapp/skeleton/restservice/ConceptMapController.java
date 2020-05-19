package at.snomapp.skeleton.restservice;

import at.snomapp.skeleton.APPC.APPCTree;
import at.snomapp.skeleton.APPC.Entry;
import at.snomapp.skeleton.conceptMapping.ConceptMap;
import at.snomapp.skeleton.conceptMapping.Element;
import at.snomapp.skeleton.conceptMapping.EquivalenceType;
import at.snomapp.skeleton.conceptMapping.impl.APPCElement;
import at.snomapp.skeleton.conceptMapping.impl.ConceptMapImpl;
import at.snomapp.skeleton.conceptMapping.impl.SNOMEDElement;
import at.snomapp.skeleton.importer.CSVImporter;
import at.snomapp.skeleton.importer.Importer;
import at.snomapp.skeleton.repo.APPCRepo;
import at.snomapp.skeleton.repo.ConceptMapRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

public class ConceptMapController {
    private ConceptMapRepo repo;

    @Autowired
    public ConceptMapController(ConceptMapRepo readingrepo) {
        this.repo = readingrepo;
    }

    @DeleteMapping
        // flushes databank
        // to be used for debugging only
        // remove from release version
    void clearDB(){
        repo.deleteAll();
    }

    @PostMapping("/testMapping")
    void importAPPC(@RequestBody String filename){
        repo.deleteAll();

        String appc = "1-2-1-2"; //APPC for eye
        String snomed = "81745001"; //APPC for the eye "region"
        ConceptMap map = new ConceptMapImpl("APPC", "SNOMED");
        Element appcElement = new APPCElement(appc);
        Element snomedElement = new SNOMEDElement(snomed);
        map.addMapping(appcElement,snomedElement, EquivalenceType.WIDER);
        repo.save(map);

    }




}
