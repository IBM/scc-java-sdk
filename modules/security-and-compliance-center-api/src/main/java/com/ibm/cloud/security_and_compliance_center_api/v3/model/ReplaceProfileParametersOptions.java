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
 * The replaceProfileParameters options.
 */
public class ReplaceProfileParametersOptions extends GenericModel {

  protected String instanceId;
  protected String profileId;
  protected List<DefaultParameters> defaultParameters;
  protected String id;
  protected String accountId;

  /**
   * Builder.
   */
  public static class Builder {
    private String instanceId;
    private String profileId;
    private List<DefaultParameters> defaultParameters;
    private String id;
    private String accountId;

    /**
     * Instantiates a new Builder from an existing ReplaceProfileParametersOptions instance.
     *
     * @param replaceProfileParametersOptions the instance to initialize the Builder with
     */
    private Builder(ReplaceProfileParametersOptions replaceProfileParametersOptions) {
      this.instanceId = replaceProfileParametersOptions.instanceId;
      this.profileId = replaceProfileParametersOptions.profileId;
      this.defaultParameters = replaceProfileParametersOptions.defaultParameters;
      this.id = replaceProfileParametersOptions.id;
      this.accountId = replaceProfileParametersOptions.accountId;
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
     * @param defaultParameters the defaultParameters
     */
    public Builder(String instanceId, String profileId, List<DefaultParameters> defaultParameters) {
      this.instanceId = instanceId;
      this.profileId = profileId;
      this.defaultParameters = defaultParameters;
    }

    /**
     * Builds a ReplaceProfileParametersOptions.
     *
     * @return the new ReplaceProfileParametersOptions instance
     */
    public ReplaceProfileParametersOptions build() {
      return new ReplaceProfileParametersOptions(this);
    }

    /**
     * Adds a new element to defaultParameters.
     *
     * @param defaultParameters the new element to be added
     * @return the ReplaceProfileParametersOptions builder
     */
    public Builder addDefaultParameters(DefaultParameters defaultParameters) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(defaultParameters,
        "defaultParameters cannot be null");
      if (this.defaultParameters == null) {
        this.defaultParameters = new ArrayList<DefaultParameters>();
      }
      this.defaultParameters.add(defaultParameters);
      return this;
    }

    /**
     * Set the instanceId.
     *
     * @param instanceId the instanceId
     * @return the ReplaceProfileParametersOptions builder
     */
    public Builder instanceId(String instanceId) {
      this.instanceId = instanceId;
      return this;
    }

    /**
     * Set the profileId.
     *
     * @param profileId the profileId
     * @return the ReplaceProfileParametersOptions builder
     */
    public Builder profileId(String profileId) {
      this.profileId = profileId;
      return this;
    }

    /**
     * Set the defaultParameters.
     * Existing defaultParameters will be replaced.
     *
     * @param defaultParameters the defaultParameters
     * @return the ReplaceProfileParametersOptions builder
     */
    public Builder defaultParameters(List<DefaultParameters> defaultParameters) {
      this.defaultParameters = defaultParameters;
      return this;
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the ReplaceProfileParametersOptions builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the ReplaceProfileParametersOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the profileDefaultParametersResponse.
     *
     * @param profileDefaultParametersResponse the profileDefaultParametersResponse
     * @return the ReplaceProfileParametersOptions builder
     */
    public Builder profileDefaultParametersResponse(ProfileDefaultParametersResponse profileDefaultParametersResponse) {
      this.defaultParameters = profileDefaultParametersResponse.defaultParameters();
      this.id = profileDefaultParametersResponse.id();
      return this;
    }
  }

  protected ReplaceProfileParametersOptions() { }

  protected ReplaceProfileParametersOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceId,
      "instanceId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.profileId,
      "profileId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.defaultParameters,
      "defaultParameters cannot be null");
    instanceId = builder.instanceId;
    profileId = builder.profileId;
    defaultParameters = builder.defaultParameters;
    id = builder.id;
    accountId = builder.accountId;
  }

  /**
   * New builder.
   *
   * @return a ReplaceProfileParametersOptions builder
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

  /**
   * Gets the defaultParameters.
   *
   * list of parameters given by default.
   *
   * @return the defaultParameters
   */
  public List<DefaultParameters> defaultParameters() {
    return defaultParameters;
  }

  /**
   * Gets the id.
   *
   * The ID of the Profile.
   *
   * @return the id
   */
  public String id() {
    return id;
  }

  /**
   * Gets the accountId.
   *
   * The user account ID.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }
}

