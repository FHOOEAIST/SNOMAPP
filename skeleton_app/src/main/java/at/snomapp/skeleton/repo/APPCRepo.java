package at.snomapp.skeleton.repo;

import at.snomapp.skeleton.domain.appc.Entry;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
// repository used for storing and retrieving APPC Entries
public interface APPCRepo extends Neo4jRepository<Entry, Long> {
    Entry findByDisplayName(String displayName);
    Iterable<Entry> findAllByDisplayNameContainingIgnoreCase(String displayName);
}
