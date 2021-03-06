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
import io.swagger.client.model.AsyncConceptChangeBatch;
import io.swagger.client.model.CollectionConceptMini;
import io.swagger.client.model.ConceptDescriptionsResult;
import io.swagger.client.model.ConceptMini;
import io.swagger.client.model.ConceptReferencesResult;
import io.swagger.client.model.ConceptView;
import io.swagger.client.model.Expression;
import io.swagger.client.model.ExpressionStringPojo;
import io.swagger.client.model.InboundRelationshipsResult;
import io.swagger.client.model.ItemsPageConcept;
import io.swagger.client.model.ItemsPageConceptMini;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ConceptsApi
 */
public class ConceptsApiTest {

    private final ConceptsApi api = new ConceptsApi();

    
    /**
     * Load a concept in the browser format.
     *
     * During content authoring previous versions of the concept can be loaded from version control. To do this use the branch path format {branch@yyyy-MM-ddTHH:mm:ss.SSSZ} or {branch@epoch_milliseconds}. The version of the concept when the branch was created can be loaded using {branch@-}.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void findBrowserConceptUsingGETTest() throws ApiException {
        String branch = "MAIN";
        String conceptId = "100000000";
        String acceptLanguage = "en-X-900000000000509007,en-X-900000000000508004,en";
        ConceptView response = api.findBrowserConceptUsingGET(branch, conceptId, acceptLanguage);

        //US 4_6 Server response
        System.out.println(response.toString());
        Assert.assertNotEquals(null,response);
    }
    
    /**
     * findConceptAncestors
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void findConceptAncestorsUsingGETTest() throws ApiException {
        String branch = "MAIN";
        String conceptId = "900000000000455006";
        String acceptLanguage = "en-X-900000000000509007,en-X-900000000000508004,en";
        String form = "inferred";
        List<ConceptMini> response = api.findConceptAncestorsUsingGET(branch, conceptId, acceptLanguage, form);

        ///US 4_6 Server response
        System.out.println(response.toString());
        Assert.assertNotEquals(null,response);
    }
    
    /**
     * findConceptChildren
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void findConceptChildrenUsingGETTest() throws ApiException {
        String branch = "MAIN";
        String conceptId = "900000000000455006";
        String acceptLanguage = "en-X-900000000000509007,en-X-900000000000508004,en";
        String form = "inferred";
        List<ConceptMini> response = api.findConceptChildrenUsingGET(branch, conceptId, acceptLanguage, form);

        //US 4_6 Server response
        System.out.println(response.toString());
        Assert.assertNotEquals(null,response);
    }
    
    /**
     * findConceptDescendants
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void findConceptDescendantsUsingGETTest() throws ApiException {
        String branch = "MAIN";
        String conceptId = "900000000000455006";
        String acceptLanguage = "en-X-900000000000509007,en-X-900000000000508004,en";
        Boolean stated = false;
        Integer offset = 0;
        Integer limit = 50;
        ItemsPageConceptMini response = api.findConceptDescendantsUsingGET(branch, conceptId, acceptLanguage, stated, offset, limit);

        //US 4_6 Server response
        System.out.println(response.toString());
        Assert.assertNotEquals(null,response);
    }
    
    /**
     * findConceptDescriptions
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */

    @Test
    public void findConceptDescriptionsUsingGETTest() throws ApiException {
        String branch = "MAIN";
        String conceptId = "100000000";
        String acceptLanguage = "en-X-900000000000509007,en-X-900000000000508004,en";
        ConceptDescriptionsResult response = api.findConceptDescriptionsUsingGET(branch, conceptId, acceptLanguage);

        //US 4_6 Server response
        System.out.println(response.toString());
        Assert.assertNotEquals(null,response);
    }
    
    /**
     * findConceptInboundRelationships
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void findConceptInboundRelationshipsUsingGETTest() throws ApiException {
        String branch = "MAIN";
        String conceptId = "100000000";
        InboundRelationshipsResult response = api.findConceptInboundRelationshipsUsingGET(branch, conceptId);

        //US 4_6 Server response
        System.out.println(response.toString());
        Assert.assertNotEquals(null,response);
    }
    
    /**
     * findConceptParents
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void findConceptParentsUsingGETTest() throws ApiException {
        String branch = "MAIN";
        String conceptId = "900000000000455006";
        String acceptLanguage = "en-X-900000000000509007,en-X-900000000000508004,en";
        String form = "inferred";
        List<ConceptMini> response = api.findConceptParentsUsingGET(branch, conceptId, acceptLanguage, form);

        //US 4_6 Server response
        System.out.println(response.toString());
        Assert.assertNotEquals(null,response);
    }
    
    /**
     * Find concepts which reference this concept in the inferred or stated form (including stated axioms).
     *
     * Pagination works on the referencing concepts. A referencing concept may have one or more references of different types.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void findConceptReferencesUsingGETTest() throws ApiException {
        String branch = "MAIN";
        long conceptId = 100000000;
        String acceptLanguage = "en-X-900000000000509007,en-X-900000000000508004,en";
        Boolean stated = false;
        Integer offset = 0;
        Integer limit = 1000;
        ConceptReferencesResult response = api.findConceptReferencesUsingGET(branch, conceptId, acceptLanguage, stated, offset, limit);

        //US 4_6 Server response
        System.out.println(response.toString());
        Assert.assertNotEquals(null,response);
    }
    
    /**
     * findConcept
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void findConceptUsingGETTest() throws ApiException {
        String branch = "MAIN";
        String conceptId = "100000000";
        String acceptLanguage = "en-X-900000000000509007,en-X-900000000000508004,en";
        ConceptMini response = api.findConceptUsingGET(branch, conceptId, acceptLanguage);

        //US 4_6 Server response
        System.out.println(response.toString());
        Assert.assertNotEquals(null,response);
    }
    
    /**
     * findConcepts
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void findConceptsUsingGETTest() throws ApiException {
        String branch = "MAIN";
        String acceptLanguage = "en-X-900000000000509007,en-X-900000000000508004,en";
        Boolean activeFilter = null;
        String definitionStatusFilter = null;
        String term = null;
        Boolean termActive = null;
        String ecl = null;
        String statedEcl = null;
        List<String> conceptIds = null;
        Integer offset = null;
        Integer limit = null;
        String searchAfter = null;
        ItemsPageConceptMini response = api.findConceptsUsingGET(branch, acceptLanguage, activeFilter, definitionStatusFilter, term, termActive, ecl, statedEcl, conceptIds, offset, limit, searchAfter);

        //US 4_6 Server response
        System.out.println(response.toString());
        Assert.assertNotEquals(null,response);
    }
    
    /**
     * Load concepts in the browser format.
     *
     * When enabled &#39;searchAfter&#39; can be used for unlimited pagination. Load the first page then take the &#39;searchAfter&#39; value from the response and use that as a parameter in the next page request instead of &#39;number&#39;.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getBrowserConceptsUsingGETTest() throws ApiException {
        String branch = "MAIN";
        String acceptLanguage = "en-X-900000000000509007,en-X-900000000000508004,en";
        Integer number = null;
        Integer size = null;
        String searchAfter = null;
        ItemsPageConcept response = api.getBrowserConceptsUsingGET(branch, acceptLanguage, number, size, searchAfter);

        //US 4_6 Server response
        System.out.println(response.toString());
        Assert.assertNotEquals(null,response);
    }
    
    /**
     * getConceptAuthoringForm
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getConceptAuthoringFormUsingGETTest() throws ApiException {
        String branch = "MAIN";
        String conceptId = "100000000";
        String acceptLanguage = "en-X-900000000000509007,en-X-900000000000508004,en";
        Expression response = api.getConceptAuthoringFormUsingGET(branch, conceptId, acceptLanguage);

        //US 4_6 Server response
        System.out.println(response.toString());
        Assert.assertNotEquals(null,response);
    }
    
    /**
     * Fetch the status of a bulk concept creation or update.
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Ignore //because bulk ID is unknown
    @Test
    public void getConceptBulkChangeUsingGETTest() throws ApiException {
        String branch = "MAIN";
        //ToDo find BulkID
        String bulkChangeId = null;
        AsyncConceptChangeBatch response = api.getConceptBulkChangeUsingGET(branch, bulkChangeId);

        //US 4_6 Server response
        System.out.println(response.toString());
        Assert.assertNotEquals(null,response);
    }
    
    /**
     * getConceptNormalForm
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getConceptNormalFormUsingGETTest() throws ApiException {
        String branch = "MAIN";
        String conceptId = "100000000";
        String acceptLanguage = "en-X-900000000000509007,en-X-900000000000508004,en";
        Boolean statedView = false;
        Boolean includeTerms = false;
        ExpressionStringPojo response = api.getConceptNormalFormUsingGET(branch, conceptId, acceptLanguage, statedView, includeTerms);

        //US 4_6 Server response
        System.out.println(response.toString());
        Assert.assertNotEquals(null,response);
    }
    
}
