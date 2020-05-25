package at.snomapp.skeleton.appc;

import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity(label = "AxisEntry")
public class AxisEntry extends Entry{

    public AxisEntry() {
    }

    public AxisEntry(String displayName) {
        super(displayName, null);
    }

    @Override
    public String toString() {
        return "AxisEntry{" + super.toString() + "}";
    }
}
