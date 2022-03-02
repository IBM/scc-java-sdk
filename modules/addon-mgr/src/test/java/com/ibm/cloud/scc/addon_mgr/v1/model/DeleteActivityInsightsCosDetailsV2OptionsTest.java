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

import com.ibm.cloud.scc.addon_mgr.v1.model.DeleteActivityInsightsCosDetailsV2Options;
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
 * Unit test class for the DeleteActivityInsightsCosDetailsV2Options model.
 */
public class DeleteActivityInsightsCosDetailsV2OptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testDeleteActivityInsightsCosDetailsV2Options() throws Throwable {
    DeleteActivityInsightsCosDetailsV2Options deleteActivityInsightsCosDetailsV2OptionsModel = new DeleteActivityInsightsCosDetailsV2Options.Builder()
      .ids(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
      .transactionId("testString")
      .build();
    assertEquals(deleteActivityInsightsCosDetailsV2OptionsModel.ids(), new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(deleteActivityInsightsCosDetailsV2OptionsModel.transactionId(), "testString");
  }
}