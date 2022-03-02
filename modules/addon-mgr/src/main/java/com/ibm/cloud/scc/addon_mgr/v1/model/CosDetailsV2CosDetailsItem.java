/*
 * (C) Copyright IBM Corp. 2022.
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
package com.ibm.cloud.scc.addon_mgr.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * CosDetailsV2CosDetailsItem.
 */
public class CosDetailsV2CosDetailsItem extends GenericModel {

  /**
   * Insights type.
   */
  public interface Type {
    /** network-insights. */
    String NETWORK_INSIGHTS = "network-insights";
    /** activity-insights. */
    String ACTIVITY_INSIGHTS = "activity-insights";
  }

  @SerializedName("cos_instance")
  protected String cosInstance;
  @SerializedName("bucket_name")
  protected String bucketName;
  protected String description;
  protected String type;
  @SerializedName("cos_bucket_url")
  protected String cosBucketUrl;

  /**
   * Builder.
   */
  public static class Builder {
    private String cosInstance;
    private String bucketName;
    private String description;
    private String type;
    private String cosBucketUrl;

    private Builder(CosDetailsV2CosDetailsItem cosDetailsV2CosDetailsItem) {
      this.cosInstance = cosDetailsV2CosDetailsItem.cosInstance;
      this.bucketName = cosDetailsV2CosDetailsItem.bucketName;
      this.description = cosDetailsV2CosDetailsItem.description;
      this.type = cosDetailsV2CosDetailsItem.type;
      this.cosBucketUrl = cosDetailsV2CosDetailsItem.cosBucketUrl;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param cosInstance the cosInstance
     * @param bucketName the bucketName
     * @param description the description
     * @param type the type
     * @param cosBucketUrl the cosBucketUrl
     */
    public Builder(String cosInstance, String bucketName, String description, String type, String cosBucketUrl) {
      this.cosInstance = cosInstance;
      this.bucketName = bucketName;
      this.description = description;
      this.type = type;
      this.cosBucketUrl = cosBucketUrl;
    }

    /**
     * Builds a CosDetailsV2CosDetailsItem.
     *
     * @return the new CosDetailsV2CosDetailsItem instance
     */
    public CosDetailsV2CosDetailsItem build() {
      return new CosDetailsV2CosDetailsItem(this);
    }

    /**
     * Set the cosInstance.
     *
     * @param cosInstance the cosInstance
     * @return the CosDetailsV2CosDetailsItem builder
     */
    public Builder cosInstance(String cosInstance) {
      this.cosInstance = cosInstance;
      return this;
    }

    /**
     * Set the bucketName.
     *
     * @param bucketName the bucketName
     * @return the CosDetailsV2CosDetailsItem builder
     */
    public Builder bucketName(String bucketName) {
      this.bucketName = bucketName;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the CosDetailsV2CosDetailsItem builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the CosDetailsV2CosDetailsItem builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the cosBucketUrl.
     *
     * @param cosBucketUrl the cosBucketUrl
     * @return the CosDetailsV2CosDetailsItem builder
     */
    public Builder cosBucketUrl(String cosBucketUrl) {
      this.cosBucketUrl = cosBucketUrl;
      return this;
    }
  }

  protected CosDetailsV2CosDetailsItem(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.cosInstance,
      "cosInstance cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.bucketName,
      "bucketName cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.description,
      "description cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.type,
      "type cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.cosBucketUrl,
      "cosBucketUrl cannot be null");
    cosInstance = builder.cosInstance;
    bucketName = builder.bucketName;
    description = builder.description;
    type = builder.type;
    cosBucketUrl = builder.cosBucketUrl;
  }

  /**
   * New builder.
   *
   * @return a CosDetailsV2CosDetailsItem builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the cosInstance.
   *
   * @return the cosInstance
   */
  public String cosInstance() {
    return cosInstance;
  }

  /**
   * Gets the bucketName.
   *
   * @return the bucketName
   */
  public String bucketName() {
    return bucketName;
  }

  /**
   * Gets the description.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the type.
   *
   * Insights type.
   *
   * @return the type
   */
  public String type() {
    return type;
  }

  /**
   * Gets the cosBucketUrl.
   *
   * cos bucket url.
   *
   * @return the cosBucketUrl
   */
  public String cosBucketUrl() {
    return cosBucketUrl;
  }
}

