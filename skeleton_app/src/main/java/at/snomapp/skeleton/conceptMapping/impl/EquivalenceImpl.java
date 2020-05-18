package at.snomapp.skeleton.conceptMapping.impl;

import at.snomapp.skeleton.conceptMapping.Element;
import at.snomapp.skeleton.conceptMapping.Equivalence;
import at.snomapp.skeleton.conceptMapping.EquivalenceType;
import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type = "maps")
public class EquivalenceImpl implements Equivalence {

    @Id @GeneratedValue   private Long relationshipId;

    @StartNode
    private Element source;
    @EndNode
    private Element destination;
    @Property(name = "equivalence")
    private EquivalenceType equivalence;

    EquivalenceImpl(Element source, Element destination, EquivalenceType equivalence){
        this.source = source;
        this.destination = destination;
        this.equivalence = equivalence;
    }

    @Override
    public Element getSource() {
        return source;
    }

    @Override
    public Element getDestination() {
        return destination;
    }

    @Override
    public EquivalenceType getEquivalence() {
        return equivalence;
    }
}
