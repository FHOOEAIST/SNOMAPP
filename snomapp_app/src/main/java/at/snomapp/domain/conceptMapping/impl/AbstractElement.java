package at.snomapp.domain.conceptMapping.impl;

import at.snomapp.domain.conceptMapping.Element;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public abstract class AbstractElement implements Element {

    protected String codesystem;
    protected String code;
    protected String displayName;

    @Override
    public String getCode(){
        return code;
    }

    @Override
    public String getCodeSystem(){
        return codesystem;
    }

    @Override
    public String getDisplayName() {
        return displayName;
    }
}
