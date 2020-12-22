package at.snomapp.skeleton.restservice;


import at.snomapp.skeleton.domain.appc.APPCTree;
import at.snomapp.skeleton.domain.appc.Entry;

import at.snomapp.skeleton.domain.conceptMapping.impl.SNOMEDElement;
import at.snomapp.skeleton.domain.scoring.ScoringAlgorithm;
import at.snomapp.skeleton.domain.scoring.ScoringModel;
import at.snomapp.skeleton.domain.scoring.impl.Cosine;
import at.snomapp.skeleton.domain.scoring.impl.Jaccard;
import at.snomapp.skeleton.domain.scoring.impl.Levenshtein;
import at.snomapp.skeleton.domain.scoring.impl.LongestCommonSubsequence;

import at.snomapp.skeleton.repo.APPCRepo;
import at.snomapp.skeleton.repo.ConceptMapRepo;

import io.swagger.client.model.BrowserDescriptionSearchResult;
import io.swagger.client.model.Description;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;


@Controller
public class ViewController<SnomedAPPCMapping>{

    private final APPCRepo repo;
    private ConceptMapRepo conceptMapRepo;

    @Autowired
    public ViewController(APPCRepo readingrepo, ConceptMapRepo conceptMapRepo) {
        this.repo = readingrepo;
        this.conceptMapRepo = conceptMapRepo;
    }

    @GetMapping({"/index", "/"})
    public String startPage(Model model) {
        APPCController appcController = new APPCController(repo);

        try {
            APPCTree tree = appcController.getTree();
            model.addAttribute("anatomy", tree.getAnatomyJsonString());
            model.addAttribute("laterality", tree.getLateralityJsonString());
            model.addAttribute("modality", tree.getModalityJsonString());
            model.addAttribute("procedure", tree.getProcedureJsonString());
            model.addAttribute("version", tree.getVersion());
        } catch (Exception e) {
            model.addAttribute("version", "not loaded");
        }
        return "startPage";
    }

    @ExceptionHandler(Exception.class)
    public String error(Model model){
        try{
            // check if server and API are responsive to report proper error
            SnomedController snomedController = new SnomedController();
            List<BrowserDescriptionSearchResult> resultList = snomedController.findByDisplayName("eye","Anatomy");
            if(resultList == null || resultList.size() == 0){
                model.addAttribute("reason", "server");
            }else{
                model.addAttribute("reason", "internal");
            }
        }catch(Exception e){
            model.addAttribute("reason", "server");
        }

        return "errorPage";
    }

    @GetMapping("/result")
    public String resultPage(@RequestParam Long id, @RequestParam(required = false) String[] scores, Model model) {
        ConceptMapController conceptMapController = new ConceptMapController(conceptMapRepo,repo);
        SnomedController snomedController = new SnomedController();

        Optional<Entry> byId = repo.findById(id);
        if (byId.isPresent()) {
            Entry entry = byId.get();
            List<String> scoringMethods = new ArrayList<>();
            if (scores != null) {
                for (String score : scores) {
                    String[] splittedScore = score.split(",");
                    for (String splitted : splittedScore) {
                        scoringMethods.add(splitted);
                    }

                }
            }

            List<ScoringAlgorithm> algorithms = new ArrayList<>();
            List<BrowserDescriptionSearchResult> resultList = snomedController.findByDisplayName(entry.getDisplayName(),entry.getAxis());
            Map<String, List<Description>> resultMap = snomedController.findSynonyms(resultList);

            //if user chose algorithm use this one instead
            if (scoringMethods.size() > 0) {
                for (String score : scoringMethods
                ) {
                    switch (score) {
                        case "cosinus":
                            algorithms.add(new Cosine(1.0 / scoringMethods.size()));
                            break;
                        case "levenshtein":
                            algorithms.add(new Levenshtein(1.0 / scoringMethods.size()));
                            break;
                        case "jaccard":
                            algorithms.add(new Jaccard(1.0 / scoringMethods.size()));
                            break;
                        case "subsequence":
                            algorithms.add(new LongestCommonSubsequence(1.0 / scoringMethods.size()));
                            break;
                    }
                }
            } else {
                // create a new scoring model
                // compare algorithms can be appended or removed randomly
                // all algorithms which are included are applied on all strings

                algorithms.add(new Levenshtein(0.5));
                algorithms.add(new LongestCommonSubsequence(0.5));
            }

            ScoringModel scoringModel = new ScoringModel(algorithms);
            // calculates for each result his score
            //resultList.forEach(res -> res.setScore(scoringModel.calcUnweightedScore( entry.getDisplayName(), res.getTerm() )));
            //resultList.forEach(res -> res.setScore(scoringModel.calcWeightedScore( entry.getDisplayName(), res.getTerm() )));

            //resultList.forEach(res -> res.setScore(scoringModel.calcUnweightedScoreSynonym(entry.getDisplayName(), resultMap, res.getConcept().getId()) ));
            resultList.forEach(res -> res.setScore(scoringModel.calcWeightedScoreSynonym(entry.getDisplayName(), resultMap, res.getConcept().getId()) ));


            // for scoring visibility
            int maxScore = 0;
            int minScore = Integer.MAX_VALUE;
            for (BrowserDescriptionSearchResult result : resultList){
                int score = scoringModel.calcWeightedScoreSynonym(entry.getDisplayName(), resultMap, result.getConcept().getId());
                if (score < minScore){
                    minScore = score;
                }
                if(score > maxScore){
                    maxScore = score;
                }
                result.setScore(score);
            }
          
            // sort resultList by property score
            Collections.sort(resultList);

            List<String> mappings = new ArrayList<>();
            model.addAttribute("results",resultList);
            model.addAttribute("resMap", resultMap);
            model.addAttribute("appc", entry);
            Iterable<Map<String, Object>> mapps = conceptMapRepo.getSnomedCodeAndEquivalence(entry.getCode(), entry.getAxis());
            model.addAttribute("mapps", mapps);
            Iterable<SNOMEDElement> maps = conceptMapRepo.findMappedElementsByCodeAndAxis(entry.getCode(), entry.getAxis());
            maps.forEach(map -> mappings.add(map.getCode()));
            model.addAttribute("mappings", mappings);

            model.addAttribute("scoringModel", scoringModel );

            // for scoring visibility
            model.addAttribute("colorStep", (maxScore - minScore) / 3);
        }

        // TODO: 06.10.2020 maybe add a page for errors
        return "resultPage";
    }

    @GetMapping("translate")
    public String translateToSnomed(
            Model model,
            @RequestParam String modalityCode,
            @RequestParam String lateralityCode,
            @RequestParam String proceduresCode,
            @RequestParam String anatomyCode
    ){
        model.addAttribute("laterality_appc", repo.findByCodeAndAxis(lateralityCode,"Laterality").getDisplayName());
        model.addAttribute("modality_appc", repo.findByCodeAndAxis(modalityCode,"Modality").getDisplayName());
        model.addAttribute("procedures_appc", repo.findByCodeAndAxis(proceduresCode,"Procedures").getDisplayName());
        model.addAttribute("anatomy_appc", repo.findByCodeAndAxis(anatomyCode,"Anatomy").getDisplayName());
        model.addAttribute("laterality", conceptMapRepo.findEquivalentOrEqualSnomedElementsForAPPC(lateralityCode, "Laterality"));
        model.addAttribute("modality", conceptMapRepo.findEquivalentOrEqualSnomedElementsForAPPC(modalityCode, "Modality"));
        model.addAttribute("procedures", conceptMapRepo.findEquivalentOrEqualSnomedElementsForAPPC(proceduresCode, "Procedures"));
        model.addAttribute("anatomy", conceptMapRepo.findEquivalentOrEqualSnomedElementsForAPPC(anatomyCode, "Anatomy"));

        return "fullSpecifiedResultPage";
    }
}
