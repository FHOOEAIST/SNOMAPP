package at.snomapp.skeleton.domain.conceptMapping;

public enum EquivalenceType {
    EQUIVALENT("equivalent"),
    EQUAL("equal"),
    WIDER("wider"),
    SUBSUMES("subsumes"),
    NARROWER("narrower"),
    SPECIALIZES("specializes"),
    INEXACT("inexact"),
    UNMATCH("unmatch"),
    DISJOINT("disjoint");

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
