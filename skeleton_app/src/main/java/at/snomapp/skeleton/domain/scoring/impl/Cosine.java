package at.snomapp.skeleton.domain.scoring.impl;

import at.snomapp.skeleton.domain.scoring.ScoringAlgorithm;
import org.apache.commons.text.similarity.CosineDistance;

public class Cosine implements ScoringAlgorithm {

    private CosineDistance cosineDistance = new CosineDistance();
    private double weight;
    private String description = "Cosine Distance";
    private String URL = "https://de.wikipedia.org/wiki/Kosinus-%C3%84hnlichkeit";

    public Cosine(double weight) {
        this.weight = weight;
    }

    @Override
    public double getScore(String sequenceA, String sequenceB) {
        return cosineDistance.apply(sequenceA, sequenceB);
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
