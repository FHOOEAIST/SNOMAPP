package at.snomapp.skeleton.restservice;


import at.snomapp.skeleton.domain.appc.APPCEntry;
import at.snomapp.skeleton.domain.appc.APPCTree;
import at.snomapp.skeleton.domain.appc.Entry;
import at.snomapp.skeleton.domain.conceptMapping.impl.EquivalenceImpl;

import at.snomapp.skeleton.domain.conceptMapping.impl.SNOMEDElement;
import at.snomapp.skeleton.domain.scoring.ScoringAlgorithm;
import at.snomapp.skeleton.domain.scoring.ScoringModel;
import at.snomapp.skeleton.domain.scoring.impl.Cosine;
import at.snomapp.skeleton.domain.scoring.impl.Jaccard;
import at.snomapp.skeleton.domain.scoring.impl.Levenshtein;
import at.snomapp.skeleton.domain.scoring.impl.LongestCommonSubsequence;

import at.snomapp.skeleton.repo.APPCRepo;
import at.snomapp.skeleton.repo.ConceptMapRepo;
import at.snomapp.skeleton.repo.MappingRepo;
import io.swagger.client.model.BrowserDescriptionSearchResult;
import io.swagger.client.model.Description;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;


@Controller
public class ViewController {

    private final APPCRepo repo;
    private ConceptMapRepo Conceptmaprepo;
    private MappingRepo mappingRepo;

    @Autowired
    public ViewController(APPCRepo readingrepo) {this.repo = readingrepo;}

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
        ConceptMapController conceptMapController = new ConceptMapController(Conceptmaprepo,mappingRepo);
        SnomedController snomedController = new SnomedController();

        Optional<Entry> byId = repo.findById(id);
        if(byId.isPresent()){
            Entry entry = byId.get();
            List<BrowserDescriptionSearchResult> resultList = snomedController.findByDisplayName(entry.getDisplayName());


            // create a new scoring model
            // compare algorithms can be appended or removed randomly
            // all algorithms which are included are applied on all strings
            List<ScoringAlgorithm> algorithms = new ArrayList<>();
            //algorithms.add(new Cosine(0.3));
            //algorithms.add(new Jaccard(0.3));
            algorithms.add(new Levenshtein(0.5));
            algorithms.add(new LongestCommonSubsequence(0.5));
            ScoringModel scoringModel = new ScoringModel(algorithms);

            // calculate for each result his score
            for (BrowserDescriptionSearchResult result : resultList){
                int score = scoringModel.calculateWeightedScore(entry.getDisplayName(), result.getTerm());
                result.setScore(score);
            }
            // sort resultList by property score
            Collections.sort(resultList);

            Map<String, List<Description>> resultMap = snomedController.findSynonyms(resultList);

            List<EquivalenceImpl> mappings = new ArrayList<>();
            model.addAttribute("results",resultList);
            model.addAttribute("resMap", resultMap);
            model.addAttribute("appc", entry);
            //ToDo
            model.addAttribute("mappings", mappings);
        }

        // TODO: 06.10.2020 maybe add a page for errors
        return "resultPage";
    }

}
