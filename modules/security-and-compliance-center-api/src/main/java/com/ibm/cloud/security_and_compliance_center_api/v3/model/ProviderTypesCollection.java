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

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The provider types collection.
 */
public class ProviderTypesCollection extends GenericModel {

  @SerializedName("provider_types")
  protected List<ProviderTypeItem> providerTypes;

  protected ProviderTypesCollection() { }

  /**
   * Gets the providerTypes.
   *
   * The array of provder type.
   *
   * @return the providerTypes
   */
  public List<ProviderTypeItem> getProviderTypes() {
    return providerTypes;
  }
}
