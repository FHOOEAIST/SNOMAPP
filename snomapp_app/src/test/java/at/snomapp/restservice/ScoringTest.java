package at.snomapp.restservice;

import at.snomapp.domain.scoring.ScoringAlgorithm;
import at.snomapp.domain.scoring.ScoringModel;
import at.snomapp.domain.scoring.impl.Levenshtein;
import at.snomapp.domain.scoring.impl.LongestCommonSubsequence;
import io.swagger.client.model.BrowserDescriptionSearchResult;
import io.swagger.client.model.Description;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoringTest {

    SnomedController snomedController = new SnomedController();
    List<BrowserDescriptionSearchResult> resultList = snomedController.findByDisplayName("neck", "Anatomy");
    Map<String, List<Description>> resultMap = snomedController.findSynonyms(resultList);


    @Test
    void ScoreNeckUnweighted() {
        // create new scoring model
        List<ScoringAlgorithm> algorithms = new ArrayList<>();
        algorithms.add(new Levenshtein(0.5));
        algorithms.add(new LongestCommonSubsequence(0.5));
        ScoringModel scoringModel = new ScoringModel(algorithms);

        //calculates for each result his unweighted score
        resultList.forEach(res -> res.setScore(scoringModel.calcUnweightedScore( "neck", res.getTerm() )));

        Collections.sort(resultList);
        assertEquals(resultList.get(0).getScore(), 3);

    }

    @Test
    void ScoreNeckWeighted() {
        // create new scoring model
        List<ScoringAlgorithm> algorithms = new ArrayList<>();
        algorithms.add(new Levenshtein(0.5));
        algorithms.add(new LongestCommonSubsequence(0.5));
        ScoringModel scoringModel = new ScoringModel(algorithms);

        //calculates for each result his weighted score
        resultList.forEach(res -> res.setScore(scoringModel.calcWeightedScore( "neck", res.getTerm() )));

        Collections.sort(resultList);
        assertEquals(resultList.get(0).getScore(), 2);

    }

    @Test
    void ScoreNeckUnweightedSynonym() {
        // create a new scoring model
        List<ScoringAlgorithm> algorithms = new ArrayList<>();
        algorithms.add(new Levenshtein(0.5));
        algorithms.add(new LongestCommonSubsequence(0.5));
        ScoringModel scoringModel = new ScoringModel(algorithms);

        resultList.forEach(res -> res.setScore(scoringModel.calcUnweightedScoreSynonym("neck", resultMap, res.getConcept().getId()) ));

        Collections.sort(resultList);
        assertEquals(resultList.get(0).getScore(), 19);

    }

    @Test
    void ScoreNeckWeightedSynonym() {
        // create a new scoring model
        List<ScoringAlgorithm> algorithms = new ArrayList<>();
        algorithms.add(new Levenshtein(0.5));
        algorithms.add(new LongestCommonSubsequence(0.5));
        ScoringModel scoringModel = new ScoringModel(algorithms);

        resultList.forEach(res -> res.setScore(scoringModel.calcWeightedScoreSynonym("neck", resultMap, res.getConcept().getId()) ));

        Collections.sort(resultList);
        assertEquals(resultList.get(0).getScore(), 10);

    }

}
