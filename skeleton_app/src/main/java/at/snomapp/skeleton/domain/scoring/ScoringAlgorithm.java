package at.snomapp.skeleton.domain.scoring;

public interface ScoringAlgorithm {

    double levenshteinDistance (String sequenceA, String sequenceB);
    double jaccardDistance (String sequenceA, String sequenceB);
    double cosineDistance (String sequenceA, String sequenceB);
    double longestCommonSubsequenceDistance (String sequenceA, String sequenceB);
}
