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
package com.ibm.cloud.scc.notifications_api.v1.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Response including channels.
 */
public class ChannelGetChannel extends GenericModel {

  /**
   * Type of callback URL.
   */
  public interface Type {
    /** Webhook. */
    String WEBHOOK = "Webhook";
  }

  @SerializedName("channel_id")
  protected String channelId;
  protected String name;
  protected String description;
  protected String type;
  protected ChannelGetChannelSeverity severity;
  protected String endpoint;
  protected Boolean enabled;
  @SerializedName("alert_source")
  protected List<ChannelGetChannelAlertSourceItem> alertSource;
  protected String frequency;

  /**
   * Gets the channelId.
   *
   * A unique ID for the channel.
   *
   * @return the channelId
   */
  public String getChannelId() {
    return channelId;
  }

  /**
   * Gets the name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the description.
   *
   * A one sentence description of this `Channel`.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the type.
   *
   * Type of callback URL.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Gets the severity.
   *
   * The severity of the notification.
   *
   * @return the severity
   */
  public ChannelGetChannelSeverity getSeverity() {
    return severity;
  }

  /**
   * Gets the endpoint.
   *
   * The callback URL which receives the notification.
   *
   * @return the endpoint
   */
  public String getEndpoint() {
    return endpoint;
  }

  /**
   * Gets the enabled.
   *
   * Whether the channel is enabled. The default is disabled.
   *
   * @return the enabled
   */
  public Boolean isEnabled() {
    return enabled;
  }

  /**
   * Gets the alertSource.
   *
   * @return the alertSource
   */
  public List<ChannelGetChannelAlertSourceItem> getAlertSource() {
    return alertSource;
  }

  /**
   * Gets the frequency.
   *
   * @return the frequency
   */
  public String getFrequency() {
    return frequency;
  }
}

