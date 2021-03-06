package at.snomapp.domain.scoring;

import io.swagger.client.model.Description;

import java.util.List;
import java.util.Map;

public class ScoringModel {

    public List<ScoringAlgorithm> getAlgorithms() {
        return algorithms;
    }

    // list of algorithms which are applied on given strings
    private List<ScoringAlgorithm> algorithms;

    public ScoringModel(List<ScoringAlgorithm> algorithms) {
        this.algorithms = algorithms;
    }

    // calculates weighted sum of scores of all applied algorithms
    public int calcWeightedScore(String seqA, String seqB){
        if (seqA == null || seqB == null || seqA == "" || seqB == ""){
            return 0;
        }

        double res = 0;
        for (ScoringAlgorithm algorithm : algorithms){
            // calculate weighted points
            res += algorithm.getScore(seqA, seqB) * algorithm.getWeight();
        }
        return (int) Math.round(res);
    }

    // calculates unweighted sum of scores of all applied algorithms
    public int calcUnweightedScore(String seqA, String seqB){
        if (seqA == null || seqB == null || seqA == "" || seqB == ""){
            return 0;
        }

        double res = 0;
        for (ScoringAlgorithm algorithm : algorithms) {
            // calculate unweighted points
            res += algorithm.getScore(seqA, seqB);
        }
        return (int) Math.round(res);
    }



    public int calcWeightedScoreSynonym(String appcDisplayName,  Map<String, List<Description>> resMap, String snomedCode){
        List<Description> synonyms = resMap.get(snomedCode);
        if (synonyms == null || synonyms.size() == 0){
            return 0;
        }

        // adds all weighted scores of existing synonyms
        double res = synonyms.stream().mapToDouble(synonym -> calcWeightedScore(appcDisplayName, synonym.getTerm())).sum();

        // calculates mean of all scores
        res = res / synonyms.size();

        return (int) Math.round(res);
    }

    public int calcUnweightedScoreSynonym(String appcDisplayName,  Map<String, List<Description>> resMap, String snomedCode){
        List<Description> synonyms = resMap.get(snomedCode);
        if (synonyms == null || synonyms.size() == 0){
            return 0;
        }

        // adds all unweighted scores of existing synonyms
        double res = synonyms.stream().mapToDouble(synonym -> calcUnweightedScore(appcDisplayName, synonym.getTerm())).sum();

        // calculates mean of all scores
        res = res / synonyms.size();

        return (int) Math.round(res);
    }


}
