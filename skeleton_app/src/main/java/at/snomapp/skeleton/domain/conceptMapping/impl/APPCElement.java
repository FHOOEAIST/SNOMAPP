package at.snomapp.skeleton.conceptMapping.impl;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity(label = "APPCElement")
public class APPCElement extends AbstractElement {

    @Id
    @GeneratedValue
    private Long id;

    public APPCElement(String code){
        this.code = code;
        this.codesystem = "GET URI FOR APPC";
    }
}
