package at.snomapp.restservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

//@RestController
public class EntryController {

    //reference to EntryRepository
    private EntryRepository entryRepository;

    @Autowired
    public EntryController( EntryRepository entryRepository ) {
        this.entryRepository = entryRepository;
    }


    @GetMapping( "/entries" )
    List<Entry> all() {
        return (List<Entry>) this.entryRepository.findAll();
    }

}
