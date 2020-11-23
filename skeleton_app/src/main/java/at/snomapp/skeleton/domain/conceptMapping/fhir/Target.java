package at.snomapp.skeleton.domain.conceptMapping.fhir;

public class Target {
    private final String code;
    private final String display;
    private final String equivalence;

    public Target(String code, String display, String equivalence) {
        this.code = code;
        this.display = display;
        this.equivalence = equivalence;
    }

    public String getCode() {
        return code;
    }

    public String getDisplay() {
        return display;
    }

    public String getEquivalence() {
        return equivalence;
    }
}
