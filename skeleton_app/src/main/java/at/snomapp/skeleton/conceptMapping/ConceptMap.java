package at.snomapp.skeleton.conceptMapping;

import java.io.IOException;

public interface ConceptMap {
    String getSource();
    String getDestination();
    StatusType getStatus();
    void printMap(String filename) throws IOException;
    void addMapping(Element source, Element destination, EquivalenceType equivalence);
    void setStatus(StatusType status);
}
