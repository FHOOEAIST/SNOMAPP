package at.snomapp.skeleton.domain.conceptMapping.impl;

import at.snomapp.skeleton.domain.conceptMapping.*;
import org.neo4j.ogm.annotation.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

@NodeEntity(label = "ConceptMap")
public class ConceptMapImpl implements ConceptMap {

    @Id
    @GeneratedValue
    private Long id;

    @Property
    private final String source;
    @Property
    private final String destination;
    @Property
    private StatusType status = StatusType.DRAFT;

    @Relationship(type = "contains")
    private Set<APPCElement> elements = new HashSet<>();

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
    public Set<APPCElement> getElements() {
        return elements;
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
        for (APPCElement appc : elements) {
            for (Equivalence equivalence : appc.getEquivalences()){
                stringBuilder.append(equivalence.getSource().getCode());
                stringBuilder.append(" from axis ").append(appc.getAxis());
                stringBuilder.append(" -> ");
                stringBuilder.append(equivalence.getDestination().getCode());
                stringBuilder.append(": ");
                stringBuilder.append(equivalence.getEquivalence().toString());
                stringBuilder.append("\n");
            }
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    @Override
    public void addMapping(APPCElement source, SNOMEDElement destination, EquivalenceType equivalence) {
        elements.add(source);
        source.add(destination,equivalence);
    }

    @Override
    public void setStatus(StatusType status) {
        this.status = status;
    }
}
