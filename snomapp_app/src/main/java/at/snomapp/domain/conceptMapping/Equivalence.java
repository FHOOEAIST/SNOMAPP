package at.snomapp.domain.conceptMapping;

public interface Equivalence {
    Element getSource();
    Element getDestination();
    EquivalenceType getEquivalence();
}
