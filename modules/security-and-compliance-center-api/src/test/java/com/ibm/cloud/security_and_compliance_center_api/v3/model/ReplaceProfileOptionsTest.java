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
import com.ibm.cloud.sdk.core.util.DateUtils;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Assessment;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ControlDoc;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ControlSpecification;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.DefaultParameters;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Parameter;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ProfileControls;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ReplaceProfileOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ReplaceProfileOptions model.
 */
public class ReplaceProfileOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testReplaceProfileOptions() throws Throwable {
    ControlDoc controlDocModel = new ControlDoc.Builder()
      .controlDocsId("testString")
      .controlDocsType("testString")
      .build();
    assertEquals(controlDocModel.controlDocsId(), "testString");
    assertEquals(controlDocModel.controlDocsType(), "testString");

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

    ProfileControls profileControlsModel = new ProfileControls.Builder()
      .controlRequirement(true)
      .controlLibraryId("testString")
      .controlId("testString")
      .controlLibraryVersion("testString")
      .controlName("testString")
      .controlDescription("testString")
      .controlSeverity("testString")
      .controlCategory("testString")
      .controlParent("testString")
      .controlDocs(controlDocModel)
      .controlSpecifications(java.util.Arrays.asList(controlSpecificationModel))
      .build();
    assertEquals(profileControlsModel.controlRequirement(), Boolean.valueOf(true));
    assertEquals(profileControlsModel.controlLibraryId(), "testString");
    assertEquals(profileControlsModel.controlId(), "testString");
    assertEquals(profileControlsModel.controlLibraryVersion(), "testString");
    assertEquals(profileControlsModel.controlName(), "testString");
    assertEquals(profileControlsModel.controlDescription(), "testString");
    assertEquals(profileControlsModel.controlSeverity(), "testString");
    assertEquals(profileControlsModel.controlCategory(), "testString");
    assertEquals(profileControlsModel.controlParent(), "testString");
    assertEquals(profileControlsModel.controlDocs(), controlDocModel);
    assertEquals(profileControlsModel.controlSpecifications(), java.util.Arrays.asList(controlSpecificationModel));

    DefaultParameters defaultParametersModel = new DefaultParameters.Builder()
      .assessmentType("testString")
      .assessmentId("testString")
      .parameterName("testString")
      .parameterDefaultValue("testString")
      .parameterDisplayName("testString")
      .parameterType("testString")
      .build();
    assertEquals(defaultParametersModel.assessmentType(), "testString");
    assertEquals(defaultParametersModel.assessmentId(), "testString");
    assertEquals(defaultParametersModel.parameterName(), "testString");
    assertEquals(defaultParametersModel.parameterDefaultValue(), "testString");
    assertEquals(defaultParametersModel.parameterDisplayName(), "testString");
    assertEquals(defaultParametersModel.parameterType(), "testString");

    ReplaceProfileOptions replaceProfileOptionsModel = new ReplaceProfileOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .profileId("testString")
      .newProfileType("custom")
      .newControls(java.util.Arrays.asList(profileControlsModel))
      .newDefaultParameters(java.util.Arrays.asList(defaultParametersModel))
      .newId("testString")
      .newProfileName("testString")
      .newInstanceId("testString")
      .newHierarchyEnabled(true)
      .newProfileDescription("testString")
      .newProfileVersion("testString")
      .newVersionGroupLabel("testString")
      .newLatest(true)
      .newCreatedBy("testString")
      .newCreatedOn(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
      .newUpdatedBy("testString")
      .newUpdatedOn(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
      .newControlsCount(Long.valueOf("26"))
      .newAttachmentsCount(Long.valueOf("26"))
      .accountId("testString")
      .build();
    assertEquals(replaceProfileOptionsModel.instanceId(), "acd7032c-15a3-484f-bf5b-67d41534d940");
    assertEquals(replaceProfileOptionsModel.profileId(), "testString");
    assertEquals(replaceProfileOptionsModel.newProfileType(), "custom");
    assertEquals(replaceProfileOptionsModel.newControls(), java.util.Arrays.asList(profileControlsModel));
    assertEquals(replaceProfileOptionsModel.newDefaultParameters(), java.util.Arrays.asList(defaultParametersModel));
    assertEquals(replaceProfileOptionsModel.newId(), "testString");
    assertEquals(replaceProfileOptionsModel.newProfileName(), "testString");
    assertEquals(replaceProfileOptionsModel.newInstanceId(), "testString");
    assertEquals(replaceProfileOptionsModel.newHierarchyEnabled(), Boolean.valueOf(true));
    assertEquals(replaceProfileOptionsModel.newProfileDescription(), "testString");
    assertEquals(replaceProfileOptionsModel.newProfileVersion(), "testString");
    assertEquals(replaceProfileOptionsModel.newVersionGroupLabel(), "testString");
    assertEquals(replaceProfileOptionsModel.newLatest(), Boolean.valueOf(true));
    assertEquals(replaceProfileOptionsModel.newCreatedBy(), "testString");
    assertEquals(replaceProfileOptionsModel.newCreatedOn(), DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"));
    assertEquals(replaceProfileOptionsModel.newUpdatedBy(), "testString");
    assertEquals(replaceProfileOptionsModel.newUpdatedOn(), DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"));
    assertEquals(replaceProfileOptionsModel.newControlsCount(), Long.valueOf("26"));
    assertEquals(replaceProfileOptionsModel.newAttachmentsCount(), Long.valueOf("26"));
    assertEquals(replaceProfileOptionsModel.accountId(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testReplaceProfileOptionsError() throws Throwable {
    new ReplaceProfileOptions.Builder().build();
  }

}