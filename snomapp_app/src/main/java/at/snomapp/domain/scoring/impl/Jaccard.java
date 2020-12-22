package at.snomapp.domain.scoring.impl;

import at.snomapp.domain.scoring.ScoringAlgorithm;
import org.apache.commons.text.similarity.JaccardDistance;

public class Jaccard implements ScoringAlgorithm {

    private JaccardDistance jaccardDistance = new JaccardDistance();
    private double weight;
    private String description = "Jaccard Distance";
    private String URL = "https://en.wikipedia.org/wiki/Jaccard_index";

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
