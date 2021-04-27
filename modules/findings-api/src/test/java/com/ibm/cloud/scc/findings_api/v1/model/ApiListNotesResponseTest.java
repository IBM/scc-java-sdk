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
import com.ibm.cloud.sdk.core.util.DateUtils;
import com.ibm.cloud.scc.findings_api.v1.model.ApiListNotesResponse;
import com.ibm.cloud.scc.findings_api.v1.model.ApiNote;
import com.ibm.cloud.scc.findings_api.v1.model.ApiNoteRelatedUrl;
import com.ibm.cloud.scc.findings_api.v1.model.Card;
import com.ibm.cloud.scc.findings_api.v1.model.CardElementTimeSeriesCardElement;
import com.ibm.cloud.scc.findings_api.v1.model.FindingType;
import com.ibm.cloud.scc.findings_api.v1.model.KpiType;
import com.ibm.cloud.scc.findings_api.v1.model.RemediationStep;
import com.ibm.cloud.scc.findings_api.v1.model.Reporter;
import com.ibm.cloud.scc.findings_api.v1.model.Section;
import com.ibm.cloud.scc.findings_api.v1.model.ValueTypeFindingCountValueType;
import com.ibm.cloud.scc.findings_api.v1.utils.TestUtilities;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ApiListNotesResponse model.
 */
public class ApiListNotesResponseTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testApiListNotesResponse() throws Throwable {
    ApiListNotesResponse apiListNotesResponseModel = new ApiListNotesResponse();
    assertNull(apiListNotesResponseModel.getNotes());
    assertNull(apiListNotesResponseModel.getNextPageToken());
  }
}