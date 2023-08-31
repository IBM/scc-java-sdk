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
import com.ibm.cloud.security_and_compliance_center_api.v3.model.AttachmentParameterPrototype;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.AttachmentsNotificationsPrototype;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.AttachmentsPrototype;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.CreateAttachmentOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.FailedControls;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.MultiCloudScope;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.PropertyItem;
import com.ibm.cloud.security_and_compliance_center_api.v3.utils.TestUtilities;
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
    PropertyItem propertyItemModel = new PropertyItem.Builder()
      .name("testString")
      .value("testString")
      .build();
    assertEquals(propertyItemModel.name(), "testString");
    assertEquals(propertyItemModel.value(), "testString");

    MultiCloudScope multiCloudScopeModel = new MultiCloudScope.Builder()
      .environment("testString")
      .xProperties(java.util.Arrays.asList(propertyItemModel))
      .build();
    assertEquals(multiCloudScopeModel.environment(), "testString");
    assertEquals(multiCloudScopeModel.xProperties(), java.util.Arrays.asList(propertyItemModel));

    FailedControls failedControlsModel = new FailedControls.Builder()
      .thresholdLimit(Long.valueOf("26"))
      .failedControlIds(java.util.Arrays.asList("5C453578-E9A1-421E-AD0F-C6AFCDD67CCF"))
      .build();
    assertEquals(failedControlsModel.thresholdLimit(), Long.valueOf("26"));
    assertEquals(failedControlsModel.failedControlIds(), java.util.Arrays.asList("5C453578-E9A1-421E-AD0F-C6AFCDD67CCF"));

    AttachmentsNotificationsPrototype attachmentsNotificationsPrototypeModel = new AttachmentsNotificationsPrototype.Builder()
      .enabled(true)
      .controls(failedControlsModel)
      .build();
    assertEquals(attachmentsNotificationsPrototypeModel.enabled(), Boolean.valueOf(true));
    assertEquals(attachmentsNotificationsPrototypeModel.controls(), failedControlsModel);

    AttachmentParameterPrototype attachmentParameterPrototypeModel = new AttachmentParameterPrototype.Builder()
      .assessmentType("testString")
      .assessmentId("testString")
      .parameterName("testString")
      .parameterValue("testString")
      .parameterDisplayName("testString")
      .parameterType("string")
      .build();
    assertEquals(attachmentParameterPrototypeModel.assessmentType(), "testString");
    assertEquals(attachmentParameterPrototypeModel.assessmentId(), "testString");
    assertEquals(attachmentParameterPrototypeModel.parameterName(), "testString");
    assertEquals(attachmentParameterPrototypeModel.parameterValue(), "testString");
    assertEquals(attachmentParameterPrototypeModel.parameterDisplayName(), "testString");
    assertEquals(attachmentParameterPrototypeModel.parameterType(), "string");

    AttachmentsPrototype attachmentsPrototypeModel = new AttachmentsPrototype.Builder()
      .id("130003ea8bfa43c5aacea07a86da3000")
      .name("account-130003ea8bfa43c5aacea07a86da3000")
      .description("Test description")
      .scope(java.util.Arrays.asList(multiCloudScopeModel))
      .status("enabled")
      .schedule("daily")
      .notifications(attachmentsNotificationsPrototypeModel)
      .attachmentParameters(java.util.Arrays.asList(attachmentParameterPrototypeModel))
      .build();
    assertEquals(attachmentsPrototypeModel.id(), "130003ea8bfa43c5aacea07a86da3000");
    assertEquals(attachmentsPrototypeModel.name(), "account-130003ea8bfa43c5aacea07a86da3000");
    assertEquals(attachmentsPrototypeModel.description(), "Test description");
    assertEquals(attachmentsPrototypeModel.scope(), java.util.Arrays.asList(multiCloudScopeModel));
    assertEquals(attachmentsPrototypeModel.status(), "enabled");
    assertEquals(attachmentsPrototypeModel.schedule(), "daily");
    assertEquals(attachmentsPrototypeModel.notifications(), attachmentsNotificationsPrototypeModel);
    assertEquals(attachmentsPrototypeModel.attachmentParameters(), java.util.Arrays.asList(attachmentParameterPrototypeModel));

    CreateAttachmentOptions createAttachmentOptionsModel = new CreateAttachmentOptions.Builder()
      .attachments(java.util.Arrays.asList(attachmentsPrototypeModel))
      .profileId("testString")
      .xCorrelationId("testString")
      .xRequestId("testString")
      .build();
    assertEquals(createAttachmentOptionsModel.attachments(), java.util.Arrays.asList(attachmentsPrototypeModel));
    assertEquals(createAttachmentOptionsModel.profileId(), "testString");
    assertEquals(createAttachmentOptionsModel.xCorrelationId(), "testString");
    assertEquals(createAttachmentOptionsModel.xRequestId(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateAttachmentOptionsError() throws Throwable {
    new CreateAttachmentOptions.Builder().build();
  }

}