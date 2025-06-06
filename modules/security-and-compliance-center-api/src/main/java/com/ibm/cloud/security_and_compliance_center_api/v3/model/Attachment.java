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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The attachment that is associated with a report.
 */
public class Attachment extends GenericModel {

  protected String id;
  protected String name;
  protected String description;
  protected String schedule;
  protected Object scope;
  protected List<Scope> scopes;
  protected AttachmentNotifications notifications;

  protected Attachment() { }

  /**
   * Gets the id.
   *
   * The attachment ID.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the name.
   *
   * The name of the attachment.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the description.
   *
   * The description of the attachment.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the schedule.
   *
   * The attachment schedule.
   *
   * @return the schedule
   */
  public String getSchedule() {
    return schedule;
  }

  /**
   * Gets the scope.
   *
   * (deprecated) The scope associated with the report.
   *
   * @return the scope
   * @deprecated this method is deprecated and may be removed in a future release
   */
  @Deprecated
  public Object getScope() {
    return scope;
  }

  /**
   * Gets the scopes.
   *
   * The report's scopes based on the caller's access permissions.
   *
   * @return the scopes
   */
  public List<Scope> getScopes() {
    return scopes;
  }

  /**
   * Gets the notifications.
   *
   * The notification configuration of the attachment.
   *
   * @return the notifications
   */
  public AttachmentNotifications getNotifications() {
    return notifications;
  }
}

