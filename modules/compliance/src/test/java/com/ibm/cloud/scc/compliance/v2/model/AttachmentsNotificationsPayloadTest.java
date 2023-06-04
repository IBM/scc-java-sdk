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

import com.ibm.cloud.scc.compliance.v2.model.AttachmentsNotificationsPayload;
import com.ibm.cloud.scc.compliance.v2.model.FailedControls;
import com.ibm.cloud.scc.compliance.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the AttachmentsNotificationsPayload model.
 */
public class AttachmentsNotificationsPayloadTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testAttachmentsNotificationsPayload() throws Throwable {
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

    String json = TestUtilities.serialize(attachmentsNotificationsPayloadModel);

    AttachmentsNotificationsPayload attachmentsNotificationsPayloadModelNew = TestUtilities.deserialize(json, AttachmentsNotificationsPayload.class);
    assertTrue(attachmentsNotificationsPayloadModelNew instanceof AttachmentsNotificationsPayload);
    assertEquals(attachmentsNotificationsPayloadModelNew.enabled(), Boolean.valueOf(true));
    assertEquals(attachmentsNotificationsPayloadModelNew.controls().toString(), failedControlsModel.toString());
  }
}