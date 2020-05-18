package at.snomapp.skeleton.conceptMapping.impl;

public class SNOMEDElement extends AbstractElement{

    public SNOMEDElement(String code){
        this.code = code;
        this.codesystem = "GET URI FOR SNOMED";
    }
}
