package at.snomapp.skeleton.domain.scoring;


import org.apache.commons.text.similarity.*;

public class ScoringAlgorithmImpl implements ScoringAlgorithm {

    private LevenshteinDistance levenshteinDistance = new LevenshteinDistance();
    private JaccardDistance jaccardDistance = new JaccardDistance();
    private CosineDistance cosineDistance = new CosineDistance();
    private LongestCommonSubsequenceDistance longestCommonSubsequenceDistance = new LongestCommonSubsequenceDistance();

    // a higher score indicates a greater distance
    // 0 = total similarity e.g. Str1 = "foo" and Str2 = "foo"
    // both string must not be null or empty

    // levenshteinDistance and longestCommonSubsequenceDistance [0 ; infinite]
    // jaccardDistance and cosineDistance  [0 ; 1]

    @Override
    public double levenshteinDistance(String sequenceA, String sequenceB) {
        return levenshteinDistance.apply(sequenceA, sequenceB);
    }

    @Override
    public double jaccardDistance(String sequenceA, String sequenceB) {
        return jaccardDistance.apply(sequenceA, sequenceB);
    }

    @Override
    public double cosineDistance(String sequenceA, String sequenceB) {
        return cosineDistance.apply(sequenceA, sequenceB);
    }

    @Override
    public double longestCommonSubsequenceDistance(String sequenceA, String sequenceB) {
        return longestCommonSubsequenceDistance.apply(sequenceA, sequenceB);
    }
}
