package at.snomapp.domain.conceptMapping.impl;

import at.snomapp.domain.conceptMapping.Element;
import at.snomapp.domain.conceptMapping.Equivalence;
import at.snomapp.domain.conceptMapping.EquivalenceType;
import at.snomapp.domain.convert.EquivalenceTypeConverter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.neo4j.ogm.annotation.*;
import org.neo4j.ogm.annotation.typeconversion.Convert;

@RelationshipEntity(type = "maps")
public class EquivalenceImpl implements Equivalence {

    @Id @GeneratedValue private Long relationshipId;

    @JsonIgnore
    @StartNode private Element source;

    @EndNode private Element destination;

    @Property(name = "equivalence")
    @Convert(EquivalenceTypeConverter.class)
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


    // TODO: check if neccessary
    public Long getRelationshipId() {
        return relationshipId;
    }

    public void setRelationshipId(Long relationshipId) {
        this.relationshipId = relationshipId;
    }
}
