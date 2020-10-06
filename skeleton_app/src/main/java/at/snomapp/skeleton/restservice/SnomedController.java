package at.snomapp.skeleton.restservice;

import io.swagger.client.ApiException;
import io.swagger.client.api.DescriptionsApi;
import io.swagger.client.model.BrowserDescriptionSearchResult;
import io.swagger.client.model.PageBrowserDescriptionSearchResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("snomed")
// provides endpoints for searching for snomed codes
public class SnomedController {


    private DescriptionsApi api = new DescriptionsApi();

    public SnomedController() {
        // TODO: add our snowstorm URL here
        //  api.getApiClient().setBasePath();
    }

    @GetMapping
    // displayName passed in as query parameter
    List<BrowserDescriptionSearchResult> findByDisplayName(@RequestParam String displayName){
        String branch = "MAIN";
        String acceptLanguage = "en-X-900000000000509007,en-X-900000000000508004,en";
        String term = displayName;
        Boolean active = true;
        String module = null;
        List<String> language = null;
        String semanticTag = null;
        Boolean conceptActive = true;
        String conceptRefset = null;
        Boolean groupByConcept = false;
        // this could be set to REGEX in order to do a regex search but standard should satisfy the US 9-1 requirements
        String searchMode = "STANDARD";
        Integer offset = 0;
        // unlimited page space
        // if this leads to performance problems consider replacing with smaller page size
        Integer limit = null;

        PageBrowserDescriptionSearchResult response = null;
        try {
            response = api.findBrowserDescriptionsUsingGET(branch, acceptLanguage, term, active, module, language,
                    semanticTag, conceptActive, conceptRefset, groupByConcept, searchMode, offset, limit);
        } catch (ApiException e) {
            e.printStackTrace();
        }

        // might want to replace with wrapped PageBrowserDescriptionSearchResult depending on if we need the
        // meta information (e.g. size of returned array) aor not
        return response != null ? response.getItems() : null;
    }
}
