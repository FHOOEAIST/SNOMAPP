package at.snomapp.skeleton.repo;

import at.snomapp.skeleton.APPC.Entry;
import at.snomapp.skeleton.conceptMapping.ConceptMap;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConceptMapRepo extends Neo4jRepository<ConceptMap, Long> {

}
