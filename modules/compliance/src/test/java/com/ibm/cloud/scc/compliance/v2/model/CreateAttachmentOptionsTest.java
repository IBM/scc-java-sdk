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

import com.ibm.cloud.scc.compliance.v2.model.AttachmentPayload;
import com.ibm.cloud.scc.compliance.v2.model.AttachmentsNotificationsPayload;
import com.ibm.cloud.scc.compliance.v2.model.CreateAttachmentOptions;
import com.ibm.cloud.scc.compliance.v2.model.FailedControls;
import com.ibm.cloud.scc.compliance.v2.model.ParameterDetails;
import com.ibm.cloud.scc.compliance.v2.model.ParameterInfo;
import com.ibm.cloud.scc.compliance.v2.model.ScopePayload;
import com.ibm.cloud.scc.compliance.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the CreateAttachmentOptions model.
 */
public class CreateAttachmentOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCreateAttachmentOptions() throws Throwable {
    ScopePayload scopePayloadModel = new ScopePayload.Builder()
      .scopeId("testString")
      .scopeType("testString")
      .build();
    assertEquals(scopePayloadModel.scopeId(), "testString");
    assertEquals(scopePayloadModel.scopeType(), "testString");

    ParameterInfo parameterInfoModel = new ParameterInfo.Builder()
      .parameterName("testString")
      .parameterDisplayName("testString")
      .parameterType("numeric")
      .build();
    assertEquals(parameterInfoModel.parameterName(), "testString");
    assertEquals(parameterInfoModel.parameterDisplayName(), "testString");
    assertEquals(parameterInfoModel.parameterType(), "numeric");

    ParameterDetails parameterDetailsModel = new ParameterDetails.Builder()
      .parameterName("testString")
      .parameterDisplayName("testString")
      .parameterType("numeric")
      .parameterValue("testString")
      .assessmentType("testString")
      .assessmentId("testString")
      .parameters(java.util.Arrays.asList(parameterInfoModel))
      .build();
    assertEquals(parameterDetailsModel.parameterName(), "testString");
    assertEquals(parameterDetailsModel.parameterDisplayName(), "testString");
    assertEquals(parameterDetailsModel.parameterType(), "numeric");
    assertEquals(parameterDetailsModel.parameterValue(), "testString");
    assertEquals(parameterDetailsModel.assessmentType(), "testString");
    assertEquals(parameterDetailsModel.assessmentId(), "testString");
    assertEquals(parameterDetailsModel.parameters(), java.util.Arrays.asList(parameterInfoModel));

    FailedControls failedControlsModel = new FailedControls.Builder()
      .thresholdLimit(Long.valueOf("26"))
      .failedControlIds(java.util.Arrays.asList("testString"))
      .build();
    assertEquals(failedControlsModel.thresholdLimit(), Long.valueOf("26"));
    assertEquals(failedControlsModel.failedControlIds(), java.util.Arrays.asList("testString"));

    AttachmentsNotificationsPayload attachmentsNotificationsPayloadModel = new AttachmentsNotificationsPayload.Builder()
      .enabled(true)
      .controls(failedControlsModel)
      .build();
    assertEquals(attachmentsNotificationsPayloadModel.enabled(), Boolean.valueOf(true));
    assertEquals(attachmentsNotificationsPayloadModel.controls(), failedControlsModel);

    AttachmentPayload attachmentPayloadModel = new AttachmentPayload.Builder()
      .id("testString")
      .accountId("testString")
      .includedScope(scopePayloadModel)
      .exclusions(java.util.Arrays.asList(scopePayloadModel))
      .createdBy("testString")
      .createdOn("testString")
      .updatedBy("testString")
      .updatedOn("testString")
      .status("enabled")
      .attachmentParameters(java.util.Arrays.asList(parameterDetailsModel))
      .attachmentNotifications(attachmentsNotificationsPayloadModel)
      .build();
    assertEquals(attachmentPayloadModel.id(), "testString");
    assertEquals(attachmentPayloadModel.accountId(), "testString");
    assertEquals(attachmentPayloadModel.includedScope(), scopePayloadModel);
    assertEquals(attachmentPayloadModel.exclusions(), java.util.Arrays.asList(scopePayloadModel));
    assertEquals(attachmentPayloadModel.createdBy(), "testString");
    assertEquals(attachmentPayloadModel.createdOn(), "testString");
    assertEquals(attachmentPayloadModel.updatedBy(), "testString");
    assertEquals(attachmentPayloadModel.updatedOn(), "testString");
    assertEquals(attachmentPayloadModel.status(), "enabled");
    assertEquals(attachmentPayloadModel.attachmentParameters(), java.util.Arrays.asList(parameterDetailsModel));
    assertEquals(attachmentPayloadModel.attachmentNotifications(), attachmentsNotificationsPayloadModel);

    CreateAttachmentOptions createAttachmentOptionsModel = new CreateAttachmentOptions.Builder()
      .profilesId("testString")
      .instanceId("testString")
      .attachments(java.util.Arrays.asList(attachmentPayloadModel))
      .transactionId("testString")
      .build();
    assertEquals(createAttachmentOptionsModel.profilesId(), "testString");
    assertEquals(createAttachmentOptionsModel.instanceId(), "testString");
    assertEquals(createAttachmentOptionsModel.attachments(), java.util.Arrays.asList(attachmentPayloadModel));
    assertEquals(createAttachmentOptionsModel.transactionId(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateAttachmentOptionsError() throws Throwable {
    new CreateAttachmentOptions.Builder().build();
  }

}