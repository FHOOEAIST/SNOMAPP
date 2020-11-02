package at.snomapp.skeleton.restservice;

import at.snomapp.skeleton.domain.conceptMapping.ConceptMap;
import at.snomapp.skeleton.domain.conceptMapping.EquivalenceType;
import at.snomapp.skeleton.domain.conceptMapping.impl.APPCElement;
import at.snomapp.skeleton.domain.conceptMapping.impl.ConceptMapImpl;
import at.snomapp.skeleton.domain.conceptMapping.impl.SNOMEDElement;
import at.snomapp.skeleton.repo.ConceptMapRepo;
import at.snomapp.skeleton.repo.MappingRepo;
import io.swagger.client.model.Concept;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

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

    @PostMapping("/submit")
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<HttpStatus> submitMapping(@RequestBody ConceptMapRequest object){
        Iterator<ConceptMap> iterator = conceptMapRepo.findAll().iterator();
        ConceptMap conceptMap;
        if(!iterator.hasNext()){
            conceptMap = new ConceptMapImpl("APPC", "SNOMED CT");
        }
        else {
            conceptMap = iterator.next();
        }
        APPCElement appcElement = conceptMapRepo.findElementByCodeAndAxis(object.appcCode, object.appcAxis);
        if(appcElement == null){
            appcElement = new APPCElement(object.appcCode, object.appcAxis);
        }

        SNOMEDElement snomedElement = new SNOMEDElement(object.snomedCode);
        switch (object.map){
            case "equivalent":
                conceptMap.addMapping(appcElement, snomedElement, EquivalenceType.EQUIVALENT);
                break;
            case "subsumes":
                conceptMap.addMapping(appcElement, snomedElement, EquivalenceType.SUBSUMES);
                break;
            case "wider":
                conceptMap.addMapping(appcElement, snomedElement, EquivalenceType.WIDER);
                break;
            case "equal":
                conceptMap.addMapping(appcElement, snomedElement, EquivalenceType.EQUAL);
                break;
            case "narrower":
                conceptMap.addMapping(appcElement, snomedElement, EquivalenceType.NARROWER);
                break;
            case "inexact":
                conceptMap.addMapping(appcElement, snomedElement, EquivalenceType.INEXACT);
                break;
            case "unmatch":
                conceptMap.addMapping(appcElement, snomedElement, EquivalenceType.UNMATCH);
                break;
            case "disjoint":
                conceptMap.addMapping(appcElement, snomedElement, EquivalenceType.DISJOINT);
                break;
        }
        conceptMapRepo.save(conceptMap);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    private static class ConceptMapRequest {

        String appcCode;
        String snomedCode;
        String map;
        String appcAxis;

        public String getAppcCode() {
            return appcCode;
        }

        public String getSnomedCode() {
            return snomedCode;
        }

        public String getMap() {
            return map;
        }

        public String getAppcAxis() {
            return appcAxis;
        }

        public void setAppcCode(String appcCode){
            this.appcCode = appcCode;
        }

        public void setSnomedCode(String snomedCode){
            this.snomedCode = snomedCode;
        }

        public void setMap(String map){
            this.map = map;
        }
    }
}


