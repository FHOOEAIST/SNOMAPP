package at.snomapp.skeleton.domain.scoring.impl;

import at.snomapp.skeleton.domain.scoring.ScoringAlgorithm;
import org.apache.commons.text.similarity.CosineDistance;

public class Cosine implements ScoringAlgorithm {

    CosineDistance cosineDistance = new CosineDistance();

    @Override
    public double calculateScore(String sequenceA, String sequenceB) {
        return cosineDistance.apply(sequenceA, sequenceB);
    }
}
