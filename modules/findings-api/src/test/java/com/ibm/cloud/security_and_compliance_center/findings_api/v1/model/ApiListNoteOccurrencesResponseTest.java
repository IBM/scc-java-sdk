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

package com.ibm.cloud.security_and_compliance_center.findings_api.v1.model;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.DateUtils;
import com.ibm.cloud.security_and_compliance_center.findings_api.v1.model.ApiListNoteOccurrencesResponse;
import com.ibm.cloud.security_and_compliance_center.findings_api.v1.model.ApiOccurrence;
import com.ibm.cloud.security_and_compliance_center.findings_api.v1.model.Context;
import com.ibm.cloud.security_and_compliance_center.findings_api.v1.model.DataTransferred;
import com.ibm.cloud.security_and_compliance_center.findings_api.v1.model.Finding;
import com.ibm.cloud.security_and_compliance_center.findings_api.v1.model.Kpi;
import com.ibm.cloud.security_and_compliance_center.findings_api.v1.model.NetworkConnection;
import com.ibm.cloud.security_and_compliance_center.findings_api.v1.model.RemediationStep;
import com.ibm.cloud.security_and_compliance_center.findings_api.v1.model.SocketAddress;
import com.ibm.cloud.security_and_compliance_center.findings_api.v1.utils.TestUtilities;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ApiListNoteOccurrencesResponse model.
 */
public class ApiListNoteOccurrencesResponseTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testApiListNoteOccurrencesResponse() throws Throwable {
    ApiListNoteOccurrencesResponse apiListNoteOccurrencesResponseModel = new ApiListNoteOccurrencesResponse();
    assertNull(apiListNoteOccurrencesResponseModel.getOccurrences());
    assertNull(apiListNoteOccurrencesResponseModel.getNextPageToken());
  }
}