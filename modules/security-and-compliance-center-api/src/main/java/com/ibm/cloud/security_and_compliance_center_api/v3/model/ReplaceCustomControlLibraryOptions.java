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
import java.util.Date;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The replaceCustomControlLibrary options.
 */
public class ReplaceCustomControlLibraryOptions extends GenericModel {

  /**
   * The control library type.
   */
  public interface ControlLibraryType {
    /** predefined. */
    String PREDEFINED = "predefined";
    /** custom. */
    String CUSTOM = "custom";
  }

  protected String controlLibrariesId;
  protected String id;
  protected String accountId;
  protected String controlLibraryName;
  protected String controlLibraryDescription;
  protected String controlLibraryType;
  protected String versionGroupLabel;
  protected String controlLibraryVersion;
  protected Date createdOn;
  protected String createdBy;
  protected Date updatedOn;
  protected String updatedBy;
  protected Boolean latest;
  protected Boolean hierarchyEnabled;
  protected Long controlsCount;
  protected Long controlParentsCount;
  protected List<ControlsInControlLib> controls;
  protected String xCorrelationId;
  protected String xRequestId;

  /**
   * Builder.
   */
  public static class Builder {
    private String controlLibrariesId;
    private String id;
    private String accountId;
    private String controlLibraryName;
    private String controlLibraryDescription;
    private String controlLibraryType;
    private String versionGroupLabel;
    private String controlLibraryVersion;
    private Date createdOn;
    private String createdBy;
    private Date updatedOn;
    private String updatedBy;
    private Boolean latest;
    private Boolean hierarchyEnabled;
    private Long controlsCount;
    private Long controlParentsCount;
    private List<ControlsInControlLib> controls;
    private String xCorrelationId;
    private String xRequestId;

    /**
     * Instantiates a new Builder from an existing ReplaceCustomControlLibraryOptions instance.
     *
     * @param replaceCustomControlLibraryOptions the instance to initialize the Builder with
     */
    private Builder(ReplaceCustomControlLibraryOptions replaceCustomControlLibraryOptions) {
      this.controlLibrariesId = replaceCustomControlLibraryOptions.controlLibrariesId;
      this.id = replaceCustomControlLibraryOptions.id;
      this.accountId = replaceCustomControlLibraryOptions.accountId;
      this.controlLibraryName = replaceCustomControlLibraryOptions.controlLibraryName;
      this.controlLibraryDescription = replaceCustomControlLibraryOptions.controlLibraryDescription;
      this.controlLibraryType = replaceCustomControlLibraryOptions.controlLibraryType;
      this.versionGroupLabel = replaceCustomControlLibraryOptions.versionGroupLabel;
      this.controlLibraryVersion = replaceCustomControlLibraryOptions.controlLibraryVersion;
      this.createdOn = replaceCustomControlLibraryOptions.createdOn;
      this.createdBy = replaceCustomControlLibraryOptions.createdBy;
      this.updatedOn = replaceCustomControlLibraryOptions.updatedOn;
      this.updatedBy = replaceCustomControlLibraryOptions.updatedBy;
      this.latest = replaceCustomControlLibraryOptions.latest;
      this.hierarchyEnabled = replaceCustomControlLibraryOptions.hierarchyEnabled;
      this.controlsCount = replaceCustomControlLibraryOptions.controlsCount;
      this.controlParentsCount = replaceCustomControlLibraryOptions.controlParentsCount;
      this.controls = replaceCustomControlLibraryOptions.controls;
      this.xCorrelationId = replaceCustomControlLibraryOptions.xCorrelationId;
      this.xRequestId = replaceCustomControlLibraryOptions.xRequestId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param controlLibrariesId the controlLibrariesId
     */
    public Builder(String controlLibrariesId) {
      this.controlLibrariesId = controlLibrariesId;
    }

    /**
     * Builds a ReplaceCustomControlLibraryOptions.
     *
     * @return the new ReplaceCustomControlLibraryOptions instance
     */
    public ReplaceCustomControlLibraryOptions build() {
      return new ReplaceCustomControlLibraryOptions(this);
    }

    /**
     * Adds an controls to controls.
     *
     * @param controls the new controls
     * @return the ReplaceCustomControlLibraryOptions builder
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
     * Set the controlLibrariesId.
     *
     * @param controlLibrariesId the controlLibrariesId
     * @return the ReplaceCustomControlLibraryOptions builder
     */
    public Builder controlLibrariesId(String controlLibrariesId) {
      this.controlLibrariesId = controlLibrariesId;
      return this;
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the ReplaceCustomControlLibraryOptions builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the ReplaceCustomControlLibraryOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the controlLibraryName.
     *
     * @param controlLibraryName the controlLibraryName
     * @return the ReplaceCustomControlLibraryOptions builder
     */
    public Builder controlLibraryName(String controlLibraryName) {
      this.controlLibraryName = controlLibraryName;
      return this;
    }

    /**
     * Set the controlLibraryDescription.
     *
     * @param controlLibraryDescription the controlLibraryDescription
     * @return the ReplaceCustomControlLibraryOptions builder
     */
    public Builder controlLibraryDescription(String controlLibraryDescription) {
      this.controlLibraryDescription = controlLibraryDescription;
      return this;
    }

    /**
     * Set the controlLibraryType.
     *
     * @param controlLibraryType the controlLibraryType
     * @return the ReplaceCustomControlLibraryOptions builder
     */
    public Builder controlLibraryType(String controlLibraryType) {
      this.controlLibraryType = controlLibraryType;
      return this;
    }

    /**
     * Set the versionGroupLabel.
     *
     * @param versionGroupLabel the versionGroupLabel
     * @return the ReplaceCustomControlLibraryOptions builder
     */
    public Builder versionGroupLabel(String versionGroupLabel) {
      this.versionGroupLabel = versionGroupLabel;
      return this;
    }

    /**
     * Set the controlLibraryVersion.
     *
     * @param controlLibraryVersion the controlLibraryVersion
     * @return the ReplaceCustomControlLibraryOptions builder
     */
    public Builder controlLibraryVersion(String controlLibraryVersion) {
      this.controlLibraryVersion = controlLibraryVersion;
      return this;
    }

    /**
     * Set the createdOn.
     *
     * @param createdOn the createdOn
     * @return the ReplaceCustomControlLibraryOptions builder
     */
    public Builder createdOn(Date createdOn) {
      this.createdOn = createdOn;
      return this;
    }

    /**
     * Set the createdBy.
     *
     * @param createdBy the createdBy
     * @return the ReplaceCustomControlLibraryOptions builder
     */
    public Builder createdBy(String createdBy) {
      this.createdBy = createdBy;
      return this;
    }

    /**
     * Set the updatedOn.
     *
     * @param updatedOn the updatedOn
     * @return the ReplaceCustomControlLibraryOptions builder
     */
    public Builder updatedOn(Date updatedOn) {
      this.updatedOn = updatedOn;
      return this;
    }

    /**
     * Set the updatedBy.
     *
     * @param updatedBy the updatedBy
     * @return the ReplaceCustomControlLibraryOptions builder
     */
    public Builder updatedBy(String updatedBy) {
      this.updatedBy = updatedBy;
      return this;
    }

    /**
     * Set the latest.
     *
     * @param latest the latest
     * @return the ReplaceCustomControlLibraryOptions builder
     */
    public Builder latest(Boolean latest) {
      this.latest = latest;
      return this;
    }

    /**
     * Set the hierarchyEnabled.
     *
     * @param hierarchyEnabled the hierarchyEnabled
     * @return the ReplaceCustomControlLibraryOptions builder
     */
    public Builder hierarchyEnabled(Boolean hierarchyEnabled) {
      this.hierarchyEnabled = hierarchyEnabled;
      return this;
    }

    /**
     * Set the controlsCount.
     *
     * @param controlsCount the controlsCount
     * @return the ReplaceCustomControlLibraryOptions builder
     */
    public Builder controlsCount(long controlsCount) {
      this.controlsCount = controlsCount;
      return this;
    }

    /**
     * Set the controlParentsCount.
     *
     * @param controlParentsCount the controlParentsCount
     * @return the ReplaceCustomControlLibraryOptions builder
     */
    public Builder controlParentsCount(long controlParentsCount) {
      this.controlParentsCount = controlParentsCount;
      return this;
    }

    /**
     * Set the controls.
     * Existing controls will be replaced.
     *
     * @param controls the controls
     * @return the ReplaceCustomControlLibraryOptions builder
     */
    public Builder controls(List<ControlsInControlLib> controls) {
      this.controls = controls;
      return this;
    }

    /**
     * Set the xCorrelationId.
     *
     * @param xCorrelationId the xCorrelationId
     * @return the ReplaceCustomControlLibraryOptions builder
     */
    public Builder xCorrelationId(String xCorrelationId) {
      this.xCorrelationId = xCorrelationId;
      return this;
    }

    /**
     * Set the xRequestId.
     *
     * @param xRequestId the xRequestId
     * @return the ReplaceCustomControlLibraryOptions builder
     */
    public Builder xRequestId(String xRequestId) {
      this.xRequestId = xRequestId;
      return this;
    }

    /**
     * Set the controlLibrary.
     *
     * @param controlLibrary the controlLibrary
     * @return the ReplaceCustomControlLibraryOptions builder
     */
    public Builder controlLibrary(ControlLibrary controlLibrary) {
      this.id = controlLibrary.id();
      this.accountId = controlLibrary.accountId();
      this.controlLibraryName = controlLibrary.controlLibraryName();
      this.controlLibraryDescription = controlLibrary.controlLibraryDescription();
      this.controlLibraryType = controlLibrary.controlLibraryType();
      this.versionGroupLabel = controlLibrary.versionGroupLabel();
      this.controlLibraryVersion = controlLibrary.controlLibraryVersion();
      this.createdOn = controlLibrary.createdOn();
      this.createdBy = controlLibrary.createdBy();
      this.updatedOn = controlLibrary.updatedOn();
      this.updatedBy = controlLibrary.updatedBy();
      this.latest = controlLibrary.latest();
      this.hierarchyEnabled = controlLibrary.hierarchyEnabled();
      this.controlsCount = controlLibrary.controlsCount();
      this.controlParentsCount = controlLibrary.controlParentsCount();
      this.controls = controlLibrary.controls();
      return this;
    }
  }

  protected ReplaceCustomControlLibraryOptions() { }

  protected ReplaceCustomControlLibraryOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.controlLibrariesId,
      "controlLibrariesId cannot be empty");
    controlLibrariesId = builder.controlLibrariesId;
    id = builder.id;
    accountId = builder.accountId;
    controlLibraryName = builder.controlLibraryName;
    controlLibraryDescription = builder.controlLibraryDescription;
    controlLibraryType = builder.controlLibraryType;
    versionGroupLabel = builder.versionGroupLabel;
    controlLibraryVersion = builder.controlLibraryVersion;
    createdOn = builder.createdOn;
    createdBy = builder.createdBy;
    updatedOn = builder.updatedOn;
    updatedBy = builder.updatedBy;
    latest = builder.latest;
    hierarchyEnabled = builder.hierarchyEnabled;
    controlsCount = builder.controlsCount;
    controlParentsCount = builder.controlParentsCount;
    controls = builder.controls;
    xCorrelationId = builder.xCorrelationId;
    xRequestId = builder.xRequestId;
  }

  /**
   * New builder.
   *
   * @return a ReplaceCustomControlLibraryOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the controlLibrariesId.
   *
   * The control library ID.
   *
   * @return the controlLibrariesId
   */
  public String controlLibrariesId() {
    return controlLibrariesId;
  }

  /**
   * Gets the id.
   *
   * The control library ID.
   *
   * @return the id
   */
  public String id() {
    return id;
  }

  /**
   * Gets the accountId.
   *
   * The account ID.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
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
   * Gets the createdOn.
   *
   * The date when the control library was created.
   *
   * @return the createdOn
   */
  public Date createdOn() {
    return createdOn;
  }

  /**
   * Gets the createdBy.
   *
   * The user who created the control library.
   *
   * @return the createdBy
   */
  public String createdBy() {
    return createdBy;
  }

  /**
   * Gets the updatedOn.
   *
   * The date when the control library was updated.
   *
   * @return the updatedOn
   */
  public Date updatedOn() {
    return updatedOn;
  }

  /**
   * Gets the updatedBy.
   *
   * The user who updated the control library.
   *
   * @return the updatedBy
   */
  public String updatedBy() {
    return updatedBy;
  }

  /**
   * Gets the latest.
   *
   * The latest version of the control library.
   *
   * @return the latest
   */
  public Boolean latest() {
    return latest;
  }

  /**
   * Gets the hierarchyEnabled.
   *
   * The indication of whether hierarchy is enabled for the control library.
   *
   * @return the hierarchyEnabled
   */
  public Boolean hierarchyEnabled() {
    return hierarchyEnabled;
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
   * Gets the controlParentsCount.
   *
   * The number of parent controls in the control library.
   *
   * @return the controlParentsCount
   */
  public Long controlParentsCount() {
    return controlParentsCount;
  }

  /**
   * Gets the controls.
   *
   * The list of controls in a control library.
   *
   * @return the controls
   */
  public List<ControlsInControlLib> controls() {
    return controls;
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

