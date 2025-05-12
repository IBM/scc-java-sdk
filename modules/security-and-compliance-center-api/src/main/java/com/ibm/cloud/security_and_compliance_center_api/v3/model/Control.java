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

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * A technical, administrative, or physical safeguard designed to meet a set of defined security and privacy
 * requirements.
 */
public class Control extends GenericModel {

  @SerializedName("control_name")
  protected String controlName;
  @SerializedName("control_id")
  protected String controlId;
  @SerializedName("control_description")
  protected String controlDescription;
  @SerializedName("control_category")
  protected String controlCategory;
  @SerializedName("control_parent")
  protected String controlParent;
  @SerializedName("control_severity")
  protected String controlSeverity;
  @SerializedName("control_tags")
  protected List<String> controlTags;
  @SerializedName("control_specifications")
  protected List<ControlSpecification> controlSpecifications;
  @SerializedName("control_docs")
  protected ControlDoc controlDocs;
  protected String status;

  protected Control() { }

  /**
   * Gets the controlName.
   *
   * The ID of the control library that contains the profile.
   *
   * @return the controlName
   */
  public String getControlName() {
    return controlName;
  }

  /**
   * Gets the controlId.
   *
   * The control name.
   *
   * @return the controlId
   */
  public String getControlId() {
    return controlId;
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
   * Gets the controlCategory.
   *
   * The association of the control.
   *
   * @return the controlCategory
   */
  public String getControlCategory() {
    return controlCategory;
  }

  /**
   * Gets the controlParent.
   *
   * The ID of the parent control.
   *
   * @return the controlParent
   */
  public String getControlParent() {
    return controlParent;
  }

  /**
   * Gets the controlSeverity.
   *
   * Details how important a control is should it fail.
   *
   * @return the controlSeverity
   */
  public String getControlSeverity() {
    return controlSeverity;
  }

  /**
   * Gets the controlTags.
   *
   * tags associated with a control.
   *
   * @return the controlTags
   */
  public List<String> getControlTags() {
    return controlTags;
  }

  /**
   * Gets the controlSpecifications.
   *
   * List of control specifications associated with the control.
   *
   * @return the controlSpecifications
   */
  public List<ControlSpecification> getControlSpecifications() {
    return controlSpecifications;
  }

  /**
   * Gets the controlDocs.
   *
   * References to a control documentation.
   *
   * @return the controlDocs
   */
  public ControlDoc getControlDocs() {
    return controlDocs;
  }

  /**
   * Gets the status.
   *
   * Determines if a control will be evaluated or not.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }
}

