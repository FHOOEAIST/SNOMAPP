package at.snomapp.skeleton.APPC;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Set;

public abstract class Entry {
    @Id
    @GeneratedValue
    private Long id;
    private String description;

    // bydirectional 1..n relationship between children and parent entries
    @Relationship(type = "child")
    protected Set<APPCEntry> children;

    @Relationship(type = "child", direction = "INCOMING")
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

    public Set<APPCEntry> getChildren() {
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
}
