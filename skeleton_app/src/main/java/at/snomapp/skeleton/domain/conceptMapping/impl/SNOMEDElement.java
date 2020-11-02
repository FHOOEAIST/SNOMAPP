package at.snomapp.skeleton.domain.conceptMapping.impl;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity(label = "SnomedElement")
public class SNOMEDElement extends AbstractElement{

    @Id
    @GeneratedValue
    private Long id;

    private String displayName;

    public SNOMEDElement(String code, String displayName){
        this.displayName = displayName;
        this.code = code;
        this.codesystem = "GET URI FOR SNOMED";
    }

}
