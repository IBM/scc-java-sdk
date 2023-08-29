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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The properties supported for scoping by this environment.
 */
public class PropertyItem extends GenericModel {

  protected String name;
  protected String value;

  /**
   * Builder.
   */
  public static class Builder {
    private String name;
    private String value;

    /**
     * Instantiates a new Builder from an existing PropertyItem instance.
     *
     * @param propertyItem the instance to initialize the Builder with
     */
    private Builder(PropertyItem propertyItem) {
      this.name = propertyItem.name;
      this.value = propertyItem.value;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a PropertyItem.
     *
     * @return the new PropertyItem instance
     */
    public PropertyItem build() {
      return new PropertyItem(this);
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the PropertyItem builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the value.
     *
     * @param value the value
     * @return the PropertyItem builder
     */
    public Builder value(String value) {
      this.value = value;
      return this;
    }
  }

  protected PropertyItem() { }

  protected PropertyItem(Builder builder) {
    name = builder.name;
    value = builder.value;
  }

  /**
   * New builder.
   *
   * @return a PropertyItem builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the name.
   *
   * The name of the property.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the value.
   *
   * The value of the property.
   *
   * @return the value
   */
  public String value() {
    return value;
  }
}

