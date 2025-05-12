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
 * The getService options.
 */
public class GetServiceOptions extends GenericModel {

  protected String servicesName;

  /**
   * Builder.
   */
  public static class Builder {
    private String servicesName;

    /**
     * Instantiates a new Builder from an existing GetServiceOptions instance.
     *
     * @param getServiceOptions the instance to initialize the Builder with
     */
    private Builder(GetServiceOptions getServiceOptions) {
      this.servicesName = getServiceOptions.servicesName;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param servicesName the servicesName
     */
    public Builder(String servicesName) {
      this.servicesName = servicesName;
    }

    /**
     * Builds a GetServiceOptions.
     *
     * @return the new GetServiceOptions instance
     */
    public GetServiceOptions build() {
      return new GetServiceOptions(this);
    }

    /**
     * Set the servicesName.
     *
     * @param servicesName the servicesName
     * @return the GetServiceOptions builder
     */
    public Builder servicesName(String servicesName) {
      this.servicesName = servicesName;
      return this;
    }
  }

  protected GetServiceOptions() { }

  protected GetServiceOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.servicesName,
      "servicesName cannot be empty");
    servicesName = builder.servicesName;
  }

  /**
   * New builder.
   *
   * @return a GetServiceOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the servicesName.
   *
   * The name of the corresponding service.
   *
   * @return the servicesName
   */
  public String servicesName() {
    return servicesName;
  }
}

