# Customisation

## Customizing DAMAP backend

To migrate with the base, you need to fetch updates with upstream, following Semantic Versioning guidelines:

- **Major:** Big changes (first value).
- **Minor:** Additional changes (second value).
  For more details on Semantic Versioning, see [semver.org](https://semver.org/).

### Dependency Management

There are two options for handling the DAMAP dependency:

1. **Maven Central Approach**: You can specify the DAMAP version as a dependency, and Maven will automatically pull it from [Maven Central](https://central.sonatype.com/artifact/org.damap/base).

   Add the following dependency to your `pom.xml`:

   ```xml
   <dependency>
     <groupId>org.damap</groupId>
     <artifactId>base</artifactId>
     <version>4.0.2</version>
   </dependency>
   ```

2. **Local Build Approach**: Alternatively, you can download the DAMAP Git repository, compile it locally, and specify the compiled version as a dependency. When doing this, Maven will prioritize the locally compiled version over the one from Maven Central.

   To compile locally, run the following:

   ```shell
   git clone https://github.com/tugraz-rdm/damap-backend-tugraz.git
   cd damap-backend
   mvn clean install
   ```

   Then, add the dependency to your `pom.xml`:

   ```xml
   <dependency>
     <groupId>org.damap</groupId>
     <artifactId>base</artifactId>
     <version>4.0.2</version>
   </dependency>
   ```

   Ensure the local version is built properly so Maven uses it over the central repository version.

### Overriding Configuration Values

To connect required components, provide values to custom config variables in `application.yaml`. To use YAML, add the following to your `pom.xml`:

```xml
<dependency>
  <groupId>io.quarkus</groupId>
  <artifactId>quarkus-config-yaml</artifactId>
</dependency>
```

Copy the custom config settings from the backend's `application.yaml` to your project’s `application.yaml`, and edit them as needed.

You can override these variables at runtime using environment variables (see [quarkus config guide](https://quarkus.io/guides/config-reference)).

```yaml
damap:
  origins: https://your.frontend.com, https://*.yourdomain.com
```

### Configuring Authentication Service

Add the following values for authentication service integration:

```yaml
damap:
  auth:
    url: https://your.authentication.server
    client:
      backend: your-backend-authentication-client-id
      frontend: your-frontend-authentication-client-id
    scope: your-authentication-scope
    user: your-authentication-claim-holding-the-user-id
```

### Configuring the Database

Provide database config values:

```yaml
damap:
  datasource:
    url: jdbc:your-datasource-url
    username: your-database-username
    password: your-database-password
    db-kind: postgresql
```

If you want to customize Liquibase, you can create your own changelogs. For example:

```yaml
liquibase:
  migrate-at-start: true
  change-log: at/ac/tugraz/damap/db/newChangeLog-root.yaml
```

Include the damap changelogs and create custom ones as needed.
