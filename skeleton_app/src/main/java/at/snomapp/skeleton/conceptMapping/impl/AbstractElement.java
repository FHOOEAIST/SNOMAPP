package at.snomapp.skeleton.conceptMapping.impl;

import at.snomapp.skeleton.conceptMapping.Element;

public abstract class AbstractElement implements Element {

    protected String codesystem;
    protected String code;

    @Override
    public String getCode(){
        return code;
    }

    @Override
    public String getCodeSystem(){
        return codesystem;
    }

}
