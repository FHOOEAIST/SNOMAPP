package at.snomapp.skeleton.conceptMapping.impl;

import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity(label = "APPCElement")
public class APPCElement extends AbstractElement {

    public APPCElement(String code){
        this.code = code;
        this.codesystem = "GET URI FOR APPC";
    }
}
