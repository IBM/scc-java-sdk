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
 * The control specifications of a control library.
 */
public class ControlSpecifications extends GenericModel {

  /**
   * The responsibility for managing the control.
   */
  public interface Responsibility {
    /** user. */
    String USER = "user";
  }

  @SerializedName("control_specification_id")
  protected String controlSpecificationId;
  protected String responsibility;
  @SerializedName("component_id")
  protected String componentId;
  @SerializedName("component_name")
  protected String componentName;
  protected String environment;
  @SerializedName("control_specification_description")
  protected String controlSpecificationDescription;
  @SerializedName("assessments_count")
  protected Long assessmentsCount;
  protected List<Implementation> assessments;

  /**
   * Builder.
   */
  public static class Builder {
    private String controlSpecificationId;
    private String responsibility;
    private String componentId;
    private String componentName;
    private String environment;
    private String controlSpecificationDescription;
    private Long assessmentsCount;
    private List<Implementation> assessments;

    /**
     * Instantiates a new Builder from an existing ControlSpecifications instance.
     *
     * @param controlSpecifications the instance to initialize the Builder with
     */
    private Builder(ControlSpecifications controlSpecifications) {
      this.controlSpecificationId = controlSpecifications.controlSpecificationId;
      this.responsibility = controlSpecifications.responsibility;
      this.componentId = controlSpecifications.componentId;
      this.componentName = controlSpecifications.componentName;
      this.environment = controlSpecifications.environment;
      this.controlSpecificationDescription = controlSpecifications.controlSpecificationDescription;
      this.assessmentsCount = controlSpecifications.assessmentsCount;
      this.assessments = controlSpecifications.assessments;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ControlSpecifications.
     *
     * @return the new ControlSpecifications instance
     */
    public ControlSpecifications build() {
      return new ControlSpecifications(this);
    }

    /**
     * Adds an assessments to assessments.
     *
     * @param assessments the new assessments
     * @return the ControlSpecifications builder
     */
    public Builder addAssessments(Implementation assessments) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(assessments,
        "assessments cannot be null");
      if (this.assessments == null) {
        this.assessments = new ArrayList<Implementation>();
      }
      this.assessments.add(assessments);
      return this;
    }

    /**
     * Set the controlSpecificationId.
     *
     * @param controlSpecificationId the controlSpecificationId
     * @return the ControlSpecifications builder
     */
    public Builder controlSpecificationId(String controlSpecificationId) {
      this.controlSpecificationId = controlSpecificationId;
      return this;
    }

    /**
     * Set the responsibility.
     *
     * @param responsibility the responsibility
     * @return the ControlSpecifications builder
     */
    public Builder responsibility(String responsibility) {
      this.responsibility = responsibility;
      return this;
    }

    /**
     * Set the componentId.
     *
     * @param componentId the componentId
     * @return the ControlSpecifications builder
     */
    public Builder componentId(String componentId) {
      this.componentId = componentId;
      return this;
    }

    /**
     * Set the componentName.
     *
     * @param componentName the componentName
     * @return the ControlSpecifications builder
     */
    public Builder componentName(String componentName) {
      this.componentName = componentName;
      return this;
    }

    /**
     * Set the environment.
     *
     * @param environment the environment
     * @return the ControlSpecifications builder
     */
    public Builder environment(String environment) {
      this.environment = environment;
      return this;
    }

    /**
     * Set the controlSpecificationDescription.
     *
     * @param controlSpecificationDescription the controlSpecificationDescription
     * @return the ControlSpecifications builder
     */
    public Builder controlSpecificationDescription(String controlSpecificationDescription) {
      this.controlSpecificationDescription = controlSpecificationDescription;
      return this;
    }

    /**
     * Set the assessmentsCount.
     *
     * @param assessmentsCount the assessmentsCount
     * @return the ControlSpecifications builder
     */
    public Builder assessmentsCount(long assessmentsCount) {
      this.assessmentsCount = assessmentsCount;
      return this;
    }

    /**
     * Set the assessments.
     * Existing assessments will be replaced.
     *
     * @param assessments the assessments
     * @return the ControlSpecifications builder
     */
    public Builder assessments(List<Implementation> assessments) {
      this.assessments = assessments;
      return this;
    }
  }

  protected ControlSpecifications() { }

  protected ControlSpecifications(Builder builder) {
    controlSpecificationId = builder.controlSpecificationId;
    responsibility = builder.responsibility;
    componentId = builder.componentId;
    componentName = builder.componentName;
    environment = builder.environment;
    controlSpecificationDescription = builder.controlSpecificationDescription;
    assessmentsCount = builder.assessmentsCount;
    assessments = builder.assessments;
  }

  /**
   * New builder.
   *
   * @return a ControlSpecifications builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the controlSpecificationId.
   *
   * The control specification ID.
   *
   * @return the controlSpecificationId
   */
  public String controlSpecificationId() {
    return controlSpecificationId;
  }

  /**
   * Gets the responsibility.
   *
   * The responsibility for managing the control.
   *
   * @return the responsibility
   */
  public String responsibility() {
    return responsibility;
  }

  /**
   * Gets the componentId.
   *
   * The component ID.
   *
   * @return the componentId
   */
  public String componentId() {
    return componentId;
  }

  /**
   * Gets the componentName.
   *
   * The component name.
   *
   * @return the componentName
   */
  public String componentName() {
    return componentName;
  }

  /**
   * Gets the environment.
   *
   * The control specifications environment.
   *
   * @return the environment
   */
  public String environment() {
    return environment;
  }

  /**
   * Gets the controlSpecificationDescription.
   *
   * The control specifications description.
   *
   * @return the controlSpecificationDescription
   */
  public String controlSpecificationDescription() {
    return controlSpecificationDescription;
  }

  /**
   * Gets the assessmentsCount.
   *
   * The number of assessments.
   *
   * @return the assessmentsCount
   */
  public Long assessmentsCount() {
    return assessmentsCount;
  }

  /**
   * Gets the assessments.
   *
   * The assessments.
   *
   * @return the assessments
   */
  public List<Implementation> assessments() {
    return assessments;
  }
}

