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
 * Unit test class for the ControlsInControlLib model.
 */
public class ControlsInControlLibTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testControlsInControlLib() throws Throwable {
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
      .componenetName("componenet_name")
      .environment("environment")
      .controlSpecificationDescription("control_specification_description")
      .assessmentsCount(Long.valueOf("1"))
      .assessments(java.util.Arrays.asList(implementationModel))
      .build();
    assertEquals(controlSpecificationsModel.controlSpecificationId(), "f3517159-889e-4781-819a-89d89b747c85");
    assertEquals(controlSpecificationsModel.responsibility(), "user");
    assertEquals(controlSpecificationsModel.componentId(), "f3517159-889e-4781-819a-89d89b747c85");
    assertEquals(controlSpecificationsModel.componenetName(), "componenet_name");
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

    String json = TestUtilities.serialize(controlsInControlLibModel);

    ControlsInControlLib controlsInControlLibModelNew = TestUtilities.deserialize(json, ControlsInControlLib.class);
    assertTrue(controlsInControlLibModelNew instanceof ControlsInControlLib);
    assertEquals(controlsInControlLibModelNew.controlName(), "testString");
    assertEquals(controlsInControlLibModelNew.controlId(), "1fa45e17-9322-4e6c-bbd6-1c51db08e790");
    assertEquals(controlsInControlLibModelNew.controlDescription(), "testString");
    assertEquals(controlsInControlLibModelNew.controlCategory(), "testString");
    assertEquals(controlsInControlLibModelNew.controlParent(), "testString");
    assertEquals(controlsInControlLibModelNew.controlDocs().toString(), controlDocsModel.toString());
    assertEquals(controlsInControlLibModelNew.controlRequirement(), Boolean.valueOf(true));
    assertEquals(controlsInControlLibModelNew.status(), "enabled");
  }
}