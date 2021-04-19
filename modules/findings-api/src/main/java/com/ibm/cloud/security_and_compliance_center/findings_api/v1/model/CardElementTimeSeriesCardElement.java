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

import java.util.ArrayList;
import java.util.List;

/**
 * A card element with a time series chart.
 */
public class CardElementTimeSeriesCardElement extends CardElement {

  /**
   * Kind of element
   * - NUMERIC&amp;#58; Single numeric value
   * - BREAKDOWN&amp;#58; Breakdown of numeric values
   * - TIME_SERIES&amp;#58; Time-series of numeric values.
   */
  public interface Kind {
    /** NUMERIC. */
    String NUMERIC = "NUMERIC";
    /** BREAKDOWN. */
    String BREAKDOWN = "BREAKDOWN";
    /** TIME_SERIES. */
    String TIME_SERIES = "TIME_SERIES";
  }


  /**
   * Builder.
   */
  public static class Builder {
    private String text;
    private String defaultInterval;
    private String kind;
    private String defaultTimeRange;
    private List<ValueType> valueTypes;

    public Builder(CardElement cardElementTimeSeriesCardElement) {
      this.text = cardElementTimeSeriesCardElement.text;
      this.defaultInterval = cardElementTimeSeriesCardElement.defaultInterval;
      this.kind = cardElementTimeSeriesCardElement.kind;
      this.defaultTimeRange = cardElementTimeSeriesCardElement.defaultTimeRange;
      this.valueTypes = cardElementTimeSeriesCardElement.valueTypes;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param text the text
     * @param kind the kind
     * @param valueTypes the valueTypes
     */
    public Builder(String text, String kind, List<ValueType> valueTypes) {
      this.text = text;
      this.kind = kind;
      this.valueTypes = valueTypes;
    }

    /**
     * Builds a CardElementTimeSeriesCardElement.
     *
     * @return the new CardElementTimeSeriesCardElement instance
     */
    public CardElementTimeSeriesCardElement build() {
      return new CardElementTimeSeriesCardElement(this);
    }

    /**
     * Adds an valueTypes to valueTypes.
     *
     * @param valueTypes the new valueTypes
     * @return the CardElementTimeSeriesCardElement builder
     */
    public Builder addValueTypes(ValueType valueTypes) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(valueTypes,
        "valueTypes cannot be null");
      if (this.valueTypes == null) {
        this.valueTypes = new ArrayList<ValueType>();
      }
      this.valueTypes.add(valueTypes);
      return this;
    }

    /**
     * Set the text.
     *
     * @param text the text
     * @return the CardElementTimeSeriesCardElement builder
     */
    public Builder text(String text) {
      this.text = text;
      return this;
    }

    /**
     * Set the defaultInterval.
     *
     * @param defaultInterval the defaultInterval
     * @return the CardElementTimeSeriesCardElement builder
     */
    public Builder defaultInterval(String defaultInterval) {
      this.defaultInterval = defaultInterval;
      return this;
    }

    /**
     * Set the kind.
     *
     * @param kind the kind
     * @return the CardElementTimeSeriesCardElement builder
     */
    public Builder kind(String kind) {
      this.kind = kind;
      return this;
    }

    /**
     * Set the defaultTimeRange.
     *
     * @param defaultTimeRange the defaultTimeRange
     * @return the CardElementTimeSeriesCardElement builder
     */
    public Builder defaultTimeRange(String defaultTimeRange) {
      this.defaultTimeRange = defaultTimeRange;
      return this;
    }

    /**
     * Set the valueTypes.
     * Existing valueTypes will be replaced.
     *
     * @param valueTypes the valueTypes
     * @return the CardElementTimeSeriesCardElement builder
     */
    public Builder valueTypes(List<ValueType> valueTypes) {
      this.valueTypes = valueTypes;
      return this;
    }
  }

  protected CardElementTimeSeriesCardElement(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.text,
      "text cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.kind,
      "kind cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.valueTypes,
      "valueTypes cannot be null");
    text = builder.text;
    defaultInterval = builder.defaultInterval;
    kind = builder.kind;
    defaultTimeRange = builder.defaultTimeRange;
    valueTypes = builder.valueTypes;
  }

  /**
   * New builder.
   *
   * @return a CardElementTimeSeriesCardElement builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}

