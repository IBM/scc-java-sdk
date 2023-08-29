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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The details of the last scan of an attachment.
 */
public class LastScan extends GenericModel {

  /**
   * The status of the last scan of an attachment.
   */
  public interface Status {
    /** in_progress. */
    String IN_PROGRESS = "in_progress";
    /** completed. */
    String COMPLETED = "completed";
  }

  protected String id;
  protected String status;
  protected Date time;

  /**
   * Builder.
   */
  public static class Builder {
    private String id;
    private String status;
    private Date time;

    /**
     * Instantiates a new Builder from an existing LastScan instance.
     *
     * @param lastScan the instance to initialize the Builder with
     */
    private Builder(LastScan lastScan) {
      this.id = lastScan.id;
      this.status = lastScan.status;
      this.time = lastScan.time;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a LastScan.
     *
     * @return the new LastScan instance
     */
    public LastScan build() {
      return new LastScan(this);
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the LastScan builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the status.
     *
     * @param status the status
     * @return the LastScan builder
     */
    public Builder status(String status) {
      this.status = status;
      return this;
    }

    /**
     * Set the time.
     *
     * @param time the time
     * @return the LastScan builder
     */
    public Builder time(Date time) {
      this.time = time;
      return this;
    }
  }

  protected LastScan() { }

  protected LastScan(Builder builder) {
    id = builder.id;
    status = builder.status;
    time = builder.time;
  }

  /**
   * New builder.
   *
   * @return a LastScan builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the id.
   *
   * The ID of the last scan of an attachment.
   *
   * @return the id
   */
  public String id() {
    return id;
  }

  /**
   * Gets the status.
   *
   * The status of the last scan of an attachment.
   *
   * @return the status
   */
  public String status() {
    return status;
  }

  /**
   * Gets the time.
   *
   * The time when the last scan started.
   *
   * @return the time
   */
  public Date time() {
    return time;
  }
}

