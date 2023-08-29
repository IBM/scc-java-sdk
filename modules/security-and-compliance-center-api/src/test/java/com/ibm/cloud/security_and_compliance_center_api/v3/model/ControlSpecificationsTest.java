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
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ControlSpecifications;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Implementation;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ParameterInfo;
import com.ibm.cloud.security_and_compliance_center_api.v3.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ControlSpecifications model.
 */
public class ControlSpecificationsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testControlSpecifications() throws Throwable {
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
      .componenetName("testString")
      .environment("testString")
      .controlSpecificationDescription("testString")
      .assessmentsCount(Long.valueOf("26"))
      .assessments(java.util.Arrays.asList(implementationModel))
      .build();
    assertEquals(controlSpecificationsModel.controlSpecificationId(), "f3517159-889e-4781-819a-89d89b747c85");
    assertEquals(controlSpecificationsModel.responsibility(), "user");
    assertEquals(controlSpecificationsModel.componentId(), "f3517159-889e-4781-819a-89d89b747c85");
    assertEquals(controlSpecificationsModel.componenetName(), "testString");
    assertEquals(controlSpecificationsModel.environment(), "testString");
    assertEquals(controlSpecificationsModel.controlSpecificationDescription(), "testString");
    assertEquals(controlSpecificationsModel.assessmentsCount(), Long.valueOf("26"));
    assertEquals(controlSpecificationsModel.assessments(), java.util.Arrays.asList(implementationModel));

    String json = TestUtilities.serialize(controlSpecificationsModel);

    ControlSpecifications controlSpecificationsModelNew = TestUtilities.deserialize(json, ControlSpecifications.class);
    assertTrue(controlSpecificationsModelNew instanceof ControlSpecifications);
    assertEquals(controlSpecificationsModelNew.controlSpecificationId(), "f3517159-889e-4781-819a-89d89b747c85");
    assertEquals(controlSpecificationsModelNew.responsibility(), "user");
    assertEquals(controlSpecificationsModelNew.componentId(), "f3517159-889e-4781-819a-89d89b747c85");
    assertEquals(controlSpecificationsModelNew.componenetName(), "testString");
    assertEquals(controlSpecificationsModelNew.environment(), "testString");
    assertEquals(controlSpecificationsModelNew.controlSpecificationDescription(), "testString");
    assertEquals(controlSpecificationsModelNew.assessmentsCount(), Long.valueOf("26"));
  }
}