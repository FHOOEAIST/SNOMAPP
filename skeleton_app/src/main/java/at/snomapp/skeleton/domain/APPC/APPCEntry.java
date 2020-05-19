package at.snomapp.skeleton.domain.APPC;

import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity(label = "APPCEntry")
public class APPCEntry extends Entry {

    private int layerCode;

    public APPCEntry() {
    }

    public APPCEntry(String description, int layerCode) {
        super(description);
        this.layerCode = layerCode;
    }

    public int getLayerCode() {
        return layerCode;
    }

    @Override
    public String toString() {
        return "\n\t\t APPCEntry{" +
                "layerCode=" + layerCode + ", " + super.getDescription()  + ", Children= " + super.children  + "}";
    }

}
