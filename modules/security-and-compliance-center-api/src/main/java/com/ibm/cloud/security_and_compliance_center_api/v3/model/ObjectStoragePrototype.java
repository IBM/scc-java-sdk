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
 * The payload to connect a Cloud Object Storage instance to an Security and Compliance Center instance.
 */
public class ObjectStoragePrototype extends GenericModel {

  protected String bucket;
  @SerializedName("instance_crn")
  protected String instanceCrn;

  /**
   * Builder.
   */
  public static class Builder {
    private String bucket;
    private String instanceCrn;

    /**
     * Instantiates a new Builder from an existing ObjectStoragePrototype instance.
     *
     * @param objectStoragePrototype the instance to initialize the Builder with
     */
    private Builder(ObjectStoragePrototype objectStoragePrototype) {
      this.bucket = objectStoragePrototype.bucket;
      this.instanceCrn = objectStoragePrototype.instanceCrn;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ObjectStoragePrototype.
     *
     * @return the new ObjectStoragePrototype instance
     */
    public ObjectStoragePrototype build() {
      return new ObjectStoragePrototype(this);
    }

    /**
     * Set the bucket.
     *
     * @param bucket the bucket
     * @return the ObjectStoragePrototype builder
     */
    public Builder bucket(String bucket) {
      this.bucket = bucket;
      return this;
    }

    /**
     * Set the instanceCrn.
     *
     * @param instanceCrn the instanceCrn
     * @return the ObjectStoragePrototype builder
     */
    public Builder instanceCrn(String instanceCrn) {
      this.instanceCrn = instanceCrn;
      return this;
    }
  }

  protected ObjectStoragePrototype() { }

  protected ObjectStoragePrototype(Builder builder) {
    bucket = builder.bucket;
    instanceCrn = builder.instanceCrn;
  }

  /**
   * New builder.
   *
   * @return a ObjectStoragePrototype builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the bucket.
   *
   * The connected Cloud Object Storage bucket name.
   *
   * @return the bucket
   */
  public String bucket() {
    return bucket;
  }

  /**
   * Gets the instanceCrn.
   *
   * The connected Cloud Object Storage instance CRN.
   *
   * @return the instanceCrn
   */
  public String instanceCrn() {
    return instanceCrn;
  }
}

