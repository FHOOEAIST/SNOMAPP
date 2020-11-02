package at.snomapp.skeleton.restservice;


import at.snomapp.skeleton.domain.appc.APPCEntry;
import at.snomapp.skeleton.domain.appc.APPCTree;
import at.snomapp.skeleton.domain.appc.Entry;
import at.snomapp.skeleton.domain.conceptMapping.Equivalence;
import at.snomapp.skeleton.domain.conceptMapping.impl.APPCElement;
import at.snomapp.skeleton.domain.conceptMapping.impl.SNOMEDElement;
import at.snomapp.skeleton.repo.*;
import io.swagger.client.model.BrowserDescriptionSearchResult;
import io.swagger.client.model.Description;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
public class ViewController<SnomedAPPCMapping> {

    private final APPCRepo repo;
    private ConceptMapRepo conceptMapRepo;
    private MappingRepo mappingRepo;
    private ConceptRelationshipRepo conceptRelationshipRepo;

    @Autowired
    public ViewController(APPCRepo readingrepo, ConceptMapRepo conceptMapRepo, ConceptRelationshipRepo conceptRelationshipRepo) {this.repo = readingrepo;
        this.conceptMapRepo = conceptMapRepo;
        this.conceptRelationshipRepo = conceptRelationshipRepo;
    }

    @GetMapping("/startPage")
    public String startPage(Model model){
        APPCController appcController = new APPCController(repo);

        try {
            APPCTree tree = appcController.getTree();
            model.addAttribute("anatomy", tree.getAnatomyJsonString());
            model.addAttribute("laterality", tree.getLateralityJsonString());
            model.addAttribute("modality", tree.getModalityJsonString());
            model.addAttribute("procedure", tree.getProcedureJsonString());
            model.addAttribute("version", tree.getVersion());
        }catch (Exception e){
            model.addAttribute("version", "not loaded");
        }
        return "startPage";
    }

    @GetMapping("/index")
    public String index(Model model){
        APPCController appcController = new APPCController(repo);

        //store in model the json string of nodes for each axis
        model.addAttribute("anatomy", appcController.getTree().getAnatomyJsonString());
        model.addAttribute("laterality", appcController.getTree().getLateralityJsonString());
        model.addAttribute("modality", appcController.getTree().getModalityJsonString());
        model.addAttribute("procedure", appcController.getTree().getProcedureJsonString());
        return "index";
    }

    @GetMapping("/resultPage")
    public String resultPage(@RequestParam Long id, Model model){
        ConceptMapController conceptMapController = new ConceptMapController(conceptMapRepo,mappingRepo);
        SnomedController snomedController = new SnomedController();

        Optional<Entry> byId = repo.findById(id);
        if(byId.isPresent()){
            Entry entry = byId.get();
            List<BrowserDescriptionSearchResult> resultList = snomedController.findByDisplayName(entry.getDisplayName());
            List<String> mappings = new ArrayList<>();
            Map<String, List<Description>> resultMap = snomedController.findSynonyms(resultList);
            model.addAttribute("results",resultList);
            model.addAttribute("resMap", resultMap);
            model.addAttribute("appc", entry);
            Iterable<Map<String, Object>> mapps = conceptMapRepo.getSnomedCodeAndEquivalence(entry.getCode(), entry.getAxis());
            model.addAttribute("mapps", mapps);
            System.out.println(mapps.iterator().next().values().toArray()[0]);
            Iterable<SNOMEDElement> maps = conceptMapRepo.findMappedElementsByCodeAndAxis(entry.getCode(), entry.getAxis());
            maps.forEach(map-> mappings.add(map.getCode()));
            model.addAttribute("mappings", mappings);
        }

        // TODO: 06.10.2020 maybe add a page for errors
        return "resultPage";
    }

}
