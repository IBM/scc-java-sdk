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
 * The createRuleAttachments options.
 */
public class CreateRuleAttachmentsOptions extends GenericModel {

  protected String ruleId;
  protected List<RuleAttachmentRequest> attachments;
  protected String transactionId;

  /**
   * Builder.
   */
  public static class Builder {
    private String ruleId;
    private List<RuleAttachmentRequest> attachments;
    private String transactionId;

    private Builder(CreateRuleAttachmentsOptions createRuleAttachmentsOptions) {
      this.ruleId = createRuleAttachmentsOptions.ruleId;
      this.attachments = createRuleAttachmentsOptions.attachments;
      this.transactionId = createRuleAttachmentsOptions.transactionId;
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
     * @param attachments the attachments
     */
    public Builder(String ruleId, List<RuleAttachmentRequest> attachments) {
      this.ruleId = ruleId;
      this.attachments = attachments;
    }

    /**
     * Builds a CreateRuleAttachmentsOptions.
     *
     * @return the new CreateRuleAttachmentsOptions instance
     */
    public CreateRuleAttachmentsOptions build() {
      return new CreateRuleAttachmentsOptions(this);
    }

    /**
     * Adds an attachment to attachments.
     *
     * @param attachment the new attachment
     * @return the CreateRuleAttachmentsOptions builder
     */
    public Builder addAttachment(RuleAttachmentRequest attachment) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(attachment,
        "attachment cannot be null");
      if (this.attachments == null) {
        this.attachments = new ArrayList<RuleAttachmentRequest>();
      }
      this.attachments.add(attachment);
      return this;
    }

    /**
     * Set the ruleId.
     *
     * @param ruleId the ruleId
     * @return the CreateRuleAttachmentsOptions builder
     */
    public Builder ruleId(String ruleId) {
      this.ruleId = ruleId;
      return this;
    }

    /**
     * Set the attachments.
     * Existing attachments will be replaced.
     *
     * @param attachments the attachments
     * @return the CreateRuleAttachmentsOptions builder
     */
    public Builder attachments(List<RuleAttachmentRequest> attachments) {
      this.attachments = attachments;
      return this;
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the CreateRuleAttachmentsOptions builder
     */
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }
  }

  protected CreateRuleAttachmentsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.ruleId,
      "ruleId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.attachments,
      "attachments cannot be null");
    ruleId = builder.ruleId;
    attachments = builder.attachments;
    transactionId = builder.transactionId;
  }

  /**
   * New builder.
   *
   * @return a CreateRuleAttachmentsOptions builder
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
   * Gets the attachments.
   *
   * @return the attachments
   */
  public List<RuleAttachmentRequest> attachments() {
    return attachments;
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

