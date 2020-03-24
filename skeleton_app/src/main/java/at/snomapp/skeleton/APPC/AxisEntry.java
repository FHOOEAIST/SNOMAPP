package at.snomapp.skeleton.APPC;

import org.neo4j.ogm.annotation.NodeEntity;

import java.util.HashSet;
import java.util.Set;

@NodeEntity
public class AxisEntry extends Entry{
    public AxisEntry(String description) {
        super(description);
    }
}
