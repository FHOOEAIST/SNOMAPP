package at.snomapp.skeleton.restservice;

import io.swagger.client.ApiException;
import io.swagger.client.api.DescriptionsApi;
import io.swagger.client.model.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("snomed")
// provides endpoints for searching for snomed codes
public class SnomedController {


    private final DescriptionsApi api = new DescriptionsApi();

    public SnomedController() {
        api.getApiClient().setBasePath("http://193.170.192.200:8080");
    }

    @GetMapping("find-by-displayname")
        // displayName passed in as query parameter
    BrowserDescriptionResultWrapper findByDisplayName(@RequestParam String displayName, @RequestParam String APPCAxis, int limit, int offset) {
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

        //set semantic tag to reduce searchresult

        switch (APPCAxis.toLowerCase()) {
            case "anatomy":
                semanticTags.add("body structure");
                break;
            case "laterality":
                semanticTags.add("qualifier value");
                break;
            case "modality":
                semanticTags.add( "procedure");
                semanticTags.add("qualifier value");
                break;
            case "procedures":
                semanticTags.add("procedure");
                semanticTags.add("physical object");
                semanticTags.add("disorder");
                semanticTags.add("qualifier value");
                semanticTags.add("morphologic abnormality");
                semanticTags.add("body structure");
                break;
        }

        PageBrowserDescriptionSearchResult response = null;
        try {
            response = api.findBrowserDescriptionsUsingGET(branch, acceptLanguage, term, active, module, language,
                    semanticTags, conceptActive, conceptRefset, groupByConcept, searchMode, offset, limit);

        } catch (ApiException e) {
            try{
                response = api.findBrowserDescriptionsUsingGET(branch, acceptLanguage, term, active, module, language,
                        semanticTags, conceptActive, conceptRefset, groupByConcept, searchMode, offset, null);
            } catch (ApiException apiException) {
                apiException.printStackTrace();
            }
        }

        if(response!=null){
            List<BrowserDescriptionSearchResult> searchResults = new ArrayList<>();
            for (BrowserDescriptionSearchResult item : response.getItems()) {
                if(searchResults.stream().noneMatch(i -> i.getConcept().getId().equals(item.getConcept().getId()))){
                    searchResults.add(item);
                }
            }
            return new BrowserDescriptionResultWrapper(searchResults, response.getTotalPages());
        }
        return null;
    }

    public static class BrowserDescriptionResultWrapper {
        private final List<BrowserDescriptionSearchResult> searchResults;
        private final int numPages;

        public BrowserDescriptionResultWrapper(List<BrowserDescriptionSearchResult> searchResults, int numPages) {
            this.searchResults = searchResults;
            this.numPages = numPages;
        }

        public List<BrowserDescriptionSearchResult> getSearchResults() {
            return searchResults;
        }

        public int getNumPages() {
            return numPages;
        }

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
