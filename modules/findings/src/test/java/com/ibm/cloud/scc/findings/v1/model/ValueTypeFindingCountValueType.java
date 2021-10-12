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

import java.util.ArrayList;
import java.util.List;

/**
 * ValueTypeFindingCountValueType.
 */
public class ValueTypeFindingCountValueType extends ValueType {

  /**
   * Kind of element - FINDING_COUNT&amp;#58; Kind of value derived from a count of finding occurrences.
   */
  public interface Kind {
    /** FINDING_COUNT. */
    String FINDING_COUNT = "FINDING_COUNT";
  }


  /**
   * Builder.
   */
  public static class Builder {
    private String kind;
    private List<String> findingNoteNames;
    private String text;

    public Builder(ValueType valueTypeFindingCountValueType) {
      this.kind = valueTypeFindingCountValueType.kind;
      this.findingNoteNames = valueTypeFindingCountValueType.findingNoteNames;
      this.text = valueTypeFindingCountValueType.text;
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
     * @param findingNoteNames the findingNoteNames
     * @param text the text
     */
    public Builder(String kind, List<String> findingNoteNames, String text) {
      this.kind = kind;
      this.findingNoteNames = findingNoteNames;
      this.text = text;
    }

    /**
     * Builds a ValueTypeFindingCountValueType.
     *
     * @return the new ValueTypeFindingCountValueType instance
     */
    public ValueTypeFindingCountValueType build() {
      return new ValueTypeFindingCountValueType(this);
    }

    /**
     * Adds an findingNoteNames to findingNoteNames.
     *
     * @param findingNoteNames the new findingNoteNames
     * @return the ValueTypeFindingCountValueType builder
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
     * @return the ValueTypeFindingCountValueType builder
     */
    public Builder kind(String kind) {
      this.kind = kind;
      return this;
    }

    /**
     * Set the findingNoteNames.
     * Existing findingNoteNames will be replaced.
     *
     * @param findingNoteNames the findingNoteNames
     * @return the ValueTypeFindingCountValueType builder
     */
    public Builder findingNoteNames(List<String> findingNoteNames) {
      this.findingNoteNames = findingNoteNames;
      return this;
    }

    /**
     * Set the text.
     *
     * @param text the text
     * @return the ValueTypeFindingCountValueType builder
     */
    public Builder text(String text) {
      this.text = text;
      return this;
    }
  }

  protected ValueTypeFindingCountValueType(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.kind,
      "kind cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.findingNoteNames,
      "findingNoteNames cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.text,
      "text cannot be null");
    kind = builder.kind;
    findingNoteNames = builder.findingNoteNames;
    text = builder.text;
  }

  /**
   * New builder.
   *
   * @return a ValueTypeFindingCountValueType builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }
}

