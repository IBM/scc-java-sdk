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

import java.util.Map;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * UpdateProviderTypeInstanceRequest.
 *
 * Classes which extend this class:
 * - UpdateProviderTypeInstanceRequestProviderTypeInstancePrototypeForPatchingName
 * - UpdateProviderTypeInstanceRequestProviderTypeInstancePrototypeForPatchingAttributes
 */
public class UpdateProviderTypeInstanceRequest extends GenericModel {

  protected String name;
  protected Map<String, Object> attributes;

  protected UpdateProviderTypeInstanceRequest() { }

  /**
   * Gets the name.
   *
   * The provider type instance name.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the attributes.
   *
   * The attributes for connecting to the provider type instance.
   *
   * @return the attributes
   */
  public Map<String, Object> attributes() {
    return attributes;
  }
}

