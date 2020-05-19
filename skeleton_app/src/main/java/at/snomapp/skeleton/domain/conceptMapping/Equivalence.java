package at.snomapp.skeleton.domain.conceptMapping;

import org.neo4j.ogm.annotation.NodeEntity;

public interface Equivalence {
    Element getSource();
    Element getDestination();
    EquivalenceType getEquivalence();
}
