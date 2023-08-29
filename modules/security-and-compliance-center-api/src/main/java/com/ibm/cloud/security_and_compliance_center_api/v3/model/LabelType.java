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
 * The label that is associated with the provider type.
 */
public class LabelType extends GenericModel {

  protected String text;
  protected String tip;

  protected LabelType() { }

  /**
   * Gets the text.
   *
   * The text of the label.
   *
   * @return the text
   */
  public String getText() {
    return text;
  }

  /**
   * Gets the tip.
   *
   * The text to be shown when user hover overs the label.
   *
   * @return the tip
   */
  public String getTip() {
    return tip;
  }
}

