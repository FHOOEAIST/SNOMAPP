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


import io.swagger.client.model.Description;
import io.swagger.client.model.ItemsPageDescription;
import io.swagger.client.model.PageBrowserDescriptionSearchResult;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DescriptionsApi {
    private ApiClient apiClient;

    public DescriptionsApi() {
        this(Configuration.getDefaultApiClient());
    }

    public DescriptionsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for fetchDescriptionUsingGET
     * @param branch branch (required)
     * @param descriptionId descriptionId (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call fetchDescriptionUsingGETCall(String branch, String descriptionId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/{branch}/descriptions/{descriptionId}"
            .replaceAll("\\{" + "branch" + "\\}", apiClient.escapeString(branch.toString()))
            .replaceAll("\\{" + "descriptionId" + "\\}", apiClient.escapeString(descriptionId.toString()));

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
    private com.squareup.okhttp.Call fetchDescriptionUsingGETValidateBeforeCall(String branch, String descriptionId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'branch' is set
        if (branch == null) {
            throw new ApiException("Missing the required parameter 'branch' when calling fetchDescriptionUsingGET(Async)");
        }
        
        // verify the required parameter 'descriptionId' is set
        if (descriptionId == null) {
            throw new ApiException("Missing the required parameter 'descriptionId' when calling fetchDescriptionUsingGET(Async)");
        }
        

        com.squareup.okhttp.Call call = fetchDescriptionUsingGETCall(branch, descriptionId, progressListener, progressRequestListener);
        return call;

    }

    /**
     * fetchDescription
     * 
     * @param branch branch (required)
     * @param descriptionId descriptionId (required)
     * @return Description
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Description fetchDescriptionUsingGET(String branch, String descriptionId) throws ApiException {
        ApiResponse<Description> resp = fetchDescriptionUsingGETWithHttpInfo(branch, descriptionId);
        return resp.getData();
    }

    /**
     * fetchDescription
     * 
     * @param branch branch (required)
     * @param descriptionId descriptionId (required)
     * @return ApiResponse&lt;Description&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Description> fetchDescriptionUsingGETWithHttpInfo(String branch, String descriptionId) throws ApiException {
        com.squareup.okhttp.Call call = fetchDescriptionUsingGETValidateBeforeCall(branch, descriptionId, null, null);
        Type localVarReturnType = new TypeToken<Description>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * fetchDescription (asynchronously)
     * 
     * @param branch branch (required)
     * @param descriptionId descriptionId (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call fetchDescriptionUsingGETAsync(String branch, String descriptionId, final ApiCallback<Description> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = fetchDescriptionUsingGETValidateBeforeCall(branch, descriptionId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Description>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for findBrowserDescriptionsUsingGET
     * @param branch branch (required)
     * @param acceptLanguage Accept-Language (required)
     * @param term term (optional)
     * @param active active (optional)
     * @param module module (optional)
     * @param language List of two character language codes to match. The English language code &#39;en&#39; will not be added automatically, in contrast to the Accept-Language header which always includes it. Accept-Language header still controls result FSN and PT language selection. (optional)
     * @param semanticTag semanticTag (optional)
     * @param conceptActive conceptActive (optional)
     * @param conceptRefset conceptRefset (optional)
     * @param groupByConcept groupByConcept (optional, default to false)
     * @param searchMode searchMode (optional, default to STANDARD)
     * @param offset offset (optional, default to 0)
     * @param limit limit (optional, default to 50)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call findBrowserDescriptionsUsingGETCall(String branch, String acceptLanguage, String term,
                                                                        Boolean active, String module, List<String> language, String semanticTag, Boolean conceptActive,
                                                                        String conceptRefset, Boolean groupByConcept, String searchMode, Integer offset, Integer limit,
                                                                        final ProgressResponseBody.ProgressListener progressListener,
                                                                        final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/browser/{branch}/descriptions"
            .replaceAll("\\{" + "branch" + "\\}", apiClient.escapeString(branch.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (term != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("term", term));
        if (active != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("active", active));
        if (module != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("module", module));
        if (language != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("multi", "language", language));
        if (semanticTag != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("semanticTag", semanticTag));
        if (conceptActive != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("conceptActive", conceptActive));
        if (conceptRefset != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("conceptRefset", conceptRefset));
        if (groupByConcept != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("groupByConcept", groupByConcept));
        if (searchMode != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("searchMode", searchMode));
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
    private com.squareup.okhttp.Call findBrowserDescriptionsUsingGETValidateBeforeCall(String branch, String acceptLanguage, String term, Boolean active, String module, List<String> language, String semanticTag, Boolean conceptActive, String conceptRefset, Boolean groupByConcept, String searchMode, Integer offset, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'branch' is set
        if (branch == null) {
            throw new ApiException("Missing the required parameter 'branch' when calling findBrowserDescriptionsUsingGET(Async)");
        }
        
        // verify the required parameter 'acceptLanguage' is set
        if (acceptLanguage == null) {
            throw new ApiException("Missing the required parameter 'acceptLanguage' when calling findBrowserDescriptionsUsingGET(Async)");
        }
        

        com.squareup.okhttp.Call call = findBrowserDescriptionsUsingGETCall(branch, acceptLanguage, term, active, module, language, semanticTag, conceptActive, conceptRefset, groupByConcept, searchMode, offset, limit, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Search for concept descriptions.
     * The Accept-Language header is used to specify the user&#39;s preferred language, &#39;en&#39; is always added as a fallback if not already included in the list. Each language is used as an optional clause for matching and will include the correct character folding behaviour for that language. The Accept-Language header list is also used to chose the best translated FSN and PT values in the response.
     * @param branch branch (required)
     * @param acceptLanguage Accept-Language (required)
     * @param term term (optional)
     * @param active active (optional)
     * @param module module (optional)
     * @param language List of two character language codes to match. The English language code &#39;en&#39; will not be added automatically, in contrast to the Accept-Language header which always includes it. Accept-Language header still controls result FSN and PT language selection. (optional)
     * @param semanticTag semanticTag (optional)
     * @param conceptActive conceptActive (optional)
     * @param conceptRefset conceptRefset (optional)
     * @param groupByConcept groupByConcept (optional, default to false)
     * @param searchMode searchMode (optional, default to STANDARD)
     * @param offset offset (optional, default to 0)
     * @param limit limit (optional, default to 50)
     * @return PageBrowserDescriptionSearchResult
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public PageBrowserDescriptionSearchResult findBrowserDescriptionsUsingGET(String branch, String acceptLanguage, String term, Boolean active, String module, List<String> language, String semanticTag, Boolean conceptActive, String conceptRefset, Boolean groupByConcept, String searchMode, Integer offset, Integer limit) throws ApiException {
        ApiResponse<PageBrowserDescriptionSearchResult> resp = findBrowserDescriptionsUsingGETWithHttpInfo(branch, acceptLanguage, term, active, module, language, semanticTag, conceptActive, conceptRefset, groupByConcept, searchMode, offset, limit);
        return resp.getData();
    }

    /**
     * Search for concept descriptions.
     * The Accept-Language header is used to specify the user&#39;s preferred language, &#39;en&#39; is always added as a fallback if not already included in the list. Each language is used as an optional clause for matching and will include the correct character folding behaviour for that language. The Accept-Language header list is also used to chose the best translated FSN and PT values in the response.
     * @param branch branch (required)
     * @param acceptLanguage Accept-Language (required)
     * @param term term (optional)
     * @param active active (optional)
     * @param module module (optional)
     * @param language List of two character language codes to match. The English language code &#39;en&#39; will not be added automatically, in contrast to the Accept-Language header which always includes it. Accept-Language header still controls result FSN and PT language selection. (optional)
     * @param semanticTag semanticTag (optional)
     * @param conceptActive conceptActive (optional)
     * @param conceptRefset conceptRefset (optional)
     * @param groupByConcept groupByConcept (optional, default to false)
     * @param searchMode searchMode (optional, default to STANDARD)
     * @param offset offset (optional, default to 0)
     * @param limit limit (optional, default to 50)
     * @return ApiResponse&lt;PageBrowserDescriptionSearchResult&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<PageBrowserDescriptionSearchResult> findBrowserDescriptionsUsingGETWithHttpInfo(String branch, String acceptLanguage, String term, Boolean active, String module, List<String> language, String semanticTag, Boolean conceptActive, String conceptRefset, Boolean groupByConcept, String searchMode, Integer offset, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = findBrowserDescriptionsUsingGETValidateBeforeCall(branch, acceptLanguage, term, active, module, language, semanticTag, conceptActive, conceptRefset, groupByConcept, searchMode, offset, limit, null, null);
        Type localVarReturnType = new TypeToken<PageBrowserDescriptionSearchResult>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Search for concept descriptions. (asynchronously)
     * The Accept-Language header is used to specify the user&#39;s preferred language, &#39;en&#39; is always added as a fallback if not already included in the list. Each language is used as an optional clause for matching and will include the correct character folding behaviour for that language. The Accept-Language header list is also used to chose the best translated FSN and PT values in the response.
     * @param branch branch (required)
     * @param acceptLanguage Accept-Language (required)
     * @param term term (optional)
     * @param active active (optional)
     * @param module module (optional)
     * @param language List of two character language codes to match. The English language code &#39;en&#39; will not be added automatically, in contrast to the Accept-Language header which always includes it. Accept-Language header still controls result FSN and PT language selection. (optional)
     * @param semanticTag semanticTag (optional)
     * @param conceptActive conceptActive (optional)
     * @param conceptRefset conceptRefset (optional)
     * @param groupByConcept groupByConcept (optional, default to false)
     * @param searchMode searchMode (optional, default to STANDARD)
     * @param offset offset (optional, default to 0)
     * @param limit limit (optional, default to 50)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call findBrowserDescriptionsUsingGETAsync(String branch, String acceptLanguage, String term, Boolean active, String module, List<String> language, String semanticTag, Boolean conceptActive, String conceptRefset, Boolean groupByConcept, String searchMode, Integer offset, Integer limit, final ApiCallback<PageBrowserDescriptionSearchResult> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = findBrowserDescriptionsUsingGETValidateBeforeCall(branch, acceptLanguage, term, active, module, language, semanticTag, conceptActive, conceptRefset, groupByConcept, searchMode, offset, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<PageBrowserDescriptionSearchResult>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for findDescriptionsUsingGET
     * @param branch branch (required)
     * @param concept The concept id to match (optional)
     * @param offset offset (optional, default to 0)
     * @param limit limit (optional, default to 50)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call findDescriptionsUsingGETCall(String branch, String concept, Integer offset, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/{branch}/descriptions"
            .replaceAll("\\{" + "branch" + "\\}", apiClient.escapeString(branch.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (concept != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("concept", concept));
        if (offset != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("offset", offset));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));

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
    private com.squareup.okhttp.Call findDescriptionsUsingGETValidateBeforeCall(String branch, String concept, Integer offset, Integer limit, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'branch' is set
        if (branch == null) {
            throw new ApiException("Missing the required parameter 'branch' when calling findDescriptionsUsingGET(Async)");
        }
        

        com.squareup.okhttp.Call call = findDescriptionsUsingGETCall(branch, concept, offset, limit, progressListener, progressRequestListener);
        return call;

    }

    /**
     * findDescriptions
     * 
     * @param branch branch (required)
     * @param concept The concept id to match (optional)
     * @param offset offset (optional, default to 0)
     * @param limit limit (optional, default to 50)
     * @return ItemsPageDescription
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ItemsPageDescription findDescriptionsUsingGET(String branch, String concept, Integer offset, Integer limit) throws ApiException {
        ApiResponse<ItemsPageDescription> resp = findDescriptionsUsingGETWithHttpInfo(branch, concept, offset, limit);
        return resp.getData();
    }

    /**
     * findDescriptions
     * 
     * @param branch branch (required)
     * @param concept The concept id to match (optional)
     * @param offset offset (optional, default to 0)
     * @param limit limit (optional, default to 50)
     * @return ApiResponse&lt;ItemsPageDescription&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ItemsPageDescription> findDescriptionsUsingGETWithHttpInfo(String branch, String concept, Integer offset, Integer limit) throws ApiException {
        com.squareup.okhttp.Call call = findDescriptionsUsingGETValidateBeforeCall(branch, concept, offset, limit, null, null);
        Type localVarReturnType = new TypeToken<ItemsPageDescription>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * findDescriptions (asynchronously)
     * 
     * @param branch branch (required)
     * @param concept The concept id to match (optional)
     * @param offset offset (optional, default to 0)
     * @param limit limit (optional, default to 50)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call findDescriptionsUsingGETAsync(String branch, String concept, Integer offset, Integer limit, final ApiCallback<ItemsPageDescription> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = findDescriptionsUsingGETValidateBeforeCall(branch, concept, offset, limit, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ItemsPageDescription>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
