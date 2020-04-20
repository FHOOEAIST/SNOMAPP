package at.snomapp.skeleton.repo;

import at.snomapp.skeleton.APPC.APPCEntry;
import at.snomapp.skeleton.APPC.Entry;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface APPCRepo extends Neo4jRepository<APPCEntry, Long> {
    Entry findByDescription(String Description);
}
