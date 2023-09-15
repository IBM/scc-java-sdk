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
 * The rule target.
 */
public class Target extends GenericModel {

  @SerializedName("service_name")
  protected String serviceName;
  @SerializedName("service_display_name")
  protected String serviceDisplayName;
  @SerializedName("resource_kind")
  protected String resourceKind;
  @SerializedName("additional_target_attributes")
  protected List<AdditionalTargetAttribute> additionalTargetAttributes;

  protected Target() { }

  /**
   * Gets the serviceName.
   *
   * The target service name.
   *
   * @return the serviceName
   */
  public String getServiceName() {
    return serviceName;
  }

  /**
   * Gets the serviceDisplayName.
   *
   * The display name of the target service.
   *
   * @return the serviceDisplayName
   */
  public String getServiceDisplayName() {
    return serviceDisplayName;
  }

  /**
   * Gets the resourceKind.
   *
   * The target resource kind.
   *
   * @return the resourceKind
   */
  public String getResourceKind() {
    return resourceKind;
  }

  /**
   * Gets the additionalTargetAttributes.
   *
   * The additional target attributes used to filter to a subset of resources.
   *
   * @return the additionalTargetAttributes
   */
  public List<AdditionalTargetAttribute> getAdditionalTargetAttributes() {
    return additionalTargetAttributes;
  }
}

