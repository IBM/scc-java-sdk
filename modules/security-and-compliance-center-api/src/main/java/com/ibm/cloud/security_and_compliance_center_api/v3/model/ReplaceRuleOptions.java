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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The replaceRule options.
 */
public class ReplaceRuleOptions extends GenericModel {

  protected String ruleId;
  protected String ifMatch;
  protected String description;
  protected TargetPrototype target;
  protected RequiredConfig requiredConfig;
  protected String version;
  protected Import xImport;
  protected List<String> labels;
  protected String xCorrelationId;
  protected String xRequestId;

  /**
   * Builder.
   */
  public static class Builder {
    private String ruleId;
    private String ifMatch;
    private String description;
    private TargetPrototype target;
    private RequiredConfig requiredConfig;
    private String version;
    private Import xImport;
    private List<String> labels;
    private String xCorrelationId;
    private String xRequestId;

    /**
     * Instantiates a new Builder from an existing ReplaceRuleOptions instance.
     *
     * @param replaceRuleOptions the instance to initialize the Builder with
     */
    private Builder(ReplaceRuleOptions replaceRuleOptions) {
      this.ruleId = replaceRuleOptions.ruleId;
      this.ifMatch = replaceRuleOptions.ifMatch;
      this.description = replaceRuleOptions.description;
      this.target = replaceRuleOptions.target;
      this.requiredConfig = replaceRuleOptions.requiredConfig;
      this.version = replaceRuleOptions.version;
      this.xImport = replaceRuleOptions.xImport;
      this.labels = replaceRuleOptions.labels;
      this.xCorrelationId = replaceRuleOptions.xCorrelationId;
      this.xRequestId = replaceRuleOptions.xRequestId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param ruleId the ruleId
     * @param ifMatch the ifMatch
     * @param description the description
     * @param target the target
     * @param requiredConfig the requiredConfig
     */
    public Builder(String ruleId, String ifMatch, String description, TargetPrototype target, RequiredConfig requiredConfig) {
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
     * Adds an labels to labels.
     *
     * @param labels the new labels
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
    public Builder target(TargetPrototype target) {
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

    /**
     * Set the xCorrelationId.
     *
     * @param xCorrelationId the xCorrelationId
     * @return the ReplaceRuleOptions builder
     */
    public Builder xCorrelationId(String xCorrelationId) {
      this.xCorrelationId = xCorrelationId;
      return this;
    }

    /**
     * Set the xRequestId.
     *
     * @param xRequestId the xRequestId
     * @return the ReplaceRuleOptions builder
     */
    public Builder xRequestId(String xRequestId) {
      this.xRequestId = xRequestId;
      return this;
    }
  }

  protected ReplaceRuleOptions() { }

  protected ReplaceRuleOptions(Builder builder) {
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
    ruleId = builder.ruleId;
    ifMatch = builder.ifMatch;
    description = builder.description;
    target = builder.target;
    requiredConfig = builder.requiredConfig;
    version = builder.version;
    xImport = builder.xImport;
    labels = builder.labels;
    xCorrelationId = builder.xCorrelationId;
    xRequestId = builder.xRequestId;
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
   * Gets the ruleId.
   *
   * The ID of the corresponding rule.
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
  public TargetPrototype target() {
    return target;
  }

  /**
   * Gets the requiredConfig.
   *
   * The required configurations.
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

  /**
   * Gets the xCorrelationId.
   *
   * The supplied or generated value of this header is logged for a request and repeated in a response header for the
   * corresponding response. The same value is used for downstream requests and retries of those requests. If a value of
   * this header is not supplied in a request, the service generates a random (version 4) UUID.
   *
   * @return the xCorrelationId
   */
  public String xCorrelationId() {
    return xCorrelationId;
  }

  /**
   * Gets the xRequestId.
   *
   * The supplied or generated value of this header is logged for a request and repeated in a response header  for the
   * corresponding response.  The same value is not used for downstream requests and retries of those requests.  If a
   * value of this header is not supplied in a request, the service generates a random (version 4) UUID.
   *
   * @return the xRequestId
   */
  public String xRequestId() {
    return xRequestId;
  }
}

