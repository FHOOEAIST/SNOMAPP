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
import io.swagger.client.model.Description;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * ConceptDescriptionsResult
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-04-02T10:22:15.067Z")
public class ConceptDescriptionsResult {
  @SerializedName("conceptDescriptions")
  private List<Description> conceptDescriptions = null;

  public ConceptDescriptionsResult conceptDescriptions(List<Description> conceptDescriptions) {
    this.conceptDescriptions = conceptDescriptions;
    return this;
  }

  public ConceptDescriptionsResult addConceptDescriptionsItem(Description conceptDescriptionsItem) {
    if (this.conceptDescriptions == null) {
      this.conceptDescriptions = new ArrayList<Description>();
    }
    this.conceptDescriptions.add(conceptDescriptionsItem);
    return this;
  }

   /**
   * Get conceptDescriptions
   * @return conceptDescriptions
  **/
  @ApiModelProperty(value = "")
  public List<Description> getConceptDescriptions() {
    return conceptDescriptions;
  }

  public void setConceptDescriptions(List<Description> conceptDescriptions) {
    this.conceptDescriptions = conceptDescriptions;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConceptDescriptionsResult conceptDescriptionsResult = (ConceptDescriptionsResult) o;
    return Objects.equals(this.conceptDescriptions, conceptDescriptionsResult.conceptDescriptions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(conceptDescriptions);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConceptDescriptionsResult {\n");
    
    sb.append("    conceptDescriptions: ").append(toIndentedString(conceptDescriptions)).append("\n");
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

