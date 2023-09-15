#!/bin/bash

# This script will publish code coverage info for a build of the master branch
# or a tagged release.

printf ">>>>> Publishing code coverage info\n"

JACOCO_SOURCE_PATH=modules/common/src/main/java ./cc-test-reporter format-coverage modules/common/target/site/jacoco/jacoco.xml -d -o common.json -t jacoco
JACOCO_SOURCE_PATH=modules/security-and-compliance-center-api/src/main/java ./cc-test-reporter format-coverage modules/security-and-compliance-center-api/target/site/jacoco/jacoco.xml -d -o security-and-compliance-center-api.json -t jacoco

./cc-test-reporter sum-coverage common.json security-and-compliance-center-api.json -o coverage.json -d

./cc-test-reporter upload-coverage --input coverage.json
