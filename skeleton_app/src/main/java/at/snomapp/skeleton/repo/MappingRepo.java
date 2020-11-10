package at.snomapp.skeleton.repo;

import at.snomapp.skeleton.domain.conceptMapping.impl.APPCElement;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MappingRepo extends Neo4jRepository<APPCElement, Long> {

    APPCElement findByAxisAndCode(String axis, String code);

    APPCElement findByAxis(String axis);

    APPCElement findByCode(String code);

    @Query("MATCH (e:APPCElement{axis: $0, code:$1})-[:maps{equivalence: $2}]->(s:SnomedElement) RETURN count(s)")
    int countMappingsWithEquivalenceForAxisAndCode(String axis, String code, String equivalence);
}
