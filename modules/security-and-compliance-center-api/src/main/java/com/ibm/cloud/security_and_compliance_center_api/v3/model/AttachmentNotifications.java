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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The notification configuration of the attachment.
 */
public class AttachmentNotifications extends GenericModel {

  protected Boolean enabled;
  protected AttachmentNotificationsControls controls;

  /**
   * Builder.
   */
  public static class Builder {
    private Boolean enabled;
    private AttachmentNotificationsControls controls;

    /**
     * Instantiates a new Builder from an existing AttachmentNotifications instance.
     *
     * @param attachmentNotifications the instance to initialize the Builder with
     */
    private Builder(AttachmentNotifications attachmentNotifications) {
      this.enabled = attachmentNotifications.enabled;
      this.controls = attachmentNotifications.controls;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a AttachmentNotifications.
     *
     * @return the new AttachmentNotifications instance
     */
    public AttachmentNotifications build() {
      return new AttachmentNotifications(this);
    }

    /**
     * Set the enabled.
     *
     * @param enabled the enabled
     * @return the AttachmentNotifications builder
     */
    public Builder enabled(Boolean enabled) {
      this.enabled = enabled;
      return this;
    }

    /**
     * Set the controls.
     *
     * @param controls the controls
     * @return the AttachmentNotifications builder
     */
    public Builder controls(AttachmentNotificationsControls controls) {
      this.controls = controls;
      return this;
    }
  }

  protected AttachmentNotifications() { }

  protected AttachmentNotifications(Builder builder) {
    enabled = builder.enabled;
    controls = builder.controls;
  }

  /**
   * New builder.
   *
   * @return a AttachmentNotifications builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the enabled.
   *
   * Shows if the notification is enabled or disabled.
   *
   * @return the enabled
   */
  public Boolean enabled() {
    return enabled;
  }

  /**
   * Gets the controls.
   *
   * The controls associated with an AttachmentNotification.
   *
   * @return the controls
   */
  public AttachmentNotificationsControls controls() {
    return controls;
  }
}

