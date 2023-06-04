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
package com.ibm.cloud.scc.compliance.v2.model;

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The replaceProfileParameters options.
 */
public class ReplaceProfileParametersOptions extends GenericModel {

  protected String profilesId;
  protected String instanceId;
  protected String id;
  protected List<DefaultParameters> defaultParameters;
  protected String transactionId;

  /**
   * Builder.
   */
  public static class Builder {
    private String profilesId;
    private String instanceId;
    private String id;
    private List<DefaultParameters> defaultParameters;
    private String transactionId;

    /**
     * Instantiates a new Builder from an existing ReplaceProfileParametersOptions instance.
     *
     * @param replaceProfileParametersOptions the instance to initialize the Builder with
     */
    private Builder(ReplaceProfileParametersOptions replaceProfileParametersOptions) {
      this.profilesId = replaceProfileParametersOptions.profilesId;
      this.instanceId = replaceProfileParametersOptions.instanceId;
      this.id = replaceProfileParametersOptions.id;
      this.defaultParameters = replaceProfileParametersOptions.defaultParameters;
      this.transactionId = replaceProfileParametersOptions.transactionId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param profilesId the profilesId
     * @param instanceId the instanceId
     */
    public Builder(String profilesId, String instanceId) {
      this.profilesId = profilesId;
      this.instanceId = instanceId;
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
     * Adds an defaultParameters to defaultParameters.
     *
     * @param defaultParameters the new defaultParameters
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
     * Set the profilesId.
     *
     * @param profilesId the profilesId
     * @return the ReplaceProfileParametersOptions builder
     */
    public Builder profilesId(String profilesId) {
      this.profilesId = profilesId;
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
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the ReplaceProfileParametersOptions builder
     */
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }

    /**
     * Set the profileDefaultParametersResponse.
     *
     * @param profileDefaultParametersResponse the profileDefaultParametersResponse
     * @return the ReplaceProfileParametersOptions builder
     */
    public Builder profileDefaultParametersResponse(ProfileDefaultParametersResponse profileDefaultParametersResponse) {
      this.id = profileDefaultParametersResponse.id();
      this.defaultParameters = profileDefaultParametersResponse.defaultParameters();
      return this;
    }
  }

  protected ReplaceProfileParametersOptions() { }

  protected ReplaceProfileParametersOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.profilesId,
      "profilesId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceId,
      "instanceId cannot be empty");
    profilesId = builder.profilesId;
    instanceId = builder.instanceId;
    id = builder.id;
    defaultParameters = builder.defaultParameters;
    transactionId = builder.transactionId;
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
   * Gets the profilesId.
   *
   * The profile ID.
   *
   * @return the profilesId
   */
  public String profilesId() {
    return profilesId;
  }

  /**
   * Gets the instanceId.
   *
   * Instance id.
   *
   * @return the instanceId
   */
  public String instanceId() {
    return instanceId;
  }

  /**
   * Gets the id.
   *
   * id of parameter.
   *
   * @return the id
   */
  public String id() {
    return id;
  }

  /**
   * Gets the defaultParameters.
   *
   * default parameters.
   *
   * @return the defaultParameters
   */
  public List<DefaultParameters> defaultParameters() {
    return defaultParameters;
  }

  /**
   * Gets the transactionId.
   *
   * The transaction ID for the request in UUID v4 format.
   *
   * @return the transactionId
   */
  public String transactionId() {
    return transactionId;
  }
}

