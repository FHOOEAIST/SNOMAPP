package at.snomapp.skeleton.restservice;

import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EntryController {

    //reference to EntryRespository
    private EntryRepository entryRepository;

    @Autowired
    public EntryController( EntryRepository entryRepository ) {
        this.entryRepository = entryRepository;
    }


    @GetMapping( "/entries" )
    List<Entry> all() {
        return (List<Entry>) this.entryRepository.findAll(); //findAll returns Iterator??
     }

    @GetMapping("/entries/{id}")
    Entry one( @PathVariable("id") Long id ) {
        Entry entry = entryRepository.findById(id).orElseThrow( () -> new EntryNotFoundException(id) );
        return entry;
    }

    @PostMapping("/entries")
    Entry newEntry( @RequestBody Entry newEntry ) {
        return entryRepository.save( newEntry );
    }
}
