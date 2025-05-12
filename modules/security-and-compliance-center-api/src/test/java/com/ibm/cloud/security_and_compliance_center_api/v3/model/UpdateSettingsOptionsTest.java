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
import com.ibm.cloud.security_and_compliance_center_api.v3.model.EventNotificationsPrototype;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ObjectStoragePrototype;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.UpdateSettingsOptions;
import com.ibm.cloud.security_and_compliance_center_api.v3.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the UpdateSettingsOptions model.
 */
public class UpdateSettingsOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testUpdateSettingsOptions() throws Throwable {
    ObjectStoragePrototype objectStoragePrototypeModel = new ObjectStoragePrototype.Builder()
      .bucket("testString")
      .instanceCrn("testString")
      .build();
    assertEquals(objectStoragePrototypeModel.bucket(), "testString");
    assertEquals(objectStoragePrototypeModel.instanceCrn(), "testString");

    EventNotificationsPrototype eventNotificationsPrototypeModel = new EventNotificationsPrototype.Builder()
      .instanceCrn("testString")
      .sourceDescription("This source is used for integration with IBM Cloud Security and Compliance Center.")
      .sourceName("compliance")
      .build();
    assertEquals(eventNotificationsPrototypeModel.instanceCrn(), "testString");
    assertEquals(eventNotificationsPrototypeModel.sourceDescription(), "This source is used for integration with IBM Cloud Security and Compliance Center.");
    assertEquals(eventNotificationsPrototypeModel.sourceName(), "compliance");

    UpdateSettingsOptions updateSettingsOptionsModel = new UpdateSettingsOptions.Builder()
      .instanceId("acd7032c-15a3-484f-bf5b-67d41534d940")
      .objectStorage(objectStoragePrototypeModel)
      .eventNotifications(eventNotificationsPrototypeModel)
      .build();
    assertEquals(updateSettingsOptionsModel.instanceId(), "acd7032c-15a3-484f-bf5b-67d41534d940");
    assertEquals(updateSettingsOptionsModel.objectStorage(), objectStoragePrototypeModel);
    assertEquals(updateSettingsOptionsModel.eventNotifications(), eventNotificationsPrototypeModel);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateSettingsOptionsError() throws Throwable {
    new UpdateSettingsOptions.Builder().build();
  }

}