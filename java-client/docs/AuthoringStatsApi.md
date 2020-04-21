# AuthoringStatsApi

All URIs are relative to *https://snowstorm.test-nictiz.nl*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getChangedFSNsUsingGET**](AuthoringStatsApi.md#getChangedFSNsUsingGET) | **GET** /{branch}/authoring-stats/changed-fully-specified-names | getChangedFSNs
[**getInactivatedConceptsUsingGET**](AuthoringStatsApi.md#getInactivatedConceptsUsingGET) | **GET** /{branch}/authoring-stats/inactivated-concepts | getInactivatedConcepts
[**getInactivatedSynonymsUsingGET**](AuthoringStatsApi.md#getInactivatedSynonymsUsingGET) | **GET** /{branch}/authoring-stats/inactivated-synonyms | getInactivatedSynonyms
[**getNewConceptsUsingGET**](AuthoringStatsApi.md#getNewConceptsUsingGET) | **GET** /{branch}/authoring-stats/new-concepts | getNewConcepts
[**getNewSynonymsOnExistingConceptsUsingGET**](AuthoringStatsApi.md#getNewSynonymsOnExistingConceptsUsingGET) | **GET** /{branch}/authoring-stats/new-synonyms-on-existing-concepts | getNewSynonymsOnExistingConcepts
[**getReactivatedConceptsUsingGET**](AuthoringStatsApi.md#getReactivatedConceptsUsingGET) | **GET** /{branch}/authoring-stats/reactivated-concepts | getReactivatedConcepts
[**getReactivatedSynonymsUsingGET**](AuthoringStatsApi.md#getReactivatedSynonymsUsingGET) | **GET** /{branch}/authoring-stats/reactivated-synonyms | getReactivatedSynonyms
[**getStatsUsingGET**](AuthoringStatsApi.md#getStatsUsingGET) | **GET** /{branch}/authoring-stats | Calculate statistics for unreleased/unversioned content to be used in daily build browser.


<a name="getChangedFSNsUsingGET"></a>
# **getChangedFSNsUsingGET**
> List&lt;ConceptMicro&gt; getChangedFSNsUsingGET(branch, acceptLanguage)

getChangedFSNs

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AuthoringStatsApi;


AuthoringStatsApi apiInstance = new AuthoringStatsApi();
String branch = "branch_example"; // String | branch
String acceptLanguage = "en-US;q=0.8,en-GB;q=0.6"; // String | Accept-Language
try {
    List<ConceptMicro> result = apiInstance.getChangedFSNsUsingGET(branch, acceptLanguage);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AuthoringStatsApi#getChangedFSNsUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **branch** | **String**| branch |
 **acceptLanguage** | **String**| Accept-Language | [default to en-US;q&#x3D;0.8,en-GB;q&#x3D;0.6]

### Return type

[**List&lt;ConceptMicro&gt;**](ConceptMicro.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getInactivatedConceptsUsingGET"></a>
# **getInactivatedConceptsUsingGET**
> List&lt;ConceptMicro&gt; getInactivatedConceptsUsingGET(branch, acceptLanguage)

getInactivatedConcepts

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AuthoringStatsApi;


AuthoringStatsApi apiInstance = new AuthoringStatsApi();
String branch = "branch_example"; // String | branch
String acceptLanguage = "en-US;q=0.8,en-GB;q=0.6"; // String | Accept-Language
try {
    List<ConceptMicro> result = apiInstance.getInactivatedConceptsUsingGET(branch, acceptLanguage);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AuthoringStatsApi#getInactivatedConceptsUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **branch** | **String**| branch |
 **acceptLanguage** | **String**| Accept-Language | [default to en-US;q&#x3D;0.8,en-GB;q&#x3D;0.6]

### Return type

[**List&lt;ConceptMicro&gt;**](ConceptMicro.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getInactivatedSynonymsUsingGET"></a>
# **getInactivatedSynonymsUsingGET**
> List&lt;ConceptMicro&gt; getInactivatedSynonymsUsingGET(branch)

getInactivatedSynonyms

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AuthoringStatsApi;


AuthoringStatsApi apiInstance = new AuthoringStatsApi();
String branch = "branch_example"; // String | branch
try {
    List<ConceptMicro> result = apiInstance.getInactivatedSynonymsUsingGET(branch);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AuthoringStatsApi#getInactivatedSynonymsUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **branch** | **String**| branch |

### Return type

[**List&lt;ConceptMicro&gt;**](ConceptMicro.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getNewConceptsUsingGET"></a>
# **getNewConceptsUsingGET**
> List&lt;ConceptMicro&gt; getNewConceptsUsingGET(branch, acceptLanguage)

getNewConcepts

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AuthoringStatsApi;


AuthoringStatsApi apiInstance = new AuthoringStatsApi();
String branch = "branch_example"; // String | branch
String acceptLanguage = "en-US;q=0.8,en-GB;q=0.6"; // String | Accept-Language
try {
    List<ConceptMicro> result = apiInstance.getNewConceptsUsingGET(branch, acceptLanguage);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AuthoringStatsApi#getNewConceptsUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **branch** | **String**| branch |
 **acceptLanguage** | **String**| Accept-Language | [default to en-US;q&#x3D;0.8,en-GB;q&#x3D;0.6]

### Return type

[**List&lt;ConceptMicro&gt;**](ConceptMicro.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getNewSynonymsOnExistingConceptsUsingGET"></a>
# **getNewSynonymsOnExistingConceptsUsingGET**
> List&lt;ConceptMicro&gt; getNewSynonymsOnExistingConceptsUsingGET(branch)

getNewSynonymsOnExistingConcepts

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AuthoringStatsApi;


AuthoringStatsApi apiInstance = new AuthoringStatsApi();
String branch = "branch_example"; // String | branch
try {
    List<ConceptMicro> result = apiInstance.getNewSynonymsOnExistingConceptsUsingGET(branch);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AuthoringStatsApi#getNewSynonymsOnExistingConceptsUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **branch** | **String**| branch |

### Return type

[**List&lt;ConceptMicro&gt;**](ConceptMicro.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getReactivatedConceptsUsingGET"></a>
# **getReactivatedConceptsUsingGET**
> List&lt;ConceptMicro&gt; getReactivatedConceptsUsingGET(branch, acceptLanguage)

getReactivatedConcepts

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AuthoringStatsApi;


AuthoringStatsApi apiInstance = new AuthoringStatsApi();
String branch = "branch_example"; // String | branch
String acceptLanguage = "en-US;q=0.8,en-GB;q=0.6"; // String | Accept-Language
try {
    List<ConceptMicro> result = apiInstance.getReactivatedConceptsUsingGET(branch, acceptLanguage);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AuthoringStatsApi#getReactivatedConceptsUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **branch** | **String**| branch |
 **acceptLanguage** | **String**| Accept-Language | [default to en-US;q&#x3D;0.8,en-GB;q&#x3D;0.6]

### Return type

[**List&lt;ConceptMicro&gt;**](ConceptMicro.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getReactivatedSynonymsUsingGET"></a>
# **getReactivatedSynonymsUsingGET**
> List&lt;ConceptMicro&gt; getReactivatedSynonymsUsingGET(branch)

getReactivatedSynonyms

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AuthoringStatsApi;


AuthoringStatsApi apiInstance = new AuthoringStatsApi();
String branch = "branch_example"; // String | branch
try {
    List<ConceptMicro> result = apiInstance.getReactivatedSynonymsUsingGET(branch);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AuthoringStatsApi#getReactivatedSynonymsUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **branch** | **String**| branch |

### Return type

[**List&lt;ConceptMicro&gt;**](ConceptMicro.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getStatsUsingGET"></a>
# **getStatsUsingGET**
> AuthoringStatsSummary getStatsUsingGET(branch)

Calculate statistics for unreleased/unversioned content to be used in daily build browser.

Does not work on versioned content.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AuthoringStatsApi;


AuthoringStatsApi apiInstance = new AuthoringStatsApi();
String branch = "branch_example"; // String | branch
try {
    AuthoringStatsSummary result = apiInstance.getStatsUsingGET(branch);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AuthoringStatsApi#getStatsUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **branch** | **String**| branch |

### Return type

[**AuthoringStatsSummary**](AuthoringStatsSummary.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

