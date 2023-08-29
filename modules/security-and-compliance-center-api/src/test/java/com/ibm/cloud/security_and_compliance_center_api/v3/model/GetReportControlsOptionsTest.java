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
import com.ibm.cloud.security_and_compliance_center_api.v3.model.GetReportControlsOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the GetReportControlsOptions model.
 */
public class GetReportControlsOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testGetReportControlsOptions() throws Throwable {
    GetReportControlsOptions getReportControlsOptionsModel = new GetReportControlsOptions.Builder()
      .reportId("testString")
      .xCorrelationId("testString")
      .xRequestId("testString")
      .controlId("testString")
      .controlName("testString")
      .controlDescription("testString")
      .controlCategory("testString")
      .status("compliant")
      .sort("control_name")
      .build();
    assertEquals(getReportControlsOptionsModel.reportId(), "testString");
    assertEquals(getReportControlsOptionsModel.xCorrelationId(), "testString");
    assertEquals(getReportControlsOptionsModel.xRequestId(), "testString");
    assertEquals(getReportControlsOptionsModel.controlId(), "testString");
    assertEquals(getReportControlsOptionsModel.controlName(), "testString");
    assertEquals(getReportControlsOptionsModel.controlDescription(), "testString");
    assertEquals(getReportControlsOptionsModel.controlCategory(), "testString");
    assertEquals(getReportControlsOptionsModel.status(), "compliant");
    assertEquals(getReportControlsOptionsModel.sort(), "control_name");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetReportControlsOptionsError() throws Throwable {
    new GetReportControlsOptions.Builder().build();
  }

}