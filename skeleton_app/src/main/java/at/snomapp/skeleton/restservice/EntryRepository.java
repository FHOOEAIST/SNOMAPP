package at.snomapp.skeleton.restservice;


import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



public interface EntryRepository extends CrudRepository<Entry, Long>{

    Entry findByDescription(String description);

}
