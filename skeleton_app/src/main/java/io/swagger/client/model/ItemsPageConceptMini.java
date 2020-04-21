/*
 * Snowstorm
 * SNOMED CT Terminology Server REST API
 *
 * OpenAPI spec version: 1.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.client.model.CollectionConceptMini;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * ItemsPageConceptMini
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-04-02T10:22:15.067Z")
public class ItemsPageConceptMini {
  @SerializedName("items")
  private CollectionConceptMini items = null;

  @SerializedName("limit")
  private Long limit = null;

  @SerializedName("offset")
  private Long offset = null;

  @SerializedName("searchAfter")
  private String searchAfter = null;

  @SerializedName("searchAfterArray")
  private List<Object> searchAfterArray = null;

  @SerializedName("total")
  private Long total = null;

  public ItemsPageConceptMini items(CollectionConceptMini items) {
    this.items = items;
    return this;
  }

   /**
   * Get items
   * @return items
  **/
  @ApiModelProperty(value = "")
  public CollectionConceptMini getItems() {
    return items;
  }

  public void setItems(CollectionConceptMini items) {
    this.items = items;
  }

  public ItemsPageConceptMini limit(Long limit) {
    this.limit = limit;
    return this;
  }

   /**
   * Get limit
   * @return limit
  **/
  @ApiModelProperty(value = "")
  public Long getLimit() {
    return limit;
  }

  public void setLimit(Long limit) {
    this.limit = limit;
  }

  public ItemsPageConceptMini offset(Long offset) {
    this.offset = offset;
    return this;
  }

   /**
   * Get offset
   * @return offset
  **/
  @ApiModelProperty(value = "")
  public Long getOffset() {
    return offset;
  }

  public void setOffset(Long offset) {
    this.offset = offset;
  }

  public ItemsPageConceptMini searchAfter(String searchAfter) {
    this.searchAfter = searchAfter;
    return this;
  }

   /**
   * Get searchAfter
   * @return searchAfter
  **/
  @ApiModelProperty(value = "")
  public String getSearchAfter() {
    return searchAfter;
  }

  public void setSearchAfter(String searchAfter) {
    this.searchAfter = searchAfter;
  }

  public ItemsPageConceptMini searchAfterArray(List<Object> searchAfterArray) {
    this.searchAfterArray = searchAfterArray;
    return this;
  }

  public ItemsPageConceptMini addSearchAfterArrayItem(Object searchAfterArrayItem) {
    if (this.searchAfterArray == null) {
      this.searchAfterArray = new ArrayList<Object>();
    }
    this.searchAfterArray.add(searchAfterArrayItem);
    return this;
  }

   /**
   * Get searchAfterArray
   * @return searchAfterArray
  **/
  @ApiModelProperty(value = "")
  public List<Object> getSearchAfterArray() {
    return searchAfterArray;
  }

  public void setSearchAfterArray(List<Object> searchAfterArray) {
    this.searchAfterArray = searchAfterArray;
  }

  public ItemsPageConceptMini total(Long total) {
    this.total = total;
    return this;
  }

   /**
   * Get total
   * @return total
  **/
  @ApiModelProperty(value = "")
  public Long getTotal() {
    return total;
  }

  public void setTotal(Long total) {
    this.total = total;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ItemsPageConceptMini itemsPageConceptMini = (ItemsPageConceptMini) o;
    return Objects.equals(this.items, itemsPageConceptMini.items) &&
        Objects.equals(this.limit, itemsPageConceptMini.limit) &&
        Objects.equals(this.offset, itemsPageConceptMini.offset) &&
        Objects.equals(this.searchAfter, itemsPageConceptMini.searchAfter) &&
        Objects.equals(this.searchAfterArray, itemsPageConceptMini.searchAfterArray) &&
        Objects.equals(this.total, itemsPageConceptMini.total);
  }

  @Override
  public int hashCode() {
    return Objects.hash(items, limit, offset, searchAfter, searchAfterArray, total);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ItemsPageConceptMini {\n");
    
    sb.append("    items: ").append(toIndentedString(items)).append("\n");
    sb.append("    limit: ").append(toIndentedString(limit)).append("\n");
    sb.append("    offset: ").append(toIndentedString(offset)).append("\n");
    sb.append("    searchAfter: ").append(toIndentedString(searchAfter)).append("\n");
    sb.append("    searchAfterArray: ").append(toIndentedString(searchAfterArray)).append("\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

