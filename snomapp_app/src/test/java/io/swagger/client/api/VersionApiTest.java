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
import io.swagger.client.model.BuildVersion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for VersionApi
 */
public class VersionApiTest {

    private final VersionApi api = new VersionApi();

    
    /**
     * Software build version and timestamp.
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getBuildInformationUsingGETTest() throws ApiException {
        BuildVersion response = api.getBuildInformationUsingGET();

        //US 4_6 Server response
        System.out.println(response.toString());
        Assert.assertNotEquals(null,response);
    }
    
}
