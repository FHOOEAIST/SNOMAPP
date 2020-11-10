package at.snomapp.skeleton.domain.conceptMapping.impl;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity(label = "SnomedElement")
public class SNOMEDElement extends AbstractElement{

    @Id
    @GeneratedValue
    private Long id;

    private final String displayName;
    private final String code;

    public SNOMEDElement(String code, String displayName){
        this.displayName = displayName;
        this.code = code;
        this.codesystem = "2.16.840.1.113883.6.96";
    }

    public Long getId() {
        return id;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String getCode() {
        return code;
    }
}
