package at.snomapp.skeleton.APPC.impl;

import at.snomapp.skeleton.APPC.Entry;
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
