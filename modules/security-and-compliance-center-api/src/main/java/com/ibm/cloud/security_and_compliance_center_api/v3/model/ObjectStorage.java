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

  protected ObjectStorage() { }

  /**
   * Gets the instanceCrn.
   *
   * The connected Cloud Object Storage instance CRN.
   *
   * @return the instanceCrn
   */
  public String getInstanceCrn() {
    return instanceCrn;
  }

  /**
   * Gets the bucket.
   *
   * The connected Cloud Object Storage bucket name.
   *
   * @return the bucket
   */
  public String getBucket() {
    return bucket;
  }

  /**
   * Gets the bucketLocation.
   *
   * The connected Cloud Object Storage bucket location.
   *
   * @return the bucketLocation
   */
  public String getBucketLocation() {
    return bucketLocation;
  }

  /**
   * Gets the bucketEndpoint.
   *
   * The connected Cloud Object Storage bucket endpoint.
   *
   * @return the bucketEndpoint
   */
  public String getBucketEndpoint() {
    return bucketEndpoint;
  }

  /**
   * Gets the updatedOn.
   *
   * The date when the bucket connection was updated.
   *
   * @return the updatedOn
   */
  public Date getUpdatedOn() {
    return updatedOn;
  }
}

