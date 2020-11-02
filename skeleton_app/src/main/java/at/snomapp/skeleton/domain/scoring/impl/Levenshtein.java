package at.snomapp.skeleton.domain.scoring.impl;

import at.snomapp.skeleton.domain.scoring.ScoringAlgorithm;
import org.apache.commons.text.similarity.LevenshteinDistance;

public class Levenshtein implements ScoringAlgorithm {

    private LevenshteinDistance levenshteinDistance = new LevenshteinDistance();
    private double weight;

    public Levenshtein(double weight) {
        this.weight = weight;
    }

    @Override
    public double getScore(String sequenceA, String sequenceB) {
        return levenshteinDistance.apply(sequenceA, sequenceB);
    }

    @Override
    public double getWeight() {
        return weight;
    }

}
