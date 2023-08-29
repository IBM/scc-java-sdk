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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * AdditionalProperty.
 */
public class AdditionalProperty extends GenericModel {

  /**
   * An additional property that indicates the type of the attribute in various formats (text, url, secret, label,
   * masked).
   */
  public interface Type {
    /** secret. */
    String SECRET = "secret";
    /** label. */
    String LABEL = "label";
    /** url. */
    String URL = "url";
    /** text. */
    String TEXT = "text";
    /** masked. */
    String MASKED = "masked";
  }

  protected String type;
  @SerializedName("display_name")
  protected String displayName;

  protected AdditionalProperty() { }

  /**
   * Gets the type.
   *
   * An additional property that indicates the type of the attribute in various formats (text, url, secret, label,
   * masked).
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Gets the displayName.
   *
   * The name of the attribute that is displayed in the UI.
   *
   * @return the displayName
   */
  public String getDisplayName() {
    return displayName;
  }
}

