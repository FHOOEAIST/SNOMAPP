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
import io.swagger.client.model.Axiom;
import io.swagger.client.model.Description;
import io.swagger.client.model.Relationship;
import io.swagger.client.model.TermLangPojo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * ConceptView
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-04-02T10:22:15.067Z")
public class ConceptView {
  @SerializedName("active")
  private Boolean active = null;

  @SerializedName("classAxioms")
  private List<Axiom> classAxioms = null;

  @SerializedName("conceptId")
  private String conceptId = null;

  @SerializedName("definitionStatusId")
  private String definitionStatusId = null;

  @SerializedName("descriptions")
  private List<Description> descriptions = null;

  @SerializedName("effectiveTime")
  private String effectiveTime = null;

  @SerializedName("fsn")
  private TermLangPojo fsn = null;

  @SerializedName("gciAxioms")
  private List<Axiom> gciAxioms = null;

  @SerializedName("moduleId")
  private String moduleId = null;

  @SerializedName("pt")
  private TermLangPojo pt = null;

  @SerializedName("relationships")
  private List<Relationship> relationships = null;

  public ConceptView active(Boolean active) {
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

  public ConceptView classAxioms(List<Axiom> classAxioms) {
    this.classAxioms = classAxioms;
    return this;
  }

  public ConceptView addClassAxiomsItem(Axiom classAxiomsItem) {
    if (this.classAxioms == null) {
      this.classAxioms = new ArrayList<Axiom>();
    }
    this.classAxioms.add(classAxiomsItem);
    return this;
  }

   /**
   * Get classAxioms
   * @return classAxioms
  **/
  @ApiModelProperty(value = "")
  public List<Axiom> getClassAxioms() {
    return classAxioms;
  }

  public void setClassAxioms(List<Axiom> classAxioms) {
    this.classAxioms = classAxioms;
  }

  public ConceptView conceptId(String conceptId) {
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

  public ConceptView definitionStatusId(String definitionStatusId) {
    this.definitionStatusId = definitionStatusId;
    return this;
  }

   /**
   * Get definitionStatusId
   * @return definitionStatusId
  **/
  @ApiModelProperty(value = "")
  public String getDefinitionStatusId() {
    return definitionStatusId;
  }

  public void setDefinitionStatusId(String definitionStatusId) {
    this.definitionStatusId = definitionStatusId;
  }

  public ConceptView descriptions(List<Description> descriptions) {
    this.descriptions = descriptions;
    return this;
  }

  public ConceptView addDescriptionsItem(Description descriptionsItem) {
    if (this.descriptions == null) {
      this.descriptions = new ArrayList<Description>();
    }
    this.descriptions.add(descriptionsItem);
    return this;
  }

   /**
   * Get descriptions
   * @return descriptions
  **/
  @ApiModelProperty(value = "")
  public List<Description> getDescriptions() {
    return descriptions;
  }

  public void setDescriptions(List<Description> descriptions) {
    this.descriptions = descriptions;
  }

  public ConceptView effectiveTime(String effectiveTime) {
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

  public ConceptView fsn(TermLangPojo fsn) {
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

  public ConceptView gciAxioms(List<Axiom> gciAxioms) {
    this.gciAxioms = gciAxioms;
    return this;
  }

  public ConceptView addGciAxiomsItem(Axiom gciAxiomsItem) {
    if (this.gciAxioms == null) {
      this.gciAxioms = new ArrayList<Axiom>();
    }
    this.gciAxioms.add(gciAxiomsItem);
    return this;
  }

   /**
   * Get gciAxioms
   * @return gciAxioms
  **/
  @ApiModelProperty(value = "")
  public List<Axiom> getGciAxioms() {
    return gciAxioms;
  }

  public void setGciAxioms(List<Axiom> gciAxioms) {
    this.gciAxioms = gciAxioms;
  }

  public ConceptView moduleId(String moduleId) {
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

  public ConceptView pt(TermLangPojo pt) {
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

  public ConceptView relationships(List<Relationship> relationships) {
    this.relationships = relationships;
    return this;
  }

  public ConceptView addRelationshipsItem(Relationship relationshipsItem) {
    if (this.relationships == null) {
      this.relationships = new ArrayList<Relationship>();
    }
    this.relationships.add(relationshipsItem);
    return this;
  }

   /**
   * Get relationships
   * @return relationships
  **/
  @ApiModelProperty(value = "")
  public List<Relationship> getRelationships() {
    return relationships;
  }

  public void setRelationships(List<Relationship> relationships) {
    this.relationships = relationships;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConceptView conceptView = (ConceptView) o;
    return Objects.equals(this.active, conceptView.active) &&
        Objects.equals(this.classAxioms, conceptView.classAxioms) &&
        Objects.equals(this.conceptId, conceptView.conceptId) &&
        Objects.equals(this.definitionStatusId, conceptView.definitionStatusId) &&
        Objects.equals(this.descriptions, conceptView.descriptions) &&
        Objects.equals(this.effectiveTime, conceptView.effectiveTime) &&
        Objects.equals(this.fsn, conceptView.fsn) &&
        Objects.equals(this.gciAxioms, conceptView.gciAxioms) &&
        Objects.equals(this.moduleId, conceptView.moduleId) &&
        Objects.equals(this.pt, conceptView.pt) &&
        Objects.equals(this.relationships, conceptView.relationships);
  }

  @Override
  public int hashCode() {
    return Objects.hash(active, classAxioms, conceptId, definitionStatusId, descriptions, effectiveTime, fsn, gciAxioms, moduleId, pt, relationships);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConceptView {\n");
    
    sb.append("    active: ").append(toIndentedString(active)).append("\n");
    sb.append("    classAxioms: ").append(toIndentedString(classAxioms)).append("\n");
    sb.append("    conceptId: ").append(toIndentedString(conceptId)).append("\n");
    sb.append("    definitionStatusId: ").append(toIndentedString(definitionStatusId)).append("\n");
    sb.append("    descriptions: ").append(toIndentedString(descriptions)).append("\n");
    sb.append("    effectiveTime: ").append(toIndentedString(effectiveTime)).append("\n");
    sb.append("    fsn: ").append(toIndentedString(fsn)).append("\n");
    sb.append("    gciAxioms: ").append(toIndentedString(gciAxioms)).append("\n");
    sb.append("    moduleId: ").append(toIndentedString(moduleId)).append("\n");
    sb.append("    pt: ").append(toIndentedString(pt)).append("\n");
    sb.append("    relationships: ").append(toIndentedString(relationships)).append("\n");
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
