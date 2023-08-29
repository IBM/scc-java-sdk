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

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The createCustomControlLibrary options.
 */
public class CreateCustomControlLibraryOptions extends GenericModel {

  /**
   * The control library type.
   */
  public interface ControlLibraryType {
    /** predefined. */
    String PREDEFINED = "predefined";
    /** custom. */
    String CUSTOM = "custom";
  }

  protected String controlLibraryName;
  protected String controlLibraryDescription;
  protected String controlLibraryType;
  protected List<ControlsInControlLib> controls;
  protected String versionGroupLabel;
  protected String controlLibraryVersion;
  protected Boolean latest;
  protected Long controlsCount;
  protected String xCorrelationId;
  protected String xRequestId;

  /**
   * Builder.
   */
  public static class Builder {
    private String controlLibraryName;
    private String controlLibraryDescription;
    private String controlLibraryType;
    private List<ControlsInControlLib> controls;
    private String versionGroupLabel;
    private String controlLibraryVersion;
    private Boolean latest;
    private Long controlsCount;
    private String xCorrelationId;
    private String xRequestId;

    /**
     * Instantiates a new Builder from an existing CreateCustomControlLibraryOptions instance.
     *
     * @param createCustomControlLibraryOptions the instance to initialize the Builder with
     */
    private Builder(CreateCustomControlLibraryOptions createCustomControlLibraryOptions) {
      this.controlLibraryName = createCustomControlLibraryOptions.controlLibraryName;
      this.controlLibraryDescription = createCustomControlLibraryOptions.controlLibraryDescription;
      this.controlLibraryType = createCustomControlLibraryOptions.controlLibraryType;
      this.controls = createCustomControlLibraryOptions.controls;
      this.versionGroupLabel = createCustomControlLibraryOptions.versionGroupLabel;
      this.controlLibraryVersion = createCustomControlLibraryOptions.controlLibraryVersion;
      this.latest = createCustomControlLibraryOptions.latest;
      this.controlsCount = createCustomControlLibraryOptions.controlsCount;
      this.xCorrelationId = createCustomControlLibraryOptions.xCorrelationId;
      this.xRequestId = createCustomControlLibraryOptions.xRequestId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param controlLibraryName the controlLibraryName
     * @param controlLibraryDescription the controlLibraryDescription
     * @param controlLibraryType the controlLibraryType
     * @param controls the controls
     */
    public Builder(String controlLibraryName, String controlLibraryDescription, String controlLibraryType, List<ControlsInControlLib> controls) {
      this.controlLibraryName = controlLibraryName;
      this.controlLibraryDescription = controlLibraryDescription;
      this.controlLibraryType = controlLibraryType;
      this.controls = controls;
    }

    /**
     * Builds a CreateCustomControlLibraryOptions.
     *
     * @return the new CreateCustomControlLibraryOptions instance
     */
    public CreateCustomControlLibraryOptions build() {
      return new CreateCustomControlLibraryOptions(this);
    }

    /**
     * Adds an controls to controls.
     *
     * @param controls the new controls
     * @return the CreateCustomControlLibraryOptions builder
     */
    public Builder addControls(ControlsInControlLib controls) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(controls,
        "controls cannot be null");
      if (this.controls == null) {
        this.controls = new ArrayList<ControlsInControlLib>();
      }
      this.controls.add(controls);
      return this;
    }

    /**
     * Set the controlLibraryName.
     *
     * @param controlLibraryName the controlLibraryName
     * @return the CreateCustomControlLibraryOptions builder
     */
    public Builder controlLibraryName(String controlLibraryName) {
      this.controlLibraryName = controlLibraryName;
      return this;
    }

    /**
     * Set the controlLibraryDescription.
     *
     * @param controlLibraryDescription the controlLibraryDescription
     * @return the CreateCustomControlLibraryOptions builder
     */
    public Builder controlLibraryDescription(String controlLibraryDescription) {
      this.controlLibraryDescription = controlLibraryDescription;
      return this;
    }

    /**
     * Set the controlLibraryType.
     *
     * @param controlLibraryType the controlLibraryType
     * @return the CreateCustomControlLibraryOptions builder
     */
    public Builder controlLibraryType(String controlLibraryType) {
      this.controlLibraryType = controlLibraryType;
      return this;
    }

    /**
     * Set the controls.
     * Existing controls will be replaced.
     *
     * @param controls the controls
     * @return the CreateCustomControlLibraryOptions builder
     */
    public Builder controls(List<ControlsInControlLib> controls) {
      this.controls = controls;
      return this;
    }

    /**
     * Set the versionGroupLabel.
     *
     * @param versionGroupLabel the versionGroupLabel
     * @return the CreateCustomControlLibraryOptions builder
     */
    public Builder versionGroupLabel(String versionGroupLabel) {
      this.versionGroupLabel = versionGroupLabel;
      return this;
    }

    /**
     * Set the controlLibraryVersion.
     *
     * @param controlLibraryVersion the controlLibraryVersion
     * @return the CreateCustomControlLibraryOptions builder
     */
    public Builder controlLibraryVersion(String controlLibraryVersion) {
      this.controlLibraryVersion = controlLibraryVersion;
      return this;
    }

    /**
     * Set the latest.
     *
     * @param latest the latest
     * @return the CreateCustomControlLibraryOptions builder
     */
    public Builder latest(Boolean latest) {
      this.latest = latest;
      return this;
    }

    /**
     * Set the controlsCount.
     *
     * @param controlsCount the controlsCount
     * @return the CreateCustomControlLibraryOptions builder
     */
    public Builder controlsCount(long controlsCount) {
      this.controlsCount = controlsCount;
      return this;
    }

    /**
     * Set the xCorrelationId.
     *
     * @param xCorrelationId the xCorrelationId
     * @return the CreateCustomControlLibraryOptions builder
     */
    public Builder xCorrelationId(String xCorrelationId) {
      this.xCorrelationId = xCorrelationId;
      return this;
    }

    /**
     * Set the xRequestId.
     *
     * @param xRequestId the xRequestId
     * @return the CreateCustomControlLibraryOptions builder
     */
    public Builder xRequestId(String xRequestId) {
      this.xRequestId = xRequestId;
      return this;
    }
  }

  protected CreateCustomControlLibraryOptions() { }

  protected CreateCustomControlLibraryOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.controlLibraryName,
      "controlLibraryName cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.controlLibraryDescription,
      "controlLibraryDescription cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.controlLibraryType,
      "controlLibraryType cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.controls,
      "controls cannot be null");
    controlLibraryName = builder.controlLibraryName;
    controlLibraryDescription = builder.controlLibraryDescription;
    controlLibraryType = builder.controlLibraryType;
    controls = builder.controls;
    versionGroupLabel = builder.versionGroupLabel;
    controlLibraryVersion = builder.controlLibraryVersion;
    latest = builder.latest;
    controlsCount = builder.controlsCount;
    xCorrelationId = builder.xCorrelationId;
    xRequestId = builder.xRequestId;
  }

  /**
   * New builder.
   *
   * @return a CreateCustomControlLibraryOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the controlLibraryName.
   *
   * The control library name.
   *
   * @return the controlLibraryName
   */
  public String controlLibraryName() {
    return controlLibraryName;
  }

  /**
   * Gets the controlLibraryDescription.
   *
   * The control library description.
   *
   * @return the controlLibraryDescription
   */
  public String controlLibraryDescription() {
    return controlLibraryDescription;
  }

  /**
   * Gets the controlLibraryType.
   *
   * The control library type.
   *
   * @return the controlLibraryType
   */
  public String controlLibraryType() {
    return controlLibraryType;
  }

  /**
   * Gets the controls.
   *
   * The controls.
   *
   * @return the controls
   */
  public List<ControlsInControlLib> controls() {
    return controls;
  }

  /**
   * Gets the versionGroupLabel.
   *
   * The version group label.
   *
   * @return the versionGroupLabel
   */
  public String versionGroupLabel() {
    return versionGroupLabel;
  }

  /**
   * Gets the controlLibraryVersion.
   *
   * The control library version.
   *
   * @return the controlLibraryVersion
   */
  public String controlLibraryVersion() {
    return controlLibraryVersion;
  }

  /**
   * Gets the latest.
   *
   * The latest control library version.
   *
   * @return the latest
   */
  public Boolean latest() {
    return latest;
  }

  /**
   * Gets the controlsCount.
   *
   * The number of controls.
   *
   * @return the controlsCount
   */
  public Long controlsCount() {
    return controlsCount;
  }

  /**
   * Gets the xCorrelationId.
   *
   * The supplied or generated value of this header is logged for a request and repeated in a response header for the
   * corresponding response. The same value is used for downstream requests and retries of those requests. If a value of
   * this header is not supplied in a request, the service generates a random (version 4) UUID.
   *
   * @return the xCorrelationId
   */
  public String xCorrelationId() {
    return xCorrelationId;
  }

  /**
   * Gets the xRequestId.
   *
   * The supplied or generated value of this header is logged for a request and repeated in a response header for the
   * corresponding response. The same value is not used for downstream requests and retries of those requests. If a
   * value of this header is not supplied in a request, the service generates a random (version 4) UUID.
   *
   * @return the xRequestId
   */
  public String xRequestId() {
    return xRequestId;
  }
}

