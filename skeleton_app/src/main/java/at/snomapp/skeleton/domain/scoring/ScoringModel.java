package at.snomapp.skeleton.domain.scoring;

import java.util.HashMap;

public class ScoringModel {

    private HashMap<ScoringAlgorithm, Integer> ratingCriteria = new HashMap<>();

    public HashMap<ScoringAlgorithm, Integer> getRatingCriteria() {
        return ratingCriteria;
    }

    public void setRatingCriteria(HashMap<ScoringAlgorithm, Integer> ratingCriteria) {
        this.ratingCriteria = ratingCriteria;
    }


    double calculateResultScore(String sequenceA, String sequenceB){
        double result = 0;
        for (HashMap.Entry<ScoringAlgorithm, Integer> criteria : ratingCriteria.entrySet()){
            result += criteria.getKey().calculateScore(sequenceA, sequenceB) * criteria.getValue();
        }
        return result;
    }

}
