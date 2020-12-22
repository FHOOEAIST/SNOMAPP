package at.snomapp.domain.conceptMapping;

import at.snomapp.domain.conceptMapping.impl.APPCElement;
import at.snomapp.domain.conceptMapping.impl.SNOMEDElement;
import org.neo4j.ogm.annotation.NodeEntity;

import java.io.IOException;
import java.util.Set;

@NodeEntity
public interface ConceptMap {
    String getSource();
    String getDestination();
    StatusType getStatus();
    Set<APPCElement> getElements();
    void printMap(String filename) throws IOException;
    void addMapping(APPCElement source, SNOMEDElement destination, EquivalenceType equivalence);
    void setStatus(StatusType status);
}
