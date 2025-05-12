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
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Assessment;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Control;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ControlDoc;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ControlLibrary;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ControlSpecification;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Parameter;
import com.ibm.cloud.security_and_compliance_center_api.v3.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ControlLibrary model.
 */
public class ControlLibraryTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testControlLibrary() throws Throwable {
    ControlLibrary controlLibraryModel = new ControlLibrary();
    assertNull(controlLibraryModel.getControlLibraryName());
    assertNull(controlLibraryModel.getControlLibraryDescription());
    assertNull(controlLibraryModel.getControlLibraryType());
    assertNull(controlLibraryModel.getControlLibraryVersion());
    assertNull(controlLibraryModel.getControls());
    assertNull(controlLibraryModel.getId());
    assertNull(controlLibraryModel.getAccountId());
    assertNull(controlLibraryModel.getVersionGroupLabel());
    assertNull(controlLibraryModel.isLatest());
    assertNull(controlLibraryModel.getCreatedBy());
    assertNull(controlLibraryModel.getCreatedOn());
    assertNull(controlLibraryModel.getUpdatedBy());
    assertNull(controlLibraryModel.getUpdatedOn());
    assertNull(controlLibraryModel.isHierarchyEnabled());
    assertNull(controlLibraryModel.getControlsCount());
    assertNull(controlLibraryModel.getControlParentsCount());
  }
}