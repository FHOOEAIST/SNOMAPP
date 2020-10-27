package at.snomapp.skeleton.domain.appc;

import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity(label = "APPCEntry")
public class APPCEntry extends Entry {

    public APPCEntry() {
    }

    public APPCEntry(String displayName, String code, String axis) {
        super(displayName, code, axis);
    }

    @Override
    public String toString() {
        return "\n\t\t APPCEntry{" +
                "code=" + code +
                "axis=" + axis +
                "layerCode=" + layerCode + ", " + super.getDisplayName()  + ", Children= " + super.children  + "}";
    }

}
