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
package com.ibm.cloud.scc.findings.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Kpi provides details about a KPI occurrence.
 */
public class Kpi extends GenericModel {

  protected Double value;
  protected Double total;

  /**
   * Builder.
   */
  public static class Builder {
    private Double value;
    private Double total;

    private Builder(Kpi kpi) {
      this.value = kpi.value;
      this.total = kpi.total;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param value the value
     */
    public Builder(Double value) {
      this.value = value;
    }

    /**
     * Builds a Kpi.
     *
     * @return the new Kpi instance
     */
    public Kpi build() {
      return new Kpi(this);
    }

    /**
     * Set the value.
     *
     * @param value the value
     * @return the Kpi builder
     */
    public Builder value(Double value) {
      this.value = value;
      return this;
    }

    /**
     * Set the total.
     *
     * @param total the total
     * @return the Kpi builder
     */
    public Builder total(Double total) {
      this.total = total;
      return this;
    }
  }

  protected Kpi(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.value,
      "value cannot be null");
    value = builder.value;
    total = builder.total;
  }

  /**
   * New builder.
   *
   * @return a Kpi builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the value.
   *
   * The value of this KPI.
   *
   * @return the value
   */
  public Double value() {
    return value;
  }

  /**
   * Gets the total.
   *
   * The total value of this KPI.
   *
   * @return the total
   */
  public Double total() {
    return total;
  }
}

