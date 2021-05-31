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

package com.ibm.cloud.scc.findings.v1;

import com.ibm.cloud.scc.findings.v1.model.ApiListNoteOccurrencesResponse;
import com.ibm.cloud.scc.findings.v1.model.ApiListNotesResponse;
import com.ibm.cloud.scc.findings.v1.model.ApiListOccurrencesResponse;
import com.ibm.cloud.scc.findings.v1.model.ApiListProvidersResponse;
import com.ibm.cloud.scc.findings.v1.model.ApiNote;
import com.ibm.cloud.scc.findings.v1.model.ApiOccurrence;
import com.ibm.cloud.scc.findings.v1.model.CreateNoteOptions;
import com.ibm.cloud.scc.findings.v1.model.CreateOccurrenceOptions;
import com.ibm.cloud.scc.findings.v1.model.DeleteNoteOptions;
import com.ibm.cloud.scc.findings.v1.model.DeleteOccurrenceOptions;
import com.ibm.cloud.scc.findings.v1.model.GetNoteOptions;
import com.ibm.cloud.scc.findings.v1.model.GetOccurrenceNoteOptions;
import com.ibm.cloud.scc.findings.v1.model.GetOccurrenceOptions;
import com.ibm.cloud.scc.findings.v1.model.ListNoteOccurrencesOptions;
import com.ibm.cloud.scc.findings.v1.model.ListNotesOptions;
import com.ibm.cloud.scc.findings.v1.model.ListOccurrencesOptions;
import com.ibm.cloud.scc.findings.v1.model.ListProvidersOptions;
import com.ibm.cloud.scc.findings.v1.model.PostGraphOptions;
import com.ibm.cloud.scc.findings.v1.model.Reporter;
import com.ibm.cloud.scc.findings.v1.model.UpdateNoteOptions;
import com.ibm.cloud.scc.findings.v1.model.UpdateOccurrenceOptions;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.util.CredentialUtils;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//
// This file provides an example of how to use the Findings service.
//
// The following configuration properties are assumed to be defined:
// FINDINGS_URL=<service base url>
// FINDINGS_AUTH_TYPE=iam
// FINDINGS_APIKEY=<IAM apikey>
// FINDINGS_AUTH_URL=<IAM token service base URL - omit this if using the production environment>
//
// These configuration properties can be exported as environment variables, or stored
// in a configuration file and then:
// export IBM_CREDENTIALS_FILE=<name of configuration file>
//
public class FindingsExamples {
  private static final Logger logger = LoggerFactory.getLogger(FindingsExamples.class);
  protected FindingsExamples() { }

  @SuppressWarnings("checkstyle:methodlength")
  public static void main(String[] args) throws Exception {
    Findings service = Findings.newInstance();

    // Load up our test-specific config properties.
    Map<String, String> config = CredentialUtils.getServiceProperties(Findings.DEFAULT_SERVICE_NAME);

    try {
      // begin-postGraph
      PostGraphOptions postGraphOptions = new PostGraphOptions.Builder()
        .accountId("testString")
        .body(new java.io.ByteArrayInputStream("This is a mock file.".getBytes()))
        .build();

      Response<Void> response = service.postGraph(postGraphOptions).execute();
      // end-postGraph
      System.out.printf("postGraph() response status code: %d%n", response.getStatusCode());
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("createNote() result:");
      // begin-createNote
      Reporter reporterModel = new Reporter.Builder()
        .id("testString")
        .title("testString")
        .build();
      CreateNoteOptions createNoteOptions = new CreateNoteOptions.Builder()
        .accountId("testString")
        .providerId("testString")
        .shortDescription("testString")
        .longDescription("testString")
        .kind("FINDING")
        .id("testString")
        .reportedBy(reporterModel)
        .build();

      Response<ApiNote> response = service.createNote(createNoteOptions).execute();
      ApiNote apiNote = response.getResult();

      System.out.println(apiNote);
      // end-createNote
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("listNotes() result:");
      // begin-listNotes
      ListNotesOptions listNotesOptions = new ListNotesOptions.Builder()
        .accountId("testString")
        .providerId("testString")
        .build();

      Response<ApiListNotesResponse> response = service.listNotes(listNotesOptions).execute();
      ApiListNotesResponse apiListNotesResponse = response.getResult();

      System.out.println(apiListNotesResponse);
      // end-listNotes
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getNote() result:");
      // begin-getNote
      GetNoteOptions getNoteOptions = new GetNoteOptions.Builder()
        .accountId("testString")
        .providerId("testString")
        .noteId("testString")
        .build();

      Response<ApiNote> response = service.getNote(getNoteOptions).execute();
      ApiNote apiNote = response.getResult();

      System.out.println(apiNote);
      // end-getNote
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("updateNote() result:");
      // begin-updateNote
      Reporter reporterModel = new Reporter.Builder()
        .id("testString")
        .title("testString")
        .build();
      UpdateNoteOptions updateNoteOptions = new UpdateNoteOptions.Builder()
        .accountId("testString")
        .providerId("testString")
        .noteId("testString")
        .shortDescription("testString")
        .longDescription("testString")
        .kind("FINDING")
        .id("testString")
        .reportedBy(reporterModel)
        .build();

      Response<ApiNote> response = service.updateNote(updateNoteOptions).execute();
      ApiNote apiNote = response.getResult();

      System.out.println(apiNote);
      // end-updateNote
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getOccurrenceNote() result:");
      // begin-getOccurrenceNote
      GetOccurrenceNoteOptions getOccurrenceNoteOptions = new GetOccurrenceNoteOptions.Builder()
        .accountId("testString")
        .providerId("testString")
        .occurrenceId("testString")
        .build();

      Response<ApiNote> response = service.getOccurrenceNote(getOccurrenceNoteOptions).execute();
      ApiNote apiNote = response.getResult();

      System.out.println(apiNote);
      // end-getOccurrenceNote
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("createOccurrence() result:");
      // begin-createOccurrence
      CreateOccurrenceOptions createOccurrenceOptions = new CreateOccurrenceOptions.Builder()
        .accountId("testString")
        .providerId("testString")
        .noteName("testString")
        .kind("FINDING")
        .id("testString")
        .build();

      Response<ApiOccurrence> response = service.createOccurrence(createOccurrenceOptions).execute();
      ApiOccurrence apiOccurrence = response.getResult();

      System.out.println(apiOccurrence);
      // end-createOccurrence
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("listOccurrences() result:");
      // begin-listOccurrences
      ListOccurrencesOptions listOccurrencesOptions = new ListOccurrencesOptions.Builder()
        .accountId("testString")
        .providerId("testString")
        .build();

      Response<ApiListOccurrencesResponse> response = service.listOccurrences(listOccurrencesOptions).execute();
      ApiListOccurrencesResponse apiListOccurrencesResponse = response.getResult();

      System.out.println(apiListOccurrencesResponse);
      // end-listOccurrences
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("listNoteOccurrences() result:");
      // begin-listNoteOccurrences
      ListNoteOccurrencesOptions listNoteOccurrencesOptions = new ListNoteOccurrencesOptions.Builder()
        .accountId("testString")
        .providerId("testString")
        .noteId("testString")
        .build();

      Response<ApiListNoteOccurrencesResponse> response = service.listNoteOccurrences(listNoteOccurrencesOptions).execute();
      ApiListNoteOccurrencesResponse apiListNoteOccurrencesResponse = response.getResult();

      System.out.println(apiListNoteOccurrencesResponse);
      // end-listNoteOccurrences
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getOccurrence() result:");
      // begin-getOccurrence
      GetOccurrenceOptions getOccurrenceOptions = new GetOccurrenceOptions.Builder()
        .accountId("testString")
        .providerId("testString")
        .occurrenceId("testString")
        .build();

      Response<ApiListOccurrencesResponse> response = service.getOccurrence(getOccurrenceOptions).execute();
      ApiListOccurrencesResponse apiListOccurrencesResponse = response.getResult();

      System.out.println(apiListOccurrencesResponse);
      // end-getOccurrence
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("updateOccurrence() result:");
      // begin-updateOccurrence
      UpdateOccurrenceOptions updateOccurrenceOptions = new UpdateOccurrenceOptions.Builder()
        .accountId("testString")
        .providerId("testString")
        .occurrenceId("testString")
        .noteName("testString")
        .kind("FINDING")
        .id("testString")
        .build();

      Response<ApiOccurrence> response = service.updateOccurrence(updateOccurrenceOptions).execute();
      ApiOccurrence apiOccurrence = response.getResult();

      System.out.println(apiOccurrence);
      // end-updateOccurrence
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("listProviders() result:");
      // begin-listProviders
      ListProvidersOptions listProvidersOptions = new ListProvidersOptions.Builder()
        .accountId("testString")
        .build();

      Response<ApiListProvidersResponse> response = service.listProviders(listProvidersOptions).execute();
      ApiListProvidersResponse apiListProvidersResponse = response.getResult();

      System.out.println(apiListProvidersResponse);
      // end-listProviders
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-deleteOccurrence
      DeleteOccurrenceOptions deleteOccurrenceOptions = new DeleteOccurrenceOptions.Builder()
        .accountId("testString")
        .providerId("testString")
        .occurrenceId("testString")
        .build();

      Response<Void> response = service.deleteOccurrence(deleteOccurrenceOptions).execute();
      // end-deleteOccurrence
      System.out.printf("deleteOccurrence() response status code: %d%n", response.getStatusCode());
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-deleteNote
      DeleteNoteOptions deleteNoteOptions = new DeleteNoteOptions.Builder()
        .accountId("testString")
        .providerId("testString")
        .noteId("testString")
        .build();

      Response<Void> response = service.deleteNote(deleteNoteOptions).execute();
      // end-deleteNote
      System.out.printf("deleteNote() response status code: %d%n", response.getStatusCode());
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

  }
}
