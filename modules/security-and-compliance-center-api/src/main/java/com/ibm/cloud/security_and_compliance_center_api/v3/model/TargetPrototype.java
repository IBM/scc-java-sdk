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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The rule target.
 */
public class TargetPrototype extends GenericModel {

  @SerializedName("service_name")
  protected String serviceName;
  @SerializedName("resource_kind")
  protected String resourceKind;
  @SerializedName("additional_target_attributes")
  protected List<AdditionalTargetAttribute> additionalTargetAttributes;

  /**
   * Builder.
   */
  public static class Builder {
    private String serviceName;
    private String resourceKind;
    private List<AdditionalTargetAttribute> additionalTargetAttributes;

    /**
     * Instantiates a new Builder from an existing TargetPrototype instance.
     *
     * @param targetPrototype the instance to initialize the Builder with
     */
    private Builder(TargetPrototype targetPrototype) {
      this.serviceName = targetPrototype.serviceName;
      this.resourceKind = targetPrototype.resourceKind;
      this.additionalTargetAttributes = targetPrototype.additionalTargetAttributes;
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
     * Builds a TargetPrototype.
     *
     * @return the new TargetPrototype instance
     */
    public TargetPrototype build() {
      return new TargetPrototype(this);
    }

    /**
     * Adds an additionalTargetAttributes to additionalTargetAttributes.
     *
     * @param additionalTargetAttributes the new additionalTargetAttributes
     * @return the TargetPrototype builder
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
     * @return the TargetPrototype builder
     */
    public Builder serviceName(String serviceName) {
      this.serviceName = serviceName;
      return this;
    }

    /**
     * Set the resourceKind.
     *
     * @param resourceKind the resourceKind
     * @return the TargetPrototype builder
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
     * @return the TargetPrototype builder
     */
    public Builder additionalTargetAttributes(List<AdditionalTargetAttribute> additionalTargetAttributes) {
      this.additionalTargetAttributes = additionalTargetAttributes;
      return this;
    }
  }

  protected TargetPrototype() { }

  protected TargetPrototype(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.serviceName,
      "serviceName cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.resourceKind,
      "resourceKind cannot be null");
    serviceName = builder.serviceName;
    resourceKind = builder.resourceKind;
    additionalTargetAttributes = builder.additionalTargetAttributes;
  }

  /**
   * New builder.
   *
   * @return a TargetPrototype builder
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
}

