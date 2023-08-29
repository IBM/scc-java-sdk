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
import com.ibm.cloud.security_and_compliance_center_api.v3.model.AttachmentParameterPrototype;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.AttachmentsNotificationsPrototype;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.FailedControls;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.LastScan;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.MultiCloudScope;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.PropertyItem;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ReplaceProfileAttachmentOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ReplaceProfileAttachmentOptions model.
 */
public class ReplaceProfileAttachmentOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testReplaceProfileAttachmentOptions() throws Throwable {
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

    LastScan lastScanModel = new LastScan.Builder()
      .id("e8a39d25-0051-4328-8462-988ad321f49a")
      .status("in_progress")
      .time(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
      .build();
    assertEquals(lastScanModel.id(), "e8a39d25-0051-4328-8462-988ad321f49a");
    assertEquals(lastScanModel.status(), "in_progress");
    assertEquals(lastScanModel.time(), DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"));

    ReplaceProfileAttachmentOptions replaceProfileAttachmentOptionsModel = new ReplaceProfileAttachmentOptions.Builder()
      .attachmentId("testString")
      .profilesId("testString")
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
      .xCorrelationId("testString")
      .xRequestId("testString")
      .build();
    assertEquals(replaceProfileAttachmentOptionsModel.attachmentId(), "testString");
    assertEquals(replaceProfileAttachmentOptionsModel.profilesId(), "testString");
    assertEquals(replaceProfileAttachmentOptionsModel.id(), "130003ea8bfa43c5aacea07a86da3000");
    assertEquals(replaceProfileAttachmentOptionsModel.profileId(), "7ec45986-54fc-4b66-a303-d9577b078c65");
    assertEquals(replaceProfileAttachmentOptionsModel.accountId(), "130003ea8bfa43c5aacea07a86da3000");
    assertEquals(replaceProfileAttachmentOptionsModel.instanceId(), "edf9524f-406c-412c-acbb-ee371a5cabda");
    assertEquals(replaceProfileAttachmentOptionsModel.scope(), java.util.Arrays.asList(multiCloudScopeModel));
    assertEquals(replaceProfileAttachmentOptionsModel.createdOn(), DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"));
    assertEquals(replaceProfileAttachmentOptionsModel.createdBy(), "testString");
    assertEquals(replaceProfileAttachmentOptionsModel.updatedOn(), DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"));
    assertEquals(replaceProfileAttachmentOptionsModel.updatedBy(), "testString");
    assertEquals(replaceProfileAttachmentOptionsModel.status(), "enabled");
    assertEquals(replaceProfileAttachmentOptionsModel.schedule(), "daily");
    assertEquals(replaceProfileAttachmentOptionsModel.notifications(), attachmentsNotificationsPrototypeModel);
    assertEquals(replaceProfileAttachmentOptionsModel.attachmentParameters(), java.util.Arrays.asList(attachmentParameterPrototypeModel));
    assertEquals(replaceProfileAttachmentOptionsModel.lastScan(), lastScanModel);
    assertEquals(replaceProfileAttachmentOptionsModel.nextScanTime(), DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"));
    assertEquals(replaceProfileAttachmentOptionsModel.name(), "account-130003ea8bfa43c5aacea07a86da3000");
    assertEquals(replaceProfileAttachmentOptionsModel.description(), "Test description");
    assertEquals(replaceProfileAttachmentOptionsModel.xCorrelationId(), "testString");
    assertEquals(replaceProfileAttachmentOptionsModel.xRequestId(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testReplaceProfileAttachmentOptionsError() throws Throwable {
    new ReplaceProfileAttachmentOptions.Builder().build();
  }

}