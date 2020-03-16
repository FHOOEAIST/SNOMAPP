package at.snomapp.skeleton.testapplication.controller;

import at.snomapp.skeleton.testapplication.repo.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

// this class makes it possible to send http requests to our application
// the RestController annotation automatically sets up everything we need on launch
// all that is left to do is to configure the routes
@RequestMapping("/demo")
@RestController
public class ControllerTest {

    private Repo repo;

    // right here dependency injection is used to save us the hassle of setting default values
    @Autowired
    ControllerTest(@Qualifier("StackRepo") Repo repo){
        this.repo = repo;
    }

    // should simply print a message to the browser if localhost:8080/demo is entered
    @GetMapping
    public String getDefaultResponse(){
        return "Hello there";
    }

    // used to save data to the repository. send unformatted strings in the request body
    // there are also cool ways to use json and autoconvert to classes
    @PostMapping("/save")
    public void saveData(@RequestBody String s){
        System.out.println(s);
        if(repo.saveData(s)){
            System.out.println("insert successful");
        }else{
            System.out.println("repository rejected insert");
        }
    }

    // retrieves all data from the repository and prints it
    // sent as raw string
    @GetMapping("/retrieve")
    public String[] getData(){
        return repo.getData();
    }

}
