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
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.threeten.bp.OffsetDateTime;

/**
 * AsyncConceptChangeBatch
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-04-02T10:22:15.067Z")
public class AsyncConceptChangeBatch {
  @SerializedName("conceptIds")
  private List<Long> conceptIds = null;

  @SerializedName("endTime")
  private OffsetDateTime endTime = null;

  @SerializedName("id")
  private String id = null;

  @SerializedName("message")
  private String message = null;

  @SerializedName("secondsDuration")
  private Float secondsDuration = null;

  @SerializedName("startTime")
  private OffsetDateTime startTime = null;

  /**
   * Gets or Sets status
   */
  @JsonAdapter(StatusEnum.Adapter.class)
  public enum StatusEnum {
    RUNNING("RUNNING"),
    
    COMPLETED("COMPLETED"),
    
    FAILED("FAILED");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static StatusEnum fromValue(String text) {
      for (StatusEnum b : StatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<StatusEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final StatusEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public StatusEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return StatusEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("status")
  private StatusEnum status = null;

  public AsyncConceptChangeBatch conceptIds(List<Long> conceptIds) {
    this.conceptIds = conceptIds;
    return this;
  }

  public AsyncConceptChangeBatch addConceptIdsItem(Long conceptIdsItem) {
    if (this.conceptIds == null) {
      this.conceptIds = new ArrayList<Long>();
    }
    this.conceptIds.add(conceptIdsItem);
    return this;
  }

   /**
   * Get conceptIds
   * @return conceptIds
  **/
  @ApiModelProperty(value = "")
  public List<Long> getConceptIds() {
    return conceptIds;
  }

  public void setConceptIds(List<Long> conceptIds) {
    this.conceptIds = conceptIds;
  }

  public AsyncConceptChangeBatch endTime(OffsetDateTime endTime) {
    this.endTime = endTime;
    return this;
  }

   /**
   * Get endTime
   * @return endTime
  **/
  @ApiModelProperty(value = "")
  public OffsetDateTime getEndTime() {
    return endTime;
  }

  public void setEndTime(OffsetDateTime endTime) {
    this.endTime = endTime;
  }

  public AsyncConceptChangeBatch id(String id) {
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

  public AsyncConceptChangeBatch message(String message) {
    this.message = message;
    return this;
  }

   /**
   * Get message
   * @return message
  **/
  @ApiModelProperty(value = "")
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public AsyncConceptChangeBatch secondsDuration(Float secondsDuration) {
    this.secondsDuration = secondsDuration;
    return this;
  }

   /**
   * Get secondsDuration
   * @return secondsDuration
  **/
  @ApiModelProperty(value = "")
  public Float getSecondsDuration() {
    return secondsDuration;
  }

  public void setSecondsDuration(Float secondsDuration) {
    this.secondsDuration = secondsDuration;
  }

  public AsyncConceptChangeBatch startTime(OffsetDateTime startTime) {
    this.startTime = startTime;
    return this;
  }

   /**
   * Get startTime
   * @return startTime
  **/
  @ApiModelProperty(value = "")
  public OffsetDateTime getStartTime() {
    return startTime;
  }

  public void setStartTime(OffsetDateTime startTime) {
    this.startTime = startTime;
  }

  public AsyncConceptChangeBatch status(StatusEnum status) {
    this.status = status;
    return this;
  }

   /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(value = "")
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AsyncConceptChangeBatch asyncConceptChangeBatch = (AsyncConceptChangeBatch) o;
    return Objects.equals(this.conceptIds, asyncConceptChangeBatch.conceptIds) &&
        Objects.equals(this.endTime, asyncConceptChangeBatch.endTime) &&
        Objects.equals(this.id, asyncConceptChangeBatch.id) &&
        Objects.equals(this.message, asyncConceptChangeBatch.message) &&
        Objects.equals(this.secondsDuration, asyncConceptChangeBatch.secondsDuration) &&
        Objects.equals(this.startTime, asyncConceptChangeBatch.startTime) &&
        Objects.equals(this.status, asyncConceptChangeBatch.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(conceptIds, endTime, id, message, secondsDuration, startTime, status);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AsyncConceptChangeBatch {\n");
    
    sb.append("    conceptIds: ").append(toIndentedString(conceptIds)).append("\n");
    sb.append("    endTime: ").append(toIndentedString(endTime)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    secondsDuration: ").append(toIndentedString(secondsDuration)).append("\n");
    sb.append("    startTime: ").append(toIndentedString(startTime)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

