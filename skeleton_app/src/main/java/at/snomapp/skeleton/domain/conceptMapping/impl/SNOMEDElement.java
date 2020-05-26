package at.snomapp.skeleton.domain.conceptMapping.impl;

import at.snomapp.skeleton.domain.conceptMapping.EquivalenceType;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity(label = "SnomedElement")
public class SNOMEDElement extends AbstractElement{

    @Id
    @GeneratedValue
    private Long id;

    public SNOMEDElement(String code){
        this.code = code;
        this.codesystem = "GET URI FOR SNOMED";
    }

}
