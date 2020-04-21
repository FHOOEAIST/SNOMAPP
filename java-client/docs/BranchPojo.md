
# BranchPojo

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**base** | [**OffsetDateTime**](OffsetDateTime.md) |  |  [optional]
**baseTimestamp** | **Long** |  |  [optional]
**containsContent** | **Boolean** |  |  [optional]
**creation** | [**OffsetDateTime**](OffsetDateTime.md) |  |  [optional]
**creationTimestamp** | **Long** |  |  [optional]
**head** | [**OffsetDateTime**](OffsetDateTime.md) |  |  [optional]
**headTimestamp** | **Long** |  |  [optional]
**locked** | **Boolean** |  |  [optional]
**metadata** | **Object** |  |  [optional]
**path** | **String** |  |  [optional]
**state** | [**StateEnum**](#StateEnum) |  |  [optional]
**versionsReplacedCounts** | **Map&lt;String, Integer&gt;** |  |  [optional]


<a name="StateEnum"></a>
## Enum: StateEnum
Name | Value
---- | -----
UP_TO_DATE | &quot;UP_TO_DATE&quot;
FORWARD | &quot;FORWARD&quot;
BEHIND | &quot;BEHIND&quot;
DIVERGED | &quot;DIVERGED&quot;



