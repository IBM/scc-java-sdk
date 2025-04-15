/*
 * (C) Copyright IBM Corp. 2025.
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

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ListInstanceAttachmentsOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ListInstanceAttachmentsOptions model.
 */
public class ListInstanceAttachmentsOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testListInstanceAttachmentsOptions() throws Throwable {
    ListInstanceAttachmentsOptions listInstanceAttachmentsOptionsModel = new ListInstanceAttachmentsOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .accountId("testString")
      .versionGroupLabel("6702d85a-6437-4d6f-8701-c0146648787b")
      .limit(Long.valueOf("25"))
      .sort("created_on")
      .direction("desc")
      .start("testString")
      .build();
    assertEquals(listInstanceAttachmentsOptionsModel.instanceId(), "acd7032c-15a3-484f-bf5b-67d41534d940");
    assertEquals(listInstanceAttachmentsOptionsModel.accountId(), "testString");
    assertEquals(listInstanceAttachmentsOptionsModel.versionGroupLabel(), "6702d85a-6437-4d6f-8701-c0146648787b");
    assertEquals(listInstanceAttachmentsOptionsModel.limit(), Long.valueOf("25"));
    assertEquals(listInstanceAttachmentsOptionsModel.sort(), "created_on");
    assertEquals(listInstanceAttachmentsOptionsModel.direction(), "desc");
    assertEquals(listInstanceAttachmentsOptionsModel.start(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListInstanceAttachmentsOptionsError() throws Throwable {
    new ListInstanceAttachmentsOptions.Builder().build();
  }

}