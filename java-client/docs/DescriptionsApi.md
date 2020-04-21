# DescriptionsApi

All URIs are relative to *https://snowstorm.test-nictiz.nl*

Method | HTTP request | Description
------------- | ------------- | -------------
[**fetchDescriptionUsingGET**](DescriptionsApi.md#fetchDescriptionUsingGET) | **GET** /{branch}/descriptions/{descriptionId} | fetchDescription
[**findBrowserDescriptionsUsingGET**](DescriptionsApi.md#findBrowserDescriptionsUsingGET) | **GET** /browser/{branch}/descriptions | Search for concept descriptions.
[**findDescriptionsUsingGET**](DescriptionsApi.md#findDescriptionsUsingGET) | **GET** /{branch}/descriptions | findDescriptions


<a name="fetchDescriptionUsingGET"></a>
# **fetchDescriptionUsingGET**
> Description fetchDescriptionUsingGET(branch, descriptionId)

fetchDescription

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DescriptionsApi;


DescriptionsApi apiInstance = new DescriptionsApi();
String branch = "branch_example"; // String | branch
String descriptionId = "descriptionId_example"; // String | descriptionId
try {
    Description result = apiInstance.fetchDescriptionUsingGET(branch, descriptionId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DescriptionsApi#fetchDescriptionUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **branch** | **String**| branch |
 **descriptionId** | **String**| descriptionId |

### Return type

[**Description**](Description.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="findBrowserDescriptionsUsingGET"></a>
# **findBrowserDescriptionsUsingGET**
> PageBrowserDescriptionSearchResult findBrowserDescriptionsUsingGET(branch, acceptLanguage, term, active, module, language, semanticTag, conceptActive, conceptRefset, groupByConcept, searchMode, offset, limit)

Search for concept descriptions.

The Accept-Language header is used to specify the user&#39;s preferred language, &#39;en&#39; is always added as a fallback if not already included in the list. Each language is used as an optional clause for matching and will include the correct character folding behaviour for that language. The Accept-Language header list is also used to chose the best translated FSN and PT values in the response.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DescriptionsApi;


DescriptionsApi apiInstance = new DescriptionsApi();
String branch = "branch_example"; // String | branch
String acceptLanguage = "en-US;q=0.8,en-GB;q=0.6"; // String | Accept-Language
String term = "term_example"; // String | term
Boolean active = true; // Boolean | active
String module = "module_example"; // String | module
List<String> language = Arrays.asList("language_example"); // List<String> | List of two character language codes to match. The English language code 'en' will not be added automatically, in contrast to the Accept-Language header which always includes it. Accept-Language header still controls result FSN and PT language selection.
String semanticTag = "semanticTag_example"; // String | semanticTag
Boolean conceptActive = true; // Boolean | conceptActive
String conceptRefset = "conceptRefset_example"; // String | conceptRefset
Boolean groupByConcept = false; // Boolean | groupByConcept
String searchMode = "STANDARD"; // String | searchMode
Integer offset = 0; // Integer | offset
Integer limit = 50; // Integer | limit
try {
    PageBrowserDescriptionSearchResult result = apiInstance.findBrowserDescriptionsUsingGET(branch, acceptLanguage, term, active, module, language, semanticTag, conceptActive, conceptRefset, groupByConcept, searchMode, offset, limit);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DescriptionsApi#findBrowserDescriptionsUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **branch** | **String**| branch |
 **acceptLanguage** | **String**| Accept-Language | [default to en-US;q&#x3D;0.8,en-GB;q&#x3D;0.6]
 **term** | **String**| term | [optional]
 **active** | **Boolean**| active | [optional]
 **module** | **String**| module | [optional]
 **language** | [**List&lt;String&gt;**](String.md)| List of two character language codes to match. The English language code &#39;en&#39; will not be added automatically, in contrast to the Accept-Language header which always includes it. Accept-Language header still controls result FSN and PT language selection. | [optional]
 **semanticTag** | **String**| semanticTag | [optional]
 **conceptActive** | **Boolean**| conceptActive | [optional]
 **conceptRefset** | **String**| conceptRefset | [optional]
 **groupByConcept** | **Boolean**| groupByConcept | [optional] [default to false]
 **searchMode** | **String**| searchMode | [optional] [default to STANDARD] [enum: STANDARD, REGEX]
 **offset** | **Integer**| offset | [optional] [default to 0]
 **limit** | **Integer**| limit | [optional] [default to 50]

### Return type

[**PageBrowserDescriptionSearchResult**](PageBrowserDescriptionSearchResult.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="findDescriptionsUsingGET"></a>
# **findDescriptionsUsingGET**
> ItemsPageDescription findDescriptionsUsingGET(branch, concept, offset, limit)

findDescriptions

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DescriptionsApi;


DescriptionsApi apiInstance = new DescriptionsApi();
String branch = "branch_example"; // String | branch
String concept = "concept_example"; // String | The concept id to match
Integer offset = 0; // Integer | offset
Integer limit = 50; // Integer | limit
try {
    ItemsPageDescription result = apiInstance.findDescriptionsUsingGET(branch, concept, offset, limit);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DescriptionsApi#findDescriptionsUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **branch** | **String**| branch |
 **concept** | **String**| The concept id to match | [optional]
 **offset** | **Integer**| offset | [optional] [default to 0]
 **limit** | **Integer**| limit | [optional] [default to 50]

### Return type

[**ItemsPageDescription**](ItemsPageDescription.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

