[![CI/CD Pipeline](https://github.com/IBM/scc-java-sdk/actions/workflows/main.yaml/badge.svg)](https://github.com/IBM/scc-java-sdk/actions/workflows/main.yaml)
[![Javadoc](https://img.shields.io/static/v1?label=javadoc&message=latest&color=blue)](http://IBM.github.io/scc-java-sdk)
[![Release](https://img.shields.io/github/v/release/IBM/scc-java-sdk)](https://img.shields.io/github/v/release/IBM/scc-java-sdk)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![codecov](https://codecov.io/gh/IBM/scc-java-sdk/branch/main/graph/badge.svg?token=9E3PB14AKI)](https://codecov.io/gh/IBM/scc-java-sdk)
[![semantic-release](https://img.shields.io/badge/%20%20%F0%9F%93%A6%F0%9F%9A%80-semantic--release-e10079.svg)](https://github.com/semantic-release/semantic-release)
[![Maven Central](https://img.shields.io/maven-central/v/com.ibm.cloud/scc)](https://maven-badges.herokuapp.com/maven-central/com.ibm.cloud/scc)

# IBM Cloud Security & Compliance Center Java SDK Version 1.0.0
Java client library to interact with various [IBM Cloud Security & Compliance Center](https://cloud.ibm.com/docs?tab=api-docs&category=platform_services%2Csecurity).

Disclaimer: this SDK is being released initially as a **pre-release** version.
Changes might occur which impact applications that use this SDK.

## Table of Contents

<!--
  The TOC below is generated using the `markdown-toc` node package.

      https://github.com/jonschlinkert/markdown-toc

  You should regenerate the TOC after making changes to this file.

      npx markdown-toc --maxdepth 4 -i README.md
  -->

<!-- toc -->

- [Overview](#overview)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
  * [Maven](#maven)
  * [Gradle](#gradle)
- [Using the SDK](#using-the-sdk)
- [Questions](#questions)
- [Issues](#issues)
- [Open source @ IBM](#open-source--ibm)
- [Contributing](#contributing)
- [License](#license)

<!-- tocstop -->

## Overview

The IBM Cloud Security & Compliance Center Java SDK allows developers to programmatically interact with the following IBM Cloud services:

Service Name | Imported Class Name
--- | ---
[FindingsApi](https://cloud.ibm.com/apidocs/findings) | FindingsApi:1.0.0
[NotificationsApi](https://cloud.ibm.com/apidocs/security-compliance/si-notifications) | NotificationsApi:1.0.0
[ConfigurationGovernanceApi](https://cloud.ibm.com/apidocs/security-compliance/config) | ConfigurationGovernanceApi:1.0.0

## Prerequisites

[ibm-cloud-onboarding]: https://cloud.ibm.com/registration

* An [IBM Cloud][ibm-cloud-onboarding] account.
* An IAM API key to allow the SDK to access your account. Create one [here](https://cloud.ibm.com/iam/apikeys).
* Java 8 or above.

## Installation
The current version of this SDK is: 1.0.0

Each service's artifact coordinates are listed in the table above.

The project artifacts are published on the public [Maven Central](https://repo1.maven.org/maven2/)
artifact repository.  This is the default public repository used by maven when searching for dependencies.
To use this repository within a gradle build, please see
[this link](https://docs.gradle.org/current/userguide/declaring_repositories.html).

To use a particular service, define a dependency that contains the
artifact coordinates (group id, artifact id and version) for the service.
Here are examples for maven and gradle:

### Maven

```xml
<dependency>
    <groupId>com.ibm.cloud</groupId>
    <artifactId>findings</artifactId>
    <version>1.0.0</version>
</dependency>
```

### Gradle
```gradle
compile 'com.ibm.cloud:findings:1.0.0'
```

## Using the SDK
For general SDK usage information, please see [this link](https://github.com/IBM/ibm-cloud-sdk-common/blob/main/README.md)

## Questions

If you are having difficulties using this SDK or have a question about the IBM Cloud services,
please ask a question at
[Stack Overflow](http://stackoverflow.com/questions/ask?tags=ibm-cloud).

## Issues
If you encounter an issue with the project, you are welcome to submit a
[bug report](https://github.com/IBM/scc-java-sdk/issues).
Before that, please search for similar issues. It's possible that someone has already reported the problem.

## Open source @ IBM
Find more open source projects on the [IBM Github Page](http://ibm.github.io/)

## Contributing
See [CONTRIBUTING](CONTRIBUTING.md).

## License

The IBM Cloud MySDK Java SDK is released under the Apache 2.0 license.
The license's full text can be found in [LICENSE](LICENSE).
