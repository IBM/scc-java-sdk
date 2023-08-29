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
import com.ibm.cloud.security_and_compliance_center_api.v3.model.EventNotifications;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ObjectStorage;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Settings;
import com.ibm.cloud.security_and_compliance_center_api.v3.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the Settings model.
 */
public class SettingsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testSettings() throws Throwable {
    EventNotifications eventNotificationsModel = new EventNotifications.Builder()
      .instanceCrn("crn:v1:staging:public:cloud-object-storage:global:a/ff88f007f9ff4622aac4fbc0eda36255:7199ae60-a214-4dd8-9bf7-ce571de49d01::")
      .updatedOn(DateUtils.parseAsDateTime("2000-01-23T04:56:07.000+00:00"))
      .sourceId("crn:v1:staging:public:event-notifications:us-south:a/ff88f007f9ff4622aac4fbc0eda36255:b8b07245-0bbe-4478-b11c-0dce523105fd::")
      .sourceDescription("This source is used for integration with IBM Cloud Security and Compliance Center.")
      .sourceName("compliance")
      .build();
    assertEquals(eventNotificationsModel.instanceCrn(), "crn:v1:staging:public:cloud-object-storage:global:a/ff88f007f9ff4622aac4fbc0eda36255:7199ae60-a214-4dd8-9bf7-ce571de49d01::");
    assertEquals(eventNotificationsModel.updatedOn(), DateUtils.parseAsDateTime("2000-01-23T04:56:07.000+00:00"));
    assertEquals(eventNotificationsModel.sourceId(), "crn:v1:staging:public:event-notifications:us-south:a/ff88f007f9ff4622aac4fbc0eda36255:b8b07245-0bbe-4478-b11c-0dce523105fd::");
    assertEquals(eventNotificationsModel.sourceDescription(), "This source is used for integration with IBM Cloud Security and Compliance Center.");
    assertEquals(eventNotificationsModel.sourceName(), "compliance");

    ObjectStorage objectStorageModel = new ObjectStorage.Builder()
      .instanceCrn("instance_crn")
      .bucket("bucket")
      .bucketLocation("bucket_location")
      .bucketEndpoint("bucket_endpoint")
      .updatedOn(DateUtils.parseAsDateTime("2000-01-23T04:56:07.000+00:00"))
      .build();
    assertEquals(objectStorageModel.instanceCrn(), "instance_crn");
    assertEquals(objectStorageModel.bucket(), "bucket");
    assertEquals(objectStorageModel.bucketLocation(), "bucket_location");
    assertEquals(objectStorageModel.bucketEndpoint(), "bucket_endpoint");
    assertEquals(objectStorageModel.updatedOn(), DateUtils.parseAsDateTime("2000-01-23T04:56:07.000+00:00"));

    Settings settingsModel = new Settings.Builder()
      .eventNotifications(eventNotificationsModel)
      .objectStorage(objectStorageModel)
      .build();
    assertEquals(settingsModel.eventNotifications(), eventNotificationsModel);
    assertEquals(settingsModel.objectStorage(), objectStorageModel);

    String json = TestUtilities.serialize(settingsModel);

    Settings settingsModelNew = TestUtilities.deserialize(json, Settings.class);
    assertTrue(settingsModelNew instanceof Settings);
    assertEquals(settingsModelNew.eventNotifications().toString(), eventNotificationsModel.toString());
    assertEquals(settingsModelNew.objectStorage().toString(), objectStorageModel.toString());
  }
}