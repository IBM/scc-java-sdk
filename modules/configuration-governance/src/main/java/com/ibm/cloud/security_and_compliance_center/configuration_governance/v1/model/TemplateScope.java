/*
 * (C) Copyright IBM Corp. 2021.
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
package com.ibm.cloud.security_and_compliance_center.configuration_governance.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The extent at which the template can be attached across your accounts.
 */
public class TemplateScope extends GenericModel {

  /**
   * The type of scope.
   */
  public interface ScopeType {
    /** enterprise. */
    String ENTERPRISE = "enterprise";
    /** enterprise.account_group. */
    String ENTERPRISE_ACCOUNT_GROUP = "enterprise.account_group";
    /** enterprise.account. */
    String ENTERPRISE_ACCOUNT = "enterprise.account";
    /** account. */
    String ACCOUNT = "account";
    /** account.resource_group. */
    String ACCOUNT_RESOURCE_GROUP = "account.resource_group";
  }

  protected String note;
  @SerializedName("scope_id")
  protected String scopeId;
  @SerializedName("scope_type")
  protected String scopeType;

  /**
   * Gets the note.
   *
   * A short description or alias to assign to the scope.
   *
   * @return the note
   */
  public String getNote() {
    return note;
  }

  /**
   * Gets the scopeId.
   *
   * The ID of the scope, such as an enterprise, account, or account group, where you want to apply the customized
   * defaults that are associated with a template.
   *
   * @return the scopeId
   */
  public String getScopeId() {
    return scopeId;
  }

  /**
   * Gets the scopeType.
   *
   * The type of scope.
   *
   * @return the scopeType
   */
  public String getScopeType() {
    return scopeType;
  }
}

