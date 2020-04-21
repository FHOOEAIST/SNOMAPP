# MrcmXmlApi

All URIs are relative to *https://snowstorm.test-nictiz.nl*

Method | HTTP request | Description
------------- | ------------- | -------------
[**retrieveAttributeValuesUsingGET**](MrcmXmlApi.md#retrieveAttributeValuesUsingGET) | **GET** /mrcm/{path}/attribute-values/{attributeId} | Retrieve valid values for the given attribute and term prefix.
[**retrieveDomainAttributesUsingGET**](MrcmXmlApi.md#retrieveDomainAttributesUsingGET) | **GET** /mrcm/{path}/domain-attributes | Retrieve MRCM domain attributes applicable for the given parents.


<a name="retrieveAttributeValuesUsingGET"></a>
# **retrieveAttributeValuesUsingGET**
> ItemsPageConceptMini retrieveAttributeValuesUsingGET(path, attributeId, termPrefix, acceptLanguage)

Retrieve valid values for the given attribute and term prefix.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.MrcmXmlApi;


MrcmXmlApi apiInstance = new MrcmXmlApi();
String path = "path_example"; // String | path
String attributeId = "attributeId_example"; // String | attributeId
String termPrefix = "termPrefix_example"; // String | termPrefix
String acceptLanguage = "en-US;q=0.8,en-GB;q=0.6"; // String | Accept-Language
try {
    ItemsPageConceptMini result = apiInstance.retrieveAttributeValuesUsingGET(path, attributeId, termPrefix, acceptLanguage);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MrcmXmlApi#retrieveAttributeValuesUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **path** | **String**| path |
 **attributeId** | **String**| attributeId |
 **termPrefix** | **String**| termPrefix |
 **acceptLanguage** | **String**| Accept-Language | [default to en-US;q&#x3D;0.8,en-GB;q&#x3D;0.6]

### Return type

[**ItemsPageConceptMini**](ItemsPageConceptMini.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveDomainAttributesUsingGET"></a>
# **retrieveDomainAttributesUsingGET**
> ItemsPageConceptMini retrieveDomainAttributesUsingGET(path, acceptLanguage, parentIds)

Retrieve MRCM domain attributes applicable for the given parents.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.MrcmXmlApi;


MrcmXmlApi apiInstance = new MrcmXmlApi();
String path = "path_example"; // String | path
String acceptLanguage = "en-US;q=0.8,en-GB;q=0.6"; // String | Accept-Language
List<Long> parentIds = Arrays.asList(56L); // List<Long> | parentIds
try {
    ItemsPageConceptMini result = apiInstance.retrieveDomainAttributesUsingGET(path, acceptLanguage, parentIds);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MrcmXmlApi#retrieveDomainAttributesUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **path** | **String**| path |
 **acceptLanguage** | **String**| Accept-Language | [default to en-US;q&#x3D;0.8,en-GB;q&#x3D;0.6]
 **parentIds** | [**List&lt;Long&gt;**](Long.md)| parentIds | [optional]

### Return type

[**ItemsPageConceptMini**](ItemsPageConceptMini.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

