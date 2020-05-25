package at.snomapp.skeleton.restservice;

import at.snomapp.skeleton.domain.conceptMapping.ConceptMap;
import at.snomapp.skeleton.domain.conceptMapping.Element;
import at.snomapp.skeleton.domain.conceptMapping.EquivalenceType;
import at.snomapp.skeleton.domain.conceptMapping.impl.APPCElement;
import at.snomapp.skeleton.domain.conceptMapping.impl.ConceptMapImpl;
import at.snomapp.skeleton.domain.conceptMapping.impl.SNOMEDElement;
import at.snomapp.skeleton.repo.ConceptMapRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ConceptMap")
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

    @PostMapping("/test")
    void importAPPC(){
        repo.deleteAll();
        String appc = "1-2-1-2"; //APPC for eye
        String snomed = "81745001"; //SNOMED: Structure of eye proper
        String snomed2 = "371398005"; //SNOMED for the eye "region"
        String snomed3 = "314859006"; //SNOMED for the eyeball axis

        ConceptMap map = new ConceptMapImpl("APPC", "SNOMED");
        APPCElement appcElement = new APPCElement(appc,"anathomy");
        SNOMEDElement snomedElementMatch = new SNOMEDElement(snomed);
        SNOMEDElement snomedElementWider = new SNOMEDElement(snomed2);
        SNOMEDElement snomedElementPartOf = new SNOMEDElement(snomed3);
        map.addMapping(appcElement,snomedElementWider,EquivalenceType.WIDER);
        map.addMapping(appcElement, snomedElementMatch, EquivalenceType.EQUAL );
        map.addMapping(appcElement,snomedElementPartOf,EquivalenceType.SUBSUMES);
        repo.save(map);
    }




}
