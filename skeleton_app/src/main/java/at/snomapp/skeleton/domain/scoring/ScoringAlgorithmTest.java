package at.snomapp.skeleton.domain.scoring;

public class ScoringAlgorithmTest {


    public static void main(String[] args) {
        ScoringAlgorithm scoringAlgorithm = new ScoringAlgorithmImpl();

        String seq1 = "test";
        String seq2 = "Kräutertee";

        System.out.println("levenshteinDistance: " + scoringAlgorithm.levenshteinDistance(seq1, seq2));
        System.out.println("jaccardDistance: " + scoringAlgorithm.jaccardDistance(seq1, seq2));
        System.out.println("cosineDistance: " + scoringAlgorithm.cosineDistance(seq1, seq2));
        System.out.println("longestCommonSubsequenceDistance: " + scoringAlgorithm.longestCommonSubsequenceDistance(seq1, seq2));

    }
}
