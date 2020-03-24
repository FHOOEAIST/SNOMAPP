package at.snomapp.skeleton.restservice;

import java.util.List;
import java.util.stream.Collectors;

// tag::hateoas-imports[]
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
// end::hateoas-imports[]

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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


    /*
    @GetMapping( "/entities" )
    List<Entry> all() {
        return this.entryRepository.findAll();
    }

     */
}
