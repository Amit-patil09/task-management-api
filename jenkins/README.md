# Jenkins CI Configuration

## Job Details

- Job Name: task-management-api-ci
- Job Type: Freestyle Project
- Source Code Repository: https://github.com/Amit-patil09/task-management-api
- Branch: main

## Source Code Management

- Git
- Repository: https://github.com/Amit-patil09/task-management-api
- Branch: */main

## Build Trigger

Poll SCM:

H/2 * * * *

## Build Steps

Execute Maven build command:

clean test package

## Post-Build Action

Archive the generated JAR files:

target/*.jar

## Build Verification

Jenkins Console Output is used to verify the build.

Expected successful result:

Finished: SUCCESS
