package at.snomapp.skeleton.domain.scoring.impl;

import at.snomapp.skeleton.domain.scoring.ScoringAlgorithm;
import org.apache.commons.text.similarity.CosineDistance;

public class Cosine implements ScoringAlgorithm {

    private CosineDistance cosineDistance = new CosineDistance();
    private double weight;
    private String description = "Cosine Distance";

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
    public String getDescription() {
        return description;
    }


}
