package at.snomapp.skeleton.domain.APPC;

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
    private String description;

    public Entry() {
    }

    // bidirectional 1..n relationship between children and parent entries
    @Relationship(type = "child")
    protected Set<Entry> children;

    @Relationship(type = "child", direction = "INCOMING")
    @JsonIgnore
    protected Entry parent;

    public Entry(String description) {
        this.description = description;
        children = new HashSet<>();
        parent = null;
    }

    public void addChild(APPCEntry child) {
        children.add(child);
        child.parent = this;
    }

    public String getDescription() {
        return description;
    }

    public Set<Entry> getChildren() {
        return children;
    }

    public Entry getParent(){
        return parent;
    }

    // returns a set containing all exact matches
    public Set<Entry> search(String query) {
        Set<Entry> result = new HashSet<>();
        if (description.equals(query)) {
            result.add(this);
        }
        children.forEach(e -> {
            result.addAll(e.search(query));
        });

        return result;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "id=" + id +
                ", description='" + description + '\'' +
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
