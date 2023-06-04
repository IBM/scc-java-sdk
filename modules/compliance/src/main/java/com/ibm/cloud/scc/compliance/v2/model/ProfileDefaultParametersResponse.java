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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The default parameters of a profile.
 */
public class ProfileDefaultParametersResponse extends GenericModel {

  protected String id;
  @SerializedName("default_parameters")
  protected List<DefaultParameters> defaultParameters;

  /**
   * Builder.
   */
  public static class Builder {
    private String id;
    private List<DefaultParameters> defaultParameters;

    /**
     * Instantiates a new Builder from an existing ProfileDefaultParametersResponse instance.
     *
     * @param profileDefaultParametersResponse the instance to initialize the Builder with
     */
    private Builder(ProfileDefaultParametersResponse profileDefaultParametersResponse) {
      this.id = profileDefaultParametersResponse.id;
      this.defaultParameters = profileDefaultParametersResponse.defaultParameters;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ProfileDefaultParametersResponse.
     *
     * @return the new ProfileDefaultParametersResponse instance
     */
    public ProfileDefaultParametersResponse build() {
      return new ProfileDefaultParametersResponse(this);
    }

    /**
     * Adds an defaultParameters to defaultParameters.
     *
     * @param defaultParameters the new defaultParameters
     * @return the ProfileDefaultParametersResponse builder
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
     * Set the id.
     *
     * @param id the id
     * @return the ProfileDefaultParametersResponse builder
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
     * @return the ProfileDefaultParametersResponse builder
     */
    public Builder defaultParameters(List<DefaultParameters> defaultParameters) {
      this.defaultParameters = defaultParameters;
      return this;
    }
  }

  protected ProfileDefaultParametersResponse() { }

  protected ProfileDefaultParametersResponse(Builder builder) {
    id = builder.id;
    defaultParameters = builder.defaultParameters;
  }

  /**
   * New builder.
   *
   * @return a ProfileDefaultParametersResponse builder
   */
  public Builder newBuilder() {
    return new Builder(this);
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
}

