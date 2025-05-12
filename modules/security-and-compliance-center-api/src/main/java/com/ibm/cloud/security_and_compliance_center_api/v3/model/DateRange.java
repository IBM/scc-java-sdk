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
 * Date range.
 */
public class DateRange extends GenericModel {

  @SerializedName("start_date")
  protected Date startDate;
  @SerializedName("end_date")
  protected Date endDate;

  /**
   * Builder.
   */
  public static class Builder {
    private Date startDate;
    private Date endDate;

    /**
     * Instantiates a new Builder from an existing DateRange instance.
     *
     * @param dateRange the instance to initialize the Builder with
     */
    private Builder(DateRange dateRange) {
      this.startDate = dateRange.startDate;
      this.endDate = dateRange.endDate;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param startDate the startDate
     * @param endDate the endDate
     */
    public Builder(Date startDate, Date endDate) {
      this.startDate = startDate;
      this.endDate = endDate;
    }

    /**
     * Builds a DateRange.
     *
     * @return the new DateRange instance
     */
    public DateRange build() {
      return new DateRange(this);
    }

    /**
     * Set the startDate.
     *
     * @param startDate the startDate
     * @return the DateRange builder
     */
    public Builder startDate(Date startDate) {
      this.startDate = startDate;
      return this;
    }

    /**
     * Set the endDate.
     *
     * @param endDate the endDate
     * @return the DateRange builder
     */
    public Builder endDate(Date endDate) {
      this.endDate = endDate;
      return this;
    }
  }

  protected DateRange() { }

  protected DateRange(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.startDate,
      "startDate cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.endDate,
      "endDate cannot be null");
    startDate = builder.startDate;
    endDate = builder.endDate;
  }

  /**
   * New builder.
   *
   * @return a DateRange builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the startDate.
   *
   * date/time for the start of the range.
   *
   * @return the startDate
   */
  public Date startDate() {
    return startDate;
  }

  /**
   * Gets the endDate.
   *
   * date/time for the end of the range.
   *
   * @return the endDate
   */
  public Date endDate() {
    return endDate;
  }
}

