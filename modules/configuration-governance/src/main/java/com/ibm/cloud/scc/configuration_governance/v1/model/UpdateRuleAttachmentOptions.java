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

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The updateRuleAttachment options.
 */
public class UpdateRuleAttachmentOptions extends GenericModel {

  protected String ruleId;
  protected String attachmentId;
  protected String ifMatch;
  protected String accountId;
  protected RuleScope includedScope;
  protected List<RuleScope> excludedScopes;
  protected String transactionId;

  /**
   * Builder.
   */
  public static class Builder {
    private String ruleId;
    private String attachmentId;
    private String ifMatch;
    private String accountId;
    private RuleScope includedScope;
    private List<RuleScope> excludedScopes;
    private String transactionId;

    private Builder(UpdateRuleAttachmentOptions updateRuleAttachmentOptions) {
      this.ruleId = updateRuleAttachmentOptions.ruleId;
      this.attachmentId = updateRuleAttachmentOptions.attachmentId;
      this.ifMatch = updateRuleAttachmentOptions.ifMatch;
      this.accountId = updateRuleAttachmentOptions.accountId;
      this.includedScope = updateRuleAttachmentOptions.includedScope;
      this.excludedScopes = updateRuleAttachmentOptions.excludedScopes;
      this.transactionId = updateRuleAttachmentOptions.transactionId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param ruleId the ruleId
     * @param attachmentId the attachmentId
     * @param ifMatch the ifMatch
     * @param accountId the accountId
     * @param includedScope the includedScope
     */
    public Builder(String ruleId, String attachmentId, String ifMatch, String accountId, RuleScope includedScope) {
      this.ruleId = ruleId;
      this.attachmentId = attachmentId;
      this.ifMatch = ifMatch;
      this.accountId = accountId;
      this.includedScope = includedScope;
    }

    /**
     * Builds a UpdateRuleAttachmentOptions.
     *
     * @return the new UpdateRuleAttachmentOptions instance
     */
    public UpdateRuleAttachmentOptions build() {
      return new UpdateRuleAttachmentOptions(this);
    }

    /**
     * Adds an excludedScope to excludedScopes.
     *
     * @param excludedScope the new excludedScope
     * @return the UpdateRuleAttachmentOptions builder
     */
    public Builder addExcludedScope(RuleScope excludedScope) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(excludedScope,
        "excludedScope cannot be null");
      if (this.excludedScopes == null) {
        this.excludedScopes = new ArrayList<RuleScope>();
      }
      this.excludedScopes.add(excludedScope);
      return this;
    }

    /**
     * Set the ruleId.
     *
     * @param ruleId the ruleId
     * @return the UpdateRuleAttachmentOptions builder
     */
    public Builder ruleId(String ruleId) {
      this.ruleId = ruleId;
      return this;
    }

    /**
     * Set the attachmentId.
     *
     * @param attachmentId the attachmentId
     * @return the UpdateRuleAttachmentOptions builder
     */
    public Builder attachmentId(String attachmentId) {
      this.attachmentId = attachmentId;
      return this;
    }

    /**
     * Set the ifMatch.
     *
     * @param ifMatch the ifMatch
     * @return the UpdateRuleAttachmentOptions builder
     */
    public Builder ifMatch(String ifMatch) {
      this.ifMatch = ifMatch;
      return this;
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the UpdateRuleAttachmentOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the includedScope.
     *
     * @param includedScope the includedScope
     * @return the UpdateRuleAttachmentOptions builder
     */
    public Builder includedScope(RuleScope includedScope) {
      this.includedScope = includedScope;
      return this;
    }

    /**
     * Set the excludedScopes.
     * Existing excludedScopes will be replaced.
     *
     * @param excludedScopes the excludedScopes
     * @return the UpdateRuleAttachmentOptions builder
     */
    public Builder excludedScopes(List<RuleScope> excludedScopes) {
      this.excludedScopes = excludedScopes;
      return this;
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the UpdateRuleAttachmentOptions builder
     */
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }
  }

  protected UpdateRuleAttachmentOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.ruleId,
      "ruleId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.attachmentId,
      "attachmentId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.ifMatch,
      "ifMatch cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.accountId,
      "accountId cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.includedScope,
      "includedScope cannot be null");
    ruleId = builder.ruleId;
    attachmentId = builder.attachmentId;
    ifMatch = builder.ifMatch;
    accountId = builder.accountId;
    includedScope = builder.includedScope;
    excludedScopes = builder.excludedScopes;
    transactionId = builder.transactionId;
  }

  /**
   * New builder.
   *
   * @return a UpdateRuleAttachmentOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the ruleId.
   *
   * The UUID that uniquely identifies the rule.
   *
   * @return the ruleId
   */
  public String ruleId() {
    return ruleId;
  }

  /**
   * Gets the attachmentId.
   *
   * The UUID that uniquely identifies the attachment.
   *
   * @return the attachmentId
   */
  public String attachmentId() {
    return attachmentId;
  }

  /**
   * Gets the ifMatch.
   *
   * Compares a supplied `Etag` value with the version that is stored for the requested resource. If the values match,
   * the server allows the request method to continue.
   *
   * To find the `Etag` value, run a GET request on the resource that you want to modify, and check the response
   * headers.
   *
   * @return the ifMatch
   */
  public String ifMatch() {
    return ifMatch;
  }

  /**
   * Gets the accountId.
   *
   * Your IBM Cloud account ID.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the includedScope.
   *
   * The extent at which the rule can be attached across your accounts.
   *
   * @return the includedScope
   */
  public RuleScope includedScope() {
    return includedScope;
  }

  /**
   * Gets the excludedScopes.
   *
   * The extent at which the rule can be excluded from the included scope.
   *
   * @return the excludedScopes
   */
  public List<RuleScope> excludedScopes() {
    return excludedScopes;
  }

  /**
   * Gets the transactionId.
   *
   * The unique identifier that is used to trace an entire request. If you omit this field, the service generates and
   * sends a transaction ID as a response header of the request. In the case of an error, the transaction ID is set in
   * the `trace` field of the response body.
   *
   * **Note:** To help with debugging logs, it is strongly recommended that you generate and supply a `Transaction-Id`
   * with each request.
   *
   * @return the transactionId
   */
  public String transactionId() {
    return transactionId;
  }
}

