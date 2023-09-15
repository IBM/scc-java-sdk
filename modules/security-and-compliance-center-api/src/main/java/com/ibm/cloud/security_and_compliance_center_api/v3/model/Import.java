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
 * The collection of import parameters.
 */
public class Import extends GenericModel {

  protected List<Parameter> parameters;

  /**
   * Builder.
   */
  public static class Builder {
    private List<Parameter> parameters;

    /**
     * Instantiates a new Builder from an existing Import instance.
     *
     * @param xImport the instance to initialize the Builder with
     */
    private Builder(Import xImport) {
      this.parameters = xImport.parameters;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a Import.
     *
     * @return the new Import instance
     */
    public Import build() {
      return new Import(this);
    }

    /**
     * Adds an parameters to parameters.
     *
     * @param parameters the new parameters
     * @return the Import builder
     */
    public Builder addParameters(Parameter parameters) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(parameters,
        "parameters cannot be null");
      if (this.parameters == null) {
        this.parameters = new ArrayList<Parameter>();
      }
      this.parameters.add(parameters);
      return this;
    }

    /**
     * Set the parameters.
     * Existing parameters will be replaced.
     *
     * @param parameters the parameters
     * @return the Import builder
     */
    public Builder parameters(List<Parameter> parameters) {
      this.parameters = parameters;
      return this;
    }
  }

  protected Import() { }

  protected Import(Builder builder) {
    parameters = builder.parameters;
  }

  /**
   * New builder.
   *
   * @return a Import builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the parameters.
   *
   * The list of import parameters.
   *
   * @return the parameters
   */
  public List<Parameter> parameters() {
    return parameters;
  }
}

