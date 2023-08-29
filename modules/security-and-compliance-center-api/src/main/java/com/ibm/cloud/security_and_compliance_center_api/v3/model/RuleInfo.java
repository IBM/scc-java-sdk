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
 * The rule.
 */
public class RuleInfo extends GenericModel {

  protected String id;
  protected String type;
  protected String description;
  protected String version;
  @SerializedName("account_id")
  protected String accountId;
  @SerializedName("created_on")
  protected String createdOn;
  @SerializedName("created_by")
  protected String createdBy;
  @SerializedName("updated_on")
  protected String updatedOn;
  @SerializedName("updated_by")
  protected String updatedBy;
  protected List<String> labels;

  protected RuleInfo() { }

  /**
   * Gets the id.
   *
   * The rule ID.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the type.
   *
   * The rule type.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Gets the description.
   *
   * The rule description.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the version.
   *
   * The rule version.
   *
   * @return the version
   */
  public String getVersion() {
    return version;
  }

  /**
   * Gets the accountId.
   *
   * The rule account ID.
   *
   * @return the accountId
   */
  public String getAccountId() {
    return accountId;
  }

  /**
   * Gets the createdOn.
   *
   * The date when the rule was created.
   *
   * @return the createdOn
   */
  public String getCreatedOn() {
    return createdOn;
  }

  /**
   * Gets the createdBy.
   *
   * The ID of the user who created the rule.
   *
   * @return the createdBy
   */
  public String getCreatedBy() {
    return createdBy;
  }

  /**
   * Gets the updatedOn.
   *
   * The date when the rule was updated.
   *
   * @return the updatedOn
   */
  public String getUpdatedOn() {
    return updatedOn;
  }

  /**
   * Gets the updatedBy.
   *
   * The ID of the user who updated the rule.
   *
   * @return the updatedBy
   */
  public String getUpdatedBy() {
    return updatedBy;
  }

  /**
   * Gets the labels.
   *
   * The rule labels.
   *
   * @return the labels
   */
  public List<String> getLabels() {
    return labels;
  }
}

