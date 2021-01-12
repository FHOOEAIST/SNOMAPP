package at.snomapp.domain.conceptMapping.fhir;

import java.util.List;

public class ConceptMapFHIRResource {

    private final String status;
    private final String source;
    private final String target;

    private final List<Group> group;

    public ConceptMapFHIRResource(String status, String source, String target, List<Group> group) {
        this.status = status;
        this.source = source;
        this.target = target;
        this.group = group;
    }

    public String getStatus() {
        return status;
    }

    public String getSource() {
        return source;
    }

    public String getTarget() {
        return target;
    }

    public List<Group> getGroup() {
        return group;
    }
}
