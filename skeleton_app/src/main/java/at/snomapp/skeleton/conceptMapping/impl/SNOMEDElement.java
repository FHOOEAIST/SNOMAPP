package at.snomapp.skeleton.conceptMapping.impl;

import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity(label = "SnomedElement")
public class SNOMEDElement extends AbstractElement{

    public SNOMEDElement(String code){
        this.code = code;
        this.codesystem = "GET URI FOR SNOMED";
    }
}
