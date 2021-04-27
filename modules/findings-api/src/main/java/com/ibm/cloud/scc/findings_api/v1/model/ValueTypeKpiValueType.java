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
package com.ibm.cloud.scc.findings_api.v1.model;

/**
 * ValueTypeKpiValueType.
 */
public class ValueTypeKpiValueType extends ValueType {

  /**
   * Kind of element
   * - KPI&amp;#58; Kind of value derived from a KPI occurrence.
   */
  public interface Kind {
    /** KPI. */
    String KPI = "KPI";
  }


  /**
   * Builder.
   */
  public static class Builder {
    private String kind;
    private String kpiNoteName;
    private String text;

    public Builder(ValueType valueTypeKpiValueType) {
      this.kind = valueTypeKpiValueType.kind;
      this.kpiNoteName = valueTypeKpiValueType.kpiNoteName;
      this.text = valueTypeKpiValueType.text;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param kind the kind
     * @param kpiNoteName the kpiNoteName
     * @param text the text
     */
    public Builder(String kind, String kpiNoteName, String text) {
      this.kind = kind;
      this.kpiNoteName = kpiNoteName;
      this.text = text;
    }

    /**
     * Builds a ValueTypeKpiValueType.
     *
     * @return the new ValueTypeKpiValueType instance
     */
    public ValueTypeKpiValueType build() {
      return new ValueTypeKpiValueType(this);
    }

    /**
     * Set the kind.
     *
     * @param kind the kind
     * @return the ValueTypeKpiValueType builder
     */
    public Builder kind(String kind) {
      this.kind = kind;
      return this;
    }

    /**
     * Set the kpiNoteName.
     *
     * @param kpiNoteName the kpiNoteName
     * @return the ValueTypeKpiValueType builder
     */
    public Builder kpiNoteName(String kpiNoteName) {
      this.kpiNoteName = kpiNoteName;
      return this;
    }

    /**
     * Set the text.
     *
     * @param text the text
     * @return the ValueTypeKpiValueType builder
     */
    public Builder text(String text) {
      this.text = text;
      return this;
    }
  }

  protected ValueTypeKpiValueType(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.kind,
      "kind cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.kpiNoteName,
      "kpiNoteName cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.text,
      "text cannot be null");
    kind = builder.kind;
    kpiNoteName = builder.kpiNoteName;
    text = builder.text;
  }

  /**
   * New builder.
   *
   * @return a ValueTypeKpiValueType builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}

