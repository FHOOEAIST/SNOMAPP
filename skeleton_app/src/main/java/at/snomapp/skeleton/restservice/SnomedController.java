package at.snomapp.skeleton.restservice;

import at.snomapp.skeleton.domain.filter.Filter;
import at.snomapp.skeleton.domain.filter.impl.AxisFilter;
import io.swagger.client.ApiException;
import io.swagger.client.api.DescriptionsApi;
import io.swagger.client.model.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.Console;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("snomed")
// provides endpoints for searching for snomed codes
public class SnomedController {


    private final DescriptionsApi api = new DescriptionsApi();

    public SnomedController() {
        api.getApiClient().setBasePath("http://193.170.192.200:8080");
    }

    @GetMapping
        // displayName passed in as query parameter
    List<BrowserDescriptionSearchResult> findByDisplayName(@RequestParam String displayName, @RequestParam String APPCAxis) {
        String branch = "MAIN";
        String acceptLanguage = "en-X-900000000000509007,en-X-900000000000508004,en";
        String term = displayName;
        Boolean active = true;
        String module = null;
        List<String> language = null;
        String semanticTag = null;
        List<String> semanticTags = new ArrayList<>();
        Boolean conceptActive = true;
        String conceptRefset = null;
        Boolean groupByConcept = false;
        // this could be set to REGEX in order to do a regex search but standard should satisfy the US 9-1 requirements
        String searchMode = "STANDARD";
        Integer offset = 0;
        // unlimited page space
        // if this leads to performance problems consider replacing with smaller page size
        Integer limit = null;
        //set semantic tag to reduce searchresults
        System.out.println(APPCAxis.toLowerCase());
        switch (APPCAxis.toLowerCase()) {
            case "anatomy":
                semanticTags.add("body structure");
                break;
            case "laterality":
                semanticTags.add("qualifier value");
                break;
            case "modality":
                semanticTags.add( "procedure");
                break;
            case "procedure":
                semanticTags.add("procedure");
                semanticTags.add("physical object");
                semanticTags.add("finding");
                semanticTags.add("qualifier value");
                break;
        }

        System.out.println(semanticTag);
        PageBrowserDescriptionSearchResult response = null;
        try {
            response = api.findBrowserDescriptionsUsingGET(branch, acceptLanguage, term, active, module, language,
                    semanticTags, conceptActive, conceptRefset, groupByConcept, searchMode, offset, limit);

        } catch (ApiException e) {
            e.printStackTrace();
        }

        // might want to replace with wrapped PageBrowserDescriptionSearchResult depending on if we need the
        // meta information (e.g. size of returned array) aor not
        return response != null ? response.getItems() : null;
    }

    Map<String, List<Description>> findSynonyms(List<BrowserDescriptionSearchResult> concepts) {
        Map<String, List<Description>> descriptionMap = new HashMap<>();
        for (BrowserDescriptionSearchResult concept : concepts) {
            String branch = "MAIN";
            String conceptId = concept.getConcept().getConceptId();
            Integer offset = 0;
            Integer limit = null;

            ItemsPageDescription response_item = null;
            try {
                response_item = api.findDescriptionsUsingGET(branch, conceptId, offset, limit);

            } catch (ApiException e) {
                e.printStackTrace();
            }

            descriptionMap.put(conceptId, response_item != null ? response_item.getItems() : null);
        }
        return descriptionMap;
    }
}
