package at.snomapp.skeleton.domain.scoring.impl;

import at.snomapp.skeleton.domain.scoring.ScoringAlgorithm;
import org.apache.commons.text.similarity.LongestCommonSubsequenceDistance;

public class LongestCommonSubsequence implements ScoringAlgorithm {

    LongestCommonSubsequenceDistance longestCommonSubsequenceDistance = new LongestCommonSubsequenceDistance();

    @Override
    public double calculateScore(String sequenceA, String sequenceB) {
        return longestCommonSubsequenceDistance.apply(sequenceA, sequenceB);
    }
}

