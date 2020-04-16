package at.snomapp.skeleton.APPC.impl;

import at.snomapp.skeleton.APPC.Entry;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class AxisEntry extends Entry {
    public AxisEntry(String description) {
        super(description);
    }
}
