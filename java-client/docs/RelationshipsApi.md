# RelationshipsApi

All URIs are relative to *https://snowstorm.test-nictiz.nl*

Method | HTTP request | Description
------------- | ------------- | -------------
[**fetchRelationshipUsingGET**](RelationshipsApi.md#fetchRelationshipUsingGET) | **GET** /{branch}/relationships/{relationshipId} | fetchRelationship
[**findRelationshipsUsingGET**](RelationshipsApi.md#findRelationshipsUsingGET) | **GET** /{branch}/relationships | findRelationships


<a name="fetchRelationshipUsingGET"></a>
# **fetchRelationshipUsingGET**
> Relationship fetchRelationshipUsingGET(branch, relationshipId, acceptLanguage)

fetchRelationship

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RelationshipsApi;


RelationshipsApi apiInstance = new RelationshipsApi();
String branch = "branch_example"; // String | branch
String relationshipId = "relationshipId_example"; // String | relationshipId
String acceptLanguage = "en-US;q=0.8,en-GB;q=0.6"; // String | Accept-Language
try {
    Relationship result = apiInstance.fetchRelationshipUsingGET(branch, relationshipId, acceptLanguage);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RelationshipsApi#fetchRelationshipUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **branch** | **String**| branch |
 **relationshipId** | **String**| relationshipId |
 **acceptLanguage** | **String**| Accept-Language | [default to en-US;q&#x3D;0.8,en-GB;q&#x3D;0.6]

### Return type

[**Relationship**](Relationship.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="findRelationshipsUsingGET"></a>
# **findRelationshipsUsingGET**
> ItemsPageRelationship findRelationshipsUsingGET(branch, acceptLanguage, active, module, effectiveTime, source, type, destination, characteristicType, group, offset, limit)

findRelationships

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.RelationshipsApi;


RelationshipsApi apiInstance = new RelationshipsApi();
String branch = "branch_example"; // String | branch
String acceptLanguage = "en-US;q=0.8,en-GB;q=0.6"; // String | Accept-Language
Boolean active = true; // Boolean | active
String module = "module_example"; // String | module
String effectiveTime = "effectiveTime_example"; // String | effectiveTime
String source = "source_example"; // String | source
String type = "type_example"; // String | type
String destination = "destination_example"; // String | destination
String characteristicType = "characteristicType_example"; // String | characteristicType
Integer group = 56; // Integer | group
Integer offset = 0; // Integer | offset
Integer limit = 50; // Integer | limit
try {
    ItemsPageRelationship result = apiInstance.findRelationshipsUsingGET(branch, acceptLanguage, active, module, effectiveTime, source, type, destination, characteristicType, group, offset, limit);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RelationshipsApi#findRelationshipsUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **branch** | **String**| branch |
 **acceptLanguage** | **String**| Accept-Language | [default to en-US;q&#x3D;0.8,en-GB;q&#x3D;0.6]
 **active** | **Boolean**| active | [optional]
 **module** | **String**| module | [optional]
 **effectiveTime** | **String**| effectiveTime | [optional]
 **source** | **String**| source | [optional]
 **type** | **String**| type | [optional]
 **destination** | **String**| destination | [optional]
 **characteristicType** | **String**| characteristicType | [optional] [enum: STATED_RELATIONSHIP, INFERRED_RELATIONSHIP, ADDITIONAL_RELATIONSHIP]
 **group** | **Integer**| group | [optional]
 **offset** | **Integer**| offset | [optional] [default to 0]
 **limit** | **Integer**| limit | [optional] [default to 50]

### Return type

[**ItemsPageRelationship**](ItemsPageRelationship.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

