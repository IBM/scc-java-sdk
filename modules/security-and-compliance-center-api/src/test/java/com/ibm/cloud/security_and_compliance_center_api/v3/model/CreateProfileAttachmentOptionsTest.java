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
import com.ibm.cloud.security_and_compliance_center_api.v3.model.AttachmentNotifications;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.AttachmentNotificationsControls;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.CreateProfileAttachmentOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.DateRange;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.MultiCloudScopePayloadById;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Parameter;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ProfileAttachmentBase;
import com.ibm.cloud.security_and_compliance_center_api.v3.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the CreateProfileAttachmentOptions model.
 */
public class CreateProfileAttachmentOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCreateProfileAttachmentOptions() throws Throwable {
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

    AttachmentNotificationsControls attachmentNotificationsControlsModel = new AttachmentNotificationsControls.Builder()
      .thresholdLimit(Long.valueOf("15"))
      .failedControlIds(java.util.Arrays.asList("testString"))
      .build();
    assertEquals(attachmentNotificationsControlsModel.thresholdLimit(), Long.valueOf("15"));
    assertEquals(attachmentNotificationsControlsModel.failedControlIds(), java.util.Arrays.asList("testString"));

    AttachmentNotifications attachmentNotificationsModel = new AttachmentNotifications.Builder()
      .enabled(true)
      .controls(attachmentNotificationsControlsModel)
      .build();
    assertEquals(attachmentNotificationsModel.enabled(), Boolean.valueOf(true));
    assertEquals(attachmentNotificationsModel.controls(), attachmentNotificationsControlsModel);

    MultiCloudScopePayloadById multiCloudScopePayloadModel = new MultiCloudScopePayloadById.Builder()
      .id("testString")
      .build();
    assertEquals(multiCloudScopePayloadModel.id(), "testString");

    DateRange dateRangeModel = new DateRange.Builder()
      .startDate(DateUtils.parseAsDateTime("2025-02-28T05:42:58.000Z"))
      .endDate(DateUtils.parseAsDateTime("2025-02-28T05:42:58.000Z"))
      .build();
    assertEquals(dateRangeModel.startDate(), DateUtils.parseAsDateTime("2025-02-28T05:42:58.000Z"));
    assertEquals(dateRangeModel.endDate(), DateUtils.parseAsDateTime("2025-02-28T05:42:58.000Z"));

    ProfileAttachmentBase profileAttachmentBaseModel = new ProfileAttachmentBase.Builder()
      .attachmentParameters(java.util.Arrays.asList(parameterModel))
      .description("testString")
      .name("testString")
      .notifications(attachmentNotificationsModel)
      .schedule("daily")
      .scope(java.util.Arrays.asList(multiCloudScopePayloadModel))
      .status("enabled")
      .dataSelectionRange(dateRangeModel)
      .build();
    assertEquals(profileAttachmentBaseModel.attachmentParameters(), java.util.Arrays.asList(parameterModel));
    assertEquals(profileAttachmentBaseModel.description(), "testString");
    assertEquals(profileAttachmentBaseModel.name(), "testString");
    assertEquals(profileAttachmentBaseModel.notifications(), attachmentNotificationsModel);
    assertEquals(profileAttachmentBaseModel.schedule(), "daily");
    assertEquals(profileAttachmentBaseModel.scope(), java.util.Arrays.asList(multiCloudScopePayloadModel));
    assertEquals(profileAttachmentBaseModel.status(), "enabled");
    assertEquals(profileAttachmentBaseModel.dataSelectionRange(), dateRangeModel);

    CreateProfileAttachmentOptions createProfileAttachmentOptionsModel = new CreateProfileAttachmentOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .profileId("9c265b4a-4cdf-47f1-acd3-17b5808f7f3f")
      .newAttachments(java.util.Arrays.asList(profileAttachmentBaseModel))
      .newProfileId("9c265b4a-4cdf-47f1-acd3-17b5808f7f3f")
      .accountId("testString")
      .build();
    assertEquals(createProfileAttachmentOptionsModel.instanceId(), "acd7032c-15a3-484f-bf5b-67d41534d940");
    assertEquals(createProfileAttachmentOptionsModel.profileId(), "9c265b4a-4cdf-47f1-acd3-17b5808f7f3f");
    assertEquals(createProfileAttachmentOptionsModel.newAttachments(), java.util.Arrays.asList(profileAttachmentBaseModel));
    assertEquals(createProfileAttachmentOptionsModel.newProfileId(), "9c265b4a-4cdf-47f1-acd3-17b5808f7f3f");
    assertEquals(createProfileAttachmentOptionsModel.accountId(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateProfileAttachmentOptionsError() throws Throwable {
    new CreateProfileAttachmentOptions.Builder().build();
  }

}