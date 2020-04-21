package at.snomapp.skeleton.restservice;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
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
