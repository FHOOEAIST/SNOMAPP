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

import io.swagger.client.ApiCallback;
import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.ApiResponse;
import io.swagger.client.Configuration;
import io.swagger.client.Pair;
import io.swagger.client.ProgressRequestBody;
import io.swagger.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import io.swagger.client.model.ItemsPageRelationship;
import io.swagger.client.model.Relationship;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RelationshipsApi {
    private ApiClient apiClient;

    public RelationshipsApi() {
        this(Configuration.getDefaultApiClient());
    }

    public RelationshipsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for fetchRelationshipUsingGET
     * @param branch branch (required)
     * @param relationshipId relationshipId (required)
     * @param acceptLanguage Accept-Language (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call fetchRelationshipUsingGETCall(String branch, String relationshipId, String acceptLanguage, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/{branch}/relationships/{relationshipId}"
            .replaceAll("\\{" + "branch" + "\\}", apiClient.escapeString(branch.toString()))
            .replaceAll("\\{" + "relationshipId" + "\\}", apiClient.escapeString(relationshipId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (acceptLanguage != null)
        localVarHeaderParams.put("Accept-Language", apiClient.parameterToString(acceptLanguage));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call fetchRelationshipUsingGETValidateBeforeCall(String branch, String relationshipId, String acceptLanguage, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'branch' is set
        if (branch == null) {
            throw new ApiException("Missing the required parameter 'branch' when calling fetchRelationshipUsingGET(Async)");
        }
        
        // verify the required parameter 'relationshipId' is set
        if (relationshipId == null) {
            throw new ApiException("Missing the required parameter 'relationshipId' when calling fetchRelationshipUsingGET(Async)");
        }
        
        // verify the required parameter 'acceptLanguage' is set
        if (acceptLanguage == null) {
            throw new ApiException("Missing the required parameter 'acceptLanguage' when calling fetchRelationshipUsingGET(Async)");
        }
        

        com.squareup.okhttp.Call call = fetchRelationshipUsingGETCall(branch, relationshipId, acceptLanguage, progressListener, progressRequestListener);
        return call;

    }

    /**
     * fetchRelationship
     * 
     * @param branch branch (required)
     * @param relationshipId relationshipId (required)
     * @param acceptLanguage Accept-Language (required)
     * @return Relationship
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Relationship fetchRelationshipUsingGET(String branch, String relationshipId, String acceptLanguage) throws ApiException {
        ApiResponse<Relationship> resp = fetchRelationshipUsingGETWithHttpInfo(branch, relationshipId, acceptLanguage);
        return resp.getData();
    }

    /**
     * fetchRelationship
     * 
     * @param branch branch (required)
     * @param relationshipId relationshipId (required)
     * @param acceptLanguage Accept-Language (required)
     * @return ApiResponse&lt;Relationship&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Relationship> fetchRelationshipUsingGETWithHttpInfo(String branch, String relationshipId, String acceptLanguage) throws ApiException {
        com.squareup.okhttp.Call call = fetchRelationshipUsingGETValidateBeforeCall(branch, relationshipId, acceptLanguage, null, null);
        Type localVarReturnType = new TypeToken<Relationship>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * fetchRelationship (asynchronously)
     * 
     * @param branch branch (required)
     * @param relationshipId relationshipId (required)
     * @param acceptLanguage Accept-Language (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call fetchRelationshipUsingGETAsync(String branch, String relationshipId, String acceptLanguage, final ApiCallback<Relationship> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = fetchRelationshipUsingGETValidateBeforeCall(branch, relationshipId, acceptLanguage, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Relationship>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for findRelationshipsUsingGET
     * @param branch branch (required)
     * @param acceptLanguage Accept-Language (required)
     * @param active active (optional)
     * @param module module (optional)
     * @param effectiveTime effectiveTime (optional)
     * @param source source (optional)
     * @param type type (optional)
     * @param destination destination (optional)
     * @param characteristicType characteristicType (optional)
     * @param group group (optional)
     * @param offset offset (optional, default to 0)
     * @param limit limit (optional, default to 50)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call findRelationshipsUsingGETCall(String branch, String acceptLanguage, Boolean active, String module, String effectiveTime, String source, String type, String destination, String characteristicType, Integer group, Integer offset, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/{branch}/relationships"
            .replaceAll("\\{" + "branch" + "\\}", apiClient.escapeString(branch.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (active != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("active", active));
        if (module != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("module", module));
        if (effectiveTime != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("effectiveTime", effectiveTime));
        if (source != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("source", source));
        if (type != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("type", type));
        if (destination != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("destination", destination));
        if (characteristicType != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("characteristicType", characteristicType));
        if (group != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("group", group));
        if (offset != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("offset", offset));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (acceptLanguage != null)
        localVarHeaderParams.put("Accept-Language", apiClient.parameterToString(acceptLanguage));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call findRelationshipsUsingGETValidateBeforeCall(String branch, String acceptLanguage, Boolean active, String module, String effectiveTime, String source, String type, String destination, String characteristicType, Integer group, Integer offset, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'branch' is set
        if (branch == null) {
            throw new ApiException("Missing the required parameter 'branch' when calling findRelationshipsUsingGET(Async)");
        }
        
        // verify the required parameter 'acceptLanguage' is set
        if (acceptLanguage == null) {
            throw new ApiException("Missing the required parameter 'acceptLanguage' when calling findRelationshipsUsingGET(Async)");
        }
        

        com.squareup.okhttp.Call call = findRelationshipsUsingGETCall(branch, acceptLanguage, active, module, effectiveTime, source, type, destination, characteristicType, group, offset, limit, progressListener, progressRequestListener);
        return call;

    }

    /**
     * findRelationships
     * 
     * @param branch branch (required)
     * @param acceptLanguage Accept-Language (required)
     * @param active active (optional)
     * @param module module (optional)
     * @param effectiveTime effectiveTime (optional)
     * @param source source (optional)
     * @param type type (optional)
     * @param destination destination (optional)
     * @param characteristicType characteristicType (optional)
     * @param group group (optional)
     * @param offset offset (optional, default to 0)
     * @param limit limit (optional, default to 50)
     * @return ItemsPageRelationship
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ItemsPageRelationship findRelationshipsUsingGET(String branch, String acceptLanguage, Boolean active, String module, String effectiveTime, String source, String type, String destination, String characteristicType, Integer group, Integer offset, Integer limit) throws ApiException {
        ApiResponse<ItemsPageRelationship> resp = findRelationshipsUsingGETWithHttpInfo(branch, acceptLanguage, active, module, effectiveTime, source, type, destination, characteristicType, group, offset, limit);
        return resp.getData();
    }

    /**
     * findRelationships
     * 
     * @param branch branch (required)
     * @param acceptLanguage Accept-Language (required)
     * @param active active (optional)
     * @param module module (optional)
     * @param effectiveTime effectiveTime (optional)
     * @param source source (optional)
     * @param type type (optional)
     * @param destination destination (optional)
     * @param characteristicType characteristicType (optional)
     * @param group group (optional)
     * @param offset offset (optional, default to 0)
     * @param limit limit (optional, default to 50)
     * @return ApiResponse&lt;ItemsPageRelationship&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ItemsPageRelationship> findRelationshipsUsingGETWithHttpInfo(String branch, String acceptLanguage, Boolean active, String module, String effectiveTime, String source, String type, String destination, String characteristicType, Integer group, Integer offset, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = findRelationshipsUsingGETValidateBeforeCall(branch, acceptLanguage, active, module, effectiveTime, source, type, destination, characteristicType, group, offset, limit, null, null);
        Type localVarReturnType = new TypeToken<ItemsPageRelationship>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * findRelationships (asynchronously)
     * 
     * @param branch branch (required)
     * @param acceptLanguage Accept-Language (required)
     * @param active active (optional)
     * @param module module (optional)
     * @param effectiveTime effectiveTime (optional)
     * @param source source (optional)
     * @param type type (optional)
     * @param destination destination (optional)
     * @param characteristicType characteristicType (optional)
     * @param group group (optional)
     * @param offset offset (optional, default to 0)
     * @param limit limit (optional, default to 50)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call findRelationshipsUsingGETAsync(String branch, String acceptLanguage, Boolean active, String module, String effectiveTime, String source, String type, String destination, String characteristicType, Integer group, Integer offset, Integer limit, final ApiCallback<ItemsPageRelationship> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = findRelationshipsUsingGETValidateBeforeCall(branch, acceptLanguage, active, module, effectiveTime, source, type, destination, characteristicType, group, offset, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ItemsPageRelationship>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}