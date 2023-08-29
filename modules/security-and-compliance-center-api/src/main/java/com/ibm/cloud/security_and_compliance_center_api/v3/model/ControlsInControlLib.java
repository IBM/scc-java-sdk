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
package com.ibm.cloud.security_and_compliance_center_api.v3.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The control details of a control library.
 */
public class ControlsInControlLib extends GenericModel {

  /**
   * The control status.
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
  @SerializedName("control_tags")
  protected List<String> controlTags;
  @SerializedName("control_specifications")
  protected List<ControlSpecifications> controlSpecifications;
  @SerializedName("control_docs")
  protected ControlDocs controlDocs;
  @SerializedName("control_requirement")
  protected Boolean controlRequirement;
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
    private List<String> controlTags;
    private List<ControlSpecifications> controlSpecifications;
    private ControlDocs controlDocs;
    private Boolean controlRequirement;
    private String status;

    /**
     * Instantiates a new Builder from an existing ControlsInControlLib instance.
     *
     * @param controlsInControlLib the instance to initialize the Builder with
     */
    private Builder(ControlsInControlLib controlsInControlLib) {
      this.controlName = controlsInControlLib.controlName;
      this.controlId = controlsInControlLib.controlId;
      this.controlDescription = controlsInControlLib.controlDescription;
      this.controlCategory = controlsInControlLib.controlCategory;
      this.controlParent = controlsInControlLib.controlParent;
      this.controlTags = controlsInControlLib.controlTags;
      this.controlSpecifications = controlsInControlLib.controlSpecifications;
      this.controlDocs = controlsInControlLib.controlDocs;
      this.controlRequirement = controlsInControlLib.controlRequirement;
      this.status = controlsInControlLib.status;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ControlsInControlLib.
     *
     * @return the new ControlsInControlLib instance
     */
    public ControlsInControlLib build() {
      return new ControlsInControlLib(this);
    }

    /**
     * Adds an controlTags to controlTags.
     *
     * @param controlTags the new controlTags
     * @return the ControlsInControlLib builder
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
     * @return the ControlsInControlLib builder
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
     * @return the ControlsInControlLib builder
     */
    public Builder controlName(String controlName) {
      this.controlName = controlName;
      return this;
    }

    /**
     * Set the controlId.
     *
     * @param controlId the controlId
     * @return the ControlsInControlLib builder
     */
    public Builder controlId(String controlId) {
      this.controlId = controlId;
      return this;
    }

    /**
     * Set the controlDescription.
     *
     * @param controlDescription the controlDescription
     * @return the ControlsInControlLib builder
     */
    public Builder controlDescription(String controlDescription) {
      this.controlDescription = controlDescription;
      return this;
    }

    /**
     * Set the controlCategory.
     *
     * @param controlCategory the controlCategory
     * @return the ControlsInControlLib builder
     */
    public Builder controlCategory(String controlCategory) {
      this.controlCategory = controlCategory;
      return this;
    }

    /**
     * Set the controlParent.
     *
     * @param controlParent the controlParent
     * @return the ControlsInControlLib builder
     */
    public Builder controlParent(String controlParent) {
      this.controlParent = controlParent;
      return this;
    }

    /**
     * Set the controlTags.
     * Existing controlTags will be replaced.
     *
     * @param controlTags the controlTags
     * @return the ControlsInControlLib builder
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
     * @return the ControlsInControlLib builder
     */
    public Builder controlSpecifications(List<ControlSpecifications> controlSpecifications) {
      this.controlSpecifications = controlSpecifications;
      return this;
    }

    /**
     * Set the controlDocs.
     *
     * @param controlDocs the controlDocs
     * @return the ControlsInControlLib builder
     */
    public Builder controlDocs(ControlDocs controlDocs) {
      this.controlDocs = controlDocs;
      return this;
    }

    /**
     * Set the controlRequirement.
     *
     * @param controlRequirement the controlRequirement
     * @return the ControlsInControlLib builder
     */
    public Builder controlRequirement(Boolean controlRequirement) {
      this.controlRequirement = controlRequirement;
      return this;
    }

    /**
     * Set the status.
     *
     * @param status the status
     * @return the ControlsInControlLib builder
     */
    public Builder status(String status) {
      this.status = status;
      return this;
    }
  }

  protected ControlsInControlLib() { }

  protected ControlsInControlLib(Builder builder) {
    controlName = builder.controlName;
    controlId = builder.controlId;
    controlDescription = builder.controlDescription;
    controlCategory = builder.controlCategory;
    controlParent = builder.controlParent;
    controlTags = builder.controlTags;
    controlSpecifications = builder.controlSpecifications;
    controlDocs = builder.controlDocs;
    controlRequirement = builder.controlRequirement;
    status = builder.status;
  }

  /**
   * New builder.
   *
   * @return a ControlsInControlLib builder
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
   * The control category.
   *
   * @return the controlCategory
   */
  public String controlCategory() {
    return controlCategory;
  }

  /**
   * Gets the controlParent.
   *
   * The parent control.
   *
   * @return the controlParent
   */
  public String controlParent() {
    return controlParent;
  }

  /**
   * Gets the controlTags.
   *
   * The control tags.
   *
   * @return the controlTags
   */
  public List<String> controlTags() {
    return controlTags;
  }

  /**
   * Gets the controlSpecifications.
   *
   * The control specifications.
   *
   * @return the controlSpecifications
   */
  public List<ControlSpecifications> controlSpecifications() {
    return controlSpecifications;
  }

  /**
   * Gets the controlDocs.
   *
   * The control documentation.
   *
   * @return the controlDocs
   */
  public ControlDocs controlDocs() {
    return controlDocs;
  }

  /**
   * Gets the controlRequirement.
   *
   * Is this a control that can be automated or manually evaluated.
   *
   * @return the controlRequirement
   */
  public Boolean controlRequirement() {
    return controlRequirement;
  }

  /**
   * Gets the status.
   *
   * The control status.
   *
   * @return the status
   */
  public String status() {
    return status;
  }
}

