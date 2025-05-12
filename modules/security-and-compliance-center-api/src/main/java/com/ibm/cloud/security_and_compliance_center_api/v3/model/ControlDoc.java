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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * References to a control documentation.
 */
public class ControlDoc extends GenericModel {

  @SerializedName("control_docs_id")
  protected String controlDocsId;
  @SerializedName("control_docs_type")
  protected String controlDocsType;

  /**
   * Builder.
   */
  public static class Builder {
    private String controlDocsId;
    private String controlDocsType;

    /**
     * Instantiates a new Builder from an existing ControlDoc instance.
     *
     * @param controlDoc the instance to initialize the Builder with
     */
    private Builder(ControlDoc controlDoc) {
      this.controlDocsId = controlDoc.controlDocsId;
      this.controlDocsType = controlDoc.controlDocsType;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ControlDoc.
     *
     * @return the new ControlDoc instance
     */
    public ControlDoc build() {
      return new ControlDoc(this);
    }

    /**
     * Set the controlDocsId.
     *
     * @param controlDocsId the controlDocsId
     * @return the ControlDoc builder
     */
    public Builder controlDocsId(String controlDocsId) {
      this.controlDocsId = controlDocsId;
      return this;
    }

    /**
     * Set the controlDocsType.
     *
     * @param controlDocsType the controlDocsType
     * @return the ControlDoc builder
     */
    public Builder controlDocsType(String controlDocsType) {
      this.controlDocsType = controlDocsType;
      return this;
    }
  }

  protected ControlDoc() { }

  protected ControlDoc(Builder builder) {
    controlDocsId = builder.controlDocsId;
    controlDocsType = builder.controlDocsType;
  }

  /**
   * New builder.
   *
   * @return a ControlDoc builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the controlDocsId.
   *
   * The ID of the control doc.
   *
   * @return the controlDocsId
   */
  public String controlDocsId() {
    return controlDocsId;
  }

  /**
   * Gets the controlDocsType.
   *
   * The type of the control doc.
   *
   * @return the controlDocsType
   */
  public String controlDocsType() {
    return controlDocsType;
  }
}

