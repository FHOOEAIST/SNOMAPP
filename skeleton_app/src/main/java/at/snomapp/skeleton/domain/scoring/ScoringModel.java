package at.snomapp.skeleton.domain.scoring;

import java.util.Map;

public class ScoringModel {

    double calculateStore( Map<ScoringAlgorithm, Integer> ratingCriteria){
        double result = 0;
        for (Map.Entry criteria : ratingCriteria.entrySet()){
            criteria.getKey();
            criteria.getKey();
        }
        return result;
    }

}
