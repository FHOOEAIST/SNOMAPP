package at.snomapp.domain.scoring.impl;

import at.snomapp.domain.scoring.ScoringAlgorithm;
import org.apache.commons.text.similarity.CosineDistance;

public class Cosine implements ScoringAlgorithm {

    private CosineDistance cosineDistance = new CosineDistance();
    private double weight;
    private String description = "Cosine Distance";
    private String URL = "https://en.wikipedia.org/wiki/Cosine_similarity";

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
