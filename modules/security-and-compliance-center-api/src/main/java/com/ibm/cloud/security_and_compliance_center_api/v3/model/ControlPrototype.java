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
 * The payload to instantiate a control.
 */
public class ControlPrototype extends GenericModel {

  @SerializedName("control_name")
  protected String controlName;
  @SerializedName("control_description")
  protected String controlDescription;
  @SerializedName("control_category")
  protected String controlCategory;
  @SerializedName("control_requirement")
  protected Boolean controlRequirement;
  @SerializedName("control_parent")
  protected String controlParent;
  @SerializedName("control_specifications")
  protected List<ControlSpecificationPrototype> controlSpecifications;
  @SerializedName("control_docs")
  protected ControlDoc controlDocs;
  protected String status;

  /**
   * Builder.
   */
  public static class Builder {
    private String controlName;
    private String controlDescription;
    private String controlCategory;
    private Boolean controlRequirement;
    private String controlParent;
    private List<ControlSpecificationPrototype> controlSpecifications;
    private ControlDoc controlDocs;
    private String status;

    /**
     * Instantiates a new Builder from an existing ControlPrototype instance.
     *
     * @param controlPrototype the instance to initialize the Builder with
     */
    private Builder(ControlPrototype controlPrototype) {
      this.controlName = controlPrototype.controlName;
      this.controlDescription = controlPrototype.controlDescription;
      this.controlCategory = controlPrototype.controlCategory;
      this.controlRequirement = controlPrototype.controlRequirement;
      this.controlParent = controlPrototype.controlParent;
      this.controlSpecifications = controlPrototype.controlSpecifications;
      this.controlDocs = controlPrototype.controlDocs;
      this.status = controlPrototype.status;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param controlName the controlName
     * @param controlDescription the controlDescription
     * @param controlCategory the controlCategory
     * @param controlRequirement the controlRequirement
     * @param controlSpecifications the controlSpecifications
     */
    public Builder(String controlName, String controlDescription, String controlCategory, Boolean controlRequirement, List<ControlSpecificationPrototype> controlSpecifications) {
      this.controlName = controlName;
      this.controlDescription = controlDescription;
      this.controlCategory = controlCategory;
      this.controlRequirement = controlRequirement;
      this.controlSpecifications = controlSpecifications;
    }

    /**
     * Builds a ControlPrototype.
     *
     * @return the new ControlPrototype instance
     */
    public ControlPrototype build() {
      return new ControlPrototype(this);
    }

    /**
     * Adds a new element to controlSpecifications.
     *
     * @param controlSpecifications the new element to be added
     * @return the ControlPrototype builder
     */
    public Builder addControlSpecifications(ControlSpecificationPrototype controlSpecifications) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(controlSpecifications,
        "controlSpecifications cannot be null");
      if (this.controlSpecifications == null) {
        this.controlSpecifications = new ArrayList<ControlSpecificationPrototype>();
      }
      this.controlSpecifications.add(controlSpecifications);
      return this;
    }

    /**
     * Set the controlName.
     *
     * @param controlName the controlName
     * @return the ControlPrototype builder
     */
    public Builder controlName(String controlName) {
      this.controlName = controlName;
      return this;
    }

    /**
     * Set the controlDescription.
     *
     * @param controlDescription the controlDescription
     * @return the ControlPrototype builder
     */
    public Builder controlDescription(String controlDescription) {
      this.controlDescription = controlDescription;
      return this;
    }

    /**
     * Set the controlCategory.
     *
     * @param controlCategory the controlCategory
     * @return the ControlPrototype builder
     */
    public Builder controlCategory(String controlCategory) {
      this.controlCategory = controlCategory;
      return this;
    }

    /**
     * Set the controlRequirement.
     *
     * @param controlRequirement the controlRequirement
     * @return the ControlPrototype builder
     */
    public Builder controlRequirement(Boolean controlRequirement) {
      this.controlRequirement = controlRequirement;
      return this;
    }

    /**
     * Set the controlParent.
     *
     * @param controlParent the controlParent
     * @return the ControlPrototype builder
     */
    public Builder controlParent(String controlParent) {
      this.controlParent = controlParent;
      return this;
    }

    /**
     * Set the controlSpecifications.
     * Existing controlSpecifications will be replaced.
     *
     * @param controlSpecifications the controlSpecifications
     * @return the ControlPrototype builder
     */
    public Builder controlSpecifications(List<ControlSpecificationPrototype> controlSpecifications) {
      this.controlSpecifications = controlSpecifications;
      return this;
    }

    /**
     * Set the controlDocs.
     *
     * @param controlDocs the controlDocs
     * @return the ControlPrototype builder
     */
    public Builder controlDocs(ControlDoc controlDocs) {
      this.controlDocs = controlDocs;
      return this;
    }

    /**
     * Set the status.
     *
     * @param status the status
     * @return the ControlPrototype builder
     */
    public Builder status(String status) {
      this.status = status;
      return this;
    }
  }

  protected ControlPrototype() { }

  protected ControlPrototype(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.controlName,
      "controlName cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.controlDescription,
      "controlDescription cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.controlCategory,
      "controlCategory cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.controlRequirement,
      "controlRequirement cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.controlSpecifications,
      "controlSpecifications cannot be null");
    controlName = builder.controlName;
    controlDescription = builder.controlDescription;
    controlCategory = builder.controlCategory;
    controlRequirement = builder.controlRequirement;
    controlParent = builder.controlParent;
    controlSpecifications = builder.controlSpecifications;
    controlDocs = builder.controlDocs;
    status = builder.status;
  }

  /**
   * New builder.
   *
   * @return a ControlPrototype builder
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
   * The association of the control.
   *
   * @return the controlCategory
   */
  public String controlCategory() {
    return controlCategory;
  }

  /**
   * Gets the controlRequirement.
   *
   * true if the control can be automated, false if the control cannot.
   *
   * @return the controlRequirement
   */
  public Boolean controlRequirement() {
    return controlRequirement;
  }

  /**
   * Gets the controlParent.
   *
   * The ID of the parent control.
   *
   * @return the controlParent
   */
  public String controlParent() {
    return controlParent;
  }

  /**
   * Gets the controlSpecifications.
   *
   * List of control specifications associated with the control.
   *
   * @return the controlSpecifications
   */
  public List<ControlSpecificationPrototype> controlSpecifications() {
    return controlSpecifications;
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
   * Gets the status.
   *
   * Details if a control library can be used or not.
   *
   * @return the status
   */
  public String status() {
    return status;
  }
}

