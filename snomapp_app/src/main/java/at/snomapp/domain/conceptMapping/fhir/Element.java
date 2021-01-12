package at.snomapp.domain.conceptMapping.fhir;

import java.util.ArrayList;
import java.util.List;

public class Element {
    private final String code;
    private final String display;
    private List<Target> target;

    public Element(String code, String display) {
        this.code = code;
        this.display = display;
    }

    public String getCode() {
        return code;
    }

    public String getDisplay() {
        return display;
    }

    public List<Target> getTarget() {
        return target;
    }

    public void addTarget(Target target){
        if(this.target==null){
            this.target = new ArrayList<>();
        }
        this.target.add(target);
    }
}
