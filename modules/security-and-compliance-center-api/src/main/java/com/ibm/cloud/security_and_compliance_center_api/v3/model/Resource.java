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
 * The resource.
 */
public class Resource extends GenericModel {

  /**
   * The allowed values of an aggregated status for controls, specifications, assessments, and resources.
   */
  public interface Status {
    /** compliant. */
    String COMPLIANT = "compliant";
    /** not_compliant. */
    String NOT_COMPLIANT = "not_compliant";
    /** unable_to_perform. */
    String UNABLE_TO_PERFORM = "unable_to_perform";
    /** user_evaluation_required. */
    String USER_EVALUATION_REQUIRED = "user_evaluation_required";
    /** not_applicable. */
    String NOT_APPLICABLE = "not_applicable";
  }

  @SerializedName("report_id")
  protected String reportId;
  @SerializedName("home_account_id")
  protected String homeAccountId;
  protected String id;
  @SerializedName("resource_name")
  protected String resourceName;
  protected Account account;
  @SerializedName("component_id")
  protected String componentId;
  @SerializedName("component_name")
  protected String componentName;
  protected String environment;
  protected Tags tags;
  protected String status;
  @SerializedName("total_count")
  protected Long totalCount;
  @SerializedName("pass_count")
  protected Long passCount;
  @SerializedName("failure_count")
  protected Long failureCount;
  @SerializedName("error_count")
  protected Long errorCount;
  @SerializedName("skipped_count")
  protected Long skippedCount;
  @SerializedName("completed_count")
  protected Long completedCount;
  @SerializedName("service_name")
  protected String serviceName;
  @SerializedName("instance_crn")
  protected String instanceCrn;

  /**
   * Builder.
   */
  public static class Builder {
    private String reportId;
    private String homeAccountId;
    private String id;
    private String resourceName;
    private Account account;
    private String componentId;
    private String componentName;
    private String environment;
    private Tags tags;
    private String status;
    private Long totalCount;
    private Long passCount;
    private Long failureCount;
    private Long errorCount;
    private Long skippedCount;
    private Long completedCount;
    private String serviceName;
    private String instanceCrn;

    /**
     * Instantiates a new Builder from an existing Resource instance.
     *
     * @param resource the instance to initialize the Builder with
     */
    private Builder(Resource resource) {
      this.reportId = resource.reportId;
      this.homeAccountId = resource.homeAccountId;
      this.id = resource.id;
      this.resourceName = resource.resourceName;
      this.account = resource.account;
      this.componentId = resource.componentId;
      this.componentName = resource.componentName;
      this.environment = resource.environment;
      this.tags = resource.tags;
      this.status = resource.status;
      this.totalCount = resource.totalCount;
      this.passCount = resource.passCount;
      this.failureCount = resource.failureCount;
      this.errorCount = resource.errorCount;
      this.skippedCount = resource.skippedCount;
      this.completedCount = resource.completedCount;
      this.serviceName = resource.serviceName;
      this.instanceCrn = resource.instanceCrn;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param status the status
     */
    public Builder(String status) {
      this.status = status;
    }

    /**
     * Builds a Resource.
     *
     * @return the new Resource instance
     */
    public Resource build() {
      return new Resource(this);
    }

    /**
     * Set the reportId.
     *
     * @param reportId the reportId
     * @return the Resource builder
     */
    public Builder reportId(String reportId) {
      this.reportId = reportId;
      return this;
    }

    /**
     * Set the homeAccountId.
     *
     * @param homeAccountId the homeAccountId
     * @return the Resource builder
     */
    public Builder homeAccountId(String homeAccountId) {
      this.homeAccountId = homeAccountId;
      return this;
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the Resource builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the resourceName.
     *
     * @param resourceName the resourceName
     * @return the Resource builder
     */
    public Builder resourceName(String resourceName) {
      this.resourceName = resourceName;
      return this;
    }

    /**
     * Set the account.
     *
     * @param account the account
     * @return the Resource builder
     */
    public Builder account(Account account) {
      this.account = account;
      return this;
    }

    /**
     * Set the componentId.
     *
     * @param componentId the componentId
     * @return the Resource builder
     */
    public Builder componentId(String componentId) {
      this.componentId = componentId;
      return this;
    }

    /**
     * Set the componentName.
     *
     * @param componentName the componentName
     * @return the Resource builder
     */
    public Builder componentName(String componentName) {
      this.componentName = componentName;
      return this;
    }

    /**
     * Set the environment.
     *
     * @param environment the environment
     * @return the Resource builder
     */
    public Builder environment(String environment) {
      this.environment = environment;
      return this;
    }

    /**
     * Set the tags.
     *
     * @param tags the tags
     * @return the Resource builder
     */
    public Builder tags(Tags tags) {
      this.tags = tags;
      return this;
    }

    /**
     * Set the status.
     *
     * @param status the status
     * @return the Resource builder
     */
    public Builder status(String status) {
      this.status = status;
      return this;
    }

    /**
     * Set the totalCount.
     *
     * @param totalCount the totalCount
     * @return the Resource builder
     */
    public Builder totalCount(long totalCount) {
      this.totalCount = totalCount;
      return this;
    }

    /**
     * Set the passCount.
     *
     * @param passCount the passCount
     * @return the Resource builder
     */
    public Builder passCount(long passCount) {
      this.passCount = passCount;
      return this;
    }

    /**
     * Set the failureCount.
     *
     * @param failureCount the failureCount
     * @return the Resource builder
     */
    public Builder failureCount(long failureCount) {
      this.failureCount = failureCount;
      return this;
    }

    /**
     * Set the errorCount.
     *
     * @param errorCount the errorCount
     * @return the Resource builder
     */
    public Builder errorCount(long errorCount) {
      this.errorCount = errorCount;
      return this;
    }

    /**
     * Set the skippedCount.
     *
     * @param skippedCount the skippedCount
     * @return the Resource builder
     */
    public Builder skippedCount(long skippedCount) {
      this.skippedCount = skippedCount;
      return this;
    }

    /**
     * Set the completedCount.
     *
     * @param completedCount the completedCount
     * @return the Resource builder
     */
    public Builder completedCount(long completedCount) {
      this.completedCount = completedCount;
      return this;
    }

    /**
     * Set the serviceName.
     *
     * @param serviceName the serviceName
     * @return the Resource builder
     */
    public Builder serviceName(String serviceName) {
      this.serviceName = serviceName;
      return this;
    }

    /**
     * Set the instanceCrn.
     *
     * @param instanceCrn the instanceCrn
     * @return the Resource builder
     */
    public Builder instanceCrn(String instanceCrn) {
      this.instanceCrn = instanceCrn;
      return this;
    }
  }

  protected Resource() { }

  protected Resource(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.status,
      "status cannot be null");
    reportId = builder.reportId;
    homeAccountId = builder.homeAccountId;
    id = builder.id;
    resourceName = builder.resourceName;
    account = builder.account;
    componentId = builder.componentId;
    componentName = builder.componentName;
    environment = builder.environment;
    tags = builder.tags;
    status = builder.status;
    totalCount = builder.totalCount;
    passCount = builder.passCount;
    failureCount = builder.failureCount;
    errorCount = builder.errorCount;
    skippedCount = builder.skippedCount;
    completedCount = builder.completedCount;
    serviceName = builder.serviceName;
    instanceCrn = builder.instanceCrn;
  }

  /**
   * New builder.
   *
   * @return a Resource builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the reportId.
   *
   * The ID of the report.
   *
   * @return the reportId
   */
  public String reportId() {
    return reportId;
  }

  /**
   * Gets the homeAccountId.
   *
   * The ID of the home account.
   *
   * @return the homeAccountId
   */
  public String homeAccountId() {
    return homeAccountId;
  }

  /**
   * Gets the id.
   *
   * The resource CRN.
   *
   * @return the id
   */
  public String id() {
    return id;
  }

  /**
   * Gets the resourceName.
   *
   * The resource name.
   *
   * @return the resourceName
   */
  public String resourceName() {
    return resourceName;
  }

  /**
   * Gets the account.
   *
   * The account that is associated with a report.
   *
   * @return the account
   */
  public Account account() {
    return account;
  }

  /**
   * Gets the componentId.
   *
   * The ID of the component.
   *
   * @return the componentId
   */
  public String componentId() {
    return componentId;
  }

  /**
   * Gets the componentName.
   *
   * The name of the component.
   *
   * @return the componentName
   */
  public String componentName() {
    return componentName;
  }

  /**
   * Gets the environment.
   *
   * The environment.
   *
   * @return the environment
   */
  public String environment() {
    return environment;
  }

  /**
   * Gets the tags.
   *
   * The collection of different types of tags.
   *
   * @return the tags
   */
  public Tags tags() {
    return tags;
  }

  /**
   * Gets the status.
   *
   * The allowed values of an aggregated status for controls, specifications, assessments, and resources.
   *
   * @return the status
   */
  public String status() {
    return status;
  }

  /**
   * Gets the totalCount.
   *
   * The total number of evaluations.
   *
   * @return the totalCount
   */
  public Long totalCount() {
    return totalCount;
  }

  /**
   * Gets the passCount.
   *
   * The number of passed evaluations.
   *
   * @return the passCount
   */
  public Long passCount() {
    return passCount;
  }

  /**
   * Gets the failureCount.
   *
   * The number of failed evaluations.
   *
   * @return the failureCount
   */
  public Long failureCount() {
    return failureCount;
  }

  /**
   * Gets the errorCount.
   *
   * The number of evaluations that started, but did not finish, and ended with errors.
   *
   * @return the errorCount
   */
  public Long errorCount() {
    return errorCount;
  }

  /**
   * Gets the skippedCount.
   *
   * The number of assessments with no corresponding evaluations.
   *
   * @return the skippedCount
   */
  public Long skippedCount() {
    return skippedCount;
  }

  /**
   * Gets the completedCount.
   *
   * The total number of completed evaluations.
   *
   * @return the completedCount
   */
  public Long completedCount() {
    return completedCount;
  }

  /**
   * Gets the serviceName.
   *
   * The name of the service.
   *
   * @return the serviceName
   */
  public String serviceName() {
    return serviceName;
  }

  /**
   * Gets the instanceCrn.
   *
   * The instance CRN.
   *
   * @return the instanceCrn
   */
  public String instanceCrn() {
    return instanceCrn;
  }
}

