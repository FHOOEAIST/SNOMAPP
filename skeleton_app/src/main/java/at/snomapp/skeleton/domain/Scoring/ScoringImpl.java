package at.snomapp.skeleton.domain.Scoring;

public class ScoringImpl implements Scoring{
    @Override
    public double hammingDistance(String sequenceA, String sequenceB) {
        int count = 0;
        for (int i = 0; i < sequenceA.length(); i++) {
            if (sequenceA.indexOf(i) != sequenceB.indexOf(i)){
                ++count;
            }
        }
        return count;
    }

    @Override
    public double levenshteinDistance(String sequenceA, String sequenceB) {
        return 0;
    }

    @Override
    public double jaccardIndex(String sequenceA, String sequenceB) {
        return 0;
    }

    @Override
    public double sorensenDice(String sequenceA, String sequenceB) {
        return 0;
    }

    @Override
    public double ratcliffObershelpsimilarity(String sequenceA, String sequenceB) {
        return 0;
    }
}
