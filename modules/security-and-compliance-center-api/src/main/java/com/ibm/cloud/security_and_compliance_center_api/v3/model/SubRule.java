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
 * A rule within a rule used in the requiredConfig.
 */
public class SubRule extends GenericModel {

  protected RuleTarget target;
  @SerializedName("required_config")
  protected RequiredConfig requiredConfig;

  /**
   * Builder.
   */
  public static class Builder {
    private RuleTarget target;
    private RequiredConfig requiredConfig;

    /**
     * Instantiates a new Builder from an existing SubRule instance.
     *
     * @param subRule the instance to initialize the Builder with
     */
    private Builder(SubRule subRule) {
      this.target = subRule.target;
      this.requiredConfig = subRule.requiredConfig;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a SubRule.
     *
     * @return the new SubRule instance
     */
    public SubRule build() {
      return new SubRule(this);
    }

    /**
     * Set the target.
     *
     * @param target the target
     * @return the SubRule builder
     */
    public Builder target(RuleTarget target) {
      this.target = target;
      return this;
    }

    /**
     * Set the requiredConfig.
     *
     * @param requiredConfig the requiredConfig
     * @return the SubRule builder
     */
    public Builder requiredConfig(RequiredConfig requiredConfig) {
      this.requiredConfig = requiredConfig;
      return this;
    }
  }

  protected SubRule() { }

  protected SubRule(Builder builder) {
    target = builder.target;
    requiredConfig = builder.requiredConfig;
  }

  /**
   * New builder.
   *
   * @return a SubRule builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the target.
   *
   * The rule target.
   *
   * @return the target
   */
  public RuleTarget target() {
    return target;
  }

  /**
   * Gets the requiredConfig.
   *
   * The required configurations for a Rule.
   *
   * @return the requiredConfig
   */
  public RequiredConfig requiredConfig() {
    return requiredConfig;
  }
}

