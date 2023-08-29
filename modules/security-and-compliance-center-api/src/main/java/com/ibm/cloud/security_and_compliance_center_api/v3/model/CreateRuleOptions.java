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
 * The createRule options.
 */
public class CreateRuleOptions extends GenericModel {

  /**
   * The rule type (user_defined or system_defined).
   */
  public interface Type {
    /** user_defined. */
    String USER_DEFINED = "user_defined";
    /** system_defined. */
    String SYSTEM_DEFINED = "system_defined";
  }

  protected String description;
  protected Target target;
  protected RequiredConfig requiredConfig;
  protected String type;
  protected String version;
  protected Import xImport;
  protected List<String> labels;
  protected String xCorrelationId;
  protected String xRequestId;

  /**
   * Builder.
   */
  public static class Builder {
    private String description;
    private Target target;
    private RequiredConfig requiredConfig;
    private String type;
    private String version;
    private Import xImport;
    private List<String> labels;
    private String xCorrelationId;
    private String xRequestId;

    /**
     * Instantiates a new Builder from an existing CreateRuleOptions instance.
     *
     * @param createRuleOptions the instance to initialize the Builder with
     */
    private Builder(CreateRuleOptions createRuleOptions) {
      this.description = createRuleOptions.description;
      this.target = createRuleOptions.target;
      this.requiredConfig = createRuleOptions.requiredConfig;
      this.type = createRuleOptions.type;
      this.version = createRuleOptions.version;
      this.xImport = createRuleOptions.xImport;
      this.labels = createRuleOptions.labels;
      this.xCorrelationId = createRuleOptions.xCorrelationId;
      this.xRequestId = createRuleOptions.xRequestId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param description the description
     * @param target the target
     * @param requiredConfig the requiredConfig
     */
    public Builder(String description, Target target, RequiredConfig requiredConfig) {
      this.description = description;
      this.target = target;
      this.requiredConfig = requiredConfig;
    }

    /**
     * Builds a CreateRuleOptions.
     *
     * @return the new CreateRuleOptions instance
     */
    public CreateRuleOptions build() {
      return new CreateRuleOptions(this);
    }

    /**
     * Adds an labels to labels.
     *
     * @param labels the new labels
     * @return the CreateRuleOptions builder
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
     * Set the description.
     *
     * @param description the description
     * @return the CreateRuleOptions builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the target.
     *
     * @param target the target
     * @return the CreateRuleOptions builder
     */
    public Builder target(Target target) {
      this.target = target;
      return this;
    }

    /**
     * Set the requiredConfig.
     *
     * @param requiredConfig the requiredConfig
     * @return the CreateRuleOptions builder
     */
    public Builder requiredConfig(RequiredConfig requiredConfig) {
      this.requiredConfig = requiredConfig;
      return this;
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the CreateRuleOptions builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the version.
     *
     * @param version the version
     * @return the CreateRuleOptions builder
     */
    public Builder version(String version) {
      this.version = version;
      return this;
    }

    /**
     * Set the xImport.
     *
     * @param xImport the xImport
     * @return the CreateRuleOptions builder
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
     * @return the CreateRuleOptions builder
     */
    public Builder labels(List<String> labels) {
      this.labels = labels;
      return this;
    }

    /**
     * Set the xCorrelationId.
     *
     * @param xCorrelationId the xCorrelationId
     * @return the CreateRuleOptions builder
     */
    public Builder xCorrelationId(String xCorrelationId) {
      this.xCorrelationId = xCorrelationId;
      return this;
    }

    /**
     * Set the xRequestId.
     *
     * @param xRequestId the xRequestId
     * @return the CreateRuleOptions builder
     */
    public Builder xRequestId(String xRequestId) {
      this.xRequestId = xRequestId;
      return this;
    }
  }

  protected CreateRuleOptions() { }

  protected CreateRuleOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.description,
      "description cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.target,
      "target cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.requiredConfig,
      "requiredConfig cannot be null");
    description = builder.description;
    target = builder.target;
    requiredConfig = builder.requiredConfig;
    type = builder.type;
    version = builder.version;
    xImport = builder.xImport;
    labels = builder.labels;
    xCorrelationId = builder.xCorrelationId;
    xRequestId = builder.xRequestId;
  }

  /**
   * New builder.
   *
   * @return a CreateRuleOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
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
  public Target target() {
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
   * Gets the type.
   *
   * The rule type (user_defined or system_defined).
   *
   * @return the type
   */
  public String type() {
    return type;
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

