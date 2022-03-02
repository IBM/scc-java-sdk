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

import com.ibm.cloud.scc.addon_mgr.v1.model.EnableInsightsV2Options;
import com.ibm.cloud.scc.addon_mgr.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the EnableInsightsV2Options model.
 */
public class EnableInsightsV2OptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testEnableInsightsV2Options() throws Throwable {
    EnableInsightsV2Options enableInsightsV2OptionsModel = new EnableInsightsV2Options.Builder()
      .regionId("testString")
      .networkInsights(true)
      .activityInsights(true)
      .transactionId("testString")
      .build();
    assertEquals(enableInsightsV2OptionsModel.regionId(), "testString");
    assertEquals(enableInsightsV2OptionsModel.networkInsights(), Boolean.valueOf(true));
    assertEquals(enableInsightsV2OptionsModel.activityInsights(), Boolean.valueOf(true));
    assertEquals(enableInsightsV2OptionsModel.transactionId(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testEnableInsightsV2OptionsError() throws Throwable {
    new EnableInsightsV2Options.Builder().build();
  }

}