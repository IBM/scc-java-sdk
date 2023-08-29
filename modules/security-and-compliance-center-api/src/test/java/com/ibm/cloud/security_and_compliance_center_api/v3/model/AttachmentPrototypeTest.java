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
import com.ibm.cloud.security_and_compliance_center_api.v3.model.AttachmentPrototype;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.AttachmentsNotificationsPrototype;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.AttachmentsPrototype;
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
 * Unit test class for the AttachmentPrototype model.
 */
public class AttachmentPrototypeTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testAttachmentPrototype() throws Throwable {
    PropertyItem propertyItemModel = new PropertyItem.Builder()
      .name("name")
      .value("value")
      .build();
    assertEquals(propertyItemModel.name(), "name");
    assertEquals(propertyItemModel.value(), "value");

    MultiCloudScope multiCloudScopeModel = new MultiCloudScope.Builder()
      .environment("environment")
      .xProperties(java.util.Arrays.asList(propertyItemModel))
      .build();
    assertEquals(multiCloudScopeModel.environment(), "environment");
    assertEquals(multiCloudScopeModel.xProperties(), java.util.Arrays.asList(propertyItemModel));

    FailedControls failedControlsModel = new FailedControls.Builder()
      .thresholdLimit(Long.valueOf("0"))
      .failedControlIds(java.util.Arrays.asList("5C453578-E9A1-421E-AD0F-C6AFCDD67CCF", "5C453578-E9A1-421E-AD0F-C6AFCDD67CCF", "5C453578-E9A1-421E-AD0F-C6AFCDD67CCF", "5C453578-E9A1-421E-AD0F-C6AFCDD67CCF", "5C453578-E9A1-421E-AD0F-C6AFCDD67CCF"))
      .build();
    assertEquals(failedControlsModel.thresholdLimit(), Long.valueOf("0"));
    assertEquals(failedControlsModel.failedControlIds(), java.util.Arrays.asList("5C453578-E9A1-421E-AD0F-C6AFCDD67CCF", "5C453578-E9A1-421E-AD0F-C6AFCDD67CCF", "5C453578-E9A1-421E-AD0F-C6AFCDD67CCF", "5C453578-E9A1-421E-AD0F-C6AFCDD67CCF", "5C453578-E9A1-421E-AD0F-C6AFCDD67CCF"));

    AttachmentsNotificationsPrototype attachmentsNotificationsPrototypeModel = new AttachmentsNotificationsPrototype.Builder()
      .enabled(true)
      .controls(failedControlsModel)
      .build();
    assertEquals(attachmentsNotificationsPrototypeModel.enabled(), Boolean.valueOf(true));
    assertEquals(attachmentsNotificationsPrototypeModel.controls(), failedControlsModel);

    AttachmentParameterPrototype attachmentParameterPrototypeModel = new AttachmentParameterPrototype.Builder()
      .assessmentType("assessment_type")
      .assessmentId("assessment_id")
      .parameterName("parameter_name")
      .parameterValue("parameter_value")
      .parameterDisplayName("parameter_display_name")
      .parameterType("string")
      .build();
    assertEquals(attachmentParameterPrototypeModel.assessmentType(), "assessment_type");
    assertEquals(attachmentParameterPrototypeModel.assessmentId(), "assessment_id");
    assertEquals(attachmentParameterPrototypeModel.parameterName(), "parameter_name");
    assertEquals(attachmentParameterPrototypeModel.parameterValue(), "parameter_value");
    assertEquals(attachmentParameterPrototypeModel.parameterDisplayName(), "parameter_display_name");
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

    AttachmentPrototype attachmentPrototypeModel = new AttachmentPrototype.Builder()
      .profileId("testString")
      .attachments(java.util.Arrays.asList(attachmentsPrototypeModel))
      .build();
    assertEquals(attachmentPrototypeModel.profileId(), "testString");
    assertEquals(attachmentPrototypeModel.attachments(), java.util.Arrays.asList(attachmentsPrototypeModel));

    String json = TestUtilities.serialize(attachmentPrototypeModel);

    AttachmentPrototype attachmentPrototypeModelNew = TestUtilities.deserialize(json, AttachmentPrototype.class);
    assertTrue(attachmentPrototypeModelNew instanceof AttachmentPrototype);
    assertEquals(attachmentPrototypeModelNew.profileId(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testAttachmentPrototypeError() throws Throwable {
    new AttachmentPrototype.Builder().build();
  }

}