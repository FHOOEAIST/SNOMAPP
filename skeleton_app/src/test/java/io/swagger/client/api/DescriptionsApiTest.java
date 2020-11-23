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
import org.junit.Assert;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for DescriptionsApi
 */
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
        String branch = "MAIN";
        String descriptionId = "1473011013";
        Description response = api.fetchDescriptionUsingGET(branch, descriptionId);

        //US 4_6 Server response
        System.out.println(response.toString());
        Assert.assertNotEquals(null,response);
    }
    
    /**
     * Search for concept descriptions.
     *
     * The Accept-Language header is used to specify the user&#39;s preferred language, &#39;en&#39; is always added as a fallback if not already included in the list. Each language is used as an optional clause for matching and will include the correct character folding behaviour for that language. The Accept-Language header list is also used to chose the best translated FSN and PT values in the response.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Ignore
    @Test
    public void findBrowserDescriptionsUsingGETTest() throws ApiException {
        String branch = "MAIN";
        String acceptLanguage = "en-X-900000000000509007,en-X-900000000000508004,en";
        String term = "eye";
        Boolean active = true;
        String module = null;
        List<String> language = null;
        List<String> semanticTags = new ArrayList<>();
        Boolean conceptActive = true;
        String conceptRefset = null;
        Boolean groupByConcept = false;
        String searchMode = "STANDARD";
        Integer offset = 0;
        Integer limit = 50;

        semanticTags.add("body structure");
        PageBrowserDescriptionSearchResult response = api.findBrowserDescriptionsUsingGET(branch, acceptLanguage, term, active, module, language, semanticTags, conceptActive, conceptRefset, groupByConcept, searchMode, offset, limit);

        //US 4_6 Server response
        System.out.println(response.toString());
        Assert.assertNotEquals(null,response);
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
        String branch = "MAIN";
        String concept = "100000000";
        Integer offset = 0;
        Integer limit = 50;
        ItemsPageDescription response = api.findDescriptionsUsingGET(branch, concept, offset, limit);

        //US 4_6 Server response
        System.out.println(response.toString());
        Assert.assertNotEquals(null,response);
    }
    
}
