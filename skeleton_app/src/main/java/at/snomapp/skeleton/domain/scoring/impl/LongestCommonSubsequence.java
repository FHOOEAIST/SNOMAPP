package at.snomapp.skeleton.domain.scoring.impl;

import at.snomapp.skeleton.domain.scoring.ScoringAlgorithm;
import org.apache.commons.text.similarity.LongestCommonSubsequenceDistance;

public class LongestCommonSubsequence implements ScoringAlgorithm {

    private LongestCommonSubsequenceDistance longestCommonSubsequenceDistance = new LongestCommonSubsequenceDistance();
    private double weight;
    private String description = "Longest Common Subsequence Distance";
    private String URL = "https://en.wikipedia.org/wiki/Longest_common_subsequence_problem";

    public LongestCommonSubsequence(double weight) {
        this.weight = weight;
    }

    @Override
    public double getScore(String sequenceA, String sequenceB) {
        return longestCommonSubsequenceDistance.apply(sequenceA, sequenceB);
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public String getURL() {
        return URL;
    }

    @Override
    public String getDescription() {
        return description;
    }
}

