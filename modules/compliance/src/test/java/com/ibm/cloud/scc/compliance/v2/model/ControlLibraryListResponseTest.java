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

package com.ibm.cloud.scc.compliance.v2.model;

import com.ibm.cloud.scc.compliance.v2.model.ControlLibraryListResponse;
import com.ibm.cloud.scc.compliance.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ControlLibraryListResponse model.
 */
public class ControlLibraryListResponseTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testControlLibraryListResponse() throws Throwable {
    ControlLibraryListResponse controlLibraryListResponseModel = new ControlLibraryListResponse();
    assertNull(controlLibraryListResponseModel.getId());
    assertNull(controlLibraryListResponseModel.getAccountId());
    assertNull(controlLibraryListResponseModel.getControlLibraryName());
    assertNull(controlLibraryListResponseModel.getControlLibraryDescription());
    assertNull(controlLibraryListResponseModel.getControlLibraryType());
    assertNull(controlLibraryListResponseModel.getCreatedOn());
    assertNull(controlLibraryListResponseModel.getCreatedBy());
    assertNull(controlLibraryListResponseModel.getUpdatedOn());
    assertNull(controlLibraryListResponseModel.getUpdatedBy());
    assertNull(controlLibraryListResponseModel.getVersionGroupLabel());
    assertNull(controlLibraryListResponseModel.getControlLibraryVersion());
    assertNull(controlLibraryListResponseModel.isLatest());
    assertNull(controlLibraryListResponseModel.getControlsCount());
  }
}