package at.snomapp.skeleton.domain.scoring.impl;

import at.snomapp.skeleton.domain.scoring.ScoringAlgorithm;
import org.apache.commons.text.similarity.JaccardDistance;

public class Jaccard implements ScoringAlgorithm {

    JaccardDistance jaccardDistance = new JaccardDistance();

    @Override
    public double calculateScore(String sequenceA, String sequenceB) {
        return jaccardDistance.apply(sequenceA, sequenceB);
    }
}
