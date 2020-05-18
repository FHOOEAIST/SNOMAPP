package at.snomapp.skeleton.conceptMapping.impl;

import at.snomapp.skeleton.conceptMapping.Element;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public abstract class AbstractElement implements Element {

    @Id
    @GeneratedValue
    private Long id;

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
