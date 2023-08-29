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
import com.ibm.cloud.security_and_compliance_center_api.v3.model.AttachmentsNotificationsPrototype;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.FailedControls;
import com.ibm.cloud.security_and_compliance_center_api.v3.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the AttachmentsNotificationsPrototype model.
 */
public class AttachmentsNotificationsPrototypeTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testAttachmentsNotificationsPrototype() throws Throwable {
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

    String json = TestUtilities.serialize(attachmentsNotificationsPrototypeModel);

    AttachmentsNotificationsPrototype attachmentsNotificationsPrototypeModelNew = TestUtilities.deserialize(json, AttachmentsNotificationsPrototype.class);
    assertTrue(attachmentsNotificationsPrototypeModelNew instanceof AttachmentsNotificationsPrototype);
    assertEquals(attachmentsNotificationsPrototypeModelNew.enabled(), Boolean.valueOf(true));
    assertEquals(attachmentsNotificationsPrototypeModelNew.controls().toString(), failedControlsModel.toString());
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testAttachmentsNotificationsPrototypeError() throws Throwable {
    new AttachmentsNotificationsPrototype.Builder().build();
  }

}