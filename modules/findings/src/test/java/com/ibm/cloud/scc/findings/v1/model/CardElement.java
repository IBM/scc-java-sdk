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

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * CardElement provides details about the elements of a Card.
 *
 * Classes which extend this class:
 * - CardElementNumericCardElement
 * - CardElementBreakdownCardElement
 * - CardElementTimeSeriesCardElement
 */
public class CardElement extends GenericModel {
  @SuppressWarnings("unused")
  protected static String discriminatorPropertyName = "kind";
  protected static java.util.Map<String, Class<?>> discriminatorMapping;
  static {
    discriminatorMapping = new java.util.HashMap<>();
    discriminatorMapping.put("NUMERIC", CardElementNumericCardElement.class);
    discriminatorMapping.put("BREAKDOWN", CardElementBreakdownCardElement.class);
    discriminatorMapping.put("TIME_SERIES", CardElementTimeSeriesCardElement.class);
  }

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

  protected String text;
  protected String kind;
  @SerializedName("default_time_range")
  protected String defaultTimeRange;
  @SerializedName("value_type")
  protected NumericCardElementValueType valueType;
  @SerializedName("value_types")
  protected List<ValueType> valueTypes;
  @SerializedName("default_interval")
  protected String defaultInterval;

  protected CardElement() {
  }

  /**
   * Gets the text.
   *
   * The text of this card element.
   *
   * @return the text
   */
  public String text() {
    return text;
  }

  /**
   * Gets the kind.
   *
   * Kind of element
   * - NUMERIC&amp;#58; Single numeric value
   * - BREAKDOWN&amp;#58; Breakdown of numeric values
   * - TIME_SERIES&amp;#58; Time-series of numeric values.
   *
   * @return the kind
   */
  public String kind() {
    return kind;
  }

  /**
   * Gets the defaultTimeRange.
   *
   * The default time range of this card element.
   *
   * @return the defaultTimeRange
   */
  public String defaultTimeRange() {
    return defaultTimeRange;
  }

  /**
   * Gets the valueType.
   *
   * @return the valueType
   */
  public NumericCardElementValueType valueType() {
    return valueType;
  }

  /**
   * Gets the valueTypes.
   *
   * the value types associated to this card element.
   *
   * @return the valueTypes
   */
  public List<ValueType> valueTypes() {
    return valueTypes;
  }

  /**
   * Gets the defaultInterval.
   *
   * The default interval of the time series.
   *
   * @return the defaultInterval
   */
  public String defaultInterval() {
    return defaultInterval;
  }
}

