package at.snomapp.skeleton.restservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("search")
// provides endpoints for searching for snomed codes
public class SearchController {

    @GetMapping
    Object findByDisplayName(@RequestParam String displayName){

        return null;
    }
}
