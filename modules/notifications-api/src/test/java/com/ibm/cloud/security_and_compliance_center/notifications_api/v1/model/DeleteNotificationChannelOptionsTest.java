/*
 * (C) Copyright IBM Corp. 2021.
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

package com.ibm.cloud.security_and_compliance_center.notifications_api.v1.model;

import com.ibm.cloud.security_and_compliance_center.notifications_api.v1.model.DeleteNotificationChannelOptions;
import com.ibm.cloud.security_and_compliance_center.notifications_api.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the DeleteNotificationChannelOptions model.
 */
public class DeleteNotificationChannelOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testDeleteNotificationChannelOptions() throws Throwable {
    DeleteNotificationChannelOptions deleteNotificationChannelOptionsModel = new DeleteNotificationChannelOptions.Builder()
      .accountId("testString")
      .channelId("testString")
      .transactionId("testString")
      .build();
    assertEquals(deleteNotificationChannelOptionsModel.accountId(), "testString");
    assertEquals(deleteNotificationChannelOptionsModel.channelId(), "testString");
    assertEquals(deleteNotificationChannelOptionsModel.transactionId(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteNotificationChannelOptionsError() throws Throwable {
    new DeleteNotificationChannelOptions.Builder().build();
  }

}