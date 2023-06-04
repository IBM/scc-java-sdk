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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The parameters details.
 */
public class ParameterInfo extends GenericModel {

  /**
   * Parameter Type.
   */
  public interface ParameterType {
    /** numeric. */
    String NUMERIC = "numeric";
    /** string_list. */
    String STRING_LIST = "string_list";
  }

  @SerializedName("parameter_name")
  protected String parameterName;
  @SerializedName("parameter_display_name")
  protected String parameterDisplayName;
  @SerializedName("parameter_type")
  protected String parameterType;

  /**
   * Builder.
   */
  public static class Builder {
    private String parameterName;
    private String parameterDisplayName;
    private String parameterType;

    /**
     * Instantiates a new Builder from an existing ParameterInfo instance.
     *
     * @param parameterInfo the instance to initialize the Builder with
     */
    private Builder(ParameterInfo parameterInfo) {
      this.parameterName = parameterInfo.parameterName;
      this.parameterDisplayName = parameterInfo.parameterDisplayName;
      this.parameterType = parameterInfo.parameterType;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ParameterInfo.
     *
     * @return the new ParameterInfo instance
     */
    public ParameterInfo build() {
      return new ParameterInfo(this);
    }

    /**
     * Set the parameterName.
     *
     * @param parameterName the parameterName
     * @return the ParameterInfo builder
     */
    public Builder parameterName(String parameterName) {
      this.parameterName = parameterName;
      return this;
    }

    /**
     * Set the parameterDisplayName.
     *
     * @param parameterDisplayName the parameterDisplayName
     * @return the ParameterInfo builder
     */
    public Builder parameterDisplayName(String parameterDisplayName) {
      this.parameterDisplayName = parameterDisplayName;
      return this;
    }

    /**
     * Set the parameterType.
     *
     * @param parameterType the parameterType
     * @return the ParameterInfo builder
     */
    public Builder parameterType(String parameterType) {
      this.parameterType = parameterType;
      return this;
    }
  }

  protected ParameterInfo() { }

  protected ParameterInfo(Builder builder) {
    parameterName = builder.parameterName;
    parameterDisplayName = builder.parameterDisplayName;
    parameterType = builder.parameterType;
  }

  /**
   * New builder.
   *
   * @return a ParameterInfo builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the parameterName.
   *
   * Parameter Name.
   *
   * @return the parameterName
   */
  public String parameterName() {
    return parameterName;
  }

  /**
   * Gets the parameterDisplayName.
   *
   * Parameter Display Name.
   *
   * @return the parameterDisplayName
   */
  public String parameterDisplayName() {
    return parameterDisplayName;
  }

  /**
   * Gets the parameterType.
   *
   * Parameter Type.
   *
   * @return the parameterType
   */
  public String parameterType() {
    return parameterType;
  }
}

