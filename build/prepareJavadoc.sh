#!/bin/sh

# based on https://odoepner.wordpress.com/2012/02/17/shell-script-to-generate-simple-index-html/

mvn javadoc:aggregate
mkdir javadocs
mv target/site/apidocs javadocs/docs

echo '<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>IBM Cloud Security & Compliance Center</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="page-header">
        <h1>IBM Cloud Security & Compliance Center Java SDK Documentation</h1>
    </div>
    <p><a href="https://cloud.ibm.com/docs?tab=api-docs&category=security%2Cplatform_services">Security & Compliance Center Info</a>
        | <a href="https://github.com/ibm-cloud-security/scc-java-sdk">GitHub</a>
    </p>
    <p><a href="docs">Javadoc</a></p>
</div>
</body>
</html>' >> javadocs/index.html