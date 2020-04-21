# VersionApi

All URIs are relative to *https://snowstorm.test-nictiz.nl*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getBuildInformationUsingGET**](VersionApi.md#getBuildInformationUsingGET) | **GET** /version | Software build version and timestamp.


<a name="getBuildInformationUsingGET"></a>
# **getBuildInformationUsingGET**
> BuildVersion getBuildInformationUsingGET()

Software build version and timestamp.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.VersionApi;


VersionApi apiInstance = new VersionApi();
try {
    BuildVersion result = apiInstance.getBuildInformationUsingGET();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling VersionApi#getBuildInformationUsingGET");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**BuildVersion**](BuildVersion.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

