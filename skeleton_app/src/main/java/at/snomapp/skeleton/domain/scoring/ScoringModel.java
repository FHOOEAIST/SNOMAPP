package at.snomapp.skeleton.domain.scoring;

import java.util.List;

public class ScoringModel {

    // list of algorithms which are applied on given strings
    private List<ScoringAlgorithm> algorithms;

    public ScoringModel(List<ScoringAlgorithm> algorithms) {
        this.algorithms = algorithms;
    }

    // calculates sum of scores of all applied algorithms
    double calculateWeightedScore(String sequenceA, String sequenceB){
        double result = 0;
        for (ScoringAlgorithm algorithm : algorithms){
            // calculate weighted points
            result += algorithm.getScore(sequenceA, sequenceB) * algorithm.getWeight();
            //System.out.println(algorithm.getClass().getName() + " " + algorithm.getScore(sequenceA, sequenceB) * algorithm.getWeight());
        }
        return result;
    }

    double calculateUnweightedScore(String sequenceA, String sequenceB){
        double result = 0;
        for (ScoringAlgorithm algorithm : algorithms){
            // calculate unweighted points
            result += algorithm.getScore(sequenceA, sequenceB);
            //System.out.println(algorithm.getClass().getName() + " " + algorithm.getScore(sequenceA, sequenceB));
        }
        return result;
    }



}
