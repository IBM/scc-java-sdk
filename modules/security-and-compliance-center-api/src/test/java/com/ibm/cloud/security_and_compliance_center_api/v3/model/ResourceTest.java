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
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Account;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Resource;
import com.ibm.cloud.security_and_compliance_center_api.v3.model.Tags;
import com.ibm.cloud.security_and_compliance_center_api.v3.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the Resource model.
 */
public class ResourceTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testResource() throws Throwable {
    Account accountModel = new Account.Builder()
      .id("531fc3e28bfc43c5a2cea07786d93f5c")
      .name("NIST")
      .type("account_type")
      .build();
    assertEquals(accountModel.id(), "531fc3e28bfc43c5a2cea07786d93f5c");
    assertEquals(accountModel.name(), "NIST");
    assertEquals(accountModel.type(), "account_type");

    Tags tagsModel = new Tags.Builder()
      .user(java.util.Arrays.asList("testString"))
      .access(java.util.Arrays.asList("testString"))
      .service(java.util.Arrays.asList("testString"))
      .build();
    assertEquals(tagsModel.user(), java.util.Arrays.asList("testString"));
    assertEquals(tagsModel.access(), java.util.Arrays.asList("testString"));
    assertEquals(tagsModel.service(), java.util.Arrays.asList("testString"));

    Resource resourceModel = new Resource.Builder()
      .reportId("30b434b3-cb08-4845-af10-7a8fc682b6a8")
      .homeAccountId("2411ffdc16844b07b42521c3443f456d")
      .id("crn:v1:bluemix:public:kms:us-south:a/5af747ca19a8a278b1b6e4eec20df507:03502a50-4ea9-463c-80e5-e27ed838cdb6::")
      .resourceName("jeff's key")
      .account(accountModel)
      .componentId("cloud-object_storage")
      .componentName("cloud-object_storage")
      .environment("ibm cloud")
      .tags(tagsModel)
      .status("compliant")
      .totalCount(Long.valueOf("140"))
      .passCount(Long.valueOf("123"))
      .failureCount(Long.valueOf("12"))
      .errorCount(Long.valueOf("5"))
      .skippedCount(Long.valueOf("7"))
      .completedCount(Long.valueOf("135"))
      .serviceName("pm-20")
      .instanceCrn("testString")
      .build();
    assertEquals(resourceModel.reportId(), "30b434b3-cb08-4845-af10-7a8fc682b6a8");
    assertEquals(resourceModel.homeAccountId(), "2411ffdc16844b07b42521c3443f456d");
    assertEquals(resourceModel.id(), "crn:v1:bluemix:public:kms:us-south:a/5af747ca19a8a278b1b6e4eec20df507:03502a50-4ea9-463c-80e5-e27ed838cdb6::");
    assertEquals(resourceModel.resourceName(), "jeff's key");
    assertEquals(resourceModel.account(), accountModel);
    assertEquals(resourceModel.componentId(), "cloud-object_storage");
    assertEquals(resourceModel.componentName(), "cloud-object_storage");
    assertEquals(resourceModel.environment(), "ibm cloud");
    assertEquals(resourceModel.tags(), tagsModel);
    assertEquals(resourceModel.status(), "compliant");
    assertEquals(resourceModel.totalCount(), Long.valueOf("140"));
    assertEquals(resourceModel.passCount(), Long.valueOf("123"));
    assertEquals(resourceModel.failureCount(), Long.valueOf("12"));
    assertEquals(resourceModel.errorCount(), Long.valueOf("5"));
    assertEquals(resourceModel.skippedCount(), Long.valueOf("7"));
    assertEquals(resourceModel.completedCount(), Long.valueOf("135"));
    assertEquals(resourceModel.serviceName(), "pm-20");
    assertEquals(resourceModel.instanceCrn(), "testString");

    String json = TestUtilities.serialize(resourceModel);

    Resource resourceModelNew = TestUtilities.deserialize(json, Resource.class);
    assertTrue(resourceModelNew instanceof Resource);
    assertEquals(resourceModelNew.reportId(), "30b434b3-cb08-4845-af10-7a8fc682b6a8");
    assertEquals(resourceModelNew.homeAccountId(), "2411ffdc16844b07b42521c3443f456d");
    assertEquals(resourceModelNew.id(), "crn:v1:bluemix:public:kms:us-south:a/5af747ca19a8a278b1b6e4eec20df507:03502a50-4ea9-463c-80e5-e27ed838cdb6::");
    assertEquals(resourceModelNew.resourceName(), "jeff's key");
    assertEquals(resourceModelNew.account().toString(), accountModel.toString());
    assertEquals(resourceModelNew.componentId(), "cloud-object_storage");
    assertEquals(resourceModelNew.componentName(), "cloud-object_storage");
    assertEquals(resourceModelNew.environment(), "ibm cloud");
    assertEquals(resourceModelNew.tags().toString(), tagsModel.toString());
    assertEquals(resourceModelNew.status(), "compliant");
    assertEquals(resourceModelNew.totalCount(), Long.valueOf("140"));
    assertEquals(resourceModelNew.passCount(), Long.valueOf("123"));
    assertEquals(resourceModelNew.failureCount(), Long.valueOf("12"));
    assertEquals(resourceModelNew.errorCount(), Long.valueOf("5"));
    assertEquals(resourceModelNew.skippedCount(), Long.valueOf("7"));
    assertEquals(resourceModelNew.completedCount(), Long.valueOf("135"));
    assertEquals(resourceModelNew.serviceName(), "pm-20");
    assertEquals(resourceModelNew.instanceCrn(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testResourceError() throws Throwable {
    new Resource.Builder().build();
  }

}