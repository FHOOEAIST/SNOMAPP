package at.snomapp.skeleton.restservice;

import at.snomapp.skeleton.repo.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

//@RestController
public class EntryController {

    // Reference to EntryRepository.
    private EntryRepository entryRepository;

    @Autowired
    public EntryController( EntryRepository entryRepository ) {
        this.entryRepository = entryRepository;
    }

    /**
     * Get a list of all APPC entries.
     * @return {@link List<Entry>}
     */
    @GetMapping( "/entries" )
    List<Entry> all() {
        return (List<Entry>) this.entryRepository.findAll();
    }

}
