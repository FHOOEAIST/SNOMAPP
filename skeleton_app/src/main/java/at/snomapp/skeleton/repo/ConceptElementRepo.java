package at.snomapp.skeleton.repo;

import at.snomapp.skeleton.domain.conceptMapping.Element;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface ConceptElementRepo extends Neo4jRepository<Element, Long> {
}
