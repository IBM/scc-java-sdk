/*
 * (C) Copyright IBM Corp. 2025.
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
 * The evaluation target.
 */
public class TargetInfo extends GenericModel {

  protected String id;
  @SerializedName("account_id")
  protected String accountId;
  @SerializedName("service_name")
  protected String serviceName;
  @SerializedName("service_display_name")
  protected String serviceDisplayName;
  @SerializedName("resource_crn")
  protected String resourceCrn;
  @SerializedName("resource_name")
  protected String resourceName;
  protected Tags tags;

  protected TargetInfo() { }

  /**
   * Gets the id.
   *
   * The target ID.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the accountId.
   *
   * The target account ID.
   *
   * @return the accountId
   */
  public String getAccountId() {
    return accountId;
  }

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
   * The target service display name.
   *
   * @return the serviceDisplayName
   */
  public String getServiceDisplayName() {
    return serviceDisplayName;
  }

  /**
   * Gets the resourceCrn.
   *
   * The target resource CRN.
   *
   * @return the resourceCrn
   */
  public String getResourceCrn() {
    return resourceCrn;
  }

  /**
   * Gets the resourceName.
   *
   * The target resource name.
   *
   * @return the resourceName
   */
  public String getResourceName() {
    return resourceName;
  }

  /**
   * Gets the tags.
   *
   * The collection of different types of tags.
   *
   * @return the tags
   */
  public Tags getTags() {
    return tags;
  }
}

