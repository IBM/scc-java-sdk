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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The rule import parameter.
 */
public class RuleParameter extends GenericModel {

  /**
   * The property type.
   */
  public interface Type {
    /** string. */
    String STRING = "string";
    /** numeric. */
    String NUMERIC = "numeric";
    /** general. */
    String GENERAL = "general";
    /** boolean. */
    String X_BOOLEAN = "boolean";
    /** string_list. */
    String STRING_LIST = "string_list";
    /** ip_list. */
    String IP_LIST = "ip_list";
    /** timestamp. */
    String TIMESTAMP = "timestamp";
  }

  protected String name;
  @SerializedName("display_name")
  protected String displayName;
  protected String description;
  protected String type;

  /**
   * Builder.
   */
  public static class Builder {
    private String name;
    private String displayName;
    private String description;
    private String type;

    /**
     * Instantiates a new Builder from an existing RuleParameter instance.
     *
     * @param ruleParameter the instance to initialize the Builder with
     */
    private Builder(RuleParameter ruleParameter) {
      this.name = ruleParameter.name;
      this.displayName = ruleParameter.displayName;
      this.description = ruleParameter.description;
      this.type = ruleParameter.type;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param type the type
     */
    public Builder(String type) {
      this.type = type;
    }

    /**
     * Builds a RuleParameter.
     *
     * @return the new RuleParameter instance
     */
    public RuleParameter build() {
      return new RuleParameter(this);
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the RuleParameter builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the displayName.
     *
     * @param displayName the displayName
     * @return the RuleParameter builder
     */
    public Builder displayName(String displayName) {
      this.displayName = displayName;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the RuleParameter builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the RuleParameter builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }
  }

  protected RuleParameter() { }

  protected RuleParameter(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.type,
      "type cannot be null");
    name = builder.name;
    displayName = builder.displayName;
    description = builder.description;
    type = builder.type;
  }

  /**
   * New builder.
   *
   * @return a RuleParameter builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the name.
   *
   * The import parameter name.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the displayName.
   *
   * The display name of the property.
   *
   * @return the displayName
   */
  public String displayName() {
    return displayName;
  }

  /**
   * Gets the description.
   *
   * The propery description.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the type.
   *
   * The property type.
   *
   * @return the type
   */
  public String type() {
    return type;
  }
}

