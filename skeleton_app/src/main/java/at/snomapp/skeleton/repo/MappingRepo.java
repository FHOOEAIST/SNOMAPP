package at.snomapp.skeleton.repo;

import at.snomapp.skeleton.domain.conceptMapping.impl.APPCElement;
import at.snomapp.skeleton.domain.conceptMapping.impl.SNOMEDElement;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MappingRepo extends Neo4jRepository<APPCElement, Long> {

    APPCElement findByAxisAndCode(String axis, String code);

    APPCElement findByAxis(String axis);

    APPCElement findByCode(String code);

    @Query("MATCH (e:APPCElement{axis: $0, code:$1})-[:maps{equivalence: $2}]->(s:SnomedElement) RETURN count(s)")
    int countMappingsWithEquivalenceForAxisAndCode(String axis, String code, String equivalence);

    @Query("MATCH (a:APPCElement{axis: $1, code: $0})-[m:maps]->(s:SnomedElement) WHERE m.equivalence = 'EQUIVALENT' OR m.equivalence = 'EQUAL' RETURN s")
    List<SNOMEDElement> findEquivalentOrEqualSnomedElementsForAPPC(String code, String axis);

    // Consider moving this when cleaning up the repos
    @Query("MATCH (n:SnomedElement) WHERE id(n)= 658 RETURN n ")
    SNOMEDElement findSnomedElementById(long id);
}
