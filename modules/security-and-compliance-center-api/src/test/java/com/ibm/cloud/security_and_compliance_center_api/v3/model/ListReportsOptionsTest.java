/*
 * (C) Copyright IBM Corp. 2023.
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
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ListReportsOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ListReportsOptions model.
 */
public class ListReportsOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testListReportsOptions() throws Throwable {
    ListReportsOptions listReportsOptionsModel = new ListReportsOptions.Builder()
      .xCorrelationId("testString")
      .xRequestId("testString")
      .attachmentId("testString")
      .groupId("testString")
      .profileId("testString")
      .type("scheduled")
      .start("testString")
      .limit(Long.valueOf("50"))
      .sort("profile_name")
      .build();
    assertEquals(listReportsOptionsModel.xCorrelationId(), "testString");
    assertEquals(listReportsOptionsModel.xRequestId(), "testString");
    assertEquals(listReportsOptionsModel.attachmentId(), "testString");
    assertEquals(listReportsOptionsModel.groupId(), "testString");
    assertEquals(listReportsOptionsModel.profileId(), "testString");
    assertEquals(listReportsOptionsModel.type(), "scheduled");
    assertEquals(listReportsOptionsModel.start(), "testString");
    assertEquals(listReportsOptionsModel.limit(), Long.valueOf("50"));
    assertEquals(listReportsOptionsModel.sort(), "profile_name");
  }
}