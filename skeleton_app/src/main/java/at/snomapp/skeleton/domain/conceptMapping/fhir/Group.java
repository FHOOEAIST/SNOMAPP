package at.snomapp.skeleton.domain.conceptMapping.fhir;

import java.util.List;

public class Group {

    private final String source;
    private final String target;

    private final List<Element> element;

    public Group(String source, String target, List<Element> element) {
        this.source = source;
        this.target = target;
        this.element = element;
    }

    public String getSource() {
        return source;
    }

    public String getTarget() {
        return target;
    }

    public List<Element> getElement() {
        return element;
    }
}
