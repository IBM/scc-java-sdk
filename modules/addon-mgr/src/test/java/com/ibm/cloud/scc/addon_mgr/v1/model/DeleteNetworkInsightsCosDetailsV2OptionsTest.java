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

import com.ibm.cloud.scc.addon_mgr.v1.model.DeleteNetworkInsightsCosDetailsV2Options;
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
 * Unit test class for the DeleteNetworkInsightsCosDetailsV2Options model.
 */
public class DeleteNetworkInsightsCosDetailsV2OptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testDeleteNetworkInsightsCosDetailsV2Options() throws Throwable {
    DeleteNetworkInsightsCosDetailsV2Options deleteNetworkInsightsCosDetailsV2OptionsModel = new DeleteNetworkInsightsCosDetailsV2Options.Builder()
      .ids(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
      .transactionId("testString")
      .build();
    assertEquals(deleteNetworkInsightsCosDetailsV2OptionsModel.ids(), new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(deleteNetworkInsightsCosDetailsV2OptionsModel.transactionId(), "testString");
  }
}