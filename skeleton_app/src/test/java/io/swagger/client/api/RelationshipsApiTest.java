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
import io.swagger.client.model.ItemsPageRelationship;
import io.swagger.client.model.Relationship;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for RelationshipsApi
 */
public class RelationshipsApiTest {

    private final RelationshipsApi api = new RelationshipsApi();

    
    /**
     * fetchRelationship
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void fetchRelationshipUsingGETTest() throws ApiException {
        String branch = "MAIN";
        String relationshipId = "288741025";
        String acceptLanguage = "en-X-900000000000509007,en-X-900000000000508004,en";
        Relationship response = api.fetchRelationshipUsingGET(branch, relationshipId, acceptLanguage);

        //US 4_6 Server response
        System.out.println(response.toString());
        Assert.assertNotEquals(null,response);
    }
    
    /**
     * findRelationships
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Ignore //because "Expected BEGIN_OBJECT but was BEGIN_ARRAY"
    @Test
    public void findRelationshipsUsingGETTest() throws ApiException {
        String branch = "MAIN";
        String acceptLanguage = "en-X-900000000000509007,en-X-900000000000508004,en";
        Boolean active = null;
        String module = null;
        String effectiveTime = null;
        String source = null;
        String type = null;
        String destination = null;
        String characteristicType = null;
        Integer group = null;
        Integer offset = null;
        Integer limit = null;
        ItemsPageRelationship response = api.findRelationshipsUsingGET(branch, acceptLanguage, active, module, effectiveTime, source, type, destination, characteristicType, group, offset, limit);

        //US 4_6 Server response
        System.out.println(response.toString());
        Assert.assertNotEquals(null,response);
    }
    
}