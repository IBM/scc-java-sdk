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
 * The details of the target account.
 */
public class Target extends GenericModel {

  protected String id;
  @SerializedName("account_id")
  protected String accountId;
  @SerializedName("trusted_profile_id")
  protected String trustedProfileId;
  protected String name;
  protected List<CredentialResponse> credentials;
  @SerializedName("created_by")
  protected String createdBy;
  @SerializedName("created_on")
  protected Date createdOn;
  @SerializedName("updated_by")
  protected String updatedBy;
  @SerializedName("updated_on")
  protected Date updatedOn;

  protected Target() { }

  /**
   * Gets the id.
   *
   * The UUID of the target.
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
   * Gets the trustedProfileId.
   *
   * The trusted profile ID.
   *
   * @return the trustedProfileId
   */
  public String getTrustedProfileId() {
    return trustedProfileId;
  }

  /**
   * Gets the name.
   *
   * The target name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the credentials.
   *
   * List of credentials.
   *
   * @return the credentials
   */
  public List<CredentialResponse> getCredentials() {
    return credentials;
  }

  /**
   * Gets the createdBy.
   *
   * The user ID who created the target.
   *
   * @return the createdBy
   */
  public String getCreatedBy() {
    return createdBy;
  }

  /**
   * Gets the createdOn.
   *
   * The time when the target was created.
   *
   * @return the createdOn
   */
  public Date getCreatedOn() {
    return createdOn;
  }

  /**
   * Gets the updatedBy.
   *
   * The user ID who updated the target.
   *
   * @return the updatedBy
   */
  public String getUpdatedBy() {
    return updatedBy;
  }

  /**
   * Gets the updatedOn.
   *
   * The time when the target was updated.
   *
   * @return the updatedOn
   */
  public Date getUpdatedOn() {
    return updatedOn;
  }
}

