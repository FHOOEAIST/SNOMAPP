package at.snomapp.skeleton.restservice;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;


//resource representation class
@NodeEntity
public class Entry {
    @Id @GeneratedValue long id;
    private String description;
    private String layerCode;


    private Entry() {};

    public Entry(long id, String description, String layerCode ){
        this.id = id;
        this.description = description;
        this.layerCode = layerCode;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) { this.id = id; }

    public String getDescription() { return description; }

    public void setDescription(String Description) { this.description = description; }

    public String getLayerCode() { return layerCode; }

    public void setLayerCode(String layerCode) { this.layerCode = layerCode; }

}