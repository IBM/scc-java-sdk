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
package com.ibm.cloud.scc.configuration_governance.v1.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The scopes to attach to a template.
 */
public class TemplateAttachment extends GenericModel {

  @SerializedName("attachment_id")
  protected String attachmentId;
  @SerializedName("template_id")
  protected String templateId;
  @SerializedName("account_id")
  protected String accountId;
  @SerializedName("included_scope")
  protected TemplateScope includedScope;
  @SerializedName("excluded_scopes")
  protected List<TemplateScope> excludedScopes;

  /**
   * Gets the attachmentId.
   *
   * The UUID that uniquely identifies the attachment.
   *
   * @return the attachmentId
   */
  public String getAttachmentId() {
    return attachmentId;
  }

  /**
   * Gets the templateId.
   *
   * The UUID that uniquely identifies the template.
   *
   * @return the templateId
   */
  public String getTemplateId() {
    return templateId;
  }

  /**
   * Gets the accountId.
   *
   * Your IBM Cloud account ID.
   *
   * @return the accountId
   */
  public String getAccountId() {
    return accountId;
  }

  /**
   * Gets the includedScope.
   *
   * The extent at which the template can be attached across your accounts.
   *
   * @return the includedScope
   */
  public TemplateScope getIncludedScope() {
    return includedScope;
  }

  /**
   * Gets the excludedScopes.
   *
   * @return the excludedScopes
   */
  public List<TemplateScope> getExcludedScopes() {
    return excludedScopes;
  }
}

