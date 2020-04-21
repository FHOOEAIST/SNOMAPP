# CodeSystemsApi

All URIs are relative to *https://snowstorm.test-nictiz.nl*

Method | HTTP request | Description
------------- | ------------- | -------------
[**findAllUsingGET**](CodeSystemsApi.md#findAllUsingGET) | **GET** /codesystems | Retrieve all code systems
[**findAllVersionsUsingGET**](CodeSystemsApi.md#findAllVersionsUsingGET) | **GET** /codesystems/{shortName}/versions | Retrieve all code system versions
[**findCodeSystemUsingGET**](CodeSystemsApi.md#findCodeSystemUsingGET) | **GET** /codesystems/{shortName} | Retrieve a code system


<a name="findAllUsingGET"></a>
# **findAllUsingGET**
> ItemsPageCodeSystem findAllUsingGET()

Retrieve all code systems

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.CodeSystemsApi;


CodeSystemsApi apiInstance = new CodeSystemsApi();
try {
    ItemsPageCodeSystem result = apiInstance.findAllUsingGET();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CodeSystemsApi#findAllUsingGET");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**ItemsPageCodeSystem**](ItemsPageCodeSystem.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="findAllVersionsUsingGET"></a>
# **findAllVersionsUsingGET**
> ItemsPageCodeSystemVersion findAllVersionsUsingGET(shortName)

Retrieve all code system versions

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.CodeSystemsApi;


CodeSystemsApi apiInstance = new CodeSystemsApi();
String shortName = "shortName_example"; // String | shortName
try {
    ItemsPageCodeSystemVersion result = apiInstance.findAllVersionsUsingGET(shortName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CodeSystemsApi#findAllVersionsUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **shortName** | **String**| shortName |

### Return type

[**ItemsPageCodeSystemVersion**](ItemsPageCodeSystemVersion.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="findCodeSystemUsingGET"></a>
# **findCodeSystemUsingGET**
> CodeSystem findCodeSystemUsingGET(shortName)

Retrieve a code system

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.CodeSystemsApi;


CodeSystemsApi apiInstance = new CodeSystemsApi();
String shortName = "shortName_example"; // String | shortName
try {
    CodeSystem result = apiInstance.findCodeSystemUsingGET(shortName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CodeSystemsApi#findCodeSystemUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **shortName** | **String**| shortName |

### Return type

[**CodeSystem**](CodeSystem.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

