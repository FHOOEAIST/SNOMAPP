package at.snomapp.skeleton.conceptMapping.impl;

import at.snomapp.skeleton.conceptMapping.*;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@NodeEntity(label = "ConceptMap")
public class ConceptMapImpl implements ConceptMap {

    @Id
    @GeneratedValue
    private Long relationshipId;

    private String source;
    private String destination;
    private StatusType status = StatusType.DRAFT;

    @Relationship(type = "has", direction = "OUTGOING")
    private List<Equivalence> entries = new ArrayList<>();

    public ConceptMapImpl(String source, String destination) {
        this.source = source;
        this.destination = destination;
    }

    @Override
    public String getSource() {
        return source;
    }

    @Override
    public String getDestination() {
        return destination;
    }

    @Override
    public StatusType getStatus() {
        return status;
    }

    @Override
    public void printMap(String filename) throws IOException {
        FileWriter writer = new FileWriter(new File(filename));
        writer.write(this.toString());
        writer.close();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ConceptMapping between ").append(source).append(" and ").append(destination).append(" : {\n");
        for (Equivalence entry : entries) {
            stringBuilder.append(entry.getSource().getCode());
            stringBuilder.append(" -> ");
            stringBuilder.append(entry.getDestination().getCode());
            stringBuilder.append(": ");
            stringBuilder.append(entry.getEquivalence().toString());
            stringBuilder.append("\n");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    @Override
    public void addMapping(Element source, Element destination, EquivalenceType equivalence) {
        Equivalence eq = new EquivalenceImpl(source,destination,equivalence);
        entries.add(eq);
    }

    @Override
    public void setStatus(StatusType status) {
        this.status = status;
    }
}
