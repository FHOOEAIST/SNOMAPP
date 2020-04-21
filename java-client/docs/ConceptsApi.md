# ConceptsApi

All URIs are relative to *https://snowstorm.test-nictiz.nl*

Method | HTTP request | Description
------------- | ------------- | -------------
[**findBrowserConceptUsingGET**](ConceptsApi.md#findBrowserConceptUsingGET) | **GET** /browser/{branch}/concepts/{conceptId} | Load a concept in the browser format.
[**findConceptAncestorsUsingGET**](ConceptsApi.md#findConceptAncestorsUsingGET) | **GET** /browser/{branch}/concepts/{conceptId}/ancestors | findConceptAncestors
[**findConceptChildrenUsingGET**](ConceptsApi.md#findConceptChildrenUsingGET) | **GET** /browser/{branch}/concepts/{conceptId}/children | findConceptChildren
[**findConceptDescendantsUsingGET**](ConceptsApi.md#findConceptDescendantsUsingGET) | **GET** /{branch}/concepts/{conceptId}/descendants | findConceptDescendants
[**findConceptDescriptionsUsingGET**](ConceptsApi.md#findConceptDescriptionsUsingGET) | **GET** /{branch}/concepts/{conceptId}/descriptions | findConceptDescriptions
[**findConceptInboundRelationshipsUsingGET**](ConceptsApi.md#findConceptInboundRelationshipsUsingGET) | **GET** /{branch}/concepts/{conceptId}/inbound-relationships | findConceptInboundRelationships
[**findConceptParentsUsingGET**](ConceptsApi.md#findConceptParentsUsingGET) | **GET** /browser/{branch}/concepts/{conceptId}/parents | findConceptParents
[**findConceptReferencesUsingGET**](ConceptsApi.md#findConceptReferencesUsingGET) | **GET** /{branch}/concepts/{conceptId}/references | Find concepts which reference this concept in the inferred or stated form (including stated axioms).
[**findConceptUsingGET**](ConceptsApi.md#findConceptUsingGET) | **GET** /{branch}/concepts/{conceptId} | findConcept
[**findConceptsUsingGET**](ConceptsApi.md#findConceptsUsingGET) | **GET** /{branch}/concepts | findConcepts
[**getBrowserConceptsUsingGET**](ConceptsApi.md#getBrowserConceptsUsingGET) | **GET** /browser/{branch}/concepts | Load concepts in the browser format.
[**getConceptAuthoringFormUsingGET**](ConceptsApi.md#getConceptAuthoringFormUsingGET) | **GET** /{branch}/concepts/{conceptId}/authoring-form | getConceptAuthoringForm
[**getConceptBulkChangeUsingGET**](ConceptsApi.md#getConceptBulkChangeUsingGET) | **GET** /browser/{branch}/concepts/bulk/{bulkChangeId} | Fetch the status of a bulk concept creation or update.
[**getConceptNormalFormUsingGET**](ConceptsApi.md#getConceptNormalFormUsingGET) | **GET** /{branch}/concepts/{conceptId}/normal-form | getConceptNormalForm


<a name="findBrowserConceptUsingGET"></a>
# **findBrowserConceptUsingGET**
> ConceptView findBrowserConceptUsingGET(branch, conceptId, acceptLanguage)

Load a concept in the browser format.

During content authoring previous versions of the concept can be loaded from version control. To do this use the branch path format {branch@yyyy-MM-ddTHH:mm:ss.SSSZ} or {branch@epoch_milliseconds}. The version of the concept when the branch was created can be loaded using {branch@-}.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ConceptsApi;


ConceptsApi apiInstance = new ConceptsApi();
String branch = "branch_example"; // String | branch
String conceptId = "conceptId_example"; // String | conceptId
String acceptLanguage = "en-US;q=0.8,en-GB;q=0.6"; // String | Accept-Language
try {
    ConceptView result = apiInstance.findBrowserConceptUsingGET(branch, conceptId, acceptLanguage);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ConceptsApi#findBrowserConceptUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **branch** | **String**| branch |
 **conceptId** | **String**| conceptId |
 **acceptLanguage** | **String**| Accept-Language | [default to en-US;q&#x3D;0.8,en-GB;q&#x3D;0.6]

### Return type

[**ConceptView**](ConceptView.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="findConceptAncestorsUsingGET"></a>
# **findConceptAncestorsUsingGET**
> CollectionConceptMini findConceptAncestorsUsingGET(branch, conceptId, acceptLanguage, form)

findConceptAncestors

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ConceptsApi;


ConceptsApi apiInstance = new ConceptsApi();
String branch = "branch_example"; // String | branch
String conceptId = "conceptId_example"; // String | conceptId
String acceptLanguage = "en-US;q=0.8,en-GB;q=0.6"; // String | Accept-Language
String form = "inferred"; // String | form
try {
    CollectionConceptMini result = apiInstance.findConceptAncestorsUsingGET(branch, conceptId, acceptLanguage, form);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ConceptsApi#findConceptAncestorsUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **branch** | **String**| branch |
 **conceptId** | **String**| conceptId |
 **acceptLanguage** | **String**| Accept-Language | [default to en-US;q&#x3D;0.8,en-GB;q&#x3D;0.6]
 **form** | **String**| form | [optional] [default to inferred] [enum: inferred, stated, additional]

### Return type

[**CollectionConceptMini**](CollectionConceptMini.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="findConceptChildrenUsingGET"></a>
# **findConceptChildrenUsingGET**
> CollectionConceptMini findConceptChildrenUsingGET(branch, conceptId, acceptLanguage, form)

findConceptChildren

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ConceptsApi;


ConceptsApi apiInstance = new ConceptsApi();
String branch = "branch_example"; // String | branch
String conceptId = "conceptId_example"; // String | conceptId
String acceptLanguage = "en-US;q=0.8,en-GB;q=0.6"; // String | Accept-Language
String form = "inferred"; // String | form
try {
    CollectionConceptMini result = apiInstance.findConceptChildrenUsingGET(branch, conceptId, acceptLanguage, form);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ConceptsApi#findConceptChildrenUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **branch** | **String**| branch |
 **conceptId** | **String**| conceptId |
 **acceptLanguage** | **String**| Accept-Language | [default to en-US;q&#x3D;0.8,en-GB;q&#x3D;0.6]
 **form** | **String**| form | [optional] [default to inferred] [enum: inferred, stated, additional]

### Return type

[**CollectionConceptMini**](CollectionConceptMini.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="findConceptDescendantsUsingGET"></a>
# **findConceptDescendantsUsingGET**
> ItemsPageConceptMini findConceptDescendantsUsingGET(branch, conceptId, acceptLanguage, stated, offset, limit)

findConceptDescendants

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ConceptsApi;


ConceptsApi apiInstance = new ConceptsApi();
String branch = "branch_example"; // String | branch
String conceptId = "conceptId_example"; // String | conceptId
String acceptLanguage = "en-US;q=0.8,en-GB;q=0.6"; // String | Accept-Language
Boolean stated = false; // Boolean | stated
Integer offset = 0; // Integer | offset
Integer limit = 50; // Integer | limit
try {
    ItemsPageConceptMini result = apiInstance.findConceptDescendantsUsingGET(branch, conceptId, acceptLanguage, stated, offset, limit);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ConceptsApi#findConceptDescendantsUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **branch** | **String**| branch |
 **conceptId** | **String**| conceptId |
 **acceptLanguage** | **String**| Accept-Language | [default to en-US;q&#x3D;0.8,en-GB;q&#x3D;0.6]
 **stated** | **Boolean**| stated | [optional] [default to false]
 **offset** | **Integer**| offset | [optional] [default to 0]
 **limit** | **Integer**| limit | [optional] [default to 50]

### Return type

[**ItemsPageConceptMini**](ItemsPageConceptMini.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="findConceptDescriptionsUsingGET"></a>
# **findConceptDescriptionsUsingGET**
> ConceptDescriptionsResult findConceptDescriptionsUsingGET(branch, conceptId, acceptLanguage)

findConceptDescriptions

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ConceptsApi;


ConceptsApi apiInstance = new ConceptsApi();
String branch = "branch_example"; // String | branch
String conceptId = "conceptId_example"; // String | conceptId
String acceptLanguage = "en-US;q=0.8,en-GB;q=0.6"; // String | Accept-Language
try {
    ConceptDescriptionsResult result = apiInstance.findConceptDescriptionsUsingGET(branch, conceptId, acceptLanguage);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ConceptsApi#findConceptDescriptionsUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **branch** | **String**| branch |
 **conceptId** | **String**| conceptId |
 **acceptLanguage** | **String**| Accept-Language | [default to en-US;q&#x3D;0.8,en-GB;q&#x3D;0.6]

### Return type

[**ConceptDescriptionsResult**](ConceptDescriptionsResult.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="findConceptInboundRelationshipsUsingGET"></a>
# **findConceptInboundRelationshipsUsingGET**
> InboundRelationshipsResult findConceptInboundRelationshipsUsingGET(branch, conceptId)

findConceptInboundRelationships

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ConceptsApi;


ConceptsApi apiInstance = new ConceptsApi();
String branch = "branch_example"; // String | branch
String conceptId = "conceptId_example"; // String | conceptId
try {
    InboundRelationshipsResult result = apiInstance.findConceptInboundRelationshipsUsingGET(branch, conceptId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ConceptsApi#findConceptInboundRelationshipsUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **branch** | **String**| branch |
 **conceptId** | **String**| conceptId |

### Return type

[**InboundRelationshipsResult**](InboundRelationshipsResult.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="findConceptParentsUsingGET"></a>
# **findConceptParentsUsingGET**
> CollectionConceptMini findConceptParentsUsingGET(branch, conceptId, acceptLanguage, form)

findConceptParents

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ConceptsApi;


ConceptsApi apiInstance = new ConceptsApi();
String branch = "branch_example"; // String | branch
String conceptId = "conceptId_example"; // String | conceptId
String acceptLanguage = "en-US;q=0.8,en-GB;q=0.6"; // String | Accept-Language
String form = "inferred"; // String | form
try {
    CollectionConceptMini result = apiInstance.findConceptParentsUsingGET(branch, conceptId, acceptLanguage, form);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ConceptsApi#findConceptParentsUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **branch** | **String**| branch |
 **conceptId** | **String**| conceptId |
 **acceptLanguage** | **String**| Accept-Language | [default to en-US;q&#x3D;0.8,en-GB;q&#x3D;0.6]
 **form** | **String**| form | [optional] [default to inferred] [enum: inferred, stated, additional]

### Return type

[**CollectionConceptMini**](CollectionConceptMini.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="findConceptReferencesUsingGET"></a>
# **findConceptReferencesUsingGET**
> ConceptReferencesResult findConceptReferencesUsingGET(branch, conceptId, acceptLanguage, stated, offset, limit)

Find concepts which reference this concept in the inferred or stated form (including stated axioms).

Pagination works on the referencing concepts. A referencing concept may have one or more references of different types.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ConceptsApi;


ConceptsApi apiInstance = new ConceptsApi();
String branch = "branch_example"; // String | branch
Long conceptId = 789L; // Long | conceptId
String acceptLanguage = "en-US;q=0.8,en-GB;q=0.6"; // String | Accept-Language
Boolean stated = false; // Boolean | stated
Integer offset = 0; // Integer | offset
Integer limit = 1000; // Integer | limit
try {
    ConceptReferencesResult result = apiInstance.findConceptReferencesUsingGET(branch, conceptId, acceptLanguage, stated, offset, limit);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ConceptsApi#findConceptReferencesUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **branch** | **String**| branch |
 **conceptId** | **Long**| conceptId |
 **acceptLanguage** | **String**| Accept-Language | [default to en-US;q&#x3D;0.8,en-GB;q&#x3D;0.6]
 **stated** | **Boolean**| stated | [optional] [default to false]
 **offset** | **Integer**| offset | [optional] [default to 0]
 **limit** | **Integer**| limit | [optional] [default to 1000]

### Return type

[**ConceptReferencesResult**](ConceptReferencesResult.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="findConceptUsingGET"></a>
# **findConceptUsingGET**
> ConceptMini findConceptUsingGET(branch, conceptId, acceptLanguage)

findConcept

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ConceptsApi;


ConceptsApi apiInstance = new ConceptsApi();
String branch = "branch_example"; // String | branch
String conceptId = "conceptId_example"; // String | conceptId
String acceptLanguage = "en-US;q=0.8,en-GB;q=0.6"; // String | Accept-Language
try {
    ConceptMini result = apiInstance.findConceptUsingGET(branch, conceptId, acceptLanguage);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ConceptsApi#findConceptUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **branch** | **String**| branch |
 **conceptId** | **String**| conceptId |
 **acceptLanguage** | **String**| Accept-Language | [default to en-US;q&#x3D;0.8,en-GB;q&#x3D;0.6]

### Return type

[**ConceptMini**](ConceptMini.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/csv

<a name="findConceptsUsingGET"></a>
# **findConceptsUsingGET**
> ItemsPageConceptMini findConceptsUsingGET(branch, acceptLanguage, activeFilter, definitionStatusFilter, term, termActive, ecl, statedEcl, conceptIds, offset, limit, searchAfter)

findConcepts

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ConceptsApi;


ConceptsApi apiInstance = new ConceptsApi();
String branch = "branch_example"; // String | branch
String acceptLanguage = "en-US;q=0.8,en-GB;q=0.6"; // String | Accept-Language
Boolean activeFilter = true; // Boolean | activeFilter
String definitionStatusFilter = "definitionStatusFilter_example"; // String | definitionStatusFilter
String term = "term_example"; // String | term
Boolean termActive = true; // Boolean | termActive
String ecl = "ecl_example"; // String | ecl
String statedEcl = "statedEcl_example"; // String | statedEcl
List<String> conceptIds = Arrays.asList("conceptIds_example"); // List<String> | conceptIds
Integer offset = 0; // Integer | offset
Integer limit = 50; // Integer | limit
String searchAfter = "searchAfter_example"; // String | searchAfter
try {
    ItemsPageConceptMini result = apiInstance.findConceptsUsingGET(branch, acceptLanguage, activeFilter, definitionStatusFilter, term, termActive, ecl, statedEcl, conceptIds, offset, limit, searchAfter);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ConceptsApi#findConceptsUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **branch** | **String**| branch |
 **acceptLanguage** | **String**| Accept-Language | [default to en-US;q&#x3D;0.8,en-GB;q&#x3D;0.6]
 **activeFilter** | **Boolean**| activeFilter | [optional]
 **definitionStatusFilter** | **String**| definitionStatusFilter | [optional]
 **term** | **String**| term | [optional]
 **termActive** | **Boolean**| termActive | [optional]
 **ecl** | **String**| ecl | [optional]
 **statedEcl** | **String**| statedEcl | [optional]
 **conceptIds** | [**List&lt;String&gt;**](String.md)| conceptIds | [optional]
 **offset** | **Integer**| offset | [optional] [default to 0]
 **limit** | **Integer**| limit | [optional] [default to 50]
 **searchAfter** | **String**| searchAfter | [optional]

### Return type

[**ItemsPageConceptMini**](ItemsPageConceptMini.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/csv

<a name="getBrowserConceptsUsingGET"></a>
# **getBrowserConceptsUsingGET**
> ItemsPageConcept getBrowserConceptsUsingGET(branch, acceptLanguage, number, size, searchAfter)

Load concepts in the browser format.

When enabled &#39;searchAfter&#39; can be used for unlimited pagination. Load the first page then take the &#39;searchAfter&#39; value from the response and use that as a parameter in the next page request instead of &#39;number&#39;.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ConceptsApi;


ConceptsApi apiInstance = new ConceptsApi();
String branch = "branch_example"; // String | branch
String acceptLanguage = "en-US;q=0.8,en-GB;q=0.6"; // String | Accept-Language
Integer number = 0; // Integer | number
Integer size = 100; // Integer | size
String searchAfter = "searchAfter_example"; // String | searchAfter
try {
    ItemsPageConcept result = apiInstance.getBrowserConceptsUsingGET(branch, acceptLanguage, number, size, searchAfter);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ConceptsApi#getBrowserConceptsUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **branch** | **String**| branch |
 **acceptLanguage** | **String**| Accept-Language | [default to en-US;q&#x3D;0.8,en-GB;q&#x3D;0.6]
 **number** | **Integer**| number | [optional] [default to 0]
 **size** | **Integer**| size | [optional] [default to 100]
 **searchAfter** | **String**| searchAfter | [optional]

### Return type

[**ItemsPageConcept**](ItemsPageConcept.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getConceptAuthoringFormUsingGET"></a>
# **getConceptAuthoringFormUsingGET**
> Expression getConceptAuthoringFormUsingGET(branch, conceptId, acceptLanguage)

getConceptAuthoringForm

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ConceptsApi;


ConceptsApi apiInstance = new ConceptsApi();
String branch = "branch_example"; // String | branch
String conceptId = "conceptId_example"; // String | conceptId
String acceptLanguage = "en-US;q=0.8,en-GB;q=0.6"; // String | Accept-Language
try {
    Expression result = apiInstance.getConceptAuthoringFormUsingGET(branch, conceptId, acceptLanguage);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ConceptsApi#getConceptAuthoringFormUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **branch** | **String**| branch |
 **conceptId** | **String**| conceptId |
 **acceptLanguage** | **String**| Accept-Language | [default to en-US;q&#x3D;0.8,en-GB;q&#x3D;0.6]

### Return type

[**Expression**](Expression.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getConceptBulkChangeUsingGET"></a>
# **getConceptBulkChangeUsingGET**
> AsyncConceptChangeBatch getConceptBulkChangeUsingGET(branch, bulkChangeId)

Fetch the status of a bulk concept creation or update.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ConceptsApi;


ConceptsApi apiInstance = new ConceptsApi();
String branch = "branch_example"; // String | branch
String bulkChangeId = "bulkChangeId_example"; // String | bulkChangeId
try {
    AsyncConceptChangeBatch result = apiInstance.getConceptBulkChangeUsingGET(branch, bulkChangeId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ConceptsApi#getConceptBulkChangeUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **branch** | **String**| branch |
 **bulkChangeId** | **String**| bulkChangeId |

### Return type

[**AsyncConceptChangeBatch**](AsyncConceptChangeBatch.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getConceptNormalFormUsingGET"></a>
# **getConceptNormalFormUsingGET**
> ExpressionStringPojo getConceptNormalFormUsingGET(branch, conceptId, acceptLanguage, statedView, includeTerms)

getConceptNormalForm

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ConceptsApi;


ConceptsApi apiInstance = new ConceptsApi();
String branch = "branch_example"; // String | branch
String conceptId = "conceptId_example"; // String | conceptId
String acceptLanguage = "en-US;q=0.8,en-GB;q=0.6"; // String | Accept-Language
Boolean statedView = false; // Boolean | statedView
Boolean includeTerms = false; // Boolean | includeTerms
try {
    ExpressionStringPojo result = apiInstance.getConceptNormalFormUsingGET(branch, conceptId, acceptLanguage, statedView, includeTerms);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ConceptsApi#getConceptNormalFormUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **branch** | **String**| branch |
 **conceptId** | **String**| conceptId |
 **acceptLanguage** | **String**| Accept-Language | [default to en-US;q&#x3D;0.8,en-GB;q&#x3D;0.6]
 **statedView** | **Boolean**| statedView | [optional] [default to false]
 **includeTerms** | **Boolean**| includeTerms | [optional] [default to false]

### Return type

[**ExpressionStringPojo**](ExpressionStringPojo.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

