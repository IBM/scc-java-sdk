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

import java.util.Map;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The createProviderTypeInstance options.
 */
public class CreateProviderTypeInstanceOptions extends GenericModel {

  protected String instanceId;
  protected String providerTypeId;
  protected String name;
  protected Map<String, Object> attributes;

  /**
   * Builder.
   */
  public static class Builder {
    private String instanceId;
    private String providerTypeId;
    private String name;
    private Map<String, Object> attributes;

    /**
     * Instantiates a new Builder from an existing CreateProviderTypeInstanceOptions instance.
     *
     * @param createProviderTypeInstanceOptions the instance to initialize the Builder with
     */
    private Builder(CreateProviderTypeInstanceOptions createProviderTypeInstanceOptions) {
      this.instanceId = createProviderTypeInstanceOptions.instanceId;
      this.providerTypeId = createProviderTypeInstanceOptions.providerTypeId;
      this.name = createProviderTypeInstanceOptions.name;
      this.attributes = createProviderTypeInstanceOptions.attributes;
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
     * @param providerTypeId the providerTypeId
     */
    public Builder(String instanceId, String providerTypeId) {
      this.instanceId = instanceId;
      this.providerTypeId = providerTypeId;
    }

    /**
     * Builds a CreateProviderTypeInstanceOptions.
     *
     * @return the new CreateProviderTypeInstanceOptions instance
     */
    public CreateProviderTypeInstanceOptions build() {
      return new CreateProviderTypeInstanceOptions(this);
    }

    /**
     * Set the instanceId.
     *
     * @param instanceId the instanceId
     * @return the CreateProviderTypeInstanceOptions builder
     */
    public Builder instanceId(String instanceId) {
      this.instanceId = instanceId;
      return this;
    }

    /**
     * Set the providerTypeId.
     *
     * @param providerTypeId the providerTypeId
     * @return the CreateProviderTypeInstanceOptions builder
     */
    public Builder providerTypeId(String providerTypeId) {
      this.providerTypeId = providerTypeId;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the CreateProviderTypeInstanceOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the attributes.
     *
     * @param attributes the attributes
     * @return the CreateProviderTypeInstanceOptions builder
     */
    public Builder attributes(Map<String, Object> attributes) {
      this.attributes = attributes;
      return this;
    }
  }

  protected CreateProviderTypeInstanceOptions() { }

  protected CreateProviderTypeInstanceOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceId,
      "instanceId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.providerTypeId,
      "providerTypeId cannot be empty");
    instanceId = builder.instanceId;
    providerTypeId = builder.providerTypeId;
    name = builder.name;
    attributes = builder.attributes;
  }

  /**
   * New builder.
   *
   * @return a CreateProviderTypeInstanceOptions builder
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
   * Gets the providerTypeId.
   *
   * The provider type ID.
   *
   * @return the providerTypeId
   */
  public String providerTypeId() {
    return providerTypeId;
  }

  /**
   * Gets the name.
   *
   * The provider type instance name.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the attributes.
   *
   * The attributes for connecting to the provider type instance.
   *
   * @return the attributes
   */
  public Map<String, Object> attributes() {
    return attributes;
  }
}

