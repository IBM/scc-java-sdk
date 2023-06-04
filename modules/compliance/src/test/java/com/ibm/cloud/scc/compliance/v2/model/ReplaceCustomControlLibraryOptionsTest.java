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
import com.ibm.cloud.scc.compliance.v2.model.ControlsInControlLibRequestPayload;
import com.ibm.cloud.scc.compliance.v2.model.ImplementationPayload;
import com.ibm.cloud.scc.compliance.v2.model.ParameterInfo;
import com.ibm.cloud.scc.compliance.v2.model.ReplaceCustomControlLibraryOptions;
import com.ibm.cloud.scc.compliance.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
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
      .parameterName("testString")
      .parameterDisplayName("testString")
      .parameterType("numeric")
      .build();
    assertEquals(parameterInfoModel.parameterName(), "testString");
    assertEquals(parameterInfoModel.parameterDisplayName(), "testString");
    assertEquals(parameterInfoModel.parameterType(), "numeric");

    ImplementationPayload implementationPayloadModel = new ImplementationPayload.Builder()
      .assessmentId("testString")
      .assessmentMethod("testString")
      .assessmentType("testString")
      .assessmentDescription("testString")
      .parameterCount(Long.valueOf("26"))
      .parameters(java.util.Arrays.asList(parameterInfoModel))
      .build();
    assertEquals(implementationPayloadModel.assessmentId(), "testString");
    assertEquals(implementationPayloadModel.assessmentMethod(), "testString");
    assertEquals(implementationPayloadModel.assessmentType(), "testString");
    assertEquals(implementationPayloadModel.assessmentDescription(), "testString");
    assertEquals(implementationPayloadModel.parameterCount(), Long.valueOf("26"));
    assertEquals(implementationPayloadModel.parameters(), java.util.Arrays.asList(parameterInfoModel));

    ControlSpecifications controlSpecificationsModel = new ControlSpecifications.Builder()
      .id("testString")
      .responsibility("user")
      .componentId("testString")
      .environment("testString")
      .description("testString")
      .assessmentsCount(Long.valueOf("26"))
      .assessments(java.util.Arrays.asList(implementationPayloadModel))
      .build();
    assertEquals(controlSpecificationsModel.id(), "testString");
    assertEquals(controlSpecificationsModel.responsibility(), "user");
    assertEquals(controlSpecificationsModel.componentId(), "testString");
    assertEquals(controlSpecificationsModel.environment(), "testString");
    assertEquals(controlSpecificationsModel.description(), "testString");
    assertEquals(controlSpecificationsModel.assessmentsCount(), Long.valueOf("26"));
    assertEquals(controlSpecificationsModel.assessments(), java.util.Arrays.asList(implementationPayloadModel));

    ControlDocs controlDocsModel = new ControlDocs.Builder()
      .controlDocsId("testString")
      .controlDocsType("testString")
      .build();
    assertEquals(controlDocsModel.controlDocsId(), "testString");
    assertEquals(controlDocsModel.controlDocsType(), "testString");

    ControlsInControlLibRequestPayload controlsInControlLibRequestPayloadModel = new ControlsInControlLibRequestPayload.Builder()
      .controlName("testString")
      .controlId("testString")
      .controlDescription("testString")
      .controlCategory("testString")
      .controlParent("testString")
      .controlSeverity("testString")
      .controlTags(java.util.Arrays.asList("testString"))
      .controlSpecifications(java.util.Arrays.asList(controlSpecificationsModel))
      .controlDocs(controlDocsModel)
      .status("enabled")
      .build();
    assertEquals(controlsInControlLibRequestPayloadModel.controlName(), "testString");
    assertEquals(controlsInControlLibRequestPayloadModel.controlId(), "testString");
    assertEquals(controlsInControlLibRequestPayloadModel.controlDescription(), "testString");
    assertEquals(controlsInControlLibRequestPayloadModel.controlCategory(), "testString");
    assertEquals(controlsInControlLibRequestPayloadModel.controlParent(), "testString");
    assertEquals(controlsInControlLibRequestPayloadModel.controlSeverity(), "testString");
    assertEquals(controlsInControlLibRequestPayloadModel.controlTags(), java.util.Arrays.asList("testString"));
    assertEquals(controlsInControlLibRequestPayloadModel.controlSpecifications(), java.util.Arrays.asList(controlSpecificationsModel));
    assertEquals(controlsInControlLibRequestPayloadModel.controlDocs(), controlDocsModel);
    assertEquals(controlsInControlLibRequestPayloadModel.status(), "enabled");

    ReplaceCustomControlLibraryOptions replaceCustomControlLibraryOptionsModel = new ReplaceCustomControlLibraryOptions.Builder()
      .controlLibrariesId("testString")
      .instanceId("testString")
      .id("testString")
      .accountId("testString")
      .controlLibraryName("testString")
      .controlLibraryDescription("testString")
      .controlLibraryType("predefined")
      .versionGroupLabel("testString")
      .controlLibraryVersion("testString")
      .latest(true)
      .controlsCount(Long.valueOf("26"))
      .controls(java.util.Arrays.asList(controlsInControlLibRequestPayloadModel))
      .transactionId("testString")
      .build();
    assertEquals(replaceCustomControlLibraryOptionsModel.controlLibrariesId(), "testString");
    assertEquals(replaceCustomControlLibraryOptionsModel.instanceId(), "testString");
    assertEquals(replaceCustomControlLibraryOptionsModel.id(), "testString");
    assertEquals(replaceCustomControlLibraryOptionsModel.accountId(), "testString");
    assertEquals(replaceCustomControlLibraryOptionsModel.controlLibraryName(), "testString");
    assertEquals(replaceCustomControlLibraryOptionsModel.controlLibraryDescription(), "testString");
    assertEquals(replaceCustomControlLibraryOptionsModel.controlLibraryType(), "predefined");
    assertEquals(replaceCustomControlLibraryOptionsModel.versionGroupLabel(), "testString");
    assertEquals(replaceCustomControlLibraryOptionsModel.controlLibraryVersion(), "testString");
    assertEquals(replaceCustomControlLibraryOptionsModel.latest(), Boolean.valueOf(true));
    assertEquals(replaceCustomControlLibraryOptionsModel.controlsCount(), Long.valueOf("26"));
    assertEquals(replaceCustomControlLibraryOptionsModel.controls(), java.util.Arrays.asList(controlsInControlLibRequestPayloadModel));
    assertEquals(replaceCustomControlLibraryOptionsModel.transactionId(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testReplaceCustomControlLibraryOptionsError() throws Throwable {
    new ReplaceCustomControlLibraryOptions.Builder().build();
  }

}