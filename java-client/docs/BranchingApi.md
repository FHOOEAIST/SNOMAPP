# BranchingApi

All URIs are relative to *https://snowstorm.test-nictiz.nl*

Method | HTTP request | Description
------------- | ------------- | -------------
[**retrieveAllBranchesUsingGET**](BranchingApi.md#retrieveAllBranchesUsingGET) | **GET** /branches | Retrieve all branches
[**retrieveBranchDescendantsUsingGET**](BranchingApi.md#retrieveBranchDescendantsUsingGET) | **GET** /branches/{path}/children | Retrieve branch descendants
[**retrieveBranchUsingGET**](BranchingApi.md#retrieveBranchUsingGET) | **GET** /branches/{path} | Retrieve a single branch


<a name="retrieveAllBranchesUsingGET"></a>
# **retrieveAllBranchesUsingGET**
> List&lt;Branch&gt; retrieveAllBranchesUsingGET()

Retrieve all branches

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.BranchingApi;


BranchingApi apiInstance = new BranchingApi();
try {
    List<Branch> result = apiInstance.retrieveAllBranchesUsingGET();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BranchingApi#retrieveAllBranchesUsingGET");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;Branch&gt;**](Branch.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveBranchDescendantsUsingGET"></a>
# **retrieveBranchDescendantsUsingGET**
> List&lt;Branch&gt; retrieveBranchDescendantsUsingGET(path, immediateChildren)

Retrieve branch descendants

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.BranchingApi;


BranchingApi apiInstance = new BranchingApi();
String path = "path_example"; // String | path
Boolean immediateChildren = false; // Boolean | immediateChildren
try {
    List<Branch> result = apiInstance.retrieveBranchDescendantsUsingGET(path, immediateChildren);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BranchingApi#retrieveBranchDescendantsUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **path** | **String**| path |
 **immediateChildren** | **Boolean**| immediateChildren | [optional] [default to false]

### Return type

[**List&lt;Branch&gt;**](Branch.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retrieveBranchUsingGET"></a>
# **retrieveBranchUsingGET**
> BranchPojo retrieveBranchUsingGET(path, includeInheritedMetadata)

Retrieve a single branch

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.BranchingApi;


BranchingApi apiInstance = new BranchingApi();
String path = "path_example"; // String | path
Boolean includeInheritedMetadata = false; // Boolean | includeInheritedMetadata
try {
    BranchPojo result = apiInstance.retrieveBranchUsingGET(path, includeInheritedMetadata);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BranchingApi#retrieveBranchUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **path** | **String**| path |
 **includeInheritedMetadata** | **Boolean**| includeInheritedMetadata | [optional] [default to false]

### Return type

[**BranchPojo**](BranchPojo.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

