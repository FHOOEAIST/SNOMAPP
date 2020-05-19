package at.snomapp.skeleton.domain.conceptMapping;

import at.snomapp.skeleton.domain.conceptMapping.impl.EquivalenceImpl;
import at.snomapp.skeleton.domain.conceptMapping.impl.SNOMEDElement;
import org.neo4j.ogm.annotation.NodeEntity;


public interface Element {
    String getCode();
    String getCodeSystem();

    void add(SNOMEDElement destination);
}
