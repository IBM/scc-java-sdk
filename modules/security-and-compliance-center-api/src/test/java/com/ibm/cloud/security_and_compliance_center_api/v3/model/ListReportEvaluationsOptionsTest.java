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
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ListReportEvaluationsOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ListReportEvaluationsOptions model.
 */
public class ListReportEvaluationsOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testListReportEvaluationsOptions() throws Throwable {
    ListReportEvaluationsOptions listReportEvaluationsOptionsModel = new ListReportEvaluationsOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .reportId("testString")
      .assessmentId("testString")
      .assessmentMethod("testString")
      .componentId("testString")
      .targetId("testString")
      .targetEnv("testString")
      .targetName("testString")
      .status("failure")
      .start("testString")
      .limit(Long.valueOf("50"))
      .sort("assessment_id")
      .scopeId("testString")
      .subscopeId("testString")
      .build();
    assertEquals(listReportEvaluationsOptionsModel.instanceId(), "acd7032c-15a3-484f-bf5b-67d41534d940");
    assertEquals(listReportEvaluationsOptionsModel.reportId(), "testString");
    assertEquals(listReportEvaluationsOptionsModel.assessmentId(), "testString");
    assertEquals(listReportEvaluationsOptionsModel.assessmentMethod(), "testString");
    assertEquals(listReportEvaluationsOptionsModel.componentId(), "testString");
    assertEquals(listReportEvaluationsOptionsModel.targetId(), "testString");
    assertEquals(listReportEvaluationsOptionsModel.targetEnv(), "testString");
    assertEquals(listReportEvaluationsOptionsModel.targetName(), "testString");
    assertEquals(listReportEvaluationsOptionsModel.status(), "failure");
    assertEquals(listReportEvaluationsOptionsModel.start(), "testString");
    assertEquals(listReportEvaluationsOptionsModel.limit(), Long.valueOf("50"));
    assertEquals(listReportEvaluationsOptionsModel.sort(), "assessment_id");
    assertEquals(listReportEvaluationsOptionsModel.scopeId(), "testString");
    assertEquals(listReportEvaluationsOptionsModel.subscopeId(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListReportEvaluationsOptionsError() throws Throwable {
    new ListReportEvaluationsOptions.Builder().build();
  }

}