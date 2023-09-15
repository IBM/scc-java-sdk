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

import java.util.Date;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The Cloud Object Storage settings.
 */
public class ObjectStorage extends GenericModel {

  @SerializedName("instance_crn")
  protected String instanceCrn;
  protected String bucket;
  @SerializedName("bucket_location")
  protected String bucketLocation;
  @SerializedName("bucket_endpoint")
  protected String bucketEndpoint;
  @SerializedName("updated_on")
  protected Date updatedOn;

  /**
   * Builder.
   */
  public static class Builder {
    private String instanceCrn;
    private String bucket;
    private String bucketLocation;
    private String bucketEndpoint;
    private Date updatedOn;

    /**
     * Instantiates a new Builder from an existing ObjectStorage instance.
     *
     * @param objectStorage the instance to initialize the Builder with
     */
    private Builder(ObjectStorage objectStorage) {
      this.instanceCrn = objectStorage.instanceCrn;
      this.bucket = objectStorage.bucket;
      this.bucketLocation = objectStorage.bucketLocation;
      this.bucketEndpoint = objectStorage.bucketEndpoint;
      this.updatedOn = objectStorage.updatedOn;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ObjectStorage.
     *
     * @return the new ObjectStorage instance
     */
    public ObjectStorage build() {
      return new ObjectStorage(this);
    }

    /**
     * Set the instanceCrn.
     *
     * @param instanceCrn the instanceCrn
     * @return the ObjectStorage builder
     */
    public Builder instanceCrn(String instanceCrn) {
      this.instanceCrn = instanceCrn;
      return this;
    }

    /**
     * Set the bucket.
     *
     * @param bucket the bucket
     * @return the ObjectStorage builder
     */
    public Builder bucket(String bucket) {
      this.bucket = bucket;
      return this;
    }

    /**
     * Set the bucketLocation.
     *
     * @param bucketLocation the bucketLocation
     * @return the ObjectStorage builder
     */
    public Builder bucketLocation(String bucketLocation) {
      this.bucketLocation = bucketLocation;
      return this;
    }

    /**
     * Set the bucketEndpoint.
     *
     * @param bucketEndpoint the bucketEndpoint
     * @return the ObjectStorage builder
     */
    public Builder bucketEndpoint(String bucketEndpoint) {
      this.bucketEndpoint = bucketEndpoint;
      return this;
    }

    /**
     * Set the updatedOn.
     *
     * @param updatedOn the updatedOn
     * @return the ObjectStorage builder
     */
    public Builder updatedOn(Date updatedOn) {
      this.updatedOn = updatedOn;
      return this;
    }
  }

  protected ObjectStorage() { }

  protected ObjectStorage(Builder builder) {
    instanceCrn = builder.instanceCrn;
    bucket = builder.bucket;
    bucketLocation = builder.bucketLocation;
    bucketEndpoint = builder.bucketEndpoint;
    updatedOn = builder.updatedOn;
  }

  /**
   * New builder.
   *
   * @return a ObjectStorage builder
   */
  public Builder newBuilder() {
    return new Builder(this);
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
   * Gets the bucketLocation.
   *
   * The connected Cloud Object Storage bucket location.
   *
   * @return the bucketLocation
   */
  public String bucketLocation() {
    return bucketLocation;
  }

  /**
   * Gets the bucketEndpoint.
   *
   * The connected Cloud Object Storage bucket endpoint.
   *
   * @return the bucketEndpoint
   */
  public String bucketEndpoint() {
    return bucketEndpoint;
  }

  /**
   * Gets the updatedOn.
   *
   * The date when the bucket connection was updated.
   *
   * @return the updatedOn
   */
  public Date updatedOn() {
    return updatedOn;
  }
}

