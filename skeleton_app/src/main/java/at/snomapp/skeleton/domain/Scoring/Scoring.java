package at.snomapp.skeleton.domain.Scoring;

public interface Scoring {


    double hammingDistance (String sequenceA, String sequenceB);
    double levenshteinDistance (String sequenceA, String sequenceB);
    double jaccardIndex (String sequenceA, String sequenceB);
    double sorensenDice (String sequenceA, String sequenceB);
    double ratcliffObershelpsimilarity (String sequenceA, String sequenceB);

}
