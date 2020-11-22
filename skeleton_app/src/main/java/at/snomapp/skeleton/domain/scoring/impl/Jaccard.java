package at.snomapp.skeleton.domain.scoring.impl;

import at.snomapp.skeleton.domain.scoring.ScoringAlgorithm;
import org.apache.commons.text.similarity.JaccardDistance;

public class Jaccard implements ScoringAlgorithm {

    private JaccardDistance jaccardDistance = new JaccardDistance();
    private double weight;
    private String description = "Jaccard Distance";
    private String URL = "https://de.wikipedia.org/wiki/Jaccard-Koeffizient";

    public Jaccard(double weight) {
        this.weight = weight;
    }

    @Override
    public double getScore(String sequenceA, String sequenceB) {
        return jaccardDistance.apply(sequenceA, sequenceB);
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
