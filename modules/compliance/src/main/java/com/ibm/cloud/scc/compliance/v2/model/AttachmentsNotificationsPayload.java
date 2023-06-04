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
package com.ibm.cloud.scc.compliance.v2.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * payload of the attachments notifications.
 */
public class AttachmentsNotificationsPayload extends GenericModel {

  protected Boolean enabled;
  protected FailedControls controls;

  /**
   * Builder.
   */
  public static class Builder {
    private Boolean enabled;
    private FailedControls controls;

    /**
     * Instantiates a new Builder from an existing AttachmentsNotificationsPayload instance.
     *
     * @param attachmentsNotificationsPayload the instance to initialize the Builder with
     */
    private Builder(AttachmentsNotificationsPayload attachmentsNotificationsPayload) {
      this.enabled = attachmentsNotificationsPayload.enabled;
      this.controls = attachmentsNotificationsPayload.controls;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a AttachmentsNotificationsPayload.
     *
     * @return the new AttachmentsNotificationsPayload instance
     */
    public AttachmentsNotificationsPayload build() {
      return new AttachmentsNotificationsPayload(this);
    }

    /**
     * Set the enabled.
     *
     * @param enabled the enabled
     * @return the AttachmentsNotificationsPayload builder
     */
    public Builder enabled(Boolean enabled) {
      this.enabled = enabled;
      return this;
    }

    /**
     * Set the controls.
     *
     * @param controls the controls
     * @return the AttachmentsNotificationsPayload builder
     */
    public Builder controls(FailedControls controls) {
      this.controls = controls;
      return this;
    }
  }

  protected AttachmentsNotificationsPayload() { }

  protected AttachmentsNotificationsPayload(Builder builder) {
    enabled = builder.enabled;
    controls = builder.controls;
  }

  /**
   * New builder.
   *
   * @return a AttachmentsNotificationsPayload builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the enabled.
   *
   * enabled notifications.
   *
   * @return the enabled
   */
  public Boolean enabled() {
    return enabled;
  }

  /**
   * Gets the controls.
   *
   * failed controls.
   *
   * @return the controls
   */
  public FailedControls controls() {
    return controls;
  }
}

