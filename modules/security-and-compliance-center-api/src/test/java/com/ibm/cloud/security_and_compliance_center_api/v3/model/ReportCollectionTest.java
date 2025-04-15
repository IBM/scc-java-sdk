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
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Account;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.AdditionalDetails;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Attachment;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.AttachmentNotifications;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.AttachmentNotificationsControls;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ComplianceStatsWithNonCompliant;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ControlSummary;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.EvalStats;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Link;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.PageHRefFirst;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.PageHRefNext;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ProfileInfo;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Report;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ReportCollection;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ReportScope;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Scope;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ScopeID;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.ScopePropertyScopeAny;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Tags;
import com.ibm.cloud.security_and_compliance_center_api.v3.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ReportCollection model.
 */
public class ReportCollectionTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testReportCollection() throws Throwable {
    ReportCollection reportCollectionModel = new ReportCollection();
    assertNull(reportCollectionModel.getLimit());
    assertNull(reportCollectionModel.getTotalCount());
    assertNull(reportCollectionModel.getFirst());
    assertNull(reportCollectionModel.getNext());
    assertNull(reportCollectionModel.getHomeAccountId());
    assertNull(reportCollectionModel.getReports());
  }
}