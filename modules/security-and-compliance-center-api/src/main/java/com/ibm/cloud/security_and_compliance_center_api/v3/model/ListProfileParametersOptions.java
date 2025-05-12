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
 * The listProfileParameters options.
 */
public class ListProfileParametersOptions extends GenericModel {

  protected String instanceId;
  protected String profileId;

  /**
   * Builder.
   */
  public static class Builder {
    private String instanceId;
    private String profileId;

    /**
     * Instantiates a new Builder from an existing ListProfileParametersOptions instance.
     *
     * @param listProfileParametersOptions the instance to initialize the Builder with
     */
    private Builder(ListProfileParametersOptions listProfileParametersOptions) {
      this.instanceId = listProfileParametersOptions.instanceId;
      this.profileId = listProfileParametersOptions.profileId;
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
     * @param profileId the profileId
     */
    public Builder(String instanceId, String profileId) {
      this.instanceId = instanceId;
      this.profileId = profileId;
    }

    /**
     * Builds a ListProfileParametersOptions.
     *
     * @return the new ListProfileParametersOptions instance
     */
    public ListProfileParametersOptions build() {
      return new ListProfileParametersOptions(this);
    }

    /**
     * Set the instanceId.
     *
     * @param instanceId the instanceId
     * @return the ListProfileParametersOptions builder
     */
    public Builder instanceId(String instanceId) {
      this.instanceId = instanceId;
      return this;
    }

    /**
     * Set the profileId.
     *
     * @param profileId the profileId
     * @return the ListProfileParametersOptions builder
     */
    public Builder profileId(String profileId) {
      this.profileId = profileId;
      return this;
    }
  }

  protected ListProfileParametersOptions() { }

  protected ListProfileParametersOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceId,
      "instanceId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.profileId,
      "profileId cannot be empty");
    instanceId = builder.instanceId;
    profileId = builder.profileId;
  }

  /**
   * New builder.
   *
   * @return a ListProfileParametersOptions builder
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
   * Gets the profileId.
   *
   * The profile ID.
   *
   * @return the profileId
   */
  public String profileId() {
    return profileId;
  }
}

