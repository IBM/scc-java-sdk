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

import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * AllInsights.
 */
public class AllInsights extends GenericModel {

  /**
   * Insights type.
   */
  public interface Type {
    /** network-insights. */
    String NETWORK_INSIGHTS = "network-insights";
    /** activity-insights. */
    String ACTIVITY_INSIGHTS = "activity-insights";
  }

  protected List<String> type;

  /**
   * Gets the type.
   *
   * @return the type
   */
  public List<String> getType() {
    return type;
  }
}

