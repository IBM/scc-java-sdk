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
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ControlLibrary;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ControlSpecifications;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ControlsInControlLib;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Implementation;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ParameterInfo;
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
    ParameterInfo parameterInfoModel = new ParameterInfo.Builder()
      .parameterName("parameter_name")
      .parameterDisplayName("parameter_display_name")
      .parameterType("string")
      .parameterValue("public")
      .build();
    assertEquals(parameterInfoModel.parameterName(), "parameter_name");
    assertEquals(parameterInfoModel.parameterDisplayName(), "parameter_display_name");
    assertEquals(parameterInfoModel.parameterType(), "string");
    assertEquals(parameterInfoModel.parameterValue(), "public");

    Implementation implementationModel = new Implementation.Builder()
      .assessmentId("assessment_id")
      .assessmentMethod("assessment_method")
      .assessmentType("assessment_type")
      .assessmentDescription("assessment_description")
      .parameterCount(Long.valueOf("5"))
      .parameters(java.util.Arrays.asList(parameterInfoModel))
      .build();
    assertEquals(implementationModel.assessmentId(), "assessment_id");
    assertEquals(implementationModel.assessmentMethod(), "assessment_method");
    assertEquals(implementationModel.assessmentType(), "assessment_type");
    assertEquals(implementationModel.assessmentDescription(), "assessment_description");
    assertEquals(implementationModel.parameterCount(), Long.valueOf("5"));
    assertEquals(implementationModel.parameters(), java.util.Arrays.asList(parameterInfoModel));

    ControlSpecifications controlSpecificationsModel = new ControlSpecifications.Builder()
      .controlSpecificationId("f3517159-889e-4781-819a-89d89b747c85")
      .responsibility("user")
      .componentId("f3517159-889e-4781-819a-89d89b747c85")
      .componentName("component_name")
      .environment("environment")
      .controlSpecificationDescription("control_specification_description")
      .assessmentsCount(Long.valueOf("1"))
      .assessments(java.util.Arrays.asList(implementationModel))
      .build();
    assertEquals(controlSpecificationsModel.controlSpecificationId(), "f3517159-889e-4781-819a-89d89b747c85");
    assertEquals(controlSpecificationsModel.responsibility(), "user");
    assertEquals(controlSpecificationsModel.componentId(), "f3517159-889e-4781-819a-89d89b747c85");
    assertEquals(controlSpecificationsModel.componentName(), "component_name");
    assertEquals(controlSpecificationsModel.environment(), "environment");
    assertEquals(controlSpecificationsModel.controlSpecificationDescription(), "control_specification_description");
    assertEquals(controlSpecificationsModel.assessmentsCount(), Long.valueOf("1"));
    assertEquals(controlSpecificationsModel.assessments(), java.util.Arrays.asList(implementationModel));

    ControlDocs controlDocsModel = new ControlDocs.Builder()
      .controlDocsId("control_docs_id")
      .controlDocsType("control_docs_type")
      .build();
    assertEquals(controlDocsModel.controlDocsId(), "control_docs_id");
    assertEquals(controlDocsModel.controlDocsType(), "control_docs_type");

    ControlsInControlLib controlsInControlLibModel = new ControlsInControlLib.Builder()
      .controlName("control_name")
      .controlId("1fa45e17-9322-4e6c-bbd6-1c51db08e790")
      .controlDescription("control_description")
      .controlCategory("control_category")
      .controlParent("control_parent")
      .controlTags(java.util.Arrays.asList("control_tags", "control_tags", "control_tags", "control_tags", "control_tags"))
      .controlSpecifications(java.util.Arrays.asList(controlSpecificationsModel))
      .controlDocs(controlDocsModel)
      .controlRequirement(true)
      .status("enabled")
      .build();
    assertEquals(controlsInControlLibModel.controlName(), "control_name");
    assertEquals(controlsInControlLibModel.controlId(), "1fa45e17-9322-4e6c-bbd6-1c51db08e790");
    assertEquals(controlsInControlLibModel.controlDescription(), "control_description");
    assertEquals(controlsInControlLibModel.controlCategory(), "control_category");
    assertEquals(controlsInControlLibModel.controlParent(), "control_parent");
    assertEquals(controlsInControlLibModel.controlTags(), java.util.Arrays.asList("control_tags", "control_tags", "control_tags", "control_tags", "control_tags"));
    assertEquals(controlsInControlLibModel.controlSpecifications(), java.util.Arrays.asList(controlSpecificationsModel));
    assertEquals(controlsInControlLibModel.controlDocs(), controlDocsModel);
    assertEquals(controlsInControlLibModel.controlRequirement(), Boolean.valueOf(true));
    assertEquals(controlsInControlLibModel.status(), "enabled");

    ControlLibrary controlLibraryModel = new ControlLibrary.Builder()
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
      .build();
    assertEquals(controlLibraryModel.id(), "f3517159-889e-4781-819a-89d89b747c85");
    assertEquals(controlLibraryModel.accountId(), "130003ea8bfa43c5aacea07a86da3000");
    assertEquals(controlLibraryModel.controlLibraryName(), "testString");
    assertEquals(controlLibraryModel.controlLibraryDescription(), "testString");
    assertEquals(controlLibraryModel.controlLibraryType(), "predefined");
    assertEquals(controlLibraryModel.versionGroupLabel(), "e0923045-f00d-44de-b49b-6f1f0e8033cc");
    assertEquals(controlLibraryModel.controlLibraryVersion(), "testString");
    assertEquals(controlLibraryModel.createdOn(), DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"));
    assertEquals(controlLibraryModel.createdBy(), "testString");
    assertEquals(controlLibraryModel.updatedOn(), DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"));
    assertEquals(controlLibraryModel.updatedBy(), "testString");
    assertEquals(controlLibraryModel.latest(), Boolean.valueOf(true));
    assertEquals(controlLibraryModel.hierarchyEnabled(), Boolean.valueOf(true));
    assertEquals(controlLibraryModel.controlsCount(), Long.valueOf("26"));
    assertEquals(controlLibraryModel.controlParentsCount(), Long.valueOf("26"));
    assertEquals(controlLibraryModel.controls(), java.util.Arrays.asList(controlsInControlLibModel));

    String json = TestUtilities.serialize(controlLibraryModel);

    ControlLibrary controlLibraryModelNew = TestUtilities.deserialize(json, ControlLibrary.class);
    assertTrue(controlLibraryModelNew instanceof ControlLibrary);
    assertEquals(controlLibraryModelNew.id(), "f3517159-889e-4781-819a-89d89b747c85");
    assertEquals(controlLibraryModelNew.accountId(), "130003ea8bfa43c5aacea07a86da3000");
    assertEquals(controlLibraryModelNew.controlLibraryName(), "testString");
    assertEquals(controlLibraryModelNew.controlLibraryDescription(), "testString");
    assertEquals(controlLibraryModelNew.controlLibraryType(), "predefined");
    assertEquals(controlLibraryModelNew.versionGroupLabel(), "e0923045-f00d-44de-b49b-6f1f0e8033cc");
    assertEquals(controlLibraryModelNew.controlLibraryVersion(), "testString");
    assertEquals(controlLibraryModelNew.createdOn(), DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"));
    assertEquals(controlLibraryModelNew.createdBy(), "testString");
    assertEquals(controlLibraryModelNew.updatedOn(), DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"));
    assertEquals(controlLibraryModelNew.updatedBy(), "testString");
    assertEquals(controlLibraryModelNew.latest(), Boolean.valueOf(true));
    assertEquals(controlLibraryModelNew.hierarchyEnabled(), Boolean.valueOf(true));
    assertEquals(controlLibraryModelNew.controlsCount(), Long.valueOf("26"));
    assertEquals(controlLibraryModelNew.controlParentsCount(), Long.valueOf("26"));
  }
}