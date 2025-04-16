/*
 * (C) Copyright IBM Corp. 2025.
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
 * The control details for a profile.
 */
public class ProfileControls extends GenericModel {

  @SerializedName("control_requirement")
  protected Boolean controlRequirement;
  @SerializedName("control_library_id")
  protected String controlLibraryId;
  @SerializedName("control_id")
  protected String controlId;
  @SerializedName("control_library_version")
  protected String controlLibraryVersion;
  @SerializedName("control_name")
  protected String controlName;
  @SerializedName("control_description")
  protected String controlDescription;
  @SerializedName("control_severity")
  protected String controlSeverity;
  @SerializedName("control_category")
  protected String controlCategory;
  @SerializedName("control_parent")
  protected String controlParent;
  @SerializedName("control_docs")
  protected ControlDoc controlDocs;
  @SerializedName("control_specifications")
  protected List<ControlSpecification> controlSpecifications;

  /**
   * Builder.
   */
  public static class Builder {
    private Boolean controlRequirement;
    private String controlLibraryId;
    private String controlId;
    private String controlLibraryVersion;
    private String controlName;
    private String controlDescription;
    private String controlSeverity;
    private String controlCategory;
    private String controlParent;
    private ControlDoc controlDocs;
    private List<ControlSpecification> controlSpecifications;

    /**
     * Instantiates a new Builder from an existing ProfileControls instance.
     *
     * @param profileControls the instance to initialize the Builder with
     */
    private Builder(ProfileControls profileControls) {
      this.controlRequirement = profileControls.controlRequirement;
      this.controlLibraryId = profileControls.controlLibraryId;
      this.controlId = profileControls.controlId;
      this.controlLibraryVersion = profileControls.controlLibraryVersion;
      this.controlName = profileControls.controlName;
      this.controlDescription = profileControls.controlDescription;
      this.controlSeverity = profileControls.controlSeverity;
      this.controlCategory = profileControls.controlCategory;
      this.controlParent = profileControls.controlParent;
      this.controlDocs = profileControls.controlDocs;
      this.controlSpecifications = profileControls.controlSpecifications;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param controlSpecifications the controlSpecifications
     */
    public Builder(List<ControlSpecification> controlSpecifications) {
      this.controlSpecifications = controlSpecifications;
    }

    /**
     * Builds a ProfileControls.
     *
     * @return the new ProfileControls instance
     */
    public ProfileControls build() {
      return new ProfileControls(this);
    }

    /**
     * Adds a new element to controlSpecifications.
     *
     * @param controlSpecifications the new element to be added
     * @return the ProfileControls builder
     */
    public Builder addControlSpecifications(ControlSpecification controlSpecifications) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(controlSpecifications,
        "controlSpecifications cannot be null");
      if (this.controlSpecifications == null) {
        this.controlSpecifications = new ArrayList<ControlSpecification>();
      }
      this.controlSpecifications.add(controlSpecifications);
      return this;
    }

    /**
     * Set the controlRequirement.
     *
     * @param controlRequirement the controlRequirement
     * @return the ProfileControls builder
     */
    public Builder controlRequirement(Boolean controlRequirement) {
      this.controlRequirement = controlRequirement;
      return this;
    }

    /**
     * Set the controlLibraryId.
     *
     * @param controlLibraryId the controlLibraryId
     * @return the ProfileControls builder
     */
    public Builder controlLibraryId(String controlLibraryId) {
      this.controlLibraryId = controlLibraryId;
      return this;
    }

    /**
     * Set the controlId.
     *
     * @param controlId the controlId
     * @return the ProfileControls builder
     */
    public Builder controlId(String controlId) {
      this.controlId = controlId;
      return this;
    }

    /**
     * Set the controlLibraryVersion.
     *
     * @param controlLibraryVersion the controlLibraryVersion
     * @return the ProfileControls builder
     */
    public Builder controlLibraryVersion(String controlLibraryVersion) {
      this.controlLibraryVersion = controlLibraryVersion;
      return this;
    }

    /**
     * Set the controlName.
     *
     * @param controlName the controlName
     * @return the ProfileControls builder
     */
    public Builder controlName(String controlName) {
      this.controlName = controlName;
      return this;
    }

    /**
     * Set the controlDescription.
     *
     * @param controlDescription the controlDescription
     * @return the ProfileControls builder
     */
    public Builder controlDescription(String controlDescription) {
      this.controlDescription = controlDescription;
      return this;
    }

    /**
     * Set the controlSeverity.
     *
     * @param controlSeverity the controlSeverity
     * @return the ProfileControls builder
     */
    public Builder controlSeverity(String controlSeverity) {
      this.controlSeverity = controlSeverity;
      return this;
    }

    /**
     * Set the controlCategory.
     *
     * @param controlCategory the controlCategory
     * @return the ProfileControls builder
     */
    public Builder controlCategory(String controlCategory) {
      this.controlCategory = controlCategory;
      return this;
    }

    /**
     * Set the controlParent.
     *
     * @param controlParent the controlParent
     * @return the ProfileControls builder
     */
    public Builder controlParent(String controlParent) {
      this.controlParent = controlParent;
      return this;
    }

    /**
     * Set the controlDocs.
     *
     * @param controlDocs the controlDocs
     * @return the ProfileControls builder
     */
    public Builder controlDocs(ControlDoc controlDocs) {
      this.controlDocs = controlDocs;
      return this;
    }

    /**
     * Set the controlSpecifications.
     * Existing controlSpecifications will be replaced.
     *
     * @param controlSpecifications the controlSpecifications
     * @return the ProfileControls builder
     */
    public Builder controlSpecifications(List<ControlSpecification> controlSpecifications) {
      this.controlSpecifications = controlSpecifications;
      return this;
    }
  }

  protected ProfileControls() { }

  protected ProfileControls(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.controlSpecifications,
      "controlSpecifications cannot be null");
    controlRequirement = builder.controlRequirement;
    controlLibraryId = builder.controlLibraryId;
    controlId = builder.controlId;
    controlLibraryVersion = builder.controlLibraryVersion;
    controlName = builder.controlName;
    controlDescription = builder.controlDescription;
    controlSeverity = builder.controlSeverity;
    controlCategory = builder.controlCategory;
    controlParent = builder.controlParent;
    controlDocs = builder.controlDocs;
    controlSpecifications = builder.controlSpecifications;
  }

  /**
   * New builder.
   *
   * @return a ProfileControls builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the controlRequirement.
   *
   * Determines if the control needs to pass during evaluation.
   *
   * @return the controlRequirement
   */
  public Boolean controlRequirement() {
    return controlRequirement;
  }

  /**
   * Gets the controlLibraryId.
   *
   * The ID of the control library that contains a profile.
   *
   * @return the controlLibraryId
   */
  public String controlLibraryId() {
    return controlLibraryId;
  }

  /**
   * Gets the controlId.
   *
   * The control ID.
   *
   * @return the controlId
   */
  public String controlId() {
    return controlId;
  }

  /**
   * Gets the controlLibraryVersion.
   *
   * The control library version.
   *
   * @return the controlLibraryVersion
   */
  public String controlLibraryVersion() {
    return controlLibraryVersion;
  }

  /**
   * Gets the controlName.
   *
   * The control name.
   *
   * @return the controlName
   */
  public String controlName() {
    return controlName;
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
   * Gets the controlSeverity.
   *
   * The control severity.
   *
   * @return the controlSeverity
   */
  public String controlSeverity() {
    return controlSeverity;
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
   * The control parent.
   *
   * @return the controlParent
   */
  public String controlParent() {
    return controlParent;
  }

  /**
   * Gets the controlDocs.
   *
   * References to a control documentation.
   *
   * @return the controlDocs
   */
  public ControlDoc controlDocs() {
    return controlDocs;
  }

  /**
   * Gets the controlSpecifications.
   *
   * List of control specifications in a profile.
   *
   * @return the controlSpecifications
   */
  public List<ControlSpecification> controlSpecifications() {
    return controlSpecifications;
  }
}

