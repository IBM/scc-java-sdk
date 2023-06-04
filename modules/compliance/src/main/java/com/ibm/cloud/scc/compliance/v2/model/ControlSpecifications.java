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
 * The control specifications for a control library.
 */
public class ControlSpecifications extends GenericModel {

  /**
   * Responsibility.
   */
  public interface Responsibility {
    /** user. */
    String USER = "user";
  }

  protected String id;
  protected String responsibility;
  @SerializedName("component_id")
  protected String componentId;
  protected String environment;
  protected String description;
  @SerializedName("assessments_count")
  protected Long assessmentsCount;
  protected List<ImplementationPayload> assessments;

  /**
   * Builder.
   */
  public static class Builder {
    private String id;
    private String responsibility;
    private String componentId;
    private String environment;
    private String description;
    private Long assessmentsCount;
    private List<ImplementationPayload> assessments;

    /**
     * Instantiates a new Builder from an existing ControlSpecifications instance.
     *
     * @param controlSpecifications the instance to initialize the Builder with
     */
    private Builder(ControlSpecifications controlSpecifications) {
      this.id = controlSpecifications.id;
      this.responsibility = controlSpecifications.responsibility;
      this.componentId = controlSpecifications.componentId;
      this.environment = controlSpecifications.environment;
      this.description = controlSpecifications.description;
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
    public Builder addAssessments(ImplementationPayload assessments) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(assessments,
        "assessments cannot be null");
      if (this.assessments == null) {
        this.assessments = new ArrayList<ImplementationPayload>();
      }
      this.assessments.add(assessments);
      return this;
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the ControlSpecifications builder
     */
    public Builder id(String id) {
      this.id = id;
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
     * Set the description.
     *
     * @param description the description
     * @return the ControlSpecifications builder
     */
    public Builder description(String description) {
      this.description = description;
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
    public Builder assessments(List<ImplementationPayload> assessments) {
      this.assessments = assessments;
      return this;
    }
  }

  protected ControlSpecifications() { }

  protected ControlSpecifications(Builder builder) {
    id = builder.id;
    responsibility = builder.responsibility;
    componentId = builder.componentId;
    environment = builder.environment;
    description = builder.description;
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
   * Gets the id.
   *
   * Control Specification ID.
   *
   * @return the id
   */
  public String id() {
    return id;
  }

  /**
   * Gets the responsibility.
   *
   * Responsibility.
   *
   * @return the responsibility
   */
  public String responsibility() {
    return responsibility;
  }

  /**
   * Gets the componentId.
   *
   * Component ID.
   *
   * @return the componentId
   */
  public String componentId() {
    return componentId;
  }

  /**
   * Gets the environment.
   *
   * Environment of control specifications.
   *
   * @return the environment
   */
  public String environment() {
    return environment;
  }

  /**
   * Gets the description.
   *
   * Description of control specifications.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the assessmentsCount.
   *
   * Number of Assessment.
   *
   * @return the assessmentsCount
   */
  public Long assessmentsCount() {
    return assessmentsCount;
  }

  /**
   * Gets the assessments.
   *
   * Assessments.
   *
   * @return the assessments
   */
  public List<ImplementationPayload> assessments() {
    return assessments;
  }
}

