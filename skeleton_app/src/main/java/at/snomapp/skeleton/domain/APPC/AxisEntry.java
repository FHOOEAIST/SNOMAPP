package at.snomapp.skeleton.domain.APPC;

import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity(label = "AxisEntry")
public class AxisEntry extends Entry{

    public AxisEntry() {
    }

    public AxisEntry(String description) {
        super(description);
    }

    @Override
    public String toString() {
        return "AxisEntry{" + super.toString() + "}";
    }

}
