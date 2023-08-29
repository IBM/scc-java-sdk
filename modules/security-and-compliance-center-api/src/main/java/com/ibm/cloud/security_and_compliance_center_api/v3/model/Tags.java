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

import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The collection of different types of tags.
 */
public class Tags extends GenericModel {

  protected List<String> user;
  protected List<String> access;
  protected List<String> service;

  protected Tags() { }

  /**
   * Gets the user.
   *
   * The collection of user tags.
   *
   * @return the user
   */
  public List<String> getUser() {
    return user;
  }

  /**
   * Gets the access.
   *
   * The collection of access tags.
   *
   * @return the access
   */
  public List<String> getAccess() {
    return access;
  }

  /**
   * Gets the service.
   *
   * The collection of service tags.
   *
   * @return the service
   */
  public List<String> getService() {
    return service;
  }
}

