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
import com.ibm.cloud.security_and_compliance_center_api.v3.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the Account model.
 */
public class AccountTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testAccount() throws Throwable {
    Account accountModel = new Account.Builder()
      .id("531fc3e28bfc43c5a2cea07786d93f5c")
      .name("NIST")
      .type("account_type")
      .build();
    assertEquals(accountModel.id(), "531fc3e28bfc43c5a2cea07786d93f5c");
    assertEquals(accountModel.name(), "NIST");
    assertEquals(accountModel.type(), "account_type");

    String json = TestUtilities.serialize(accountModel);

    Account accountModelNew = TestUtilities.deserialize(json, Account.class);
    assertTrue(accountModelNew instanceof Account);
    assertEquals(accountModelNew.id(), "531fc3e28bfc43c5a2cea07786d93f5c");
    assertEquals(accountModelNew.name(), "NIST");
    assertEquals(accountModelNew.type(), "account_type");
  }
}