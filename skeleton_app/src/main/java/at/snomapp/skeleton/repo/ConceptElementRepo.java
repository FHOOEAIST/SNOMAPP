package at.snomapp.skeleton.repo;

import at.snomapp.skeleton.domain.conceptMapping.Element;
import at.snomapp.skeleton.domain.conceptMapping.impl.APPCElement;
import at.snomapp.skeleton.domain.conceptMapping.impl.AbstractElement;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface ConceptElementRepo extends Neo4jRepository<Element, Long> {

    @Query("MATCH (m:ConceptMap)-[rel:contains]->(e:APPCElement {code: $0, axis: $1}) RETURN e")
    APPCElement findElementByCodeAndAxis(String Code, String Axis);

}
