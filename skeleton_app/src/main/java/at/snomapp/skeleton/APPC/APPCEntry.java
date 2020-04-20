package at.snomapp.skeleton.APPC;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity(label = "APPCEntry")
public class APPCEntry extends Entry {

    private int layerCode;

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
