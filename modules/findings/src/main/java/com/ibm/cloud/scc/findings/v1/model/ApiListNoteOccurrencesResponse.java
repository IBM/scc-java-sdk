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
package com.ibm.cloud.scc.findings.v1.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Response including listed occurrences for a note.
 */
public class ApiListNoteOccurrencesResponse extends GenericModel {

  protected List<ApiOccurrence> occurrences;
  @SerializedName("next_page_token")
  protected String nextPageToken;

  /**
   * Gets the occurrences.
   *
   * The occurrences attached to the specified note.
   *
   * @return the occurrences
   */
  public List<ApiOccurrence> getOccurrences() {
    return occurrences;
  }

  /**
   * Gets the nextPageToken.
   *
   * Token to receive the next page of notes.
   *
   * @return the nextPageToken
   */
  public String getNextPageToken() {
    return nextPageToken;
  }
}

