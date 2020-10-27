package at.snomapp.skeleton.domain.scoring;

import java.util.List;

public class ScoringModel {

    // list of algorithms which are applied on given strings
    private List<ScoringAlgorithm> algorithms;

    public ScoringModel(List<ScoringAlgorithm> algorithms) {
        this.algorithms = algorithms;
    }

    // calculates sum of scores of all applied algorithms
    public int calculateWeightedScore(String sequenceA, String sequenceB){
        if (sequenceA == null || sequenceB == null || sequenceA == "" || sequenceB == ""){
            return 0;
        }

        double result = 0;
        for (ScoringAlgorithm algorithm : algorithms){
            // calculate weighted points
            result += algorithm.getScore(sequenceA, sequenceB) * algorithm.getWeight();
        }
        return (int) result;
    }

    public int calculateUnweightedScore(String sequenceA, String sequenceB){
        if (sequenceA == null || sequenceB == null || sequenceA == "" || sequenceB == ""){
            return 0;
        }

        double result = 0;
        for (ScoringAlgorithm algorithm : algorithms) {
            // calculate unweighted points
            result += algorithm.getScore(sequenceA, sequenceB);
        }
        return (int) result;
    }



}
