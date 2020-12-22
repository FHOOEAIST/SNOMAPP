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
import io.swagger.client.model.TermLangPojo;
import java.io.IOException;

/**
 * ConceptMini
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-04-02T10:22:15.067Z")
public class ConceptMini {
  @SerializedName("active")
  private Boolean active = null;

  @SerializedName("conceptId")
  private String conceptId = null;

  @SerializedName("definitionStatus")
  private String definitionStatus = null;

  @SerializedName("effectiveTime")
  private String effectiveTime = null;

  @SerializedName("fsn")
  private TermLangPojo fsn = null;

  @SerializedName("id")
  private String id = null;

  @SerializedName("isLeafInferred")
  private Boolean isLeafInferred = null;

  @SerializedName("isLeafStated")
  private Boolean isLeafStated = null;

  @SerializedName("moduleId")
  private String moduleId = null;

  @SerializedName("pt")
  private TermLangPojo pt = null;

  public ConceptMini active(Boolean active) {
    this.active = active;
    return this;
  }

   /**
   * Get active
   * @return active
  **/
  @ApiModelProperty(value = "")
  public Boolean isActive() {
    return active;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }

  public ConceptMini conceptId(String conceptId) {
    this.conceptId = conceptId;
    return this;
  }

   /**
   * Get conceptId
   * @return conceptId
  **/
  @ApiModelProperty(value = "")
  public String getConceptId() {
    return conceptId;
  }

  public void setConceptId(String conceptId) {
    this.conceptId = conceptId;
  }

  public ConceptMini definitionStatus(String definitionStatus) {
    this.definitionStatus = definitionStatus;
    return this;
  }

   /**
   * Get definitionStatus
   * @return definitionStatus
  **/
  @ApiModelProperty(value = "")
  public String getDefinitionStatus() {
    return definitionStatus;
  }

  public void setDefinitionStatus(String definitionStatus) {
    this.definitionStatus = definitionStatus;
  }

  public ConceptMini effectiveTime(String effectiveTime) {
    this.effectiveTime = effectiveTime;
    return this;
  }

   /**
   * Get effectiveTime
   * @return effectiveTime
  **/
  @ApiModelProperty(value = "")
  public String getEffectiveTime() {
    return effectiveTime;
  }

  public void setEffectiveTime(String effectiveTime) {
    this.effectiveTime = effectiveTime;
  }

  public ConceptMini fsn(TermLangPojo fsn) {
    this.fsn = fsn;
    return this;
  }

   /**
   * Get fsn
   * @return fsn
  **/
  @ApiModelProperty(value = "")
  public TermLangPojo getFsn() {
    return fsn;
  }

  public void setFsn(TermLangPojo fsn) {
    this.fsn = fsn;
  }

  public ConceptMini id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ConceptMini isLeafInferred(Boolean isLeafInferred) {
    this.isLeafInferred = isLeafInferred;
    return this;
  }

   /**
   * Get isLeafInferred
   * @return isLeafInferred
  **/
  @ApiModelProperty(value = "")
  public Boolean isIsLeafInferred() {
    return isLeafInferred;
  }

  public void setIsLeafInferred(Boolean isLeafInferred) {
    this.isLeafInferred = isLeafInferred;
  }

  public ConceptMini isLeafStated(Boolean isLeafStated) {
    this.isLeafStated = isLeafStated;
    return this;
  }

   /**
   * Get isLeafStated
   * @return isLeafStated
  **/
  @ApiModelProperty(value = "")
  public Boolean isIsLeafStated() {
    return isLeafStated;
  }

  public void setIsLeafStated(Boolean isLeafStated) {
    this.isLeafStated = isLeafStated;
  }

  public ConceptMini moduleId(String moduleId) {
    this.moduleId = moduleId;
    return this;
  }

   /**
   * Get moduleId
   * @return moduleId
  **/
  @ApiModelProperty(value = "")
  public String getModuleId() {
    return moduleId;
  }

  public void setModuleId(String moduleId) {
    this.moduleId = moduleId;
  }

  public ConceptMini pt(TermLangPojo pt) {
    this.pt = pt;
    return this;
  }

   /**
   * Get pt
   * @return pt
  **/
  @ApiModelProperty(value = "")
  public TermLangPojo getPt() {
    return pt;
  }

  public void setPt(TermLangPojo pt) {
    this.pt = pt;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConceptMini conceptMini = (ConceptMini) o;
    return Objects.equals(this.active, conceptMini.active) &&
        Objects.equals(this.conceptId, conceptMini.conceptId) &&
        Objects.equals(this.definitionStatus, conceptMini.definitionStatus) &&
        Objects.equals(this.effectiveTime, conceptMini.effectiveTime) &&
        Objects.equals(this.fsn, conceptMini.fsn) &&
        Objects.equals(this.id, conceptMini.id) &&
        Objects.equals(this.isLeafInferred, conceptMini.isLeafInferred) &&
        Objects.equals(this.isLeafStated, conceptMini.isLeafStated) &&
        Objects.equals(this.moduleId, conceptMini.moduleId) &&
        Objects.equals(this.pt, conceptMini.pt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(active, conceptId, definitionStatus, effectiveTime, fsn, id, isLeafInferred, isLeafStated, moduleId, pt);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConceptMini {\n");
    
    sb.append("    active: ").append(toIndentedString(active)).append("\n");
    sb.append("    conceptId: ").append(toIndentedString(conceptId)).append("\n");
    sb.append("    definitionStatus: ").append(toIndentedString(definitionStatus)).append("\n");
    sb.append("    effectiveTime: ").append(toIndentedString(effectiveTime)).append("\n");
    sb.append("    fsn: ").append(toIndentedString(fsn)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    isLeafInferred: ").append(toIndentedString(isLeafInferred)).append("\n");
    sb.append("    isLeafStated: ").append(toIndentedString(isLeafStated)).append("\n");
    sb.append("    moduleId: ").append(toIndentedString(moduleId)).append("\n");
    sb.append("    pt: ").append(toIndentedString(pt)).append("\n");
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
