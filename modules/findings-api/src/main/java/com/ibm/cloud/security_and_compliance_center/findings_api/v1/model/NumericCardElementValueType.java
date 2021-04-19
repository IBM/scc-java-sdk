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
 * NumericCardElementValueType.
 */
public class NumericCardElementValueType extends ValueType {

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
    private List<String> findingNoteNames;

    public Builder(ValueType numericCardElementValueType) {
      this.kind = numericCardElementValueType.kind;
      this.kpiNoteName = numericCardElementValueType.kpiNoteName;
      this.text = numericCardElementValueType.text;
      this.findingNoteNames = numericCardElementValueType.findingNoteNames;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a NumericCardElementValueType.
     *
     * @return the new NumericCardElementValueType instance
     */
    public NumericCardElementValueType build() {
      return new NumericCardElementValueType(this);
    }

    /**
     * Adds an findingNoteNames to findingNoteNames.
     *
     * @param findingNoteNames the new findingNoteNames
     * @return the NumericCardElementValueType builder
     */
    public Builder addFindingNoteNames(String findingNoteNames) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(findingNoteNames,
        "findingNoteNames cannot be null");
      if (this.findingNoteNames == null) {
        this.findingNoteNames = new ArrayList<String>();
      }
      this.findingNoteNames.add(findingNoteNames);
      return this;
    }

    /**
     * Set the kind.
     *
     * @param kind the kind
     * @return the NumericCardElementValueType builder
     */
    public Builder kind(String kind) {
      this.kind = kind;
      return this;
    }

    /**
     * Set the kpiNoteName.
     *
     * @param kpiNoteName the kpiNoteName
     * @return the NumericCardElementValueType builder
     */
    public Builder kpiNoteName(String kpiNoteName) {
      this.kpiNoteName = kpiNoteName;
      return this;
    }

    /**
     * Set the text.
     *
     * @param text the text
     * @return the NumericCardElementValueType builder
     */
    public Builder text(String text) {
      this.text = text;
      return this;
    }

    /**
     * Set the findingNoteNames.
     * Existing findingNoteNames will be replaced.
     *
     * @param findingNoteNames the findingNoteNames
     * @return the NumericCardElementValueType builder
     */
    public Builder findingNoteNames(List<String> findingNoteNames) {
      this.findingNoteNames = findingNoteNames;
      return this;
    }
  }

  protected NumericCardElementValueType(Builder builder) {
    kind = builder.kind;
    kpiNoteName = builder.kpiNoteName;
    text = builder.text;
    findingNoteNames = builder.findingNoteNames;
  }

  /**
   * New builder.
   *
   * @return a NumericCardElementValueType builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}

