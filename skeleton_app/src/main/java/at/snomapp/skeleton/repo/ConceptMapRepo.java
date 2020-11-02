package at.snomapp.skeleton.repo;


import at.snomapp.skeleton.domain.conceptMapping.ConceptMap;
import at.snomapp.skeleton.domain.conceptMapping.Equivalence;
import at.snomapp.skeleton.domain.conceptMapping.impl.APPCElement;
import at.snomapp.skeleton.domain.conceptMapping.impl.ConceptMapImpl;
import at.snomapp.skeleton.domain.conceptMapping.impl.SNOMEDElement;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Set;

@Repository
public interface ConceptMapRepo extends Neo4jRepository<ConceptMap, Long> {
    @Query("MATCH (m:ConceptMap)-[rel:contains]->(e:APPCElement {code: $1, axis:$0}) RETURN m")
    Iterable<ConceptMap> findAllByAPPCAxisAndCode(String axis, String code);

    @Query("MATCH (m:ConceptMap)-[rel:contains]->(e:APPCElement {axis:$0}) RETURN m")
    Iterable<ConceptMap> findAllByAPPCAxis(String axis);

    @Query("MATCH (m:ConceptMap)-[rel:contains]->(e:APPCElement {code: $0}) RETURN m")
    Iterable<ConceptMap> findAllByAPPCCode(String code);

    @Query("MATCH (m:ConceptMap)-[rel:contains]->(e:APPCElement {code: $0, axis: $1}) RETURN e")
    APPCElement findElementByCodeAndAxis(String Code, String Axis);

    @Query("MATCH (n:APPCElement {code: $0, axis: $1 }) - [:maps]->(s:SnomedElement) RETURN s")
    Iterable<SNOMEDElement> findMappedElementsByCodeAndAxis(String code, String axis);

    @Query("MATCH (:APPCElement{code: $0, axis: $1})-[m:maps]->(s:SnomedElement) return m")
    Iterable<Equivalence> findEquivalenceByAxisAndCode(String code, String axis);

    @Query("MATCH (:APPCElement{code: $0, axis: '$1})-[m:maps]->(s:SnomedElement) \n" +
            "return s.code,m.equivalence\n" +
            "ORDER BY m.id")
    Map<String, String> getSnomedCodeAndEquivalence(String code, String axis);
}
