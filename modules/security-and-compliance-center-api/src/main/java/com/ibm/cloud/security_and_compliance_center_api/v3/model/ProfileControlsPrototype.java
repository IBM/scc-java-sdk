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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The control details of a profile.
 */
public class ProfileControlsPrototype extends GenericModel {

  @SerializedName("control_library_id")
  protected String controlLibraryId;
  @SerializedName("control_id")
  protected String controlId;

  /**
   * Builder.
   */
  public static class Builder {
    private String controlLibraryId;
    private String controlId;

    /**
     * Instantiates a new Builder from an existing ProfileControlsPrototype instance.
     *
     * @param profileControlsPrototype the instance to initialize the Builder with
     */
    private Builder(ProfileControlsPrototype profileControlsPrototype) {
      this.controlLibraryId = profileControlsPrototype.controlLibraryId;
      this.controlId = profileControlsPrototype.controlId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ProfileControlsPrototype.
     *
     * @return the new ProfileControlsPrototype instance
     */
    public ProfileControlsPrototype build() {
      return new ProfileControlsPrototype(this);
    }

    /**
     * Set the controlLibraryId.
     *
     * @param controlLibraryId the controlLibraryId
     * @return the ProfileControlsPrototype builder
     */
    public Builder controlLibraryId(String controlLibraryId) {
      this.controlLibraryId = controlLibraryId;
      return this;
    }

    /**
     * Set the controlId.
     *
     * @param controlId the controlId
     * @return the ProfileControlsPrototype builder
     */
    public Builder controlId(String controlId) {
      this.controlId = controlId;
      return this;
    }
  }

  protected ProfileControlsPrototype() { }

  protected ProfileControlsPrototype(Builder builder) {
    controlLibraryId = builder.controlLibraryId;
    controlId = builder.controlId;
  }

  /**
   * New builder.
   *
   * @return a ProfileControlsPrototype builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the controlLibraryId.
   *
   * The ID of the control library that contains the profile.
   *
   * @return the controlLibraryId
   */
  public String controlLibraryId() {
    return controlLibraryId;
  }

  /**
   * Gets the controlId.
   *
   * The control ID.
   *
   * @return the controlId
   */
  public String controlId() {
    return controlId;
  }
}

