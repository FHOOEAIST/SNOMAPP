# RefsetMembersApi

All URIs are relative to *https://snowstorm.test-nictiz.nl*

Method | HTTP request | Description
------------- | ------------- | -------------
[**fetchMemberUsingGET**](RefsetMembersApi.md#fetchMemberUsingGET) | **GET** /{branch}/members/{uuid} | fetchMember
[**findBrowserReferenceSetMembersWithAggregationsUsingGET**](RefsetMembersApi.md#findBrowserReferenceSetMembersWithAggregationsUsingGET) | **GET** /browser/{branch}/members | Search for reference set ids
[**findRefsetMembersUsingGET**](RefsetMembersApi.md#findRefsetMembersUsingGET) | **GET** /{branch}/members | Search for reference set members.


<a name="fetchMemberUsingGET"></a>
# **fetchMemberUsingGET**
> ReferenceSetMember fetchMemberUsingGET(branch, uuid, acceptLanguage)

fetchMember

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RefsetMembersApi;


RefsetMembersApi apiInstance = new RefsetMembersApi();
String branch = "branch_example"; // String | branch
String uuid = "uuid_example"; // String | uuid
String acceptLanguage = "en-US;q=0.8,en-GB;q=0.6"; // String | Accept-Language
try {
    ReferenceSetMember result = apiInstance.fetchMemberUsingGET(branch, uuid, acceptLanguage);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RefsetMembersApi#fetchMemberUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **branch** | **String**| branch |
 **uuid** | **String**| uuid |
 **acceptLanguage** | **String**| Accept-Language | [default to en-US;q&#x3D;0.8,en-GB;q&#x3D;0.6]

### Return type

[**ReferenceSetMember**](ReferenceSetMember.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="findBrowserReferenceSetMembersWithAggregationsUsingGET"></a>
# **findBrowserReferenceSetMembersWithAggregationsUsingGET**
> RefSetMemberPageWithBucketAggregationsReferenceSetMember findBrowserReferenceSetMembersWithAggregationsUsingGET(branch, acceptLanguage, referenceSet, referencedComponentId, active, offset, limit)

Search for reference set ids

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RefsetMembersApi;


RefsetMembersApi apiInstance = new RefsetMembersApi();
String branch = "branch_example"; // String | branch
String acceptLanguage = "en-US;q=0.8,en-GB;q=0.6"; // String | Accept-Language
String referenceSet = "referenceSet_example"; // String | A reference set identifier or ECL expression can be used to limit the reference sets searched. Example: <723564002
String referencedComponentId = "referencedComponentId_example"; // String | referencedComponentId
Boolean active = true; // Boolean | active
Integer offset = 0; // Integer | offset
Integer limit = 10; // Integer | limit
try {
    RefSetMemberPageWithBucketAggregationsReferenceSetMember result = apiInstance.findBrowserReferenceSetMembersWithAggregationsUsingGET(branch, acceptLanguage, referenceSet, referencedComponentId, active, offset, limit);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RefsetMembersApi#findBrowserReferenceSetMembersWithAggregationsUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **branch** | **String**| branch |
 **acceptLanguage** | **String**| Accept-Language | [default to en-US;q&#x3D;0.8,en-GB;q&#x3D;0.6]
 **referenceSet** | **String**| A reference set identifier or ECL expression can be used to limit the reference sets searched. Example: &lt;723564002 | [optional]
 **referencedComponentId** | **String**| referencedComponentId | [optional]
 **active** | **Boolean**| active | [optional]
 **offset** | **Integer**| offset | [optional] [default to 0]
 **limit** | **Integer**| limit | [optional] [default to 10]

### Return type

[**RefSetMemberPageWithBucketAggregationsReferenceSetMember**](RefSetMemberPageWithBucketAggregationsReferenceSetMember.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="findRefsetMembersUsingGET"></a>
# **findRefsetMembersUsingGET**
> ItemsPageReferenceSetMember findRefsetMembersUsingGET(branch, acceptLanguage, referenceSet, referencedComponentId, active, targetComponent, mapTarget, owlExpressionConceptId, owlExpressionGci, offset, limit)

Search for reference set members.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RefsetMembersApi;


RefsetMembersApi apiInstance = new RefsetMembersApi();
String branch = "branch_example"; // String | branch
String acceptLanguage = "en-US;q=0.8,en-GB;q=0.6"; // String | Accept-Language
String referenceSet = "referenceSet_example"; // String | A reference set identifier or ECL expression can be used to limit the reference sets searched. Example: <723564002
String referencedComponentId = "referencedComponentId_example"; // String | referencedComponentId
Boolean active = true; // Boolean | active
String targetComponent = "targetComponent_example"; // String | targetComponent
String mapTarget = "mapTarget_example"; // String | mapTarget
String owlExpressionConceptId = "owlExpressionConceptId_example"; // String | Search by concept identifiers within an owlExpression.
Boolean owlExpressionGci = true; // Boolean | Return axiom members with a GCI owlExpression.
Integer offset = 0; // Integer | offset
Integer limit = 50; // Integer | limit
try {
    ItemsPageReferenceSetMember result = apiInstance.findRefsetMembersUsingGET(branch, acceptLanguage, referenceSet, referencedComponentId, active, targetComponent, mapTarget, owlExpressionConceptId, owlExpressionGci, offset, limit);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RefsetMembersApi#findRefsetMembersUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **branch** | **String**| branch |
 **acceptLanguage** | **String**| Accept-Language | [default to en-US;q&#x3D;0.8,en-GB;q&#x3D;0.6]
 **referenceSet** | **String**| A reference set identifier or ECL expression can be used to limit the reference sets searched. Example: &lt;723564002 | [optional]
 **referencedComponentId** | **String**| referencedComponentId | [optional]
 **active** | **Boolean**| active | [optional]
 **targetComponent** | **String**| targetComponent | [optional]
 **mapTarget** | **String**| mapTarget | [optional]
 **owlExpressionConceptId** | **String**| Search by concept identifiers within an owlExpression. | [optional]
 **owlExpressionGci** | **Boolean**| Return axiom members with a GCI owlExpression. | [optional]
 **offset** | **Integer**| offset | [optional] [default to 0]
 **limit** | **Integer**| limit | [optional] [default to 50]

### Return type

[**ItemsPageReferenceSetMember**](ItemsPageReferenceSetMember.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

