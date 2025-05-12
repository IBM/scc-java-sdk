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
 * A statement that defines a security/privacy requirement for a Control.
 */
public class ControlSpecification extends GenericModel {

  protected String id;
  protected String responsibility;
  @SerializedName("component_id")
  protected String componentId;
  @SerializedName("component_name")
  protected String componentName;
  @SerializedName("component_type")
  protected String componentType;
  protected String environment;
  protected String description;
  @SerializedName("assessments_count")
  protected Long assessmentsCount;
  protected List<Assessment> assessments;

  /**
   * Builder.
   */
  public static class Builder {
    private String id;
    private String responsibility;
    private String componentId;
    private String componentName;
    private String componentType;
    private String environment;
    private String description;
    private Long assessmentsCount;
    private List<Assessment> assessments;

    /**
     * Instantiates a new Builder from an existing ControlSpecification instance.
     *
     * @param controlSpecification the instance to initialize the Builder with
     */
    private Builder(ControlSpecification controlSpecification) {
      this.id = controlSpecification.id;
      this.responsibility = controlSpecification.responsibility;
      this.componentId = controlSpecification.componentId;
      this.componentName = controlSpecification.componentName;
      this.componentType = controlSpecification.componentType;
      this.environment = controlSpecification.environment;
      this.description = controlSpecification.description;
      this.assessmentsCount = controlSpecification.assessmentsCount;
      this.assessments = controlSpecification.assessments;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param assessments the assessments
     */
    public Builder(List<Assessment> assessments) {
      this.assessments = assessments;
    }

    /**
     * Builds a ControlSpecification.
     *
     * @return the new ControlSpecification instance
     */
    public ControlSpecification build() {
      return new ControlSpecification(this);
    }

    /**
     * Adds a new element to assessments.
     *
     * @param assessments the new element to be added
     * @return the ControlSpecification builder
     */
    public Builder addAssessments(Assessment assessments) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(assessments,
        "assessments cannot be null");
      if (this.assessments == null) {
        this.assessments = new ArrayList<Assessment>();
      }
      this.assessments.add(assessments);
      return this;
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the ControlSpecification builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the responsibility.
     *
     * @param responsibility the responsibility
     * @return the ControlSpecification builder
     */
    public Builder responsibility(String responsibility) {
      this.responsibility = responsibility;
      return this;
    }

    /**
     * Set the componentId.
     *
     * @param componentId the componentId
     * @return the ControlSpecification builder
     */
    public Builder componentId(String componentId) {
      this.componentId = componentId;
      return this;
    }

    /**
     * Set the componentName.
     *
     * @param componentName the componentName
     * @return the ControlSpecification builder
     */
    public Builder componentName(String componentName) {
      this.componentName = componentName;
      return this;
    }

    /**
     * Set the componentType.
     *
     * @param componentType the componentType
     * @return the ControlSpecification builder
     */
    public Builder componentType(String componentType) {
      this.componentType = componentType;
      return this;
    }

    /**
     * Set the environment.
     *
     * @param environment the environment
     * @return the ControlSpecification builder
     */
    public Builder environment(String environment) {
      this.environment = environment;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the ControlSpecification builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the assessmentsCount.
     *
     * @param assessmentsCount the assessmentsCount
     * @return the ControlSpecification builder
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
     * @return the ControlSpecification builder
     */
    public Builder assessments(List<Assessment> assessments) {
      this.assessments = assessments;
      return this;
    }
  }

  protected ControlSpecification() { }

  protected ControlSpecification(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.assessments,
      "assessments cannot be null");
    id = builder.id;
    responsibility = builder.responsibility;
    componentId = builder.componentId;
    componentName = builder.componentName;
    componentType = builder.componentType;
    environment = builder.environment;
    description = builder.description;
    assessmentsCount = builder.assessmentsCount;
    assessments = builder.assessments;
  }

  /**
   * New builder.
   *
   * @return a ControlSpecification builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the id.
   *
   * The ID of the control.
   *
   * @return the id
   */
  public String id() {
    return id;
  }

  /**
   * Gets the responsibility.
   *
   * Details which party is responsible for the implementation of a specification.
   *
   * @return the responsibility
   */
  public String responsibility() {
    return responsibility;
  }

  /**
   * Gets the componentId.
   *
   * The ID of the component.
   *
   * @return the componentId
   */
  public String componentId() {
    return componentId;
  }

  /**
   * Gets the componentName.
   *
   * The name of the component.
   *
   * @return the componentName
   */
  public String componentName() {
    return componentName;
  }

  /**
   * Gets the componentType.
   *
   * The type of component that will use the specification.
   *
   * @return the componentType
   */
  public String componentType() {
    return componentType;
  }

  /**
   * Gets the environment.
   *
   * The cloud provider the specification is targeting.
   *
   * @return the environment
   */
  public String environment() {
    return environment;
  }

  /**
   * Gets the description.
   *
   * Information about the Control Specification.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the assessmentsCount.
   *
   * The number of rules tied to the specification.
   *
   * @return the assessmentsCount
   */
  public Long assessmentsCount() {
    return assessmentsCount;
  }

  /**
   * Gets the assessments.
   *
   * The detailed list of rules associated with the Specification.
   *
   * @return the assessments
   */
  public List<Assessment> assessments() {
    return assessments;
  }
}

