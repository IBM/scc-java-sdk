/*
 * (C) Copyright IBM Corp. 2021.
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
package com.ibm.cloud.security_and_compliance_center.notifications_api.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Response of updated channel.
 */
public class UpdateChannelResponse extends GenericModel {

  @SerializedName("channel_id")
  protected String channelId;
  @SerializedName("status_code")
  protected Long statusCode;

  /**
   * Gets the channelId.
   *
   * id of the updated channel.
   *
   * @return the channelId
   */
  public String getChannelId() {
    return channelId;
  }

  /**
   * Gets the statusCode.
   *
   * response code.
   *
   * @return the statusCode
   */
  public Long getStatusCode() {
    return statusCode;
  }
}

