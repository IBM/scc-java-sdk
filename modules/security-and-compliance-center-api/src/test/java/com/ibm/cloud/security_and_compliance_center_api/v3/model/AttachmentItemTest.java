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
import com.ibm.cloud.security_and_compliance_center_api.v3.model.AttachmentItem;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.AttachmentParameterPrototype;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.AttachmentsNotificationsPrototype;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.FailedControls;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.LastScan;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.MultiCloudScope;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.PropertyItem;
import com.ibm.cloud.security_and_compliance_center_api.v3.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the AttachmentItem model.
 */
public class AttachmentItemTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testAttachmentItem() throws Throwable {
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

    LastScan lastScanModel = new LastScan.Builder()
      .id("e8a39d25-0051-4328-8462-988ad321f49a")
      .status("in_progress")
      .time(DateUtils.parseAsDateTime("2000-01-23T04:56:07.000+00:00"))
      .build();
    assertEquals(lastScanModel.id(), "e8a39d25-0051-4328-8462-988ad321f49a");
    assertEquals(lastScanModel.status(), "in_progress");
    assertEquals(lastScanModel.time(), DateUtils.parseAsDateTime("2000-01-23T04:56:07.000+00:00"));

    AttachmentItem attachmentItemModel = new AttachmentItem.Builder()
      .id("130003ea8bfa43c5aacea07a86da3000")
      .profileId("7ec45986-54fc-4b66-a303-d9577b078c65")
      .accountId("130003ea8bfa43c5aacea07a86da3000")
      .instanceId("edf9524f-406c-412c-acbb-ee371a5cabda")
      .scope(java.util.Arrays.asList(multiCloudScopeModel))
      .createdOn(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
      .createdBy("testString")
      .updatedOn(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
      .updatedBy("testString")
      .status("enabled")
      .schedule("daily")
      .notifications(attachmentsNotificationsPrototypeModel)
      .attachmentParameters(java.util.Arrays.asList(attachmentParameterPrototypeModel))
      .lastScan(lastScanModel)
      .nextScanTime(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
      .name("account-130003ea8bfa43c5aacea07a86da3000")
      .description("Test description")
      .build();
    assertEquals(attachmentItemModel.id(), "130003ea8bfa43c5aacea07a86da3000");
    assertEquals(attachmentItemModel.profileId(), "7ec45986-54fc-4b66-a303-d9577b078c65");
    assertEquals(attachmentItemModel.accountId(), "130003ea8bfa43c5aacea07a86da3000");
    assertEquals(attachmentItemModel.instanceId(), "edf9524f-406c-412c-acbb-ee371a5cabda");
    assertEquals(attachmentItemModel.scope(), java.util.Arrays.asList(multiCloudScopeModel));
    assertEquals(attachmentItemModel.createdOn(), DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"));
    assertEquals(attachmentItemModel.createdBy(), "testString");
    assertEquals(attachmentItemModel.updatedOn(), DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"));
    assertEquals(attachmentItemModel.updatedBy(), "testString");
    assertEquals(attachmentItemModel.status(), "enabled");
    assertEquals(attachmentItemModel.schedule(), "daily");
    assertEquals(attachmentItemModel.notifications(), attachmentsNotificationsPrototypeModel);
    assertEquals(attachmentItemModel.attachmentParameters(), java.util.Arrays.asList(attachmentParameterPrototypeModel));
    assertEquals(attachmentItemModel.lastScan(), lastScanModel);
    assertEquals(attachmentItemModel.nextScanTime(), DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"));
    assertEquals(attachmentItemModel.name(), "account-130003ea8bfa43c5aacea07a86da3000");
    assertEquals(attachmentItemModel.description(), "Test description");

    String json = TestUtilities.serialize(attachmentItemModel);

    AttachmentItem attachmentItemModelNew = TestUtilities.deserialize(json, AttachmentItem.class);
    assertTrue(attachmentItemModelNew instanceof AttachmentItem);
    assertEquals(attachmentItemModelNew.id(), "130003ea8bfa43c5aacea07a86da3000");
    assertEquals(attachmentItemModelNew.profileId(), "7ec45986-54fc-4b66-a303-d9577b078c65");
    assertEquals(attachmentItemModelNew.accountId(), "130003ea8bfa43c5aacea07a86da3000");
    assertEquals(attachmentItemModelNew.instanceId(), "edf9524f-406c-412c-acbb-ee371a5cabda");
    assertEquals(attachmentItemModelNew.createdOn(), DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"));
    assertEquals(attachmentItemModelNew.createdBy(), "testString");
    assertEquals(attachmentItemModelNew.updatedOn(), DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"));
    assertEquals(attachmentItemModelNew.updatedBy(), "testString");
    assertEquals(attachmentItemModelNew.status(), "enabled");
    assertEquals(attachmentItemModelNew.schedule(), "daily");
    assertEquals(attachmentItemModelNew.notifications().toString(), attachmentsNotificationsPrototypeModel.toString());
    assertEquals(attachmentItemModelNew.lastScan().toString(), lastScanModel.toString());
    assertEquals(attachmentItemModelNew.nextScanTime(), DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"));
    assertEquals(attachmentItemModelNew.name(), "account-130003ea8bfa43c5aacea07a86da3000");
    assertEquals(attachmentItemModelNew.description(), "Test description");
  }
}