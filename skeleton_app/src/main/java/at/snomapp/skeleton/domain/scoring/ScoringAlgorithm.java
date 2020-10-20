package at.snomapp.skeleton.domain.scoring;

public interface ScoringAlgorithm {

    // a higher score indicates a greater distance
    // 0 = total similarity e.g. Str1 = "foo" and Str2 = "foo"
    // both string must not be null or empty

    // levenshteinDistance and longestCommonSubsequenceDistance [0 ; infinite]
    // jaccardDistance and cosineDistance  [0 ; 1]

    double calculateScore(String sequenceA, String sequenceB);
}
