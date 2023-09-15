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
import com.ibm.cloud.sdk.core.util.DateUtils;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ControlDocs;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ControlSpecifications;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ControlsInControlLib;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Implementation;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ParameterInfo;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ReplaceCustomControlLibraryOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ReplaceCustomControlLibraryOptions model.
 */
public class ReplaceCustomControlLibraryOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testReplaceCustomControlLibraryOptions() throws Throwable {
    ParameterInfo parameterInfoModel = new ParameterInfo.Builder()
      .parameterName("location")
      .parameterDisplayName("Location")
      .parameterType("string")
      .parameterValue("public")
      .build();
    assertEquals(parameterInfoModel.parameterName(), "location");
    assertEquals(parameterInfoModel.parameterDisplayName(), "Location");
    assertEquals(parameterInfoModel.parameterType(), "string");
    assertEquals(parameterInfoModel.parameterValue(), "public");

    Implementation implementationModel = new Implementation.Builder()
      .assessmentId("testString")
      .assessmentMethod("testString")
      .assessmentType("testString")
      .assessmentDescription("testString")
      .parameterCount(Long.valueOf("26"))
      .parameters(java.util.Arrays.asList(parameterInfoModel))
      .build();
    assertEquals(implementationModel.assessmentId(), "testString");
    assertEquals(implementationModel.assessmentMethod(), "testString");
    assertEquals(implementationModel.assessmentType(), "testString");
    assertEquals(implementationModel.assessmentDescription(), "testString");
    assertEquals(implementationModel.parameterCount(), Long.valueOf("26"));
    assertEquals(implementationModel.parameters(), java.util.Arrays.asList(parameterInfoModel));

    ControlSpecifications controlSpecificationsModel = new ControlSpecifications.Builder()
      .controlSpecificationId("f3517159-889e-4781-819a-89d89b747c85")
      .responsibility("user")
      .componentId("f3517159-889e-4781-819a-89d89b747c85")
      .componentName("testString")
      .environment("testString")
      .controlSpecificationDescription("testString")
      .assessmentsCount(Long.valueOf("26"))
      .assessments(java.util.Arrays.asList(implementationModel))
      .build();
    assertEquals(controlSpecificationsModel.controlSpecificationId(), "f3517159-889e-4781-819a-89d89b747c85");
    assertEquals(controlSpecificationsModel.responsibility(), "user");
    assertEquals(controlSpecificationsModel.componentId(), "f3517159-889e-4781-819a-89d89b747c85");
    assertEquals(controlSpecificationsModel.componentName(), "testString");
    assertEquals(controlSpecificationsModel.environment(), "testString");
    assertEquals(controlSpecificationsModel.controlSpecificationDescription(), "testString");
    assertEquals(controlSpecificationsModel.assessmentsCount(), Long.valueOf("26"));
    assertEquals(controlSpecificationsModel.assessments(), java.util.Arrays.asList(implementationModel));

    ControlDocs controlDocsModel = new ControlDocs.Builder()
      .controlDocsId("testString")
      .controlDocsType("testString")
      .build();
    assertEquals(controlDocsModel.controlDocsId(), "testString");
    assertEquals(controlDocsModel.controlDocsType(), "testString");

    ControlsInControlLib controlsInControlLibModel = new ControlsInControlLib.Builder()
      .controlName("testString")
      .controlId("1fa45e17-9322-4e6c-bbd6-1c51db08e790")
      .controlDescription("testString")
      .controlCategory("testString")
      .controlParent("testString")
      .controlTags(java.util.Arrays.asList("testString"))
      .controlSpecifications(java.util.Arrays.asList(controlSpecificationsModel))
      .controlDocs(controlDocsModel)
      .controlRequirement(true)
      .status("enabled")
      .build();
    assertEquals(controlsInControlLibModel.controlName(), "testString");
    assertEquals(controlsInControlLibModel.controlId(), "1fa45e17-9322-4e6c-bbd6-1c51db08e790");
    assertEquals(controlsInControlLibModel.controlDescription(), "testString");
    assertEquals(controlsInControlLibModel.controlCategory(), "testString");
    assertEquals(controlsInControlLibModel.controlParent(), "testString");
    assertEquals(controlsInControlLibModel.controlTags(), java.util.Arrays.asList("testString"));
    assertEquals(controlsInControlLibModel.controlSpecifications(), java.util.Arrays.asList(controlSpecificationsModel));
    assertEquals(controlsInControlLibModel.controlDocs(), controlDocsModel);
    assertEquals(controlsInControlLibModel.controlRequirement(), Boolean.valueOf(true));
    assertEquals(controlsInControlLibModel.status(), "enabled");

    ReplaceCustomControlLibraryOptions replaceCustomControlLibraryOptionsModel = new ReplaceCustomControlLibraryOptions.Builder()
      .controlLibrariesId("testString")
      .id("f3517159-889e-4781-819a-89d89b747c85")
      .accountId("130003ea8bfa43c5aacea07a86da3000")
      .controlLibraryName("testString")
      .controlLibraryDescription("testString")
      .controlLibraryType("predefined")
      .versionGroupLabel("e0923045-f00d-44de-b49b-6f1f0e8033cc")
      .controlLibraryVersion("testString")
      .createdOn(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
      .createdBy("testString")
      .updatedOn(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
      .updatedBy("testString")
      .latest(true)
      .hierarchyEnabled(true)
      .controlsCount(Long.valueOf("26"))
      .controlParentsCount(Long.valueOf("26"))
      .controls(java.util.Arrays.asList(controlsInControlLibModel))
      .xCorrelationId("testString")
      .xRequestId("testString")
      .build();
    assertEquals(replaceCustomControlLibraryOptionsModel.controlLibrariesId(), "testString");
    assertEquals(replaceCustomControlLibraryOptionsModel.id(), "f3517159-889e-4781-819a-89d89b747c85");
    assertEquals(replaceCustomControlLibraryOptionsModel.accountId(), "130003ea8bfa43c5aacea07a86da3000");
    assertEquals(replaceCustomControlLibraryOptionsModel.controlLibraryName(), "testString");
    assertEquals(replaceCustomControlLibraryOptionsModel.controlLibraryDescription(), "testString");
    assertEquals(replaceCustomControlLibraryOptionsModel.controlLibraryType(), "predefined");
    assertEquals(replaceCustomControlLibraryOptionsModel.versionGroupLabel(), "e0923045-f00d-44de-b49b-6f1f0e8033cc");
    assertEquals(replaceCustomControlLibraryOptionsModel.controlLibraryVersion(), "testString");
    assertEquals(replaceCustomControlLibraryOptionsModel.createdOn(), DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"));
    assertEquals(replaceCustomControlLibraryOptionsModel.createdBy(), "testString");
    assertEquals(replaceCustomControlLibraryOptionsModel.updatedOn(), DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"));
    assertEquals(replaceCustomControlLibraryOptionsModel.updatedBy(), "testString");
    assertEquals(replaceCustomControlLibraryOptionsModel.latest(), Boolean.valueOf(true));
    assertEquals(replaceCustomControlLibraryOptionsModel.hierarchyEnabled(), Boolean.valueOf(true));
    assertEquals(replaceCustomControlLibraryOptionsModel.controlsCount(), Long.valueOf("26"));
    assertEquals(replaceCustomControlLibraryOptionsModel.controlParentsCount(), Long.valueOf("26"));
    assertEquals(replaceCustomControlLibraryOptionsModel.controls(), java.util.Arrays.asList(controlsInControlLibModel));
    assertEquals(replaceCustomControlLibraryOptionsModel.xCorrelationId(), "testString");
    assertEquals(replaceCustomControlLibraryOptionsModel.xRequestId(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testReplaceCustomControlLibraryOptionsError() throws Throwable {
    new ReplaceCustomControlLibraryOptions.Builder().build();
  }

}