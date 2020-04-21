# ValidationApi

All URIs are relative to *https://snowstorm.test-nictiz.nl*

Method | HTTP request | Description
------------- | ------------- | -------------
[**findInactiveConceptsWithNoHistoricalAssociationByInactivationTypeUsingGET**](ValidationApi.md#findInactiveConceptsWithNoHistoricalAssociationByInactivationTypeUsingGET) | **GET** /{branch}/report/inactive-concepts-without-association | Find inactive concepts with no historical association grouped by inactivation type.


<a name="findInactiveConceptsWithNoHistoricalAssociationByInactivationTypeUsingGET"></a>
# **findInactiveConceptsWithNoHistoricalAssociationByInactivationTypeUsingGET**
> List&lt;InactivationTypeAndConceptIdList&gt; findInactiveConceptsWithNoHistoricalAssociationByInactivationTypeUsingGET(branch, conceptEffectiveTime)

Find inactive concepts with no historical association grouped by inactivation type.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ValidationApi;


ValidationApi apiInstance = new ValidationApi();
String branch = "branch_example"; // String | branch
String conceptEffectiveTime = "conceptEffectiveTime_example"; // String | conceptEffectiveTime
try {
    List<InactivationTypeAndConceptIdList> result = apiInstance.findInactiveConceptsWithNoHistoricalAssociationByInactivationTypeUsingGET(branch, conceptEffectiveTime);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ValidationApi#findInactiveConceptsWithNoHistoricalAssociationByInactivationTypeUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **branch** | **String**| branch |
 **conceptEffectiveTime** | **String**| conceptEffectiveTime | [optional]

### Return type

[**List&lt;InactivationTypeAndConceptIdList&gt;**](InactivationTypeAndConceptIdList.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

