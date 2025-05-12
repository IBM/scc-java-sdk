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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The createControlLibrary options.
 */
public class CreateControlLibraryOptions extends GenericModel {

  /**
   * Details that the control library is a user made(custom) or Security Compliance Center(predefined).
   */
  public interface ControlLibraryType {
    /** custom. */
    String CUSTOM = "custom";
  }

  protected String instanceId;
  protected String controlLibraryName;
  protected String controlLibraryDescription;
  protected String controlLibraryType;
  protected String controlLibraryVersion;
  protected List<ControlPrototype> controls;
  protected String accountId;

  /**
   * Builder.
   */
  public static class Builder {
    private String instanceId;
    private String controlLibraryName;
    private String controlLibraryDescription;
    private String controlLibraryType;
    private String controlLibraryVersion;
    private List<ControlPrototype> controls;
    private String accountId;

    /**
     * Instantiates a new Builder from an existing CreateControlLibraryOptions instance.
     *
     * @param createControlLibraryOptions the instance to initialize the Builder with
     */
    private Builder(CreateControlLibraryOptions createControlLibraryOptions) {
      this.instanceId = createControlLibraryOptions.instanceId;
      this.controlLibraryName = createControlLibraryOptions.controlLibraryName;
      this.controlLibraryDescription = createControlLibraryOptions.controlLibraryDescription;
      this.controlLibraryType = createControlLibraryOptions.controlLibraryType;
      this.controlLibraryVersion = createControlLibraryOptions.controlLibraryVersion;
      this.controls = createControlLibraryOptions.controls;
      this.accountId = createControlLibraryOptions.accountId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param instanceId the instanceId
     * @param controlLibraryName the controlLibraryName
     * @param controlLibraryDescription the controlLibraryDescription
     * @param controlLibraryType the controlLibraryType
     * @param controlLibraryVersion the controlLibraryVersion
     * @param controls the controls
     */
    public Builder(String instanceId, String controlLibraryName, String controlLibraryDescription, String controlLibraryType, String controlLibraryVersion, List<ControlPrototype> controls) {
      this.instanceId = instanceId;
      this.controlLibraryName = controlLibraryName;
      this.controlLibraryDescription = controlLibraryDescription;
      this.controlLibraryType = controlLibraryType;
      this.controlLibraryVersion = controlLibraryVersion;
      this.controls = controls;
    }

    /**
     * Builds a CreateControlLibraryOptions.
     *
     * @return the new CreateControlLibraryOptions instance
     */
    public CreateControlLibraryOptions build() {
      return new CreateControlLibraryOptions(this);
    }

    /**
     * Adds a new element to controls.
     *
     * @param controls the new element to be added
     * @return the CreateControlLibraryOptions builder
     */
    public Builder addControls(ControlPrototype controls) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(controls,
        "controls cannot be null");
      if (this.controls == null) {
        this.controls = new ArrayList<ControlPrototype>();
      }
      this.controls.add(controls);
      return this;
    }

    /**
     * Set the instanceId.
     *
     * @param instanceId the instanceId
     * @return the CreateControlLibraryOptions builder
     */
    public Builder instanceId(String instanceId) {
      this.instanceId = instanceId;
      return this;
    }

    /**
     * Set the controlLibraryName.
     *
     * @param controlLibraryName the controlLibraryName
     * @return the CreateControlLibraryOptions builder
     */
    public Builder controlLibraryName(String controlLibraryName) {
      this.controlLibraryName = controlLibraryName;
      return this;
    }

    /**
     * Set the controlLibraryDescription.
     *
     * @param controlLibraryDescription the controlLibraryDescription
     * @return the CreateControlLibraryOptions builder
     */
    public Builder controlLibraryDescription(String controlLibraryDescription) {
      this.controlLibraryDescription = controlLibraryDescription;
      return this;
    }

    /**
     * Set the controlLibraryType.
     *
     * @param controlLibraryType the controlLibraryType
     * @return the CreateControlLibraryOptions builder
     */
    public Builder controlLibraryType(String controlLibraryType) {
      this.controlLibraryType = controlLibraryType;
      return this;
    }

    /**
     * Set the controlLibraryVersion.
     *
     * @param controlLibraryVersion the controlLibraryVersion
     * @return the CreateControlLibraryOptions builder
     */
    public Builder controlLibraryVersion(String controlLibraryVersion) {
      this.controlLibraryVersion = controlLibraryVersion;
      return this;
    }

    /**
     * Set the controls.
     * Existing controls will be replaced.
     *
     * @param controls the controls
     * @return the CreateControlLibraryOptions builder
     */
    public Builder controls(List<ControlPrototype> controls) {
      this.controls = controls;
      return this;
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the CreateControlLibraryOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }
  }

  protected CreateControlLibraryOptions() { }

  protected CreateControlLibraryOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceId,
      "instanceId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.controlLibraryName,
      "controlLibraryName cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.controlLibraryDescription,
      "controlLibraryDescription cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.controlLibraryType,
      "controlLibraryType cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.controlLibraryVersion,
      "controlLibraryVersion cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.controls,
      "controls cannot be null");
    instanceId = builder.instanceId;
    controlLibraryName = builder.controlLibraryName;
    controlLibraryDescription = builder.controlLibraryDescription;
    controlLibraryType = builder.controlLibraryType;
    controlLibraryVersion = builder.controlLibraryVersion;
    controls = builder.controls;
    accountId = builder.accountId;
  }

  /**
   * New builder.
   *
   * @return a CreateControlLibraryOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the instanceId.
   *
   * The ID of the Security and Compliance Center instance.
   *
   * @return the instanceId
   */
  public String instanceId() {
    return instanceId;
  }

  /**
   * Gets the controlLibraryName.
   *
   * The name of the control library.
   *
   * @return the controlLibraryName
   */
  public String controlLibraryName() {
    return controlLibraryName;
  }

  /**
   * Gets the controlLibraryDescription.
   *
   * Details of the control library.
   *
   * @return the controlLibraryDescription
   */
  public String controlLibraryDescription() {
    return controlLibraryDescription;
  }

  /**
   * Gets the controlLibraryType.
   *
   * Details that the control library is a user made(custom) or Security Compliance Center(predefined).
   *
   * @return the controlLibraryType
   */
  public String controlLibraryType() {
    return controlLibraryType;
  }

  /**
   * Gets the controlLibraryVersion.
   *
   * The revision number of the control library.
   *
   * @return the controlLibraryVersion
   */
  public String controlLibraryVersion() {
    return controlLibraryVersion;
  }

  /**
   * Gets the controls.
   *
   * The list of rules that the control library attempts to adhere to.
   *
   * @return the controls
   */
  public List<ControlPrototype> controls() {
    return controls;
  }

  /**
   * Gets the accountId.
   *
   * The user account ID.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }
}

