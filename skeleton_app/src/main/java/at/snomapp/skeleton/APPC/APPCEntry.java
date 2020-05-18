package at.snomapp.skeleton.appc;

import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity(label = "APPCEntry")
public class APPCEntry extends Entry {

    public APPCEntry() {
    }

    public APPCEntry(String displayName, String code) {
        super(displayName, code);
    }

    @Override
    public String toString() {
        return "\n\t\t APPCEntry{" +
                "code=" + code +
                "layerCode=" + layerCode + ", " + super.getDisplayName()  + ", Children= " + super.children  + "}";
    }

}
