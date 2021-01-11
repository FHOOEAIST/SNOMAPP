package at.snomapp.restservice;


import at.snomapp.domain.appc.APPCTree;
import at.snomapp.domain.appc.Entry;
import at.snomapp.domain.conceptMapping.impl.SNOMEDElement;
import at.snomapp.domain.scoring.ScoringAlgorithm;
import at.snomapp.domain.scoring.ScoringModel;
import at.snomapp.domain.scoring.impl.Cosine;
import at.snomapp.domain.scoring.impl.Jaccard;
import at.snomapp.domain.scoring.impl.Levenshtein;
import at.snomapp.domain.scoring.impl.LongestCommonSubsequence;
import at.snomapp.repo.APPCRepo;
import at.snomapp.repo.ConceptMapRepo;
import at.snomapp.repo.MappingRepo;
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
    private MappingRepo mappingRepo;

    @Autowired
    public ViewController(APPCRepo readingrepo, ConceptMapRepo conceptMapRepo, MappingRepo mappingRepo) {
        this.repo = readingrepo;
        this.conceptMapRepo = conceptMapRepo;
        this.mappingRepo = mappingRepo;
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
        ConceptMapController conceptMapController = new ConceptMapController(conceptMapRepo, mappingRepo,repo);
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

            // create a new scoring model
            // all algorithms which are included are applied on all strings
            ScoringModel scoringModel;
            List<Boolean> algorithmChecked = List.of(false, false, false, false, false);

            if (scoringMethods.size() == 0 || (scoringMethods.size() == 1 && scoringMethods.contains("synonyms"))) {
                // default
                algorithms.add(new Levenshtein(0.5));
                algorithms.add(new LongestCommonSubsequence(0.5));
                algorithmChecked.set(1, true);
                algorithmChecked.set(3, true);
                algorithmChecked.set(4, true);
                scoringModel = new ScoringModel(algorithms);
                resultList.forEach(res -> res.setScore(scoringModel.calcWeightedScoreSynonym(entry.getDisplayName(), resultMap, res.getConcept().getId()) ));
            }

            //if user chose algorithm use this one instead
            else {
                int countMethods = scoringMethods.size();
                if (scoringMethods.contains("synonyms")){
                    countMethods = countMethods - 1;
                }
                for (String score : scoringMethods) {
                    switch (score) {
                        case "cosinus":
                            algorithms.add(new Cosine(Math.round(1.0 / countMethods * 100) / 100d));
                            algorithmChecked.set(0, true);
                            break;
                        case "levenshtein":
                            algorithms.add(new Levenshtein(Math.round(1.0 / countMethods * 100) / 100d));
                            algorithmChecked.set(1, true);
                            break;
                        case "jaccard":
                            algorithms.add(new Jaccard(Math.round(1.0 / countMethods * 100) / 100d));
                            algorithmChecked.set(2, true);
                            break;
                        case "subsequence":
                            algorithms.add(new LongestCommonSubsequence(Math.round(1.0 / countMethods * 100) / 100d));
                            algorithmChecked.set(3, true);
                            break;
                    }
                }

                scoringModel = new ScoringModel(algorithms);
                if (scoringMethods.contains("synonyms")){
                    resultList.forEach(res -> res.setScore(scoringModel.calcWeightedScoreSynonym(entry.getDisplayName(), resultMap, res.getConcept().getId()) ));
                    algorithmChecked.set(4, true);
                } else {
                    resultList.forEach(res -> res.setScore(scoringModel.calcWeightedScore( entry.getDisplayName(), res.getTerm() )));
                }
            }


            // for scoring visibility
            int maxScore = 0;
            int minScore = Integer.MAX_VALUE;
            for (BrowserDescriptionSearchResult result : resultList){
                int score =  result.getScore();
                if (score < minScore){
                    minScore = score;
                }
                if(score > maxScore){
                    maxScore = score;
                }
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
            model.addAttribute("algorithmChecked", algorithmChecked);

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
        model.addAttribute("laterality", mappingRepo.findEquivalentOrEqualSnomedElementsForAPPC(lateralityCode, "Laterality"));
        model.addAttribute("modality", mappingRepo.findEquivalentOrEqualSnomedElementsForAPPC(modalityCode, "Modality"));
        model.addAttribute("procedures", mappingRepo.findEquivalentOrEqualSnomedElementsForAPPC(proceduresCode, "Procedures"));
        model.addAttribute("anatomy", mappingRepo.findEquivalentOrEqualSnomedElementsForAPPC(anatomyCode, "Anatomy"));

        return "fullSpecifiedResultPage";
    }
}
