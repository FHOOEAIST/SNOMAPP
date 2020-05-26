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

    private String axis;

    public APPCElement(String code, String axis){
        this.code = code;
        this.axis = axis;
        switch (axis){
            case "anatomy":
                this.codesystem = "1.2.40.0.34.5.38.4";
                break;
            case "laterality":
                this.codesystem = "1.2.40.0.34.5.38.2";
                break;
            case "modality":
                this.codesystem = "1.2.40.0.34.5.38.1";
                break;
            case "procedure":
                this.codesystem = "1.2.40.0.34.5.38.3";
                break;
            default:
                this.codesystem = "1.2.40.0.34.5.38";
                break;
        }
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
