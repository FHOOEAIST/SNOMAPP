package at.snomapp.skeleton.domain.conceptMapping;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.RelationshipEntity;

public interface Equivalence {
    Element getSource();
    Element getDestination();
    EquivalenceType getEquivalence();
}
