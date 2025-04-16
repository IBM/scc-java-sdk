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
 * The necessary fields to instantiate a Control Specification.
 */
public class ControlSpecificationPrototype extends GenericModel {

  /**
   * The cloud provider the specification is targeting.
   */
  public interface Environment {
    /** ibm-cloud. */
    String IBM_CLOUD = "ibm-cloud";
  }

  @SerializedName("component_id")
  protected String componentId;
  protected String environment;
  @SerializedName("control_specification_id")
  protected String controlSpecificationId;
  @SerializedName("control_specification_description")
  protected String controlSpecificationDescription;
  protected List<AssessmentPrototype> assessments;

  /**
   * Builder.
   */
  public static class Builder {
    private String componentId;
    private String environment;
    private String controlSpecificationId;
    private String controlSpecificationDescription;
    private List<AssessmentPrototype> assessments;

    /**
     * Instantiates a new Builder from an existing ControlSpecificationPrototype instance.
     *
     * @param controlSpecificationPrototype the instance to initialize the Builder with
     */
    private Builder(ControlSpecificationPrototype controlSpecificationPrototype) {
      this.componentId = controlSpecificationPrototype.componentId;
      this.environment = controlSpecificationPrototype.environment;
      this.controlSpecificationId = controlSpecificationPrototype.controlSpecificationId;
      this.controlSpecificationDescription = controlSpecificationPrototype.controlSpecificationDescription;
      this.assessments = controlSpecificationPrototype.assessments;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ControlSpecificationPrototype.
     *
     * @return the new ControlSpecificationPrototype instance
     */
    public ControlSpecificationPrototype build() {
      return new ControlSpecificationPrototype(this);
    }

    /**
     * Adds a new element to assessments.
     *
     * @param assessments the new element to be added
     * @return the ControlSpecificationPrototype builder
     */
    public Builder addAssessments(AssessmentPrototype assessments) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(assessments,
        "assessments cannot be null");
      if (this.assessments == null) {
        this.assessments = new ArrayList<AssessmentPrototype>();
      }
      this.assessments.add(assessments);
      return this;
    }

    /**
     * Set the componentId.
     *
     * @param componentId the componentId
     * @return the ControlSpecificationPrototype builder
     */
    public Builder componentId(String componentId) {
      this.componentId = componentId;
      return this;
    }

    /**
     * Set the environment.
     *
     * @param environment the environment
     * @return the ControlSpecificationPrototype builder
     */
    public Builder environment(String environment) {
      this.environment = environment;
      return this;
    }

    /**
     * Set the controlSpecificationId.
     *
     * @param controlSpecificationId the controlSpecificationId
     * @return the ControlSpecificationPrototype builder
     */
    public Builder controlSpecificationId(String controlSpecificationId) {
      this.controlSpecificationId = controlSpecificationId;
      return this;
    }

    /**
     * Set the controlSpecificationDescription.
     *
     * @param controlSpecificationDescription the controlSpecificationDescription
     * @return the ControlSpecificationPrototype builder
     */
    public Builder controlSpecificationDescription(String controlSpecificationDescription) {
      this.controlSpecificationDescription = controlSpecificationDescription;
      return this;
    }

    /**
     * Set the assessments.
     * Existing assessments will be replaced.
     *
     * @param assessments the assessments
     * @return the ControlSpecificationPrototype builder
     */
    public Builder assessments(List<AssessmentPrototype> assessments) {
      this.assessments = assessments;
      return this;
    }
  }

  protected ControlSpecificationPrototype() { }

  protected ControlSpecificationPrototype(Builder builder) {
    componentId = builder.componentId;
    environment = builder.environment;
    controlSpecificationId = builder.controlSpecificationId;
    controlSpecificationDescription = builder.controlSpecificationDescription;
    assessments = builder.assessments;
  }

  /**
   * New builder.
   *
   * @return a ControlSpecificationPrototype builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the componentId.
   *
   * The ID of the component. The component_id can be found from the 'service_name' using the Get Services method.
   *
   * @return the componentId
   */
  public String componentId() {
    return componentId;
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
   * Gets the controlSpecificationId.
   *
   * The ID of the control specification to give when creating the control_specification.
   *
   * @return the controlSpecificationId
   */
  public String controlSpecificationId() {
    return controlSpecificationId;
  }

  /**
   * Gets the controlSpecificationDescription.
   *
   * Information about the Control Specification.
   *
   * @return the controlSpecificationDescription
   */
  public String controlSpecificationDescription() {
    return controlSpecificationDescription;
  }

  /**
   * Gets the assessments.
   *
   * The detailed list of rules associated with the Specification.
   *
   * @return the assessments
   */
  public List<AssessmentPrototype> assessments() {
    return assessments;
  }
}

