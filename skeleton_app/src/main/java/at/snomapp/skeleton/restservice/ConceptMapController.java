package at.snomapp.skeleton.restservice;

import at.snomapp.skeleton.domain.appc.Entry;
import at.snomapp.skeleton.domain.conceptMapping.ConceptMap;
import at.snomapp.skeleton.domain.conceptMapping.Equivalence;
import at.snomapp.skeleton.domain.conceptMapping.EquivalenceType;
import at.snomapp.skeleton.domain.conceptMapping.fhir.ConceptMapFHIRResource;
import at.snomapp.skeleton.domain.conceptMapping.fhir.Element;
import at.snomapp.skeleton.domain.conceptMapping.fhir.Group;
import at.snomapp.skeleton.domain.conceptMapping.fhir.Target;
import at.snomapp.skeleton.domain.conceptMapping.impl.APPCElement;
import at.snomapp.skeleton.domain.conceptMapping.impl.ConceptMapImpl;
import at.snomapp.skeleton.domain.conceptMapping.impl.SNOMEDElement;
import at.snomapp.skeleton.repo.APPCRepo;
import at.snomapp.skeleton.repo.ConceptElementRepo;
import at.snomapp.skeleton.repo.ConceptMapRepo;
import at.snomapp.skeleton.repo.MappingRepo;
import at.snomapp.skeleton.translate.CompositionalGrammarTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/ConceptMap")
public class ConceptMapController {
    private final ConceptMapRepo conceptMapRepo;
    private final MappingRepo mappingRepo;
    private final APPCRepo appcRepo;

    @Autowired
    public ConceptMapController(ConceptMapRepo readingrepo, MappingRepo mappingRepo, APPCRepo appcRepo) {
        this.conceptMapRepo = readingrepo;
        this.mappingRepo = mappingRepo;
        this.appcRepo = appcRepo;
    }

    @DeleteMapping
        // flushes databank
        // to be used for debugging only
        // remove from release version
    void clearDB() {
        conceptMapRepo.deleteAll();
    }

    /*
    @PostMapping("/test")
    void importAPPC(){
        conceptMapRepo.deleteAll();
        String appc = "1-2-1-2"; //APPC for eye
        String snomed = "81745001"; //SNOMED: Structure of eye proper
        String snomed2 = "371398005"; //SNOMED for the eye "region"
        String snomed3 = "314859006"; //SNOMED for the eyeball axis

        ConceptMap map = new ConceptMapImpl("APPC", "SNOMED CT");
        APPCElement appcElement = new APPCElement(appc,"anatomy");
        SNOMEDElement snomedElementMatch = new SNOMEDElement(snomed, displayName);
        SNOMEDElement snomedElementWider = new SNOMEDElement(snomed2, displayName);
        SNOMEDElement snomedElementPartOf = new SNOMEDElement(snomed3, displayName);
        map.addMapping(appcElement,snomedElementWider,EquivalenceType.WIDER);
        map.addMapping(appcElement, snomedElementMatch, EquivalenceType.EQUAL );
        map.addMapping(appcElement,snomedElementPartOf,EquivalenceType.SUBSUMES);
        conceptMapRepo.save(map);
    }

     */

    // for searching for map-elements
    @GetMapping
    Iterable<ConceptMap> readByAPPC(@RequestParam(required = false) String code,
                                    @RequestParam(required = false) String axis) {
        if (code == null && axis == null) {
            return conceptMapRepo.findAll();
        } else if (code != null && axis == null) {
            return conceptMapRepo.findAllByAPPCCode(code);
        } else if (code == null) {
            return conceptMapRepo.findAllByAPPCAxis(axis);
        } else {
            return conceptMapRepo.findAllByAPPCAxisAndCode(axis, code);
        }
    }

    // for searching for mapping information (elements + equivalence)
    @GetMapping("mapping")
    APPCElement readMappingByAPPC(@RequestParam(required = false) String code,
                                  @RequestParam(required = false) String axis) {
        if (code == null && axis == null) {
            return null;
        } else if (code != null && axis == null) {
            return mappingRepo.findByCode(code);
        } else if (code == null) {
            return mappingRepo.findByAxis(axis);
        } else {
            return mappingRepo.findByAxisAndCode(axis, code);
        }
    }

    @PostMapping("/submit")
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<HttpStatus> submitMapping(@RequestBody ConceptMapRequest object) {
        Iterator<ConceptMap> iterator = conceptMapRepo.findAll().iterator();
        ConceptMap conceptMap;
        if (!iterator.hasNext()) {
            /*
              OID for SNOMED CT: 2.16.840.1.113883.6.96
              OID for APPC 1.2.40.0.34.5.38 -> Source ELGA document
             */
            conceptMap = new ConceptMapImpl("1.2.40.0.34.5.38", "2.16.840.1.113883.6.96");
        } else {
            conceptMap = iterator.next();
        }
        APPCElement appcElement = conceptMapRepo.findElementByCodeAndAxis(object.appcCode, object.appcAxis);
        if (appcElement == null) {
            appcElement = new APPCElement(object.appcCode, object.appcAxis, object.appcDisplayName);
        }

        // TODO: convert strings to enum more efficiently
        SNOMEDElement snomedElement = new SNOMEDElement(object.snomedCode, object.snomedDisplayName);
        switch (object.map) {
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

    @GetMapping("mappings/export")
    List<ConceptMap> exportConceptMaps() {
        return (List<ConceptMap>) conceptMapRepo.findAll(2);
    }

    @GetMapping("mappings/download")
    ResponseEntity<List<ConceptMap>> downloadConceptMaps(@RequestParam(required = false) String filename) {
        // Later we can let the user set the filename with a textfield and pass it as request parameter
        String downloadFilename = filename == null ? "conceptmap_" + UUID.randomUUID().toString() + ".json" : filename;

        return ResponseEntity
                .ok()
                .header("Content-Disposition", "attachment; filename=\"" + downloadFilename + "\"")
                .contentType(MediaType.APPLICATION_JSON)
                .body(exportConceptMaps());
    }

    @GetMapping("mappings/fhir/export")
    ConceptMapFHIRResource exportFHIRResource() {
        List<ConceptMap> mappings = (List<ConceptMap>) conceptMapRepo.findAll(2);
        String source = null;
        String destination = null;
        String status = null;

        Group anatomy = new Group("1.2.40.0.34.5.38.4", "2.16.840.1.113883.6.96");
        Group modality = new Group("1.2.40.0.34.5.38.1", "2.16.840.1.113883.6.96");
        Group laterality = new Group("1.2.40.0.34.5.38.2", "2.16.840.1.113883.6.96");
        Group procedure = new Group("1.2.40.0.34.5.38.3", "2.16.840.1.113883.6.96");
        List<Group> groups = new LinkedList<>(Arrays.asList(anatomy, modality, laterality, procedure));

        for (ConceptMap mapping : mappings) {
            source = mapping.getSource(); // OID for APPC
            destination = mapping.getDestination(); // OID for SNOMED
            status = mapping.getStatus().toString();
            for (APPCElement appcElement : mapping.getElements()) {
                for (Group group : groups) {
                    if (group.getSource().equals(appcElement.getCodeSystem())) {
                        Element element = new Element(appcElement.getCode(), appcElement.getDisplayName());
                        // Get SNOMED equivalences
                        for (Equivalence equivalence : appcElement.getEquivalences()) {
                            Target target = new Target(
                                    equivalence.getDestination().getCode(),
                                    equivalence.getDestination().getDisplayName(),
                                    equivalence.getEquivalence().toString());
                            element.addTarget(target);
                        }
                        group.addElement(element);
                    }
                }
            }
        }

        // remove groups without any elements
        if (groups.stream().filter(group -> group.getElement() == null).count() == 4) {
            groups = null;
        } else {
            groups.removeIf(group -> group.getElement() == null);
        }
        return new ConceptMapFHIRResource(status, source, destination, groups);
    }

    @GetMapping("mappings/fhir/download")
    ResponseEntity<ConceptMapFHIRResource> downloadFHIRResource(@RequestParam(required = false) String filename) {
        // Later we can let the user set the filename with a textfield and pass it as request parameter
        String downloadFilename = filename == null ? "conceptmap_" + UUID.randomUUID().toString() + ".json" : filename;

        return ResponseEntity
                .ok()
                .header("Content-Disposition", "attachment; filename=\"" + downloadFilename + "\"")
                .contentType(MediaType.APPLICATION_JSON)
                .body(exportFHIRResource());

    }

    @GetMapping("mappings/csv/export")
    ResponseEntity exportCSVResource(@RequestParam(required = false) String filename) {
        // Later we can let the user set the filename with a textfield and pass it as request parameter
        String downloadFilename = filename == null ? "conceptmap_" + UUID.randomUUID().toString() + ".json" : filename;

        // ToDo create csv Resource
        return ResponseEntity
                .ok()
                .header("Content-Disposition", "attachment; filename=\"" + downloadFilename + "\"")
                .contentType(MediaType.APPLICATION_JSON)
                .body(null);
    }

    @GetMapping("count")
    public Map<String, Integer> readMappingCounts(@RequestParam Long id) {
        Optional<Entry> entryOptional = appcRepo.findById(id);
        Map<String, Integer> result = new HashMap<>();
        if (entryOptional.isPresent()) {
            Entry entry = entryOptional.get();
            for (EquivalenceType equivalence : EquivalenceType.values()) {
                int count = mappingRepo.countMappingsWithEquivalenceForAxisAndCode(entry.getAxis(),
                        entry.getCode(),
                        equivalence.toString());
                result.put(equivalence.toString(), count);
            }
        }
        return result;
    }

    private static class ConceptMapRequest {

        String snomedDisplayName;
        String appcDisplayName;
        String appcCode;
        String snomedCode;
        String map;
        String appcAxis;

        public String getAppcDisplayName() {
            return appcDisplayName;
        }

        public String getSnomedDisplayName() {
            return snomedDisplayName;
        }

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

        public void setAppcDisplayName(String appcDisplayName) {
            this.appcDisplayName = appcDisplayName;
        }

        public void setSnomedDisplayName(String snomedDisplayName) {
            this.snomedDisplayName = snomedDisplayName;
        }

        public void setAppcCode(String appcCode) {
            this.appcCode = appcCode;
        }

        public void setSnomedCode(String snomedCode) {
            this.snomedCode = snomedCode;
        }

        public void setMap(String map) {
            this.map = map;
        }
    }

    @GetMapping("compositionalGrammar")
    public String toCompositionalGrammar(
            @RequestParam long modalityId,
            @RequestParam long lateralityId,
            @RequestParam long proceduresId,
            @RequestParam long anatomyId
    ) {
        CompositionalGrammarTranslator translator = new CompositionalGrammarTranslator();
        translator.setModality(mappingRepo.findSnomedElementById(modalityId));
        translator.setLaterality(mappingRepo.findSnomedElementById(lateralityId));
        translator.setProcedures(mappingRepo.findSnomedElementById(proceduresId));
        translator.setAnatomy(mappingRepo.findSnomedElementById(anatomyId));

        return translator.getCompositionalRepresentation();
    }
}


