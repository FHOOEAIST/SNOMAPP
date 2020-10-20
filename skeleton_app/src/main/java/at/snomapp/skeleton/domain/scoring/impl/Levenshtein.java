package at.snomapp.skeleton.domain.scoring.impl;

import at.snomapp.skeleton.domain.scoring.ScoringAlgorithm;
import org.apache.commons.text.similarity.LevenshteinDistance;

public class Levenshtein implements ScoringAlgorithm {

    LevenshteinDistance levenshteinDistance = new LevenshteinDistance();

    @Override
    public double calculateScore(String sequenceA, String sequenceB) {
        return levenshteinDistance.apply(sequenceA, sequenceB);
    }
}
