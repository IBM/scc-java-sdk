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
package com.ibm.cloud.security_and_compliance_center.findings_api.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * KpiType provides details about a KPI note.
 */
public class KpiType extends GenericModel {

  /**
   * The aggregation type of the KPI values.
   * - SUM&amp;#58; A single-value metrics aggregation type that sums up numeric values
   *   that are extracted from KPI occurrences.
   */
  public interface AggregationType {
    /** SUM. */
    String SUM = "SUM";
  }

  @SerializedName("aggregation_type")
  protected String aggregationType;

  /**
   * Builder.
   */
  public static class Builder {
    private String aggregationType;

    private Builder(KpiType kpiType) {
      this.aggregationType = kpiType.aggregationType;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param aggregationType the aggregationType
     */
    public Builder(String aggregationType) {
      this.aggregationType = aggregationType;
    }

    /**
     * Builds a KpiType.
     *
     * @return the new KpiType instance
     */
    public KpiType build() {
      return new KpiType(this);
    }

    /**
     * Set the aggregationType.
     *
     * @param aggregationType the aggregationType
     * @return the KpiType builder
     */
    public Builder aggregationType(String aggregationType) {
      this.aggregationType = aggregationType;
      return this;
    }
  }

  protected KpiType(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.aggregationType,
      "aggregationType cannot be null");
    aggregationType = builder.aggregationType;
  }

  /**
   * New builder.
   *
   * @return a KpiType builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the aggregationType.
   *
   * The aggregation type of the KPI values.
   * - SUM&amp;#58; A single-value metrics aggregation type that sums up numeric values
   *   that are extracted from KPI occurrences.
   *
   * @return the aggregationType
   */
  public String aggregationType() {
    return aggregationType;
  }
}

