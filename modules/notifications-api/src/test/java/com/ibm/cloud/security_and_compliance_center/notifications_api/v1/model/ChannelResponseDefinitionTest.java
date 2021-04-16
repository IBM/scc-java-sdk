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

import com.ibm.cloud.security_and_compliance_center.notifications_api.v1.model.ChannelResponseDefinition;
import com.ibm.cloud.security_and_compliance_center.notifications_api.v1.model.ChannelResponseDefinitionAlertSourceItem;
import com.ibm.cloud.security_and_compliance_center.notifications_api.v1.model.ChannelResponseDefinitionSeverity;
import com.ibm.cloud.security_and_compliance_center.notifications_api.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ChannelResponseDefinition model.
 */
public class ChannelResponseDefinitionTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testChannelResponseDefinition() throws Throwable {
    ChannelResponseDefinition channelResponseDefinitionModel = new ChannelResponseDefinition();
    assertNull(channelResponseDefinitionModel.getChannelId());
    assertNull(channelResponseDefinitionModel.getName());
    assertNull(channelResponseDefinitionModel.getDescription());
    assertNull(channelResponseDefinitionModel.getType());
    assertNull(channelResponseDefinitionModel.getSeverity());
    assertNull(channelResponseDefinitionModel.getEndpoint());
    assertNull(channelResponseDefinitionModel.isEnabled());
    assertNull(channelResponseDefinitionModel.getAlertSource());
    assertNull(channelResponseDefinitionModel.getFrequency());
  }
}