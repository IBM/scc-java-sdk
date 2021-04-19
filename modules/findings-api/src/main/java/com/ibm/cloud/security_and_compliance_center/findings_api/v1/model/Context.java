/*
 * (C) Copyright IBM Corp. 2021.
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
package com.ibm.cloud.security_and_compliance_center.findings_api.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Context.
 */
public class Context extends GenericModel {

  protected String region;
  @SerializedName("resource_crn")
  protected String resourceCrn;
  @SerializedName("resource_id")
  protected String resourceId;
  @SerializedName("resource_name")
  protected String resourceName;
  @SerializedName("resource_type")
  protected String resourceType;
  @SerializedName("service_crn")
  protected String serviceCrn;
  @SerializedName("service_name")
  protected String serviceName;
  @SerializedName("environment_name")
  protected String environmentName;
  @SerializedName("component_name")
  protected String componentName;
  @SerializedName("toolchain_id")
  protected String toolchainId;

  /**
   * Builder.
   */
  public static class Builder {
    private String region;
    private String resourceCrn;
    private String resourceId;
    private String resourceName;
    private String resourceType;
    private String serviceCrn;
    private String serviceName;
    private String environmentName;
    private String componentName;
    private String toolchainId;

    private Builder(Context context) {
      this.region = context.region;
      this.resourceCrn = context.resourceCrn;
      this.resourceId = context.resourceId;
      this.resourceName = context.resourceName;
      this.resourceType = context.resourceType;
      this.serviceCrn = context.serviceCrn;
      this.serviceName = context.serviceName;
      this.environmentName = context.environmentName;
      this.componentName = context.componentName;
      this.toolchainId = context.toolchainId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a Context.
     *
     * @return the new Context instance
     */
    public Context build() {
      return new Context(this);
    }

    /**
     * Set the region.
     *
     * @param region the region
     * @return the Context builder
     */
    public Builder region(String region) {
      this.region = region;
      return this;
    }

    /**
     * Set the resourceCrn.
     *
     * @param resourceCrn the resourceCrn
     * @return the Context builder
     */
    public Builder resourceCrn(String resourceCrn) {
      this.resourceCrn = resourceCrn;
      return this;
    }

    /**
     * Set the resourceId.
     *
     * @param resourceId the resourceId
     * @return the Context builder
     */
    public Builder resourceId(String resourceId) {
      this.resourceId = resourceId;
      return this;
    }

    /**
     * Set the resourceName.
     *
     * @param resourceName the resourceName
     * @return the Context builder
     */
    public Builder resourceName(String resourceName) {
      this.resourceName = resourceName;
      return this;
    }

    /**
     * Set the resourceType.
     *
     * @param resourceType the resourceType
     * @return the Context builder
     */
    public Builder resourceType(String resourceType) {
      this.resourceType = resourceType;
      return this;
    }

    /**
     * Set the serviceCrn.
     *
     * @param serviceCrn the serviceCrn
     * @return the Context builder
     */
    public Builder serviceCrn(String serviceCrn) {
      this.serviceCrn = serviceCrn;
      return this;
    }

    /**
     * Set the serviceName.
     *
     * @param serviceName the serviceName
     * @return the Context builder
     */
    public Builder serviceName(String serviceName) {
      this.serviceName = serviceName;
      return this;
    }

    /**
     * Set the environmentName.
     *
     * @param environmentName the environmentName
     * @return the Context builder
     */
    public Builder environmentName(String environmentName) {
      this.environmentName = environmentName;
      return this;
    }

    /**
     * Set the componentName.
     *
     * @param componentName the componentName
     * @return the Context builder
     */
    public Builder componentName(String componentName) {
      this.componentName = componentName;
      return this;
    }

    /**
     * Set the toolchainId.
     *
     * @param toolchainId the toolchainId
     * @return the Context builder
     */
    public Builder toolchainId(String toolchainId) {
      this.toolchainId = toolchainId;
      return this;
    }
  }

  protected Context(Builder builder) {
    region = builder.region;
    resourceCrn = builder.resourceCrn;
    resourceId = builder.resourceId;
    resourceName = builder.resourceName;
    resourceType = builder.resourceType;
    serviceCrn = builder.serviceCrn;
    serviceName = builder.serviceName;
    environmentName = builder.environmentName;
    componentName = builder.componentName;
    toolchainId = builder.toolchainId;
  }

  /**
   * New builder.
   *
   * @return a Context builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the region.
   *
   * The IBM Cloud region.
   *
   * @return the region
   */
  public String region() {
    return region;
  }

  /**
   * Gets the resourceCrn.
   *
   * The resource CRN (e.g. certificate CRN, image CRN).
   *
   * @return the resourceCrn
   */
  public String resourceCrn() {
    return resourceCrn;
  }

  /**
   * Gets the resourceId.
   *
   * The resource ID, in case the CRN is not available.
   *
   * @return the resourceId
   */
  public String resourceId() {
    return resourceId;
  }

  /**
   * Gets the resourceName.
   *
   * The user-friendly resource name.
   *
   * @return the resourceName
   */
  public String resourceName() {
    return resourceName;
  }

  /**
   * Gets the resourceType.
   *
   * The resource type name (e.g. Pod, Cluster, Certificate, Image).
   *
   * @return the resourceType
   */
  public String resourceType() {
    return resourceType;
  }

  /**
   * Gets the serviceCrn.
   *
   * The service CRN (e.g. CertMgr Instance CRN).
   *
   * @return the serviceCrn
   */
  public String serviceCrn() {
    return serviceCrn;
  }

  /**
   * Gets the serviceName.
   *
   * The service name (e.g. CertMgr).
   *
   * @return the serviceName
   */
  public String serviceName() {
    return serviceName;
  }

  /**
   * Gets the environmentName.
   *
   * The name of the environment the occurrence applies to.
   *
   * @return the environmentName
   */
  public String environmentName() {
    return environmentName;
  }

  /**
   * Gets the componentName.
   *
   * The name of the component the occurrence applies to.
   *
   * @return the componentName
   */
  public String componentName() {
    return componentName;
  }

  /**
   * Gets the toolchainId.
   *
   * The id of the toolchain the occurrence applies to.
   *
   * @return the toolchainId
   */
  public String toolchainId() {
    return toolchainId;
  }
}

