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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The deleteRuleAttachment options.
 */
public class DeleteRuleAttachmentOptions extends GenericModel {

  protected String ruleId;
  protected String attachmentId;
  protected String transactionId;

  /**
   * Builder.
   */
  public static class Builder {
    private String ruleId;
    private String attachmentId;
    private String transactionId;

    private Builder(DeleteRuleAttachmentOptions deleteRuleAttachmentOptions) {
      this.ruleId = deleteRuleAttachmentOptions.ruleId;
      this.attachmentId = deleteRuleAttachmentOptions.attachmentId;
      this.transactionId = deleteRuleAttachmentOptions.transactionId;
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
     */
    public Builder(String ruleId, String attachmentId) {
      this.ruleId = ruleId;
      this.attachmentId = attachmentId;
    }

    /**
     * Builds a DeleteRuleAttachmentOptions.
     *
     * @return the new DeleteRuleAttachmentOptions instance
     */
    public DeleteRuleAttachmentOptions build() {
      return new DeleteRuleAttachmentOptions(this);
    }

    /**
     * Set the ruleId.
     *
     * @param ruleId the ruleId
     * @return the DeleteRuleAttachmentOptions builder
     */
    public Builder ruleId(String ruleId) {
      this.ruleId = ruleId;
      return this;
    }

    /**
     * Set the attachmentId.
     *
     * @param attachmentId the attachmentId
     * @return the DeleteRuleAttachmentOptions builder
     */
    public Builder attachmentId(String attachmentId) {
      this.attachmentId = attachmentId;
      return this;
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the DeleteRuleAttachmentOptions builder
     */
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }
  }

  protected DeleteRuleAttachmentOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.ruleId,
      "ruleId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.attachmentId,
      "attachmentId cannot be empty");
    ruleId = builder.ruleId;
    attachmentId = builder.attachmentId;
    transactionId = builder.transactionId;
  }

  /**
   * New builder.
   *
   * @return a DeleteRuleAttachmentOptions builder
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

