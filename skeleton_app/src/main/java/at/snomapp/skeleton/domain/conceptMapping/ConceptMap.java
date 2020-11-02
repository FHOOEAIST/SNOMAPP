package at.snomapp.skeleton.domain.conceptMapping;

import at.snomapp.skeleton.domain.conceptMapping.impl.APPCElement;
import at.snomapp.skeleton.domain.conceptMapping.impl.SNOMEDElement;
import org.neo4j.ogm.annotation.NodeEntity;

import java.io.IOException;

@NodeEntity
public interface ConceptMap {
    String getSource();
    String getDestination();
    StatusType getStatus();
    void printMap(String filename) throws IOException;
    void addMapping(APPCElement source, SNOMEDElement destination, EquivalenceType equivalence);
    void setStatus(StatusType status);
}
