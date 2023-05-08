# quarkus-microprofile-config

Quarkus, like any other MicroProfile, follows the MicroProfile specifications. It allows developers to seamlessly set the variables found in the project and access them in the project scope during different life cycles.

The project’s settings are usually stored in the application.properties file. In addition, developers can locate the file in the resources folder found in the main folder
## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev -Dquarkus.profile=[your-profile]
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

