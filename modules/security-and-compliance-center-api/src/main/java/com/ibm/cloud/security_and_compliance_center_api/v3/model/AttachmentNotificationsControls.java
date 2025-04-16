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

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The controls associated with an AttachmentNotification.
 */
public class AttachmentNotificationsControls extends GenericModel {

  @SerializedName("threshold_limit")
  protected Long thresholdLimit;
  @SerializedName("failed_control_ids")
  protected List<String> failedControlIds;

  /**
   * Builder.
   */
  public static class Builder {
    private Long thresholdLimit;
    private List<String> failedControlIds;

    /**
     * Instantiates a new Builder from an existing AttachmentNotificationsControls instance.
     *
     * @param attachmentNotificationsControls the instance to initialize the Builder with
     */
    private Builder(AttachmentNotificationsControls attachmentNotificationsControls) {
      this.thresholdLimit = attachmentNotificationsControls.thresholdLimit;
      this.failedControlIds = attachmentNotificationsControls.failedControlIds;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param failedControlIds the failedControlIds
     */
    public Builder(List<String> failedControlIds) {
      this.failedControlIds = failedControlIds;
    }

    /**
     * Builds a AttachmentNotificationsControls.
     *
     * @return the new AttachmentNotificationsControls instance
     */
    public AttachmentNotificationsControls build() {
      return new AttachmentNotificationsControls(this);
    }

    /**
     * Adds a new element to failedControlIds.
     *
     * @param failedControlIds the new element to be added
     * @return the AttachmentNotificationsControls builder
     */
    public Builder addFailedControlIds(String failedControlIds) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(failedControlIds,
        "failedControlIds cannot be null");
      if (this.failedControlIds == null) {
        this.failedControlIds = new ArrayList<String>();
      }
      this.failedControlIds.add(failedControlIds);
      return this;
    }

    /**
     * Set the thresholdLimit.
     *
     * @param thresholdLimit the thresholdLimit
     * @return the AttachmentNotificationsControls builder
     */
    public Builder thresholdLimit(long thresholdLimit) {
      this.thresholdLimit = thresholdLimit;
      return this;
    }

    /**
     * Set the failedControlIds.
     * Existing failedControlIds will be replaced.
     *
     * @param failedControlIds the failedControlIds
     * @return the AttachmentNotificationsControls builder
     */
    public Builder failedControlIds(List<String> failedControlIds) {
      this.failedControlIds = failedControlIds;
      return this;
    }
  }

  protected AttachmentNotificationsControls() { }

  protected AttachmentNotificationsControls(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.failedControlIds,
      "failedControlIds cannot be null");
    thresholdLimit = builder.thresholdLimit;
    failedControlIds = builder.failedControlIds;
  }

  /**
   * New builder.
   *
   * @return a AttachmentNotificationsControls builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the thresholdLimit.
   *
   * The maximum number of not compliant controls before a notification is triggered.
   *
   * @return the thresholdLimit
   */
  public Long thresholdLimit() {
    return thresholdLimit;
  }

  /**
   * Gets the failedControlIds.
   *
   * List of controls that triggers a notification should a scan fail.
   *
   * @return the failedControlIds
   */
  public List<String> failedControlIds() {
    return failedControlIds;
  }
}

