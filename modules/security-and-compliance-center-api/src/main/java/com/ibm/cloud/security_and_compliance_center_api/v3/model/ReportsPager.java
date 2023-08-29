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

import com.ibm.cloud.sdk.core.util.UrlHelper;
import com.ibm.cloud.security_and_compliance_center_api.v3.SecurityAndComplianceCenterApi;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * ReportsPager can be used to simplify the use of the "listReports" method.
 */
public class ReportsPager {
  private static class PageContext {
    private String next;
    public String getNext() {
      return next;
    }
    public void setNext(String next) {
      this.next = next;
    }
  }

  protected boolean hasNext;
  protected ListReportsOptions options;
  protected SecurityAndComplianceCenterApi client;
  protected PageContext pageContext;

  // Hide the default ctor.
  protected ReportsPager() { }

  /**
   * Constructs a new ReportsPager instance with the specified client and options model instance.
   * @param client the SecurityAndComplianceCenterApi instance to be used to invoke the "listReports" method
   * @param options the ListReportsOptions instance to be used to invoke the "listReports" method
   */
  public ReportsPager(SecurityAndComplianceCenterApi client, ListReportsOptions options) {
    if (options.start() != null) {
      throw new IllegalArgumentException("The options 'start' field should not be set");
    }

    this.hasNext = true;
    this.client = client;
    this.options = options.newBuilder().build();
    this.pageContext = new PageContext();
  }

  /**
   * Returns true if there are more results to be retrieved.
   * @return boolean
   */
  public boolean hasNext() {
    return hasNext;
  }

  /**
   * Returns the next page of results.
   * @return a List&lt;Report&gt; that contains the next page of results
   */
  public List<Report> getNext() {
    if (!hasNext()) {
      throw new NoSuchElementException("No more results available");
    }

    ListReportsOptions.Builder builder = this.options.newBuilder();
    if (this.pageContext.getNext() != null) {
      builder.start(this.pageContext.getNext());
    }
    this.options = builder.build();

    ReportPage result = client.listReports(options).execute().getResult();

    String next = null;
    if (result.getNext() != null) {
      String queryParam = UrlHelper.getQueryParam(result.getNext().getHref(), "start");
      if (queryParam != null) {
        next = queryParam;
      }
    }
    this.pageContext.setNext(next);
    if (next == null) {
      this.hasNext = false;
    }

    return result.getReports();
  }

  /**
   * Returns all results by invoking getNext() repeatedly until all pages of results have been retrieved.
   * @return a List&lt;Report&gt; containing all results returned by the "listReports" method
   */
  public List<Report> getAll() {
    List<Report> results = new ArrayList<>();
    while (hasNext()) {
      List<Report> nextPage = getNext();
      results.addAll(nextPage);
    }
    return results;
  }
}
