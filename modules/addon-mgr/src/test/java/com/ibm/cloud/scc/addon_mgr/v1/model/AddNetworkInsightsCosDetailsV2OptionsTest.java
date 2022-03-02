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

import com.ibm.cloud.scc.addon_mgr.v1.model.AddNetworkInsightsCosDetailsV2Options;
import com.ibm.cloud.scc.addon_mgr.v1.model.CosDetailsV2CosDetailsItem;
import com.ibm.cloud.scc.addon_mgr.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the AddNetworkInsightsCosDetailsV2Options model.
 */
public class AddNetworkInsightsCosDetailsV2OptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testAddNetworkInsightsCosDetailsV2Options() throws Throwable {
    CosDetailsV2CosDetailsItem cosDetailsV2CosDetailsItemModel = new CosDetailsV2CosDetailsItem.Builder()
      .cosInstance("testString")
      .bucketName("testString")
      .description("testString")
      .type("network-insights")
      .cosBucketUrl("testString")
      .build();
    assertEquals(cosDetailsV2CosDetailsItemModel.cosInstance(), "testString");
    assertEquals(cosDetailsV2CosDetailsItemModel.bucketName(), "testString");
    assertEquals(cosDetailsV2CosDetailsItemModel.description(), "testString");
    assertEquals(cosDetailsV2CosDetailsItemModel.type(), "network-insights");
    assertEquals(cosDetailsV2CosDetailsItemModel.cosBucketUrl(), "testString");

    AddNetworkInsightsCosDetailsV2Options addNetworkInsightsCosDetailsV2OptionsModel = new AddNetworkInsightsCosDetailsV2Options.Builder()
      .regionId("testString")
      .cosDetails(new java.util.ArrayList<CosDetailsV2CosDetailsItem>(java.util.Arrays.asList(cosDetailsV2CosDetailsItemModel)))
      .transactionId("testString")
      .build();
    assertEquals(addNetworkInsightsCosDetailsV2OptionsModel.regionId(), "testString");
    assertEquals(addNetworkInsightsCosDetailsV2OptionsModel.cosDetails(), new java.util.ArrayList<CosDetailsV2CosDetailsItem>(java.util.Arrays.asList(cosDetailsV2CosDetailsItemModel)));
    assertEquals(addNetworkInsightsCosDetailsV2OptionsModel.transactionId(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testAddNetworkInsightsCosDetailsV2OptionsError() throws Throwable {
    new AddNetworkInsightsCosDetailsV2Options.Builder().build();
  }

}