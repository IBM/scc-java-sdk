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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The necessary fields to include a rule/assessment.
 */
public class AssessmentPrototype extends GenericModel {

  @SerializedName("assessment_id")
  protected String assessmentId;
  @SerializedName("assessment_description")
  protected String assessmentDescription;

  /**
   * Builder.
   */
  public static class Builder {
    private String assessmentId;
    private String assessmentDescription;

    /**
     * Instantiates a new Builder from an existing AssessmentPrototype instance.
     *
     * @param assessmentPrototype the instance to initialize the Builder with
     */
    private Builder(AssessmentPrototype assessmentPrototype) {
      this.assessmentId = assessmentPrototype.assessmentId;
      this.assessmentDescription = assessmentPrototype.assessmentDescription;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a AssessmentPrototype.
     *
     * @return the new AssessmentPrototype instance
     */
    public AssessmentPrototype build() {
      return new AssessmentPrototype(this);
    }

    /**
     * Set the assessmentId.
     *
     * @param assessmentId the assessmentId
     * @return the AssessmentPrototype builder
     */
    public Builder assessmentId(String assessmentId) {
      this.assessmentId = assessmentId;
      return this;
    }

    /**
     * Set the assessmentDescription.
     *
     * @param assessmentDescription the assessmentDescription
     * @return the AssessmentPrototype builder
     */
    public Builder assessmentDescription(String assessmentDescription) {
      this.assessmentDescription = assessmentDescription;
      return this;
    }
  }

  protected AssessmentPrototype() { }

  protected AssessmentPrototype(Builder builder) {
    assessmentId = builder.assessmentId;
    assessmentDescription = builder.assessmentDescription;
  }

  /**
   * New builder.
   *
   * @return a AssessmentPrototype builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the assessmentId.
   *
   * The ID of the rule to target. A list of rules can be obtained from the list_rules method.
   *
   * @return the assessmentId
   */
  public String assessmentId() {
    return assessmentId;
  }

  /**
   * Gets the assessmentDescription.
   *
   * Details on the intent of the rule for an assessment.
   *
   * @return the assessmentDescription
   */
  public String assessmentDescription() {
    return assessmentDescription;
  }
}

