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

package com.ibm.cloud.scc.addon_mgr.v1;

import com.ibm.cloud.scc.addon_mgr.v1.model.AddActivityInsightsCosDetailsV2Options;
import com.ibm.cloud.scc.addon_mgr.v1.model.AddNetworkInsightsCosDetailsV2Options;
import com.ibm.cloud.scc.addon_mgr.v1.model.AllInsights;
import com.ibm.cloud.scc.addon_mgr.v1.model.CosDetailsV2CosDetailsItem;
import com.ibm.cloud.scc.addon_mgr.v1.model.DeleteActivityInsightsCosDetailsV2Options;
import com.ibm.cloud.scc.addon_mgr.v1.model.DeleteNetworkInsightsCosDetailsV2Options;
import com.ibm.cloud.scc.addon_mgr.v1.model.DisableInsightsV2Options;
import com.ibm.cloud.scc.addon_mgr.v1.model.EnableInsightsV2Options;
import com.ibm.cloud.scc.addon_mgr.v1.model.GetSupportedInsightsV2Options;
import com.ibm.cloud.scc.addon_mgr.v1.model.TestAIFindingsV2Options;
import com.ibm.cloud.scc.addon_mgr.v1.utils.TestUtilities;
import com.ibm.cloud.scc.test.SdkIntegrationTestBase;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.CredentialUtils;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Integration test class for the AddonMgr service.
 */
public class AddonMgrIT extends SdkIntegrationTestBase {
  public AddonMgr service = null;
  public static Map<String, String> config = null;
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  String accountId = "testString";
  /**
   * This method provides our config filename to the base class.
   */

  public String getConfigFilename() {
    return "../../addon_mgr_v1.env";
  }

  @BeforeClass
  public void constructService() {
    // Ask super if we should skip the tests.
    if (skipTests()) {
      return;
    }

    service = AddonMgr.newInstance(accountId);
    assertNotNull(service);
    assertNotNull(service.getServiceUrl());

    // Load up our test-specific config properties.
    config = CredentialUtils.getServiceProperties(AddonMgr.DEFAULT_SERVICE_NAME);
    assertNotNull(config);
    assertFalse(config.isEmpty());
    assertEquals(service.getServiceUrl(), config.get("URL"));

    service.enableRetries(4, 30);

    System.out.println("Setup complete.");
  }

  @Test
  public void testAddNetworkInsightsCosDetailsV2() throws Exception {
    try {
      CosDetailsV2CosDetailsItem cosDetailsV2CosDetailsItemModel = new CosDetailsV2CosDetailsItem.Builder()
      .cosInstance("testString")
      .bucketName("testString")
      .description("testString")
      .type("network-insights")
      .cosBucketUrl("testString")
      .build();

      AddNetworkInsightsCosDetailsV2Options addNetworkInsightsCosDetailsV2Options = new AddNetworkInsightsCosDetailsV2Options.Builder()
      .regionId("testString")
      .cosDetails(new java.util.ArrayList<CosDetailsV2CosDetailsItem>(java.util.Arrays.asList(cosDetailsV2CosDetailsItemModel)))
      .transactionId("testString")
      .build();

      // Invoke operation
      Response<Void> response = service.addNetworkInsightsCosDetailsV2(addNetworkInsightsCosDetailsV2Options).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testAddActivityInsightsCosDetailsV2() throws Exception {
    try {
      CosDetailsV2CosDetailsItem cosDetailsV2CosDetailsItemModel = new CosDetailsV2CosDetailsItem.Builder()
      .cosInstance("testString")
      .bucketName("testString")
      .description("testString")
      .type("network-insights")
      .cosBucketUrl("testString")
      .build();

      AddActivityInsightsCosDetailsV2Options addActivityInsightsCosDetailsV2Options = new AddActivityInsightsCosDetailsV2Options.Builder()
      .regionId("testString")
      .cosDetails(new java.util.ArrayList<CosDetailsV2CosDetailsItem>(java.util.Arrays.asList(cosDetailsV2CosDetailsItemModel)))
      .transactionId("testString")
      .build();

      // Invoke operation
      Response<Void> response = service.addActivityInsightsCosDetailsV2(addActivityInsightsCosDetailsV2Options).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testDisableInsightsV2() throws Exception {
    try {
      DisableInsightsV2Options disableInsightsV2Options = new DisableInsightsV2Options.Builder()
      .regionId("testString")
      .networkInsights(true)
      .activityInsights(true)
      .transactionId("testString")
      .build();

      // Invoke operation
      Response<Void> response = service.disableInsightsV2(disableInsightsV2Options).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testEnableInsightsV2() throws Exception {
    try {
      EnableInsightsV2Options enableInsightsV2Options = new EnableInsightsV2Options.Builder()
      .regionId("testString")
      .networkInsights(true)
      .activityInsights(true)
      .transactionId("testString")
      .build();

      // Invoke operation
      Response<Void> response = service.enableInsightsV2(enableInsightsV2Options).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testGetSupportedInsightsV2() throws Exception {
    try {
      GetSupportedInsightsV2Options getSupportedInsightsV2Options = new GetSupportedInsightsV2Options.Builder()
      .transactionId("testString")
      .build();

      // Invoke operation
      Response<AllInsights> response = service.getSupportedInsightsV2(getSupportedInsightsV2Options).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      AllInsights allInsightsResult = response.getResult();

      assertNotNull(allInsightsResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testTestAiFindingsV2() throws Exception {
    try {
      TestAIFindingsV2Options testAiFindingsV2Options = new TestAIFindingsV2Options.Builder()
      .regionId("testString")
      .build();

      // Invoke operation
      Response<Void> response = service.testAiFindingsV2(testAiFindingsV2Options).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testDeleteNetworkInsightsCosDetailsV2() throws Exception {
    try {
      DeleteNetworkInsightsCosDetailsV2Options deleteNetworkInsightsCosDetailsV2Options = new DeleteNetworkInsightsCosDetailsV2Options.Builder()
      .ids(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
      .transactionId("testString")
      .build();

      // Invoke operation
      Response<Void> response = service.deleteNetworkInsightsCosDetailsV2(deleteNetworkInsightsCosDetailsV2Options).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testDeleteActivityInsightsCosDetailsV2() throws Exception {
    try {
      DeleteActivityInsightsCosDetailsV2Options deleteActivityInsightsCosDetailsV2Options = new DeleteActivityInsightsCosDetailsV2Options.Builder()
      .ids(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
      .transactionId("testString")
      .build();

      // Invoke operation
      Response<Void> response = service.deleteActivityInsightsCosDetailsV2(deleteActivityInsightsCosDetailsV2Options).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s%nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @AfterClass
  public void tearDown() {
    // Add any clean up logic here
    System.out.println("Clean up complete.");
  }
 }
