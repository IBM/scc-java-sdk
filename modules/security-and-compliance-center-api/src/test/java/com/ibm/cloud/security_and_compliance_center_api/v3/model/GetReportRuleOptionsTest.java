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
import com.ibm.cloud.security_and_compliance_center_api.v3.model.GetReportRuleOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the GetReportRuleOptions model.
 */
public class GetReportRuleOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testGetReportRuleOptions() throws Throwable {
    GetReportRuleOptions getReportRuleOptionsModel = new GetReportRuleOptions.Builder()
      .reportId("testString")
      .ruleId("rule-8d444f8c-fd1d-48de-bcaa-f43732568761")
      .xCorrelationId("testString")
      .xRequestId("testString")
      .build();
    assertEquals(getReportRuleOptionsModel.reportId(), "testString");
    assertEquals(getReportRuleOptionsModel.ruleId(), "rule-8d444f8c-fd1d-48de-bcaa-f43732568761");
    assertEquals(getReportRuleOptionsModel.xCorrelationId(), "testString");
    assertEquals(getReportRuleOptionsModel.xRequestId(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetReportRuleOptionsError() throws Throwable {
    new GetReportRuleOptions.Builder().build();
  }

}