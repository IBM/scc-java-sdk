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

import com.ibm.cloud.scc.compliance.v2.model.ControlDocs;
import com.ibm.cloud.scc.compliance.v2.model.ControlSpecifications;
import com.ibm.cloud.scc.compliance.v2.model.DefaultParameters;
import com.ibm.cloud.scc.compliance.v2.model.ImplementationPayload;
import com.ibm.cloud.scc.compliance.v2.model.ParameterInfo;
import com.ibm.cloud.scc.compliance.v2.model.ProfileControlsInResponse;
import com.ibm.cloud.scc.compliance.v2.model.ProfileResponse;
import com.ibm.cloud.scc.compliance.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ProfileResponse model.
 */
public class ProfileResponseTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testProfileResponse() throws Throwable {
    ProfileResponse profileResponseModel = new ProfileResponse();
    assertNull(profileResponseModel.getId());
    assertNull(profileResponseModel.getProfileName());
    assertNull(profileResponseModel.getProfileDescription());
    assertNull(profileResponseModel.getProfileType());
    assertNull(profileResponseModel.getProfileVersion());
    assertNull(profileResponseModel.getVersionGroupLabel());
    assertNull(profileResponseModel.isLatest());
    assertNull(profileResponseModel.getCreatedBy());
    assertNull(profileResponseModel.getCreatedOn());
    assertNull(profileResponseModel.getUpdatedBy());
    assertNull(profileResponseModel.getUpdatedOn());
    assertNull(profileResponseModel.getControlsCount());
    assertNull(profileResponseModel.getAttachmentsCount());
    assertNull(profileResponseModel.getControls());
    assertNull(profileResponseModel.getDefaultParameters());
  }
}