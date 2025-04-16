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
import com.ibm.cloud.security_and_compliance_center_api.v3.model.DateRange;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.LastScan;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.MultiCloudScopePayloadById;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Parameter;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ProfileAttachment;
import com.ibm.cloud.security_and_compliance_center_api.v3.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ProfileAttachment model.
 */
public class ProfileAttachmentTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testProfileAttachment() throws Throwable {
    ProfileAttachment profileAttachmentModel = new ProfileAttachment();
    assertNull(profileAttachmentModel.getAttachmentParameters());
    assertNull(profileAttachmentModel.getDescription());
    assertNull(profileAttachmentModel.getName());
    assertNull(profileAttachmentModel.getNotifications());
    assertNull(profileAttachmentModel.getSchedule());
    assertNull(profileAttachmentModel.getScope());
    assertNull(profileAttachmentModel.getStatus());
    assertNull(profileAttachmentModel.getDataSelectionRange());
    assertNull(profileAttachmentModel.getAccountId());
    assertNull(profileAttachmentModel.getCreatedBy());
    assertNull(profileAttachmentModel.getCreatedOn());
    assertNull(profileAttachmentModel.getId());
    assertNull(profileAttachmentModel.getInstanceId());
    assertNull(profileAttachmentModel.getLastScan());
    assertNull(profileAttachmentModel.getNextScanTime());
    assertNull(profileAttachmentModel.getProfileId());
    assertNull(profileAttachmentModel.getUpdatedBy());
    assertNull(profileAttachmentModel.getUpdatedOn());
  }
}