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


import io.swagger.client.model.CodeSystem;
import io.swagger.client.model.ItemsPageCodeSystem;
import io.swagger.client.model.ItemsPageCodeSystemVersion;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CodeSystemsApi {
    private ApiClient apiClient;

    public CodeSystemsApi() {
        this(Configuration.getDefaultApiClient());
    }

    public CodeSystemsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for findAllUsingGET
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call findAllUsingGETCall(final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/codesystems";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

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
    private com.squareup.okhttp.Call findAllUsingGETValidateBeforeCall(final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        

        com.squareup.okhttp.Call call = findAllUsingGETCall(progressListener, progressRequestListener);
        return call;

    }

    /**
     * Retrieve all code systems
     * 
     * @return ItemsPageCodeSystem
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ItemsPageCodeSystem findAllUsingGET() throws ApiException {
        ApiResponse<ItemsPageCodeSystem> resp = findAllUsingGETWithHttpInfo();
        return resp.getData();
    }

    /**
     * Retrieve all code systems
     * 
     * @return ApiResponse&lt;ItemsPageCodeSystem&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ItemsPageCodeSystem> findAllUsingGETWithHttpInfo() throws ApiException {
        com.squareup.okhttp.Call call = findAllUsingGETValidateBeforeCall(null, null);
        Type localVarReturnType = new TypeToken<ItemsPageCodeSystem>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Retrieve all code systems (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call findAllUsingGETAsync(final ApiCallback<ItemsPageCodeSystem> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = findAllUsingGETValidateBeforeCall(progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ItemsPageCodeSystem>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for findAllVersionsUsingGET
     * @param shortName shortName (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call findAllVersionsUsingGETCall(String shortName, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/codesystems/{shortName}/versions"
            .replaceAll("\\{" + "shortName" + "\\}", apiClient.escapeString(shortName.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

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
    private com.squareup.okhttp.Call findAllVersionsUsingGETValidateBeforeCall(String shortName, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'shortName' is set
        if (shortName == null) {
            throw new ApiException("Missing the required parameter 'shortName' when calling findAllVersionsUsingGET(Async)");
        }
        

        com.squareup.okhttp.Call call = findAllVersionsUsingGETCall(shortName, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Retrieve all code system versions
     * 
     * @param shortName shortName (required)
     * @return ItemsPageCodeSystemVersion
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ItemsPageCodeSystemVersion findAllVersionsUsingGET(String shortName) throws ApiException {
        ApiResponse<ItemsPageCodeSystemVersion> resp = findAllVersionsUsingGETWithHttpInfo(shortName);
        return resp.getData();
    }

    /**
     * Retrieve all code system versions
     * 
     * @param shortName shortName (required)
     * @return ApiResponse&lt;ItemsPageCodeSystemVersion&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ItemsPageCodeSystemVersion> findAllVersionsUsingGETWithHttpInfo(String shortName) throws ApiException {
        com.squareup.okhttp.Call call = findAllVersionsUsingGETValidateBeforeCall(shortName, null, null);
        Type localVarReturnType = new TypeToken<ItemsPageCodeSystemVersion>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Retrieve all code system versions (asynchronously)
     * 
     * @param shortName shortName (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call findAllVersionsUsingGETAsync(String shortName, final ApiCallback<ItemsPageCodeSystemVersion> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = findAllVersionsUsingGETValidateBeforeCall(shortName, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ItemsPageCodeSystemVersion>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for findCodeSystemUsingGET
     * @param shortName shortName (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call findCodeSystemUsingGETCall(String shortName, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/codesystems/{shortName}"
            .replaceAll("\\{" + "shortName" + "\\}", apiClient.escapeString(shortName.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

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
    private com.squareup.okhttp.Call findCodeSystemUsingGETValidateBeforeCall(String shortName, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'shortName' is set
        if (shortName == null) {
            throw new ApiException("Missing the required parameter 'shortName' when calling findCodeSystemUsingGET(Async)");
        }
        

        com.squareup.okhttp.Call call = findCodeSystemUsingGETCall(shortName, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Retrieve a code system
     * 
     * @param shortName shortName (required)
     * @return CodeSystem
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public CodeSystem findCodeSystemUsingGET(String shortName) throws ApiException {
        ApiResponse<CodeSystem> resp = findCodeSystemUsingGETWithHttpInfo(shortName);
        return resp.getData();
    }

    /**
     * Retrieve a code system
     * 
     * @param shortName shortName (required)
     * @return ApiResponse&lt;CodeSystem&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<CodeSystem> findCodeSystemUsingGETWithHttpInfo(String shortName) throws ApiException {
        com.squareup.okhttp.Call call = findCodeSystemUsingGETValidateBeforeCall(shortName, null, null);
        Type localVarReturnType = new TypeToken<CodeSystem>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Retrieve a code system (asynchronously)
     * 
     * @param shortName shortName (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call findCodeSystemUsingGETAsync(String shortName, final ApiCallback<CodeSystem> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = findCodeSystemUsingGETValidateBeforeCall(shortName, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<CodeSystem>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
