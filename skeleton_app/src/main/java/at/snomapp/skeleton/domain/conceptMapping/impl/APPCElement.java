package at.snomapp.skeleton.domain.conceptMapping.impl;


import at.snomapp.skeleton.domain.conceptMapping.Equivalence;
import at.snomapp.skeleton.domain.conceptMapping.EquivalenceType;
import org.neo4j.ogm.annotation.*;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NodeEntity(label = "APPCElement")
public class APPCElement extends AbstractElement {

    @Relationship(type = "maps")
    private Set<Equivalence> elements = new HashSet<>();

    @Id
    @GeneratedValue
    private Long id;

    @Property
    private String axis;

    public APPCElement(String code, String axis){
        this.code = code;
        this.codesystem = "GET URI FOR APPC";
        this.axis = axis;
    }

    public void add(SNOMEDElement element, EquivalenceType e) {
        Equivalence equivalence = new EquivalenceImpl(this,element, e);
        elements.add(equivalence);
    }

    public Set<Equivalence> getEquivalences(){
        return elements;
    }

    public String getAxis(){
        return axis;
    }


}
