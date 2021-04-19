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

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * the value type of a card element.
 *
 * Classes which extend this class:
 * - ValueTypeKpiValueType
 * - ValueTypeFindingCountValueType
 */
public class ValueType extends GenericModel {
  @SuppressWarnings("unused")
  protected static String discriminatorPropertyName = "kind";
  protected static java.util.Map<String, Class<?>> discriminatorMapping;
  static {
    discriminatorMapping = new java.util.HashMap<>();
    discriminatorMapping.put("KPI", ValueTypeKpiValueType.class);
    discriminatorMapping.put("FINDING_COUNT", ValueTypeFindingCountValueType.class);
  }

  /**
   * Kind of element
   * - KPI&amp;#58; Kind of value derived from a KPI occurrence.
   */
  public interface Kind {
    /** KPI. */
    String KPI = "KPI";
  }

  protected String kind;
  @SerializedName("kpi_note_name")
  protected String kpiNoteName;
  protected String text;
  @SerializedName("finding_note_names")
  protected List<String> findingNoteNames;

  protected ValueType() {
  }

  /**
   * Gets the kind.
   *
   * Kind of element
   * - KPI&amp;#58; Kind of value derived from a KPI occurrence.
   *
   * @return the kind
   */
  public String kind() {
    return kind;
  }

  /**
   * Gets the kpiNoteName.
   *
   * The name of the kpi note associated to the occurrence with the value for this card element value type.
   *
   * @return the kpiNoteName
   */
  public String kpiNoteName() {
    return kpiNoteName;
  }

  /**
   * Gets the text.
   *
   * The text of this element type.
   *
   * @return the text
   */
  public String text() {
    return text;
  }

  /**
   * Gets the findingNoteNames.
   *
   * the names of the finding note associated that act as filters for counting the occurrences.
   *
   * @return the findingNoteNames
   */
  public List<String> findingNoteNames() {
    return findingNoteNames;
  }
}

