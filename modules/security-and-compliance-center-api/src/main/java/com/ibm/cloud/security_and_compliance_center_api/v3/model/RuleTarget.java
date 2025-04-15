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
 * The rule target.
 */
public class RuleTarget extends GenericModel {

  @SerializedName("service_name")
  protected String serviceName;
  @SerializedName("service_display_name")
  protected String serviceDisplayName;
  @SerializedName("resource_kind")
  protected String resourceKind;
  @SerializedName("additional_target_attributes")
  protected List<AdditionalTargetAttribute> additionalTargetAttributes;
  protected String ref;

  /**
   * Builder.
   */
  public static class Builder {
    private String serviceName;
    private String serviceDisplayName;
    private String resourceKind;
    private List<AdditionalTargetAttribute> additionalTargetAttributes;
    private String ref;

    /**
     * Instantiates a new Builder from an existing RuleTarget instance.
     *
     * @param ruleTarget the instance to initialize the Builder with
     */
    private Builder(RuleTarget ruleTarget) {
      this.serviceName = ruleTarget.serviceName;
      this.serviceDisplayName = ruleTarget.serviceDisplayName;
      this.resourceKind = ruleTarget.resourceKind;
      this.additionalTargetAttributes = ruleTarget.additionalTargetAttributes;
      this.ref = ruleTarget.ref;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param serviceName the serviceName
     * @param resourceKind the resourceKind
     */
    public Builder(String serviceName, String resourceKind) {
      this.serviceName = serviceName;
      this.resourceKind = resourceKind;
    }

    /**
     * Builds a RuleTarget.
     *
     * @return the new RuleTarget instance
     */
    public RuleTarget build() {
      return new RuleTarget(this);
    }

    /**
     * Adds a new element to additionalTargetAttributes.
     *
     * @param additionalTargetAttributes the new element to be added
     * @return the RuleTarget builder
     */
    public Builder addAdditionalTargetAttributes(AdditionalTargetAttribute additionalTargetAttributes) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(additionalTargetAttributes,
        "additionalTargetAttributes cannot be null");
      if (this.additionalTargetAttributes == null) {
        this.additionalTargetAttributes = new ArrayList<AdditionalTargetAttribute>();
      }
      this.additionalTargetAttributes.add(additionalTargetAttributes);
      return this;
    }

    /**
     * Set the serviceName.
     *
     * @param serviceName the serviceName
     * @return the RuleTarget builder
     */
    public Builder serviceName(String serviceName) {
      this.serviceName = serviceName;
      return this;
    }

    /**
     * Set the serviceDisplayName.
     *
     * @param serviceDisplayName the serviceDisplayName
     * @return the RuleTarget builder
     */
    public Builder serviceDisplayName(String serviceDisplayName) {
      this.serviceDisplayName = serviceDisplayName;
      return this;
    }

    /**
     * Set the resourceKind.
     *
     * @param resourceKind the resourceKind
     * @return the RuleTarget builder
     */
    public Builder resourceKind(String resourceKind) {
      this.resourceKind = resourceKind;
      return this;
    }

    /**
     * Set the additionalTargetAttributes.
     * Existing additionalTargetAttributes will be replaced.
     *
     * @param additionalTargetAttributes the additionalTargetAttributes
     * @return the RuleTarget builder
     */
    public Builder additionalTargetAttributes(List<AdditionalTargetAttribute> additionalTargetAttributes) {
      this.additionalTargetAttributes = additionalTargetAttributes;
      return this;
    }

    /**
     * Set the ref.
     *
     * @param ref the ref
     * @return the RuleTarget builder
     */
    public Builder ref(String ref) {
      this.ref = ref;
      return this;
    }
  }

  protected RuleTarget() { }

  protected RuleTarget(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.serviceName,
      "serviceName cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.resourceKind,
      "resourceKind cannot be null");
    serviceName = builder.serviceName;
    serviceDisplayName = builder.serviceDisplayName;
    resourceKind = builder.resourceKind;
    additionalTargetAttributes = builder.additionalTargetAttributes;
    ref = builder.ref;
  }

  /**
   * New builder.
   *
   * @return a RuleTarget builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the serviceName.
   *
   * The target service name.
   *
   * @return the serviceName
   */
  public String serviceName() {
    return serviceName;
  }

  /**
   * Gets the serviceDisplayName.
   *
   * The display name of the target service.
   *
   * @return the serviceDisplayName
   */
  public String serviceDisplayName() {
    return serviceDisplayName;
  }

  /**
   * Gets the resourceKind.
   *
   * The target resource kind.
   *
   * @return the resourceKind
   */
  public String resourceKind() {
    return resourceKind;
  }

  /**
   * Gets the additionalTargetAttributes.
   *
   * The additional target attributes used to filter to a subset of resources.
   *
   * @return the additionalTargetAttributes
   */
  public List<AdditionalTargetAttribute> additionalTargetAttributes() {
    return additionalTargetAttributes;
  }

  /**
   * Gets the ref.
   *
   * The name of target when used in a rule.
   *
   * @return the ref
   */
  public String ref() {
    return ref;
  }
}

