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
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ControlDocs;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ControlSpecifications;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.DefaultParametersPrototype;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Implementation;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ParameterInfo;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Profile;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ProfileControls;
import com.ibm.cloud.security_and_compliance_center_api.v3.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the Profile model.
 */
public class ProfileTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testProfile() throws Throwable {
    Profile profileModel = new Profile();
    assertNull(profileModel.getId());
    assertNull(profileModel.getProfileName());
    assertNull(profileModel.getProfileDescription());
    assertNull(profileModel.getProfileType());
    assertNull(profileModel.getProfileVersion());
    assertNull(profileModel.getVersionGroupLabel());
    assertNull(profileModel.getInstanceId());
    assertNull(profileModel.isLatest());
    assertNull(profileModel.isHierarchyEnabled());
    assertNull(profileModel.getCreatedBy());
    assertNull(profileModel.getCreatedOn());
    assertNull(profileModel.getUpdatedBy());
    assertNull(profileModel.getUpdatedOn());
    assertNull(profileModel.getControlsCount());
    assertNull(profileModel.getControlParentsCount());
    assertNull(profileModel.getAttachmentsCount());
    assertNull(profileModel.getControls());
    assertNull(profileModel.getDefaultParameters());
  }
}