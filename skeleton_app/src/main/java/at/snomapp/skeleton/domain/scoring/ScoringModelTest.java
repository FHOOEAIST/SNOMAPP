package at.snomapp.skeleton.domain.scoring;

import at.snomapp.skeleton.domain.scoring.impl.Cosine;
import at.snomapp.skeleton.domain.scoring.impl.Jaccard;
import at.snomapp.skeleton.domain.scoring.impl.Levenshtein;
import at.snomapp.skeleton.domain.scoring.impl.LongestCommonSubsequence;

import java.util.ArrayList;
import java.util.List;

public class ScoringModelTest {

    public static void test (ScoringModel model, String str1, String str2){
        // calculate weightedScore
        Double weightedScore = model.calculateWeightedScore(str1, str2);
        // calculate unweightedScore
        Double unweightedScore = model.calculateUnweightedScore(str1, str2);

        System.out.println("Str1: " + str1 + " Str2: " + str2);
        System.out.println("Weighted Score: " + weightedScore);
        System.out.println("Unweighted Score: " + unweightedScore);
    }

    public static void main(String[] args) {

        // scoring model contains list of algorithms which are applied on given strings
        List<ScoringAlgorithm> algorithms = new ArrayList<>();

        algorithms.add(new Cosine(0.2));
        algorithms.add(new Jaccard(0.3));
        algorithms.add(new Levenshtein(0.7));
        algorithms.add(new LongestCommonSubsequence(0.7));

        ScoringModel scoringModel = new ScoringModel(algorithms);

        test(scoringModel, "foo", "foo");
        test(scoringModel, "test", "blablabla");
        test(scoringModel, "hallo", "hello");

    }
}
