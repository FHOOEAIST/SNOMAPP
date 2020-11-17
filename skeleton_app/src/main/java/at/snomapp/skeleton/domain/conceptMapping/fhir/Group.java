package at.snomapp.skeleton.domain.conceptMapping.fhir;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Group {

    private final String source;
    private final String target;
    private List<Element> element;

    public Group(String source, String target) {
        this.source = source;
        this.target = target;
        this.element = null;
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

    public void addElement(Element element){
        if(this.element==null){
            this.element = new ArrayList<>();
        }
        this.element.add(element);
    }
}
