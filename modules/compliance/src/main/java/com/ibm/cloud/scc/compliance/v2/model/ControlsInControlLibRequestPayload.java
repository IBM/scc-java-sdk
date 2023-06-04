/*
 * (C) Copyright IBM Corp. 2023.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.ibm.cloud.scc.compliance.v2.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The control details of a control library.
 */
public class ControlsInControlLibRequestPayload extends GenericModel {

  /**
   * Status.
   */
  public interface Status {
    /** enabled. */
    String ENABLED = "enabled";
    /** disabled. */
    String DISABLED = "disabled";
  }

  @SerializedName("control_name")
  protected String controlName;
  @SerializedName("control_id")
  protected String controlId;
  @SerializedName("control_description")
  protected String controlDescription;
  @SerializedName("control_category")
  protected String controlCategory;
  @SerializedName("control_parent")
  protected String controlParent;
  @SerializedName("control_severity")
  protected String controlSeverity;
  @SerializedName("control_tags")
  protected List<String> controlTags;
  @SerializedName("control_specifications")
  protected List<ControlSpecifications> controlSpecifications;
  @SerializedName("control_docs")
  protected ControlDocs controlDocs;
  protected String status;

  /**
   * Builder.
   */
  public static class Builder {
    private String controlName;
    private String controlId;
    private String controlDescription;
    private String controlCategory;
    private String controlParent;
    private String controlSeverity;
    private List<String> controlTags;
    private List<ControlSpecifications> controlSpecifications;
    private ControlDocs controlDocs;
    private String status;

    /**
     * Instantiates a new Builder from an existing ControlsInControlLibRequestPayload instance.
     *
     * @param controlsInControlLibRequestPayload the instance to initialize the Builder with
     */
    private Builder(ControlsInControlLibRequestPayload controlsInControlLibRequestPayload) {
      this.controlName = controlsInControlLibRequestPayload.controlName;
      this.controlId = controlsInControlLibRequestPayload.controlId;
      this.controlDescription = controlsInControlLibRequestPayload.controlDescription;
      this.controlCategory = controlsInControlLibRequestPayload.controlCategory;
      this.controlParent = controlsInControlLibRequestPayload.controlParent;
      this.controlSeverity = controlsInControlLibRequestPayload.controlSeverity;
      this.controlTags = controlsInControlLibRequestPayload.controlTags;
      this.controlSpecifications = controlsInControlLibRequestPayload.controlSpecifications;
      this.controlDocs = controlsInControlLibRequestPayload.controlDocs;
      this.status = controlsInControlLibRequestPayload.status;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ControlsInControlLibRequestPayload.
     *
     * @return the new ControlsInControlLibRequestPayload instance
     */
    public ControlsInControlLibRequestPayload build() {
      return new ControlsInControlLibRequestPayload(this);
    }

    /**
     * Adds an controlTags to controlTags.
     *
     * @param controlTags the new controlTags
     * @return the ControlsInControlLibRequestPayload builder
     */
    public Builder addControlTags(String controlTags) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(controlTags,
        "controlTags cannot be null");
      if (this.controlTags == null) {
        this.controlTags = new ArrayList<String>();
      }
      this.controlTags.add(controlTags);
      return this;
    }

    /**
     * Adds an controlSpecifications to controlSpecifications.
     *
     * @param controlSpecifications the new controlSpecifications
     * @return the ControlsInControlLibRequestPayload builder
     */
    public Builder addControlSpecifications(ControlSpecifications controlSpecifications) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(controlSpecifications,
        "controlSpecifications cannot be null");
      if (this.controlSpecifications == null) {
        this.controlSpecifications = new ArrayList<ControlSpecifications>();
      }
      this.controlSpecifications.add(controlSpecifications);
      return this;
    }

    /**
     * Set the controlName.
     *
     * @param controlName the controlName
     * @return the ControlsInControlLibRequestPayload builder
     */
    public Builder controlName(String controlName) {
      this.controlName = controlName;
      return this;
    }

    /**
     * Set the controlId.
     *
     * @param controlId the controlId
     * @return the ControlsInControlLibRequestPayload builder
     */
    public Builder controlId(String controlId) {
      this.controlId = controlId;
      return this;
    }

    /**
     * Set the controlDescription.
     *
     * @param controlDescription the controlDescription
     * @return the ControlsInControlLibRequestPayload builder
     */
    public Builder controlDescription(String controlDescription) {
      this.controlDescription = controlDescription;
      return this;
    }

    /**
     * Set the controlCategory.
     *
     * @param controlCategory the controlCategory
     * @return the ControlsInControlLibRequestPayload builder
     */
    public Builder controlCategory(String controlCategory) {
      this.controlCategory = controlCategory;
      return this;
    }

    /**
     * Set the controlParent.
     *
     * @param controlParent the controlParent
     * @return the ControlsInControlLibRequestPayload builder
     */
    public Builder controlParent(String controlParent) {
      this.controlParent = controlParent;
      return this;
    }

    /**
     * Set the controlSeverity.
     *
     * @param controlSeverity the controlSeverity
     * @return the ControlsInControlLibRequestPayload builder
     */
    public Builder controlSeverity(String controlSeverity) {
      this.controlSeverity = controlSeverity;
      return this;
    }

    /**
     * Set the controlTags.
     * Existing controlTags will be replaced.
     *
     * @param controlTags the controlTags
     * @return the ControlsInControlLibRequestPayload builder
     */
    public Builder controlTags(List<String> controlTags) {
      this.controlTags = controlTags;
      return this;
    }

    /**
     * Set the controlSpecifications.
     * Existing controlSpecifications will be replaced.
     *
     * @param controlSpecifications the controlSpecifications
     * @return the ControlsInControlLibRequestPayload builder
     */
    public Builder controlSpecifications(List<ControlSpecifications> controlSpecifications) {
      this.controlSpecifications = controlSpecifications;
      return this;
    }

    /**
     * Set the controlDocs.
     *
     * @param controlDocs the controlDocs
     * @return the ControlsInControlLibRequestPayload builder
     */
    public Builder controlDocs(ControlDocs controlDocs) {
      this.controlDocs = controlDocs;
      return this;
    }

    /**
     * Set the status.
     *
     * @param status the status
     * @return the ControlsInControlLibRequestPayload builder
     */
    public Builder status(String status) {
      this.status = status;
      return this;
    }
  }

  protected ControlsInControlLibRequestPayload() { }

  protected ControlsInControlLibRequestPayload(Builder builder) {
    controlName = builder.controlName;
    controlId = builder.controlId;
    controlDescription = builder.controlDescription;
    controlCategory = builder.controlCategory;
    controlParent = builder.controlParent;
    controlSeverity = builder.controlSeverity;
    controlTags = builder.controlTags;
    controlSpecifications = builder.controlSpecifications;
    controlDocs = builder.controlDocs;
    status = builder.status;
  }

  /**
   * New builder.
   *
   * @return a ControlsInControlLibRequestPayload builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the controlName.
   *
   * The ID of the control library that contains the profile.
   *
   * @return the controlName
   */
  public String controlName() {
    return controlName;
  }

  /**
   * Gets the controlId.
   *
   * The control name.
   *
   * @return the controlId
   */
  public String controlId() {
    return controlId;
  }

  /**
   * Gets the controlDescription.
   *
   * The control description.
   *
   * @return the controlDescription
   */
  public String controlDescription() {
    return controlDescription;
  }

  /**
   * Gets the controlCategory.
   *
   * control category.
   *
   * @return the controlCategory
   */
  public String controlCategory() {
    return controlCategory;
  }

  /**
   * Gets the controlParent.
   *
   * control parent.
   *
   * @return the controlParent
   */
  public String controlParent() {
    return controlParent;
  }

  /**
   * Gets the controlSeverity.
   *
   * Control severity.
   *
   * @return the controlSeverity
   */
  public String controlSeverity() {
    return controlSeverity;
  }

  /**
   * Gets the controlTags.
   *
   * Control Tags.
   *
   * @return the controlTags
   */
  public List<String> controlTags() {
    return controlTags;
  }

  /**
   * Gets the controlSpecifications.
   *
   * control specifications.
   *
   * @return the controlSpecifications
   */
  public List<ControlSpecifications> controlSpecifications() {
    return controlSpecifications;
  }

  /**
   * Gets the controlDocs.
   *
   * Control Docs.
   *
   * @return the controlDocs
   */
  public ControlDocs controlDocs() {
    return controlDocs;
  }

  /**
   * Gets the status.
   *
   * Status.
   *
   * @return the status
   */
  public String status() {
    return status;
  }
}

