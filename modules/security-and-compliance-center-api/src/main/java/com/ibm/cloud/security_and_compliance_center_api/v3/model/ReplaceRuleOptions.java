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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The replaceRule options.
 */
public class ReplaceRuleOptions extends GenericModel {

  protected String instanceId;
  protected String ruleId;
  protected String ifMatch;
  protected String description;
  protected RuleTargetPrototype target;
  protected RequiredConfig requiredConfig;
  protected String version;
  protected Import xImport;
  protected List<String> labels;

  /**
   * Builder.
   */
  public static class Builder {
    private String instanceId;
    private String ruleId;
    private String ifMatch;
    private String description;
    private RuleTargetPrototype target;
    private RequiredConfig requiredConfig;
    private String version;
    private Import xImport;
    private List<String> labels;

    /**
     * Instantiates a new Builder from an existing ReplaceRuleOptions instance.
     *
     * @param replaceRuleOptions the instance to initialize the Builder with
     */
    private Builder(ReplaceRuleOptions replaceRuleOptions) {
      this.instanceId = replaceRuleOptions.instanceId;
      this.ruleId = replaceRuleOptions.ruleId;
      this.ifMatch = replaceRuleOptions.ifMatch;
      this.description = replaceRuleOptions.description;
      this.target = replaceRuleOptions.target;
      this.requiredConfig = replaceRuleOptions.requiredConfig;
      this.version = replaceRuleOptions.version;
      this.xImport = replaceRuleOptions.xImport;
      this.labels = replaceRuleOptions.labels;
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
     * @param ifMatch the ifMatch
     * @param description the description
     * @param target the target
     * @param requiredConfig the requiredConfig
     */
    public Builder(String instanceId, String ruleId, String ifMatch, String description, RuleTargetPrototype target, RequiredConfig requiredConfig) {
      this.instanceId = instanceId;
      this.ruleId = ruleId;
      this.ifMatch = ifMatch;
      this.description = description;
      this.target = target;
      this.requiredConfig = requiredConfig;
    }

    /**
     * Builds a ReplaceRuleOptions.
     *
     * @return the new ReplaceRuleOptions instance
     */
    public ReplaceRuleOptions build() {
      return new ReplaceRuleOptions(this);
    }

    /**
     * Adds a new element to labels.
     *
     * @param labels the new element to be added
     * @return the ReplaceRuleOptions builder
     */
    public Builder addLabels(String labels) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(labels,
        "labels cannot be null");
      if (this.labels == null) {
        this.labels = new ArrayList<String>();
      }
      this.labels.add(labels);
      return this;
    }

    /**
     * Set the instanceId.
     *
     * @param instanceId the instanceId
     * @return the ReplaceRuleOptions builder
     */
    public Builder instanceId(String instanceId) {
      this.instanceId = instanceId;
      return this;
    }

    /**
     * Set the ruleId.
     *
     * @param ruleId the ruleId
     * @return the ReplaceRuleOptions builder
     */
    public Builder ruleId(String ruleId) {
      this.ruleId = ruleId;
      return this;
    }

    /**
     * Set the ifMatch.
     *
     * @param ifMatch the ifMatch
     * @return the ReplaceRuleOptions builder
     */
    public Builder ifMatch(String ifMatch) {
      this.ifMatch = ifMatch;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the ReplaceRuleOptions builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the target.
     *
     * @param target the target
     * @return the ReplaceRuleOptions builder
     */
    public Builder target(RuleTargetPrototype target) {
      this.target = target;
      return this;
    }

    /**
     * Set the requiredConfig.
     *
     * @param requiredConfig the requiredConfig
     * @return the ReplaceRuleOptions builder
     */
    public Builder requiredConfig(RequiredConfig requiredConfig) {
      this.requiredConfig = requiredConfig;
      return this;
    }

    /**
     * Set the version.
     *
     * @param version the version
     * @return the ReplaceRuleOptions builder
     */
    public Builder version(String version) {
      this.version = version;
      return this;
    }

    /**
     * Set the xImport.
     *
     * @param xImport the xImport
     * @return the ReplaceRuleOptions builder
     */
    public Builder xImport(Import xImport) {
      this.xImport = xImport;
      return this;
    }

    /**
     * Set the labels.
     * Existing labels will be replaced.
     *
     * @param labels the labels
     * @return the ReplaceRuleOptions builder
     */
    public Builder labels(List<String> labels) {
      this.labels = labels;
      return this;
    }
  }

  protected ReplaceRuleOptions() { }

  protected ReplaceRuleOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceId,
      "instanceId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.ruleId,
      "ruleId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.ifMatch,
      "ifMatch cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.description,
      "description cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.target,
      "target cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.requiredConfig,
      "requiredConfig cannot be null");
    instanceId = builder.instanceId;
    ruleId = builder.ruleId;
    ifMatch = builder.ifMatch;
    description = builder.description;
    target = builder.target;
    requiredConfig = builder.requiredConfig;
    version = builder.version;
    xImport = builder.xImport;
    labels = builder.labels;
  }

  /**
   * New builder.
   *
   * @return a ReplaceRuleOptions builder
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

  /**
   * Gets the ifMatch.
   *
   * This field compares a supplied `Etag` value with the version that is stored for the requested resource. If the
   * values match, the server allows the request method to continue.
   *
   * To find the `Etag` value, run a GET request on the resource that you want to modify, and check the response
   * headers.
   *
   * @return the ifMatch
   */
  public String ifMatch() {
    return ifMatch;
  }

  /**
   * Gets the description.
   *
   * The rule description.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the target.
   *
   * The rule target.
   *
   * @return the target
   */
  public RuleTargetPrototype target() {
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

  /**
   * Gets the version.
   *
   * The rule version number.
   *
   * @return the version
   */
  public String version() {
    return version;
  }

  /**
   * Gets the xImport.
   *
   * The collection of import parameters.
   *
   * @return the xImport
   */
  public Import xImport() {
    return xImport;
  }

  /**
   * Gets the labels.
   *
   * The list of labels that correspond to a rule.
   *
   * @return the labels
   */
  public List<String> labels() {
    return labels;
  }
}

