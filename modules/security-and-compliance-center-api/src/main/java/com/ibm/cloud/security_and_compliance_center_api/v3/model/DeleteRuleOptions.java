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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The deleteRule options.
 */
public class DeleteRuleOptions extends GenericModel {

  protected String instanceId;
  protected String ruleId;

  /**
   * Builder.
   */
  public static class Builder {
    private String instanceId;
    private String ruleId;

    /**
     * Instantiates a new Builder from an existing DeleteRuleOptions instance.
     *
     * @param deleteRuleOptions the instance to initialize the Builder with
     */
    private Builder(DeleteRuleOptions deleteRuleOptions) {
      this.instanceId = deleteRuleOptions.instanceId;
      this.ruleId = deleteRuleOptions.ruleId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param instanceId the instanceId
     * @param ruleId the ruleId
     */
    public Builder(String instanceId, String ruleId) {
      this.instanceId = instanceId;
      this.ruleId = ruleId;
    }

    /**
     * Builds a DeleteRuleOptions.
     *
     * @return the new DeleteRuleOptions instance
     */
    public DeleteRuleOptions build() {
      return new DeleteRuleOptions(this);
    }

    /**
     * Set the instanceId.
     *
     * @param instanceId the instanceId
     * @return the DeleteRuleOptions builder
     */
    public Builder instanceId(String instanceId) {
      this.instanceId = instanceId;
      return this;
    }

    /**
     * Set the ruleId.
     *
     * @param ruleId the ruleId
     * @return the DeleteRuleOptions builder
     */
    public Builder ruleId(String ruleId) {
      this.ruleId = ruleId;
      return this;
    }
  }

  protected DeleteRuleOptions() { }

  protected DeleteRuleOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceId,
      "instanceId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.ruleId,
      "ruleId cannot be empty");
    instanceId = builder.instanceId;
    ruleId = builder.ruleId;
  }

  /**
   * New builder.
   *
   * @return a DeleteRuleOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the instanceId.
   *
   * The ID of the Security and Compliance Center instance.
   *
   * @return the instanceId
   */
  public String instanceId() {
    return instanceId;
  }

  /**
   * Gets the ruleId.
   *
   * The ID of a rule/assessment.
   *
   * @return the ruleId
   */
  public String ruleId() {
    return ruleId;
  }
}

