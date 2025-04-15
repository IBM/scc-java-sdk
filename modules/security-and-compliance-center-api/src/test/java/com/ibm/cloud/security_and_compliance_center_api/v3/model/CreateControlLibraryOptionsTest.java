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
import com.ibm.cloud.security_and_compliance_center_api.v3.model.AssessmentPrototype;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ControlDoc;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ControlPrototype;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ControlSpecificationPrototype;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.CreateControlLibraryOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the CreateControlLibraryOptions model.
 */
public class CreateControlLibraryOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCreateControlLibraryOptions() throws Throwable {
    AssessmentPrototype assessmentPrototypeModel = new AssessmentPrototype.Builder()
      .assessmentId("testString")
      .assessmentDescription("testString")
      .build();
    assertEquals(assessmentPrototypeModel.assessmentId(), "testString");
    assertEquals(assessmentPrototypeModel.assessmentDescription(), "testString");

    ControlSpecificationPrototype controlSpecificationPrototypeModel = new ControlSpecificationPrototype.Builder()
      .componentId("testString")
      .environment("ibm-cloud")
      .controlSpecificationId("testString")
      .controlSpecificationDescription("testString")
      .assessments(java.util.Arrays.asList(assessmentPrototypeModel))
      .build();
    assertEquals(controlSpecificationPrototypeModel.componentId(), "testString");
    assertEquals(controlSpecificationPrototypeModel.environment(), "ibm-cloud");
    assertEquals(controlSpecificationPrototypeModel.controlSpecificationId(), "testString");
    assertEquals(controlSpecificationPrototypeModel.controlSpecificationDescription(), "testString");
    assertEquals(controlSpecificationPrototypeModel.assessments(), java.util.Arrays.asList(assessmentPrototypeModel));

    ControlDoc controlDocModel = new ControlDoc.Builder()
      .controlDocsId("testString")
      .controlDocsType("testString")
      .build();
    assertEquals(controlDocModel.controlDocsId(), "testString");
    assertEquals(controlDocModel.controlDocsType(), "testString");

    ControlPrototype controlPrototypeModel = new ControlPrototype.Builder()
      .controlName("testString")
      .controlDescription("testString")
      .controlCategory("testString")
      .controlRequirement(true)
      .controlParent("testString")
      .controlSpecifications(java.util.Arrays.asList(controlSpecificationPrototypeModel))
      .controlDocs(controlDocModel)
      .status("testString")
      .build();
    assertEquals(controlPrototypeModel.controlName(), "testString");
    assertEquals(controlPrototypeModel.controlDescription(), "testString");
    assertEquals(controlPrototypeModel.controlCategory(), "testString");
    assertEquals(controlPrototypeModel.controlRequirement(), Boolean.valueOf(true));
    assertEquals(controlPrototypeModel.controlParent(), "testString");
    assertEquals(controlPrototypeModel.controlSpecifications(), java.util.Arrays.asList(controlSpecificationPrototypeModel));
    assertEquals(controlPrototypeModel.controlDocs(), controlDocModel);
    assertEquals(controlPrototypeModel.status(), "testString");

    CreateControlLibraryOptions createControlLibraryOptionsModel = new CreateControlLibraryOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .controlLibraryName("testString")
      .controlLibraryDescription("testString")
      .controlLibraryType("custom")
      .controlLibraryVersion("testString")
      .controls(java.util.Arrays.asList(controlPrototypeModel))
      .accountId("testString")
      .build();
    assertEquals(createControlLibraryOptionsModel.instanceId(), "acd7032c-15a3-484f-bf5b-67d41534d940");
    assertEquals(createControlLibraryOptionsModel.controlLibraryName(), "testString");
    assertEquals(createControlLibraryOptionsModel.controlLibraryDescription(), "testString");
    assertEquals(createControlLibraryOptionsModel.controlLibraryType(), "custom");
    assertEquals(createControlLibraryOptionsModel.controlLibraryVersion(), "testString");
    assertEquals(createControlLibraryOptionsModel.controls(), java.util.Arrays.asList(controlPrototypeModel));
    assertEquals(createControlLibraryOptionsModel.accountId(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateControlLibraryOptionsError() throws Throwable {
    new CreateControlLibraryOptions.Builder().build();
  }

}