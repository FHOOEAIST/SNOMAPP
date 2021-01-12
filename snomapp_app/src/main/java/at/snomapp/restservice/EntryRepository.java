package at.snomapp.restservice;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


//@RepositoryRestResource(collectionResourceRel = "entries", path = "entries")
public interface EntryRepository extends PagingAndSortingRepository<Entry, Long>{

   List<Entry>findByDescription (@Param("description") String description);
}



