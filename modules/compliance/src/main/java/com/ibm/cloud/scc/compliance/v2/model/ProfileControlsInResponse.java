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

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The control details for a profile.
 */
public class ProfileControlsInResponse extends GenericModel {

  @SerializedName("control_library_id")
  protected String controlLibraryId;
  @SerializedName("control_id")
  protected String controlId;
  @SerializedName("control_library_version")
  protected String controlLibraryVersion;
  @SerializedName("control_name")
  protected String controlName;
  @SerializedName("control_description")
  protected String controlDescription;
  @SerializedName("control_severity")
  protected String controlSeverity;
  @SerializedName("control_category")
  protected String controlCategory;
  @SerializedName("control_parent")
  protected String controlParent;
  @SerializedName("control_docs")
  protected ControlDocs controlDocs;
  @SerializedName("control_specifications")
  protected List<ControlSpecifications> controlSpecifications;

  protected ProfileControlsInResponse() { }

  /**
   * Gets the controlLibraryId.
   *
   * The ID of the control library that contains a profile.
   *
   * @return the controlLibraryId
   */
  public String getControlLibraryId() {
    return controlLibraryId;
  }

  /**
   * Gets the controlId.
   *
   * control id.
   *
   * @return the controlId
   */
  public String getControlId() {
    return controlId;
  }

  /**
   * Gets the controlLibraryVersion.
   *
   * control library version.
   *
   * @return the controlLibraryVersion
   */
  public String getControlLibraryVersion() {
    return controlLibraryVersion;
  }

  /**
   * Gets the controlName.
   *
   * The control name.
   *
   * @return the controlName
   */
  public String getControlName() {
    return controlName;
  }

  /**
   * Gets the controlDescription.
   *
   * The control description.
   *
   * @return the controlDescription
   */
  public String getControlDescription() {
    return controlDescription;
  }

  /**
   * Gets the controlSeverity.
   *
   * The control severity.
   *
   * @return the controlSeverity
   */
  public String getControlSeverity() {
    return controlSeverity;
  }

  /**
   * Gets the controlCategory.
   *
   * The control category.
   *
   * @return the controlCategory
   */
  public String getControlCategory() {
    return controlCategory;
  }

  /**
   * Gets the controlParent.
   *
   * The control parent.
   *
   * @return the controlParent
   */
  public String getControlParent() {
    return controlParent;
  }

  /**
   * Gets the controlDocs.
   *
   * Control Docs.
   *
   * @return the controlDocs
   */
  public ControlDocs getControlDocs() {
    return controlDocs;
  }

  /**
   * Gets the controlSpecifications.
   *
   * control specifications.
   *
   * @return the controlSpecifications
   */
  public List<ControlSpecifications> getControlSpecifications() {
    return controlSpecifications;
  }
}

