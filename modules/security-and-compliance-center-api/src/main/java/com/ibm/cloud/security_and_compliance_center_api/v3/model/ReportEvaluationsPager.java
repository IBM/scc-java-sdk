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
 * ReportEvaluationsPager can be used to simplify the use of the "listReportEvaluations" method.
 */
public class ReportEvaluationsPager {
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
  protected ListReportEvaluationsOptions options;
  protected SecurityAndComplianceCenterApi client;
  protected PageContext pageContext;

  // Hide the default ctor.
  protected ReportEvaluationsPager() { }

  /**
   * Constructs a new ReportEvaluationsPager instance with the specified client and options model instance.
   * @param client the SecurityAndComplianceCenterApi instance to be used to invoke the "listReportEvaluations" method
   * @param options the ListReportEvaluationsOptions instance to be used to invoke the "listReportEvaluations" method
   */
  public ReportEvaluationsPager(SecurityAndComplianceCenterApi client, ListReportEvaluationsOptions options) {
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
   * @return a List&lt;Evaluation&gt; that contains the next page of results
   */
  public List<Evaluation> getNext() {
    if (!hasNext()) {
      throw new NoSuchElementException("No more results available");
    }

    ListReportEvaluationsOptions.Builder builder = this.options.newBuilder();
    if (this.pageContext.getNext() != null) {
      builder.start(this.pageContext.getNext());
    }
    this.options = builder.build();

    EvaluationPage result = client.listReportEvaluations(options).execute().getResult();

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

    return result.getEvaluations();
  }

  /**
   * Returns all results by invoking getNext() repeatedly until all pages of results have been retrieved.
   * @return a List&lt;Evaluation&gt; containing all results returned by the "listReportEvaluations" method
   */
  public List<Evaluation> getAll() {
    List<Evaluation> results = new ArrayList<>();
    while (hasNext()) {
      List<Evaluation> nextPage = getNext();
      results.addAll(nextPage);
    }
    return results;
  }
}
