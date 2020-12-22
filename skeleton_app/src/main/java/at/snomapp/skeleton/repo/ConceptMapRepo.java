package at.snomapp.skeleton.repo;

import at.snomapp.skeleton.domain.conceptMapping.ConceptMap;
import at.snomapp.skeleton.domain.conceptMapping.Equivalence;
import at.snomapp.skeleton.domain.conceptMapping.impl.APPCElement;
import at.snomapp.skeleton.domain.conceptMapping.impl.SNOMEDElement;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ConceptMapRepo extends Neo4jRepository<ConceptMap, Long>{
    @Query("MATCH (m:ConceptMap)-[rel:contains]->(e:APPCElement {code: $1, axis:$0}) RETURN m")
    Iterable<ConceptMap> findAllByAPPCAxisAndCode(String axis, String code);

    @Query("MATCH (m:ConceptMap)-[rel:contains]->(e:APPCElement {axis:$0}) RETURN m")
    Iterable<ConceptMap> findAllByAPPCAxis(String axis);

    @Query("MATCH (m:ConceptMap)-[rel:contains]->(e:APPCElement {code: $0}) RETURN m")
    Iterable<ConceptMap> findAllByAPPCCode(String code);

    @Query("MATCH (m:ConceptMap)-[rel:contains]->(e:APPCElement {code: $0, axis: $1}) RETURN e")
    APPCElement findElementByCodeAndAxis(String Code, String Axis);

    @Query("MATCH (m:ConceptMap)-[rel:contains]->(e:APPCElement {code: $0}) RETURN e")
    APPCElement findElementByAxis(String axis);

    @Query("MATCH (m:ConceptMap)-[rel:contains]->(e:APPCElement {axis: $0}) RETURN e")
    APPCElement findElementByCode(String code);

    @Query("MATCH (n:APPCElement {code: $0, axis: $1 }) - [:maps]->(s:SnomedElement) RETURN s")
    Iterable<SNOMEDElement> findMappedElementsByCodeAndAxis(String code, String axis);

    @Query("MATCH (:APPCElement{code: $0, axis: $1})-[m:maps]->(s:SnomedElement) return m")
    Iterable<Equivalence> findEquivalenceByAxisAndCode(String code, String axis);

    @Query("MATCH (:APPCElement{code: $0, axis: $1})-[m:maps]->(s:SnomedElement) \n" +
            "return s.code,m.equivalence,s.displayName\n" +
            "ORDER BY m.id")
    Iterable<Map<String, Object>> getSnomedCodeAndEquivalence(String code, String axis);

    @Query("MATCH (e:APPCElement{axis: $0, code:$1})-[:maps{equivalence: $2}]->(s:SnomedElement) RETURN count(s)")
    int countMappingsWithEquivalenceForAxisAndCode(String axis, String code, String equivalence);

    @Query("MATCH (a:APPCElement{axis: $1, code: $0})-[m:maps]->(s:SnomedElement) WHERE m.equivalence = 'EQUIVALENT' OR m.equivalence = 'EQUAL' RETURN s")
    List<SNOMEDElement> findEquivalentOrEqualSnomedElementsForAPPC(String code, String axis);

    // Consider moving this when cleaning up the repos
    @Query("MATCH (n:SnomedElement) WHERE id(n)= $0 RETURN n ")
    SNOMEDElement findSnomedElementById(long id);
}

