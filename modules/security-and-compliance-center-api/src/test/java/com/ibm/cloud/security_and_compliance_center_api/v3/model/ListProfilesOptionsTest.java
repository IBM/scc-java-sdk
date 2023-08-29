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
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ListProfilesOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ListProfilesOptions model.
 */
public class ListProfilesOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testListProfilesOptions() throws Throwable {
    ListProfilesOptions listProfilesOptionsModel = new ListProfilesOptions.Builder()
      .xCorrelationId("testString")
      .xRequestId("testString")
      .limit(Long.valueOf("50"))
      .profileType("custom")
      .start("testString")
      .build();
    assertEquals(listProfilesOptionsModel.xCorrelationId(), "testString");
    assertEquals(listProfilesOptionsModel.xRequestId(), "testString");
    assertEquals(listProfilesOptionsModel.limit(), Long.valueOf("50"));
    assertEquals(listProfilesOptionsModel.profileType(), "custom");
    assertEquals(listProfilesOptionsModel.start(), "testString");
  }
}