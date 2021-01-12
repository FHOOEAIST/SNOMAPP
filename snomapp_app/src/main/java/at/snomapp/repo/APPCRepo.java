package at.snomapp.repo;

import at.snomapp.domain.appc.Entry;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
// repository used for storing and retrieving APPC Entries
public interface APPCRepo extends Neo4jRepository<Entry, Long> {
    Entry findByDisplayName(String displayName);
    Entry findByCode(String code);
    @Query("MATCH (n:APPCEntry{code: $0, axis: $1}) RETURN n")
    Entry findByCodeAndAxis(String code, String axis);
    Iterable<Entry> findAllByDisplayNameContainingIgnoreCase(String displayName);
}
