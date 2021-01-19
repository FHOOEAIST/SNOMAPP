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
import io.swagger.client.model.BrowserDescriptionSearchResult;
import io.swagger.client.model.Description;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Controller
public class ViewController<SnomedAPPCMapping> {

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
    public String error(Model model) {
        try {
            // check if server and API are responsive to report proper error
            SnomedController snomedController = new SnomedController();
            List<BrowserDescriptionSearchResult> resultList = snomedController.findByDisplayName("eye", "Anatomy", 10, 0).getSearchResults();
            if (resultList == null || resultList.size() == 0) {
                model.addAttribute("reason", "server");
            } else {
                model.addAttribute("reason", "internal");
            }
        } catch (Exception e) {
            model.addAttribute("reason", "server");
        }

        return "errorPage";
    }


    @GetMapping("/result")
    public String resultPage(@RequestParam Long id,
                             @RequestParam(required = false) String[] scores,
                             @RequestParam int page,
                             @RequestParam int limit,
                             Model model) {
        ConceptMapController conceptMapController = new ConceptMapController(conceptMapRepo, repo);
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

            int numPages = 0;

            // Split display name into multiple possible search terms and search for each one
            List<String> searchTerms = extractSearchTerms(entry.getDisplayName());
            if(limit == -1){
                // Switch of paging entirely
                limit = Integer.MAX_VALUE;
            }
            int resultsPerTerm = limit / searchTerms.size();
            int offset = resultsPerTerm * (page - 1);
            List<BrowserDescriptionSearchResult> resultList = new ArrayList<>();
            for (String searchTerm : searchTerms) {
                SnomedController.BrowserDescriptionResultWrapper results = snomedController.findByDisplayName(searchTerm, entry.getAxis(), resultsPerTerm, offset);
                if(numPages < results.getNumPages()){
                    numPages = results.getNumPages();
                }
                resultList.addAll(results.getSearchResults());
            }

            List<ScoringAlgorithm> algorithms = new ArrayList<>();
            Map<String, List<Description>> resultMap = snomedController.findSynonyms(resultList);

            // create a new scoring model
            // all algorithms which are included are applied on all strings
            ScoringModel scoringModel;
            ArrayList<Boolean> algorithmChecked = new ArrayList<>(Arrays.asList(false, false, false, false, false));

            // If search yielded no result -> sequentially remove the first element from each search term until there are results or options are exhausted
            if (resultList.isEmpty()) {
                while (!(searchTerms.isEmpty() || !resultList.isEmpty())) {
                    searchTerms = searchTerms.stream()
                            .map(t -> {
                                if (t.contains(" ")) {
                                    // Remove first word in term
                                    return t.replaceFirst("^\\w+(\\s|$)+", "");
                                } else {
                                    return null;
                                }
                            })
                            .filter(Objects::nonNull)
                            .sorted(Comparator.comparingInt(t -> -t.split("\\s").length))
                            .collect(Collectors.toList());

                    resultsPerTerm = searchTerms.size() > 0 ? limit / searchTerms.size() : 0;
                    offset = resultsPerTerm * page;
                    for (String searchTerm : searchTerms) {
                        SnomedController.BrowserDescriptionResultWrapper results = snomedController.findByDisplayName(searchTerm, entry.getAxis(), resultsPerTerm, offset);
                        if (numPages < results.getNumPages()) {
                            numPages = results.getNumPages();
                        }
                        resultList.addAll(results.getSearchResults());
                    }
                }
            }

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
            else {
                int countMethods = scoringMethods.size();
                if (scoringMethods.contains("synonyms")) {
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
            for (BrowserDescriptionSearchResult result : resultList) {
                int score = scoringModel.calcWeightedScoreSynonym(entry.getDisplayName(), resultMap, result.getConcept().getId());
                if (score < minScore) {
                    minScore = score;
                }
                if (score > maxScore) {
                    maxScore = score;
                }
                result.setScore(score);
            }

            // sort resultList by property score
            Collections.sort(resultList);

            List<String> mappings = new ArrayList<>();
            model.addAttribute("results", resultList);
            model.addAttribute("resMap", resultMap);
            model.addAttribute("appc", entry);
            Iterable<Map<String, Object>> mapps = conceptMapRepo.getSnomedCodeAndEquivalence(entry.getCode(), entry.getAxis());
            model.addAttribute("mapps", mapps);
            Iterable<SNOMEDElement> maps = conceptMapRepo.findMappedElementsByCodeAndAxis(entry.getCode(), entry.getAxis());
            maps.forEach(map -> mappings.add(map.getCode()));
            model.addAttribute("mappings", mappings);

            model.addAttribute("scoringModel", scoringModel );
            model.addAttribute("algorithmChecked", algorithmChecked);

            model.addAttribute("pageLimit", limit);
            model.addAttribute("page", page);
            model.addAttribute("pages", IntStream.range(1, numPages + 1).toArray());

            // for scoring visibility
            model.addAttribute("colorStep", (maxScore - minScore) / 3);
        }

        return "resultPage";
    }

    private List<String> extractSearchTerms(String displayName) {
        // Remove filler characters
        displayName = displayName.replaceAll("etc\\.?", "");
        displayName = displayName.replaceAll("e\\.?g\\.?", "");

        // Find text within parenthesis
        List<String> tempParList = new LinkedList<>();
        Pattern parenthesesPattern = Pattern.compile("([^(]*)\\((.*)\\)([^)]*)");
        Matcher parenthesesMatcher = parenthesesPattern.matcher(displayName);
        if (parenthesesMatcher.find()) {
            // Recursive call to process inner text
            String innerParenthesesText = parenthesesMatcher.group(2);
            tempParList.addAll(extractSearchTerms(innerParenthesesText));

            // Remove inner text from current search terms
            displayName = displayName.replace(innerParenthesesText, "");
            displayName = displayName.replaceAll("[()]", "");
        }

        // Split according to delimiters
        String[] split = displayName.split("[/,;]");
        List<String> result = new LinkedList<>(Arrays.asList(split));
        // trim leading and trailing whitespaces
        result = result.stream().map(String::trim).collect(Collectors.toList());
        // Add text from parentheses last as they are likely to have the lowest relevance
        result.addAll(tempParList);
        return result;
    }

    @GetMapping("translate")
    public String translateToSnomed(
            Model model,
            @RequestParam String modalityCode,
            @RequestParam String lateralityCode,
            @RequestParam String proceduresCode,
            @RequestParam String anatomyCode
    ) {
        model.addAttribute("laterality_appc", repo.findByCodeAndAxis(lateralityCode, "Laterality").getDisplayName());
        model.addAttribute("modality_appc", repo.findByCodeAndAxis(modalityCode, "Modality").getDisplayName());
        model.addAttribute("procedures_appc", repo.findByCodeAndAxis(proceduresCode, "Procedures").getDisplayName());
        model.addAttribute("anatomy_appc", repo.findByCodeAndAxis(anatomyCode, "Anatomy").getDisplayName());
        model.addAttribute("laterality", conceptMapRepo.findEquivalentOrEqualSnomedElementsForAPPC(lateralityCode, "Laterality"));
        model.addAttribute("modality", conceptMapRepo.findEquivalentOrEqualSnomedElementsForAPPC(modalityCode, "Modality"));
        model.addAttribute("procedures", conceptMapRepo.findEquivalentOrEqualSnomedElementsForAPPC(proceduresCode, "Procedures"));
        model.addAttribute("anatomy", conceptMapRepo.findEquivalentOrEqualSnomedElementsForAPPC(anatomyCode, "Anatomy"));

        return "fullSpecifiedResultPage";
    }
}
