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
import io.swagger.client.model.ItemsPageReferenceSetMember;
import io.swagger.client.model.RefSetMemberPageWithBucketAggregationsReferenceSetMember;
import io.swagger.client.model.ReferenceSetMember;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for RefsetMembersApi
 */
@Ignore
public class RefsetMembersApiTest {

    private final RefsetMembersApi api = new RefsetMembersApi();

    
    /**
     * fetchMember
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void fetchMemberUsingGETTest() throws ApiException {
        String branch = null;
        String uuid = null;
        String acceptLanguage = null;
        ReferenceSetMember response = api.fetchMemberUsingGET(branch, uuid, acceptLanguage);

        // TODO: test validations
    }
    
    /**
     * Search for reference set ids
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void findBrowserReferenceSetMembersWithAggregationsUsingGETTest() throws ApiException {
        String branch = null;
        String acceptLanguage = null;
        String referenceSet = null;
        String referencedComponentId = null;
        Boolean active = null;
        Integer offset = null;
        Integer limit = null;
        RefSetMemberPageWithBucketAggregationsReferenceSetMember response = api.findBrowserReferenceSetMembersWithAggregationsUsingGET(branch, acceptLanguage, referenceSet, referencedComponentId, active, offset, limit);

        // TODO: test validations
    }
    
    /**
     * Search for reference set members.
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void findRefsetMembersUsingGETTest() throws ApiException {
        String branch = null;
        String acceptLanguage = null;
        String referenceSet = null;
        String referencedComponentId = null;
        Boolean active = null;
        String targetComponent = null;
        String mapTarget = null;
        String owlExpressionConceptId = null;
        Boolean owlExpressionGci = null;
        Integer offset = null;
        Integer limit = null;
        ItemsPageReferenceSetMember response = api.findRefsetMembersUsingGET(branch, acceptLanguage, referenceSet, referencedComponentId, active, targetComponent, mapTarget, owlExpressionConceptId, owlExpressionGci, offset, limit);

        // TODO: test validations
    }
    
}
