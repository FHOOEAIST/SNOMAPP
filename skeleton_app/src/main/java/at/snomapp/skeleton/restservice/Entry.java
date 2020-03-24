package at.snomapp.skeleton.restservice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
//resource representation class

@Entity
public class Entry {
    private @Id @GeneratedValue long id;
    private String description;
    private String layerCode;

    public Entry() {}

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