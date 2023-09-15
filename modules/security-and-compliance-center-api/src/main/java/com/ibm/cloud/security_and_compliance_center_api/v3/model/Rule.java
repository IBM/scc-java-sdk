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

import java.util.Date;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The rule response that corresponds to an account instance.
 */
public class Rule extends GenericModel {

  /**
   * The rule type (allowable values are `user_defined` or `system_defined`).
   */
  public interface Type {
    /** user_defined. */
    String USER_DEFINED = "user_defined";
    /** system_defined. */
    String SYSTEM_DEFINED = "system_defined";
  }

  @SerializedName("created_on")
  protected Date createdOn;
  @SerializedName("created_by")
  protected String createdBy;
  @SerializedName("updated_on")
  protected Date updatedOn;
  @SerializedName("updated_by")
  protected String updatedBy;
  protected String id;
  @SerializedName("account_id")
  protected String accountId;
  protected String description;
  protected String type;
  protected String version;
  @SerializedName("import")
  protected Import xImport;
  protected Target target;
  @SerializedName("required_config")
  protected RequiredConfig requiredConfig;
  protected List<String> labels;

  protected Rule() { }

  /**
   * Gets the createdOn.
   *
   * The date when the rule was created.
   *
   * @return the createdOn
   */
  public Date getCreatedOn() {
    return createdOn;
  }

  /**
   * Gets the createdBy.
   *
   * The user who created the rule.
   *
   * @return the createdBy
   */
  public String getCreatedBy() {
    return createdBy;
  }

  /**
   * Gets the updatedOn.
   *
   * The date when the rule was modified.
   *
   * @return the updatedOn
   */
  public Date getUpdatedOn() {
    return updatedOn;
  }

  /**
   * Gets the updatedBy.
   *
   * The user who modified the rule.
   *
   * @return the updatedBy
   */
  public String getUpdatedBy() {
    return updatedBy;
  }

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
   * Gets the accountId.
   *
   * The account ID.
   *
   * @return the accountId
   */
  public String getAccountId() {
    return accountId;
  }

  /**
   * Gets the description.
   *
   * The details of a rule's response.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the type.
   *
   * The rule type (allowable values are `user_defined` or `system_defined`).
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Gets the version.
   *
   * The version number of a rule.
   *
   * @return the version
   */
  public String getVersion() {
    return version;
  }

  /**
   * Gets the xImport.
   *
   * The collection of import parameters.
   *
   * @return the xImport
   */
  public Import getXImport() {
    return xImport;
  }

  /**
   * Gets the target.
   *
   * The rule target.
   *
   * @return the target
   */
  public Target getTarget() {
    return target;
  }

  /**
   * Gets the requiredConfig.
   *
   * The required configurations.
   *
   * @return the requiredConfig
   */
  public RequiredConfig getRequiredConfig() {
    return requiredConfig;
  }

  /**
   * Gets the labels.
   *
   * The list of labels.
   *
   * @return the labels
   */
  public List<String> getLabels() {
    return labels;
  }
}

