package at.snomapp.domain.scoring.impl;

import at.snomapp.domain.scoring.ScoringAlgorithm;
import org.apache.commons.text.similarity.LevenshteinDistance;

public class Levenshtein implements ScoringAlgorithm {

    private LevenshteinDistance levenshteinDistance = new LevenshteinDistance();
    private double weight;
    private String description = "Levenshtein Distance";
    private String URL = "https://en.wikipedia.org/wiki/Levenshtein_distance";

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

    @Override
    public String getURL() {
        return URL;
    }

    @Override
    public String getDescription() {
        return description;
    }

}
