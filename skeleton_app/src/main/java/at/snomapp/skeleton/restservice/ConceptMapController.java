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
import io.swagger.client.model.Concept;
import at.snomapp.skeleton.translate.CompositionalGrammarTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.net.URL;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/concept-map")
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

    /**
     * Flushes database.
     */
    @DeleteMapping
    void clearDB() {
        conceptMapRepo.deleteAll();
    }

    /**
     * Get mapped Elements by APPC.
     * @param code
     * @param axis
     * @return {@link Iterable}
     */
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

    /**
     * Get mapping information for APPC.
     * @param code of APPC Element.
     * @param axis of APPC Element.
     * @return APPC Element with equivalence.
     */
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

    /**
     * Store a mapping to database.
     * @param object {@link ConceptMapRequest}
     * @return {@link ResponseEntity}
     */
    @PostMapping("submit")
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

    /**
     * Get mappings as {@link List}.
     * @return List of concept-maps.
     */
    @GetMapping("mappings/export")
    List<ConceptMap> exportConceptMaps() {
        return (List<ConceptMap>) conceptMapRepo.findAll(2);
    }

    /**
     * Download concept maps as JSON resource.
     * @param filename of downloaded file.
     * @return {@link ResponseEntity<List<ConceptMap>>}
     */
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

    /**
     * Export all mappings as FHIR resource.
     * @return {@link ConceptMapFHIRResource}
     */
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

    /**
     * Download all existing mappings as FHIR concept map ans JSON document.
     * @param filename of downloaded file.
     * @return {@link ResponseEntity<ConceptMapFHIRResource>}
     */
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

    /**
     * Download EQUIVALENT and EQUAL mappings as .csv resource.
     * @param filename of downloaded file.
     * @return {@link ResponseEntity}
     */
    @GetMapping("mappings/csv/download")
    ResponseEntity exportCSVResource(@RequestParam(required = false) String filename){
        // Later we can let the user set the filename with a textfield and pass it as request parameter
        String downloadFilename = filename==null ? "conceptmap_" + UUID.randomUUID().toString() + ".csv" : filename;

        // get all existing mappings
        List<ConceptMap> mappings = (List<ConceptMap>) conceptMapRepo.findAll(2);
        String currentAxis = "";
        StringBuilder result = new StringBuilder();

        // read appc csv file
        try{
            URL resource = this.getClass().getResource("/APPCCodes/APPC_machinereadable_1.1.csv");
            BufferedReader csvReader = new BufferedReader(new FileReader(resource.getFile()));
            String row = "";
            while ((row = csvReader.readLine()) != null) {

                if(!row.contains(";")){
                    result.append(row + "\n");
                    continue;
                }

                List<String> fields = new ArrayList<>(Arrays.asList(row.split(";")));
                // current appc
                String fullCode = fields.get(1).replaceAll("[\uFEFF-\uFFFF]", "");

                switch (fields.get(0)){
                    case "Modality":
                        currentAxis = "1.2.40.0.34.5.38.1";
                        break;
                    case "Laterality":
                        currentAxis = "1.2.40.0.34.5.38.2";
                        break;
                    case "Procedures":
                        currentAxis = "1.2.40.0.34.5.38.3";
                        break;
                    case "Anatomy":
                        currentAxis = "1.2.40.0.34.5.38.4";
                        break;
                }

                Equivalence equivalent = null;
                Equivalence equal = null;
                // find all existing mappings for current appc code
                for (ConceptMap conceptMap : mappings){
                    for (APPCElement element : conceptMap.getElements()){
                        if (element.getCodeSystem().equals(currentAxis)){
                            for (Equivalence equivalence : element.getEquivalences()){
                                if (equivalence.getSource().getCode().equals(fullCode)){
                                    if (equivalence.getEquivalence().toString().equals("EQUIVALENT")){
                                        equivalent = equivalence;
                                    } else if (equivalence.getEquivalence().toString().equals("EQUAL")){
                                        equal = equivalence;
                                    }
                                }
                            }
                        }

                    }
                }

                if (equivalent != null){
                    // EQUIVALENT mapping exists
                    result.append(row + ";" + equivalent.getDestination().getCode() + ";" + equivalent.getDestination().getDisplayName() + ";" + equivalent.getEquivalence().toString() + "\n");
                }
                else if (equal != null){
                    // EQUAL mapping exists
                    result.append(row + ";" +  equal.getDestination().getCode() + ";" + equal.getDestination().getDisplayName() + ";" + equal.getEquivalence().toString() + "\n");
                }
                else{
                    // no EQUIVALENT or EQUAL mapping exists
                    result.append(row + "\n");
                }

            }
            csvReader.close();
        }
        catch(Exception e){
        }

        return ResponseEntity
                .ok()
                .header("Content-Disposition", "attachment; filename=\"" +downloadFilename+ "\"")
                .contentType(MediaType.TEXT_PLAIN)
                .body(result.toString());
    }

    /**
     * Get number of existing mappings for an APPC Element ID.
     * @param id APPC Element ID
     * @return number of mappings.
     */
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

    /**
     * Translate Snomed equivalents for APPC into Snomeds compositional grammar.
     * @param modalityId Snomed element Id.
     * @param lateralityId Snomed element Id.
     * @param proceduresId Snomed element Id.
     * @param anatomyId Snomed element Id.
     * @return compositional grammar as string.
     */
    @GetMapping("compositional-grammar")
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


