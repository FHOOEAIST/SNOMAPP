/*
 * Snowstorm
 * SNOMED CT Terminology Server REST API
 *
 * OpenAPI spec version: 1.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.client.api;

import io.swagger.client.ApiException;
import io.swagger.client.model.Description;
import io.swagger.client.model.ItemsPageDescription;
import io.swagger.client.model.PageBrowserDescriptionSearchResult;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for DescriptionsApi
 */
@Ignore
public class DescriptionsApiTest {

    private final DescriptionsApi api = new DescriptionsApi();

    
    /**
     * fetchDescription
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void fetchDescriptionUsingGETTest() throws ApiException {
        String branch = null;
        String descriptionId = null;
        Description response = api.fetchDescriptionUsingGET(branch, descriptionId);

        // TODO: test validations
    }
    
    /**
     * Search for concept descriptions.
     *
     * The Accept-Language header is used to specify the user&#39;s preferred language, &#39;en&#39; is always added as a fallback if not already included in the list. Each language is used as an optional clause for matching and will include the correct character folding behaviour for that language. The Accept-Language header list is also used to chose the best translated FSN and PT values in the response.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void findBrowserDescriptionsUsingGETTest() throws ApiException {
        String branch = null;
        String acceptLanguage = null;
        String term = null;
        Boolean active = null;
        String module = null;
        List<String> language = null;
        String semanticTag = null;
        Boolean conceptActive = null;
        String conceptRefset = null;
        Boolean groupByConcept = null;
        String searchMode = null;
        Integer offset = null;
        Integer limit = null;
        PageBrowserDescriptionSearchResult response = api.findBrowserDescriptionsUsingGET(branch, acceptLanguage, term, active, module, language, semanticTag, conceptActive, conceptRefset, groupByConcept, searchMode, offset, limit);

        // TODO: test validations
    }
    
    /**
     * findDescriptions
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void findDescriptionsUsingGETTest() throws ApiException {
        String branch = null;
        String concept = null;
        Integer offset = null;
        Integer limit = null;
        ItemsPageDescription response = api.findDescriptionsUsingGET(branch, concept, offset, limit);

        // TODO: test validations
    }
    
}
