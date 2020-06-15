package at.snomapp.skeleton.restservice;

import at.snomapp.skeleton.domain.conceptMapping.ConceptMap;
import at.snomapp.skeleton.domain.conceptMapping.EquivalenceType;
import at.snomapp.skeleton.domain.conceptMapping.impl.APPCElement;
import at.snomapp.skeleton.domain.conceptMapping.impl.ConceptMapImpl;
import at.snomapp.skeleton.domain.conceptMapping.impl.SNOMEDElement;
import at.snomapp.skeleton.repo.ConceptMapRepo;
import at.snomapp.skeleton.repo.MappingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ConceptMap")
public class ConceptMapController {
    private final ConceptMapRepo conceptMapRepo;
    private final MappingRepo mappingRepo;

    @Autowired
    public ConceptMapController(ConceptMapRepo readingrepo, MappingRepo mappingRepo) {
        this.conceptMapRepo = readingrepo;
        this.mappingRepo = mappingRepo;
    }

    @DeleteMapping
        // flushes databank
        // to be used for debugging only
        // remove from release version
    void clearDB(){
        conceptMapRepo.deleteAll();
    }

    @PostMapping("/test")
    void importAPPC(){
        conceptMapRepo.deleteAll();
        String appc = "1-2-1-2"; //APPC for eye
        String snomed = "81745001"; //SNOMED: Structure of eye proper
        String snomed2 = "371398005"; //SNOMED for the eye "region"
        String snomed3 = "314859006"; //SNOMED for the eyeball axis

        ConceptMap map = new ConceptMapImpl("APPC", "SNOMED CT");
        APPCElement appcElement = new APPCElement(appc,"anatomy");
        SNOMEDElement snomedElementMatch = new SNOMEDElement(snomed);
        SNOMEDElement snomedElementWider = new SNOMEDElement(snomed2);
        SNOMEDElement snomedElementPartOf = new SNOMEDElement(snomed3);
        map.addMapping(appcElement,snomedElementWider,EquivalenceType.WIDER);
        map.addMapping(appcElement, snomedElementMatch, EquivalenceType.EQUAL );
        map.addMapping(appcElement,snomedElementPartOf,EquivalenceType.SUBSUMES);
        conceptMapRepo.save(map);
    }

    // for searching for map-elements
    @GetMapping
    Iterable<ConceptMap> readByAPPC(@RequestParam(required = false) String code,
                                    @RequestParam(required = false) String axis){
        if(code == null && axis == null) {
            return conceptMapRepo.findAll();
        }else if(code != null && axis == null) {
            return conceptMapRepo.findAllByAPPCCode(code);
        }else if (code == null){
            return conceptMapRepo.findAllByAPPCAxis(axis);
        }else {
            return conceptMapRepo.findAllByAPPCAxisAndCode(axis, code);
        }
    }

    // for searching for mapping information (elements + equivalence)
    @GetMapping("mapping")
    APPCElement readMappingByAPPC(@RequestParam(required = false) String code,
                                  @RequestParam(required = false) String axis){
        if(code == null && axis == null) {
            return null;
        }else if(code != null && axis == null) {
           return mappingRepo.findByCode(code);
        }else if (code == null){
            return mappingRepo.findByAxis(axis);
        }else {
            return mappingRepo.findByAxisAndCode(axis, code);
        }
    }

}
