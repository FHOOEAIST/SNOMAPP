package at.snomapp.repo;

import at.snomapp.domain.conceptMapping.Equivalence;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConceptRelationshipRepo extends Neo4jRepository<Equivalence, Long> {

}
