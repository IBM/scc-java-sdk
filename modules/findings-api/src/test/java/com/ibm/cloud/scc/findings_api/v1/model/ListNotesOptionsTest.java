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

package com.ibm.cloud.scc.findings_api.v1.model;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.scc.findings_api.v1.model.ListNotesOptions;
import com.ibm.cloud.scc.findings_api.v1.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ListNotesOptions model.
 */
public class ListNotesOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testListNotesOptions() throws Throwable {
    ListNotesOptions listNotesOptionsModel = new ListNotesOptions.Builder()
      .accountId("testString")
      .providerId("testString")
      .transactionId("testString")
      .pageSize(Long.valueOf("2"))
      .pageToken("testString")
      .build();
    assertEquals(listNotesOptionsModel.accountId(), "testString");
    assertEquals(listNotesOptionsModel.providerId(), "testString");
    assertEquals(listNotesOptionsModel.transactionId(), "testString");
    assertEquals(listNotesOptionsModel.pageSize(), Long.valueOf("2"));
    assertEquals(listNotesOptionsModel.pageToken(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListNotesOptionsError() throws Throwable {
    new ListNotesOptions.Builder().build();
  }

}