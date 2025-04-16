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

import java.util.Date;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The group of resources that you want to evaluate. In the new API-based architecture, a scope can be an Enterprise,
 * Account group, Account, or Resource group.
 */
public class Scope extends GenericModel {

  protected String id;
  protected String name;
  protected String description;
  protected String environment;
  @SerializedName("properties")
  protected List<ScopeProperty> xProperties;
  @SerializedName("account_id")
  protected String accountId;
  @SerializedName("instance_id")
  protected String instanceId;
  @SerializedName("created_by")
  protected String createdBy;
  @SerializedName("created_on")
  protected Date createdOn;
  @SerializedName("updated_by")
  protected String updatedBy;
  @SerializedName("updated_on")
  protected Date updatedOn;
  @SerializedName("attachment_count")
  protected Double attachmentCount;

  protected Scope() { }

  /**
   * Gets the id.
   *
   * The ID of the scope.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the name.
   *
   * The scope name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the description.
   *
   * The scope description.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the environment.
   *
   * The scope environment. This value details what cloud provider the scope targets.
   *
   * @return the environment
   */
  public String getEnvironment() {
    return environment;
  }

  /**
   * Gets the xProperties.
   *
   * The properties that are supported for scoping by this environment.
   *
   * @return the xProperties
   */
  public List<ScopeProperty> getXProperties() {
    return xProperties;
  }

  /**
   * Gets the accountId.
   *
   * The ID of the account associated with the scope.
   *
   * @return the accountId
   */
  public String getAccountId() {
    return accountId;
  }

  /**
   * Gets the instanceId.
   *
   * The ID of the instance associated with the scope.
   *
   * @return the instanceId
   */
  public String getInstanceId() {
    return instanceId;
  }

  /**
   * Gets the createdBy.
   *
   * The identifier of the account or service ID who created the scope.
   *
   * @return the createdBy
   */
  public String getCreatedBy() {
    return createdBy;
  }

  /**
   * Gets the createdOn.
   *
   * The date when the scope was created.
   *
   * @return the createdOn
   */
  public Date getCreatedOn() {
    return createdOn;
  }

  /**
   * Gets the updatedBy.
   *
   * The ID of the user or service ID who updated the scope.
   *
   * @return the updatedBy
   */
  public String getUpdatedBy() {
    return updatedBy;
  }

  /**
   * Gets the updatedOn.
   *
   * The date when the scope was updated.
   *
   * @return the updatedOn
   */
  public Date getUpdatedOn() {
    return updatedOn;
  }

  /**
   * Gets the attachmentCount.
   *
   * The number of attachments tied to the scope.
   *
   * @return the attachmentCount
   */
  public Double getAttachmentCount() {
    return attachmentCount;
  }
}

