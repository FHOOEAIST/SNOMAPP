package at.snomapp.skeleton.restservice;

import io.swagger.client.ApiException;
import io.swagger.client.api.ConceptsApi;
import io.swagger.client.model.ItemsPageConceptMini;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("snomed")
// provides endpoints for searching for snomed codes
public class SearchController {


    private ConceptsApi api = new ConceptsApi();

    public SearchController() {
        // TODO: add our snowstorm URL here
        //  api.getApiClient().setBasePath();
    }

    @GetMapping
    ItemsPageConceptMini findByDisplayName(@RequestParam String displayName){
        String branch = "MAIN";
        String acceptLanguage = "en-X-900000000000509007,en-X-900000000000508004,en";
        Boolean activeFilter = null;
        String definitionStatusFilter = null;
        String term = displayName;
        Boolean termActive = null;
        String ecl = null;
        String statedEcl = null;
        List<String> conceptIds = null;
        Integer offset = null;
        Integer limit = null;
        String searchAfter = null;

        ItemsPageConceptMini response = null;

        try {
            response = api.findConceptsUsingGET(branch, acceptLanguage, activeFilter,
                    definitionStatusFilter, term, termActive, ecl, statedEcl, conceptIds, offset, limit, searchAfter);
        } catch (ApiException e) {
            e.printStackTrace();
        }

        return response;
    }

    // testing
    public static void main(String[] args) {
        SearchController controller = new SearchController();
        System.out.println(controller.findByDisplayName("tongue"));
    }
}
