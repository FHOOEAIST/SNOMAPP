package at.snomapp.domain.conceptMapping;

public enum EquivalenceType {
    EQUIVALENT("EQUIVALENT"),
    EQUAL("EQUAL"),
    WIDER("WIDER"),
    SUBSUMES("SUBSUMES"),
    NARROWER("NARROWER"),
    SPECIALIZES("SPECIALIZES"),
    INEXACT("INEXACT"),
    UNMATCH("UNMATCH"),
    DISJOINT("DISJOINT");

    private final String equivalenceType;

    EquivalenceType(String equivalenceType) {
        this.equivalenceType = equivalenceType;
    }

    public static EquivalenceType fromString(String value) {
        for (EquivalenceType e : EquivalenceType.values()) {
            if (e.equivalenceType.equals(value)) {
                return e;
            }
        }
        return null;
    }


    @Override
    public String toString() {
        return equivalenceType;
    }
}
