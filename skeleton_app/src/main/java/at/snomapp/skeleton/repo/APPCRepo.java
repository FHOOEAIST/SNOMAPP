package at.snomapp.skeleton.repo;

import at.snomapp.skeleton.domain.appc.Entry;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository used for storing and retrieving APPC Entries.
 */
@Repository
public interface APPCRepo extends Neo4jRepository<Entry, Long> {
    Entry findByDisplayName(String displayName);
    Entry findByCode(String code);
    @Query("MATCH (n:APPCEntry{code: $0, axis: $1}) RETURN n")
    Entry findByCodeAndAxis(String code, String axis);
    Iterable<Entry> findAllByDisplayNameContainingIgnoreCase(String displayName);
}
