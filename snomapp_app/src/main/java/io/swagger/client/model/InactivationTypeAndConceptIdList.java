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
import io.swagger.client.model.Collectionlong;
import io.swagger.client.model.ConceptMini;
import java.io.IOException;

/**
 * InactivationTypeAndConceptIdList
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-04-02T10:22:15.067Z")
public class InactivationTypeAndConceptIdList {
  @SerializedName("conceptIds")
  private Collectionlong conceptIds = null;

  @SerializedName("inactivationIndicator")
  private ConceptMini inactivationIndicator = null;

  public InactivationTypeAndConceptIdList conceptIds(Collectionlong conceptIds) {
    this.conceptIds = conceptIds;
    return this;
  }

   /**
   * Get conceptIds
   * @return conceptIds
  **/
  @ApiModelProperty(value = "")
  public Collectionlong getConceptIds() {
    return conceptIds;
  }

  public void setConceptIds(Collectionlong conceptIds) {
    this.conceptIds = conceptIds;
  }

  public InactivationTypeAndConceptIdList inactivationIndicator(ConceptMini inactivationIndicator) {
    this.inactivationIndicator = inactivationIndicator;
    return this;
  }

   /**
   * Get inactivationIndicator
   * @return inactivationIndicator
  **/
  @ApiModelProperty(value = "")
  public ConceptMini getInactivationIndicator() {
    return inactivationIndicator;
  }

  public void setInactivationIndicator(ConceptMini inactivationIndicator) {
    this.inactivationIndicator = inactivationIndicator;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InactivationTypeAndConceptIdList inactivationTypeAndConceptIdList = (InactivationTypeAndConceptIdList) o;
    return Objects.equals(this.conceptIds, inactivationTypeAndConceptIdList.conceptIds) &&
        Objects.equals(this.inactivationIndicator, inactivationTypeAndConceptIdList.inactivationIndicator);
  }

  @Override
  public int hashCode() {
    return Objects.hash(conceptIds, inactivationIndicator);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InactivationTypeAndConceptIdList {\n");
    
    sb.append("    conceptIds: ").append(toIndentedString(conceptIds)).append("\n");
    sb.append("    inactivationIndicator: ").append(toIndentedString(inactivationIndicator)).append("\n");
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
