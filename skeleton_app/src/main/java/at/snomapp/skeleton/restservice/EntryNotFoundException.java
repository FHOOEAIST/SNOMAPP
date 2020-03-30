package at.snomapp.skeleton.restservice;

public class EntryNotFoundException extends RuntimeException{
    EntryNotFoundException(Long id){
        super("Could not find Entry "  + id);
    }
}
