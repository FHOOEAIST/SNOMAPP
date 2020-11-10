package at.snomapp.skeleton.domain.scoring;

public interface ScoringAlgorithm {

    // a higher score indicates a greater distance
    // 0 = total similarity e.g. Str1 = "foo" and Str2 = "foo" --> best score
    // both string MUST NOT BE NULL or EMPTY

    // range of numbers levenshteinDistance and longestCommonSubsequenceDistance [0 ; infinite]
    // range of numbers jaccardDistance and cosineDistance  [0 ; 1]

    double getScore(String sequenceA, String sequenceB);
    double getWeight();
    String getDescription();
}
