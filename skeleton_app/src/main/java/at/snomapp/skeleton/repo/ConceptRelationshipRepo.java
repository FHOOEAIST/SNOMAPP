package at.snomapp.skeleton.repo;

import at.snomapp.skeleton.APPC.Entry;
import at.snomapp.skeleton.conceptMapping.Equivalence;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConceptRelationshipRepo extends Neo4jRepository<Equivalence, Long> {
}
