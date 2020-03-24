package at.snomapp.skeleton.restservice;


import org.springframework.data.repository.CrudRepository;

public interface EntryRepository extends CrudRepository<Entry, Long> {

}
