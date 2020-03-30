package at.snomapp.skeleton.restservice;


import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EntryRepository extends Neo4jRepository<Entry, Long> {    //????

}
