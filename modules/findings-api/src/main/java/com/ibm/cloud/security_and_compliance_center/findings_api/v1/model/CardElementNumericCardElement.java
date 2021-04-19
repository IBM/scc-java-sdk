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

/**
 * A card element with a single numeric value".
 */
public class CardElementNumericCardElement extends CardElement {

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
    private String kind;
    private String defaultTimeRange;
    private NumericCardElementValueType valueType;

    public Builder(CardElement cardElementNumericCardElement) {
      this.text = cardElementNumericCardElement.text;
      this.kind = cardElementNumericCardElement.kind;
      this.defaultTimeRange = cardElementNumericCardElement.defaultTimeRange;
      this.valueType = cardElementNumericCardElement.valueType;
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
     * @param valueType the valueType
     */
    public Builder(String text, String kind, NumericCardElementValueType valueType) {
      this.text = text;
      this.kind = kind;
      this.valueType = valueType;
    }

    /**
     * Builds a CardElementNumericCardElement.
     *
     * @return the new CardElementNumericCardElement instance
     */
    public CardElementNumericCardElement build() {
      return new CardElementNumericCardElement(this);
    }

    /**
     * Set the text.
     *
     * @param text the text
     * @return the CardElementNumericCardElement builder
     */
    public Builder text(String text) {
      this.text = text;
      return this;
    }

    /**
     * Set the kind.
     *
     * @param kind the kind
     * @return the CardElementNumericCardElement builder
     */
    public Builder kind(String kind) {
      this.kind = kind;
      return this;
    }

    /**
     * Set the defaultTimeRange.
     *
     * @param defaultTimeRange the defaultTimeRange
     * @return the CardElementNumericCardElement builder
     */
    public Builder defaultTimeRange(String defaultTimeRange) {
      this.defaultTimeRange = defaultTimeRange;
      return this;
    }

    /**
     * Set the valueType.
     *
     * @param valueType the valueType
     * @return the CardElementNumericCardElement builder
     */
    public Builder valueType(NumericCardElementValueType valueType) {
      this.valueType = valueType;
      return this;
    }
  }

  protected CardElementNumericCardElement(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.text,
      "text cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.kind,
      "kind cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.valueType,
      "valueType cannot be null");
    text = builder.text;
    kind = builder.kind;
    defaultTimeRange = builder.defaultTimeRange;
    valueType = builder.valueType;
  }

  /**
   * New builder.
   *
   * @return a CardElementNumericCardElement builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}

