package at.snomapp.skeleton.repo;


import at.snomapp.skeleton.domain.conceptMapping.ConceptMap;
import at.snomapp.skeleton.domain.conceptMapping.impl.ConceptMapImpl;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConceptMapRepo extends Neo4jRepository<ConceptMap, Long> {
    @Query("MATCH (m:ConceptMap)-[rel:contains]->(e:APPCElement {code: $1, axis:$0}) RETURN m")
    Iterable<ConceptMap> findAllByAPPCAxisAndCode(String axis, String code);

    @Query("MATCH (m:ConceptMap)-[rel:contains]->(e:APPCElement {axis:$0}) RETURN m")
    Iterable<ConceptMap> findAllByAPPCAxis(String axis);

    @Query("MATCH (m:ConceptMap)-[rel:contains]->(e:APPCElement {code: $0}) RETURN m")
    Iterable<ConceptMap> findAllByAPPCCode(String code);

}
