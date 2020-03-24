package at.snomapp.skeleton.APPC;

import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class APPCEntry extends Entry {

    private int layerCode;

    public APPCEntry(String description, int layerCode) {
        super(description);
        this.layerCode = layerCode;
    }

    public int getLayerCode() {
        return layerCode;
    }
}
