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

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The updateNotificationChannel options.
 */
public class UpdateNotificationChannelOptions extends GenericModel {

  /**
   * Type of callback URL.
   */
  public interface Type {
    /** Webhook. */
    String WEBHOOK = "Webhook";
  }

  public interface Severity {
    /** low. */
    String LOW = "low";
    /** medium. */
    String MEDIUM = "medium";
    /** high. */
    String HIGH = "high";
    /** critical. */
    String CRITICAL = "critical";
  }

  protected String accountId;
  protected String channelId;
  protected String name;
  protected String type;
  protected String endpoint;
  protected String description;
  protected List<String> severity;
  protected Boolean enabled;
  protected List<NotificationChannelAlertSourceItem> alertSource;
  protected String transactionId;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountId;
    private String channelId;
    private String name;
    private String type;
    private String endpoint;
    private String description;
    private List<String> severity;
    private Boolean enabled;
    private List<NotificationChannelAlertSourceItem> alertSource;
    private String transactionId;

    private Builder(UpdateNotificationChannelOptions updateNotificationChannelOptions) {
      this.accountId = updateNotificationChannelOptions.accountId;
      this.channelId = updateNotificationChannelOptions.channelId;
      this.name = updateNotificationChannelOptions.name;
      this.type = updateNotificationChannelOptions.type;
      this.endpoint = updateNotificationChannelOptions.endpoint;
      this.description = updateNotificationChannelOptions.description;
      this.severity = updateNotificationChannelOptions.severity;
      this.enabled = updateNotificationChannelOptions.enabled;
      this.alertSource = updateNotificationChannelOptions.alertSource;
      this.transactionId = updateNotificationChannelOptions.transactionId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param accountId the accountId
     * @param channelId the channelId
     * @param name the name
     * @param type the type
     * @param endpoint the endpoint
     */
    public Builder(String accountId, String channelId, String name, String type, String endpoint) {
      this.accountId = accountId;
      this.channelId = channelId;
      this.name = name;
      this.type = type;
      this.endpoint = endpoint;
    }

    /**
     * Builds a UpdateNotificationChannelOptions.
     *
     * @return the new UpdateNotificationChannelOptions instance
     */
    public UpdateNotificationChannelOptions build() {
      return new UpdateNotificationChannelOptions(this);
    }

    /**
     * Adds an severity to severity.
     *
     * @param severity the new severity
     * @return the UpdateNotificationChannelOptions builder
     */
    public Builder addSeverity(String severity) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(severity,
        "severity cannot be null");
      if (this.severity == null) {
        this.severity = new ArrayList<String>();
      }
      this.severity.add(severity);
      return this;
    }

    /**
     * Adds an alertSource to alertSource.
     *
     * @param alertSource the new alertSource
     * @return the UpdateNotificationChannelOptions builder
     */
    public Builder addAlertSource(NotificationChannelAlertSourceItem alertSource) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(alertSource,
        "alertSource cannot be null");
      if (this.alertSource == null) {
        this.alertSource = new ArrayList<NotificationChannelAlertSourceItem>();
      }
      this.alertSource.add(alertSource);
      return this;
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the UpdateNotificationChannelOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the channelId.
     *
     * @param channelId the channelId
     * @return the UpdateNotificationChannelOptions builder
     */
    public Builder channelId(String channelId) {
      this.channelId = channelId;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the UpdateNotificationChannelOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the UpdateNotificationChannelOptions builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the endpoint.
     *
     * @param endpoint the endpoint
     * @return the UpdateNotificationChannelOptions builder
     */
    public Builder endpoint(String endpoint) {
      this.endpoint = endpoint;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the UpdateNotificationChannelOptions builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the severity.
     * Existing severity will be replaced.
     *
     * @param severity the severity
     * @return the UpdateNotificationChannelOptions builder
     */
    public Builder severity(List<String> severity) {
      this.severity = severity;
      return this;
    }

    /**
     * Set the enabled.
     *
     * @param enabled the enabled
     * @return the UpdateNotificationChannelOptions builder
     */
    public Builder enabled(Boolean enabled) {
      this.enabled = enabled;
      return this;
    }

    /**
     * Set the alertSource.
     * Existing alertSource will be replaced.
     *
     * @param alertSource the alertSource
     * @return the UpdateNotificationChannelOptions builder
     */
    public Builder alertSource(List<NotificationChannelAlertSourceItem> alertSource) {
      this.alertSource = alertSource;
      return this;
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the UpdateNotificationChannelOptions builder
     */
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }
  }

  protected UpdateNotificationChannelOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.accountId,
      "accountId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.channelId,
      "channelId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.name,
      "name cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.type,
      "type cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.endpoint,
      "endpoint cannot be null");
    accountId = builder.accountId;
    channelId = builder.channelId;
    name = builder.name;
    type = builder.type;
    endpoint = builder.endpoint;
    description = builder.description;
    severity = builder.severity;
    enabled = builder.enabled;
    alertSource = builder.alertSource;
    transactionId = builder.transactionId;
  }

  /**
   * New builder.
   *
   * @return a UpdateNotificationChannelOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the accountId.
   *
   * Account ID.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the channelId.
   *
   * Channel ID.
   *
   * @return the channelId
   */
  public String channelId() {
    return channelId;
  }

  /**
   * Gets the name.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the type.
   *
   * Type of callback URL.
   *
   * @return the type
   */
  public String type() {
    return type;
  }

  /**
   * Gets the endpoint.
   *
   * The callback URL which receives the notification.
   *
   * @return the endpoint
   */
  public String endpoint() {
    return endpoint;
  }

  /**
   * Gets the description.
   *
   * A one sentence description of this `Channel`.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the severity.
   *
   * Severity of the notification to be received.
   *
   * @return the severity
   */
  public List<String> severity() {
    return severity;
  }

  /**
   * Gets the enabled.
   *
   * Channel is enabled or not. Default is disabled.
   *
   * @return the enabled
   */
  public Boolean enabled() {
    return enabled;
  }

  /**
   * Gets the alertSource.
   *
   * @return the alertSource
   */
  public List<NotificationChannelAlertSourceItem> alertSource() {
    return alertSource;
  }

  /**
   * Gets the transactionId.
   *
   * The transaction id for the request in uuid v4 format.
   *
   * @return the transactionId
   */
  public String transactionId() {
    return transactionId;
  }
}

