package at.snomapp.skeleton.domain.conceptMapping;

import org.neo4j.ogm.annotation.NodeEntity;

import java.io.IOException;

public interface ConceptMap {
    String getSource();
    String getDestination();
    StatusType getStatus();
    void printMap(String filename) throws IOException;
    void addMapping(Element source, Element destination, EquivalenceType equivalence);
    void setStatus(StatusType status);
}
