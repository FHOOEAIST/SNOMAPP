package at.snomapp.skeleton.domain.appc;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Set;

@NodeEntity
public abstract class Entry {

    @Id
    @GeneratedValue
    private Long id;
    protected String displayName;
    protected int layerCode;
    protected String code;
    protected String axis;

    public Entry() {
    }

    // bidirectional 1..n relationship between children and parent entries
    @Relationship(type = "child")
    protected Set<Entry> children;

    @Relationship(type = "child", direction = "INCOMING")
    @JsonIgnore
    protected Entry parent;

    public Entry(String description, String code, String axis) {
        this.displayName = description;
        this.children = new HashSet<>();
        this.parent = null;
        this.code = code;
        this.axis = (axis != null ? axis : description);

        if (code != null && !code.isEmpty()) {
            // if code is given save last position separately as layerCode
            String[] codes = code.split("-");
            try {
                this.layerCode = Integer.parseInt(codes[codes.length-1]);
            } catch (NumberFormatException e) {
                // no parsable integer found
                this.layerCode = -1;
            }
        }else{
            // no code given
            this.layerCode = -1;
        }
    }

    public void addChild(Entry child) {
        children.add(child);
        child.parent = this;
        child.axis = child.getParent().axis;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getLayerCode() {
        return layerCode;
    }

    public String getCode() {
        return code;
    }

    public Set<Entry> getChildren() {
        return children;
    }

    public Entry getParent() {
        return parent;
    }

    public String getAxis() { return axis; }

    // returns a set containing all exact matches
    public Set<Entry> search(String query) {
        Set<Entry> result = new HashSet<>();
        if (displayName.equals(query)) {
            result.add(this);
        }
        children.forEach(e -> result.addAll(e.search(query)));

        return result;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "id=" + id +
                ", description='" + displayName + '\'' +
                "\n\t children=" + children +
                "\n\t parent=" + parent +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
