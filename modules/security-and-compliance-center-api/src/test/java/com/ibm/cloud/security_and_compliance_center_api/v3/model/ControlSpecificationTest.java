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
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ControlSpecification;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Parameter;
import com.ibm.cloud.security_and_compliance_center_api.v3.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ControlSpecification model.
 */
public class ControlSpecificationTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testControlSpecification() throws Throwable {
    Parameter parameterModel = new Parameter.Builder()
      .assessmentType("testString")
      .assessmentId("testString")
      .parameterName("location")
      .parameterDisplayName("Location")
      .parameterType("string")
      .parameterValue("testString")
      .build();
    assertEquals(parameterModel.assessmentType(), "testString");
    assertEquals(parameterModel.assessmentId(), "testString");
    assertEquals(parameterModel.parameterName(), "location");
    assertEquals(parameterModel.parameterDisplayName(), "Location");
    assertEquals(parameterModel.parameterType(), "string");
    assertEquals(parameterModel.parameterValue(), "testString");

    Assessment assessmentModel = new Assessment.Builder()
      .assessmentId("382c2b06-e6b2-43ee-b189-c1c7743b67ee")
      .assessmentType("ibm-cloud-rule")
      .assessmentMethod("ibm-cloud-rule")
      .assessmentDescription("Check whether Cloud Object Storage is accessible only by using private endpoints")
      .parameterCount(Long.valueOf("1"))
      .parameters(java.util.Arrays.asList(parameterModel))
      .build();
    assertEquals(assessmentModel.assessmentId(), "382c2b06-e6b2-43ee-b189-c1c7743b67ee");
    assertEquals(assessmentModel.assessmentType(), "ibm-cloud-rule");
    assertEquals(assessmentModel.assessmentMethod(), "ibm-cloud-rule");
    assertEquals(assessmentModel.assessmentDescription(), "Check whether Cloud Object Storage is accessible only by using private endpoints");
    assertEquals(assessmentModel.parameterCount(), Long.valueOf("1"));
    assertEquals(assessmentModel.parameters(), java.util.Arrays.asList(parameterModel));

    ControlSpecification controlSpecificationModel = new ControlSpecification.Builder()
      .id("testString")
      .responsibility("testString")
      .componentId("testString")
      .componentName("testString")
      .componentType("testString")
      .environment("testString")
      .description("testString")
      .assessmentsCount(Long.valueOf("26"))
      .assessments(java.util.Arrays.asList(assessmentModel))
      .build();
    assertEquals(controlSpecificationModel.id(), "testString");
    assertEquals(controlSpecificationModel.responsibility(), "testString");
    assertEquals(controlSpecificationModel.componentId(), "testString");
    assertEquals(controlSpecificationModel.componentName(), "testString");
    assertEquals(controlSpecificationModel.componentType(), "testString");
    assertEquals(controlSpecificationModel.environment(), "testString");
    assertEquals(controlSpecificationModel.description(), "testString");
    assertEquals(controlSpecificationModel.assessmentsCount(), Long.valueOf("26"));
    assertEquals(controlSpecificationModel.assessments(), java.util.Arrays.asList(assessmentModel));

    String json = TestUtilities.serialize(controlSpecificationModel);

    ControlSpecification controlSpecificationModelNew = TestUtilities.deserialize(json, ControlSpecification.class);
    assertTrue(controlSpecificationModelNew instanceof ControlSpecification);
    assertEquals(controlSpecificationModelNew.id(), "testString");
    assertEquals(controlSpecificationModelNew.responsibility(), "testString");
    assertEquals(controlSpecificationModelNew.componentId(), "testString");
    assertEquals(controlSpecificationModelNew.componentName(), "testString");
    assertEquals(controlSpecificationModelNew.componentType(), "testString");
    assertEquals(controlSpecificationModelNew.environment(), "testString");
    assertEquals(controlSpecificationModelNew.description(), "testString");
    assertEquals(controlSpecificationModelNew.assessmentsCount(), Long.valueOf("26"));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testControlSpecificationError() throws Throwable {
    new ControlSpecification.Builder().build();
  }

}