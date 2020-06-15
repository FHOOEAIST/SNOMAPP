package at.snomapp.skeleton.repo;

import at.snomapp.skeleton.domain.conceptMapping.impl.APPCElement;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MappingRepo extends Neo4jRepository<APPCElement, Long> {

    APPCElement findByAxisAndCode(String axis, String code);

    APPCElement findByAxis(String axis);

    APPCElement findByCode(String code);
}
