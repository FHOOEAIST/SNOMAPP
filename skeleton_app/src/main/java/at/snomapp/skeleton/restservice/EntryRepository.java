package at.snomapp.skeleton.restservice;
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;



@RepositoryRestResource(collectionResourceRel = "entries", path = "entries")
public interface EntryRepository extends PagingAndSortingRepository<Entry, Long>{

   List<Entry>findByDescription (@Param("description") String description);
}



