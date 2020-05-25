package at.snomapp.skeleton.domain.conceptMapping.impl;

import at.snomapp.skeleton.domain.conceptMapping.Element;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
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
