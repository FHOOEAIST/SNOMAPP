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
import io.swagger.client.model.Branch;
import io.swagger.client.model.BranchPojo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for BranchingApi
 */
public class BranchingApiTest {

    private final BranchingApi api = new BranchingApi();

    
    /**
     * Retrieve all branches
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void retrieveAllBranchesUsingGETTest() throws ApiException {
        List<Branch> response = api.retrieveAllBranchesUsingGET();

        // TODO: test validations
        //US 4_6 Server response
        System.out.println(response.toString());
        Assert.assertNotEquals(null,response);
    }
    
    /**
     * Retrieve branch descendants
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void retrieveBranchDescendantsUsingGETTest() throws ApiException {
        String path = "MAIN";
        Boolean immediateChildren = null;
        List<Branch> response = api.retrieveBranchDescendantsUsingGET(path, immediateChildren);

        // TODO: test validations
        //US 4_6 Server response
        System.out.println(response.toString());
        Assert.assertNotEquals(null,response);
    }
    
    /**
     * Retrieve a single branch
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void retrieveBranchUsingGETTest() throws ApiException {
        String path = "MAIN";
        Boolean includeInheritedMetadata = null;
        BranchPojo response = api.retrieveBranchUsingGET(path, includeInheritedMetadata);

        // TODO: test validations
        //US 4_6 Server response
        System.out.println(response.toString());
        Assert.assertNotEquals(null,response);
    }
    
}
