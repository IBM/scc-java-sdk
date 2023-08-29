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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The request payload of the attachment notifications.
 */
public class AttachmentsNotificationsPrototype extends GenericModel {

  protected Boolean enabled;
  protected FailedControls controls;

  /**
   * Builder.
   */
  public static class Builder {
    private Boolean enabled;
    private FailedControls controls;

    /**
     * Instantiates a new Builder from an existing AttachmentsNotificationsPrototype instance.
     *
     * @param attachmentsNotificationsPrototype the instance to initialize the Builder with
     */
    private Builder(AttachmentsNotificationsPrototype attachmentsNotificationsPrototype) {
      this.enabled = attachmentsNotificationsPrototype.enabled;
      this.controls = attachmentsNotificationsPrototype.controls;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param enabled the enabled
     * @param controls the controls
     */
    public Builder(Boolean enabled, FailedControls controls) {
      this.enabled = enabled;
      this.controls = controls;
    }

    /**
     * Builds a AttachmentsNotificationsPrototype.
     *
     * @return the new AttachmentsNotificationsPrototype instance
     */
    public AttachmentsNotificationsPrototype build() {
      return new AttachmentsNotificationsPrototype(this);
    }

    /**
     * Set the enabled.
     *
     * @param enabled the enabled
     * @return the AttachmentsNotificationsPrototype builder
     */
    public Builder enabled(Boolean enabled) {
      this.enabled = enabled;
      return this;
    }

    /**
     * Set the controls.
     *
     * @param controls the controls
     * @return the AttachmentsNotificationsPrototype builder
     */
    public Builder controls(FailedControls controls) {
      this.controls = controls;
      return this;
    }
  }

  protected AttachmentsNotificationsPrototype() { }

  protected AttachmentsNotificationsPrototype(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.enabled,
      "enabled cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.controls,
      "controls cannot be null");
    enabled = builder.enabled;
    controls = builder.controls;
  }

  /**
   * New builder.
   *
   * @return a AttachmentsNotificationsPrototype builder
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
   * The failed controls.
   *
   * @return the controls
   */
  public FailedControls controls() {
    return controls;
  }
}

