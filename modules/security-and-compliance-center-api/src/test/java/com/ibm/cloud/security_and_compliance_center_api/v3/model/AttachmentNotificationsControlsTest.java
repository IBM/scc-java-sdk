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
import com.ibm.cloud.security_and_compliance_center_api.v3.model.AttachmentNotificationsControls;
import com.ibm.cloud.security_and_compliance_center_api.v3.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the AttachmentNotificationsControls model.
 */
public class AttachmentNotificationsControlsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testAttachmentNotificationsControls() throws Throwable {
    AttachmentNotificationsControls attachmentNotificationsControlsModel = new AttachmentNotificationsControls.Builder()
      .thresholdLimit(Long.valueOf("15"))
      .failedControlIds(java.util.Arrays.asList("testString"))
      .build();
    assertEquals(attachmentNotificationsControlsModel.thresholdLimit(), Long.valueOf("15"));
    assertEquals(attachmentNotificationsControlsModel.failedControlIds(), java.util.Arrays.asList("testString"));

    String json = TestUtilities.serialize(attachmentNotificationsControlsModel);

    AttachmentNotificationsControls attachmentNotificationsControlsModelNew = TestUtilities.deserialize(json, AttachmentNotificationsControls.class);
    assertTrue(attachmentNotificationsControlsModelNew instanceof AttachmentNotificationsControls);
    assertEquals(attachmentNotificationsControlsModelNew.thresholdLimit(), Long.valueOf("15"));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testAttachmentNotificationsControlsError() throws Throwable {
    new AttachmentNotificationsControls.Builder().build();
  }

}