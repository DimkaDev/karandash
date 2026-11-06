# SiteForge control plane

Java 21, Quarkus 3.40.1.1 and Maven 3.9.16 (wrapper with distribution checksum).

Run from the repository root with a Java 21 JDK configured:

```sh
services/control-plane/mvnw -f services/control-plane/pom.xml verify
services/control-plane/mvnw -f services/control-plane/pom.xml quarkus:dev
```

Development listens on `127.0.0.1:8080`; tests select a free local port.
Automatic Dev Services are disabled for development and tests. Database
configuration belongs to the next infrastructure slice.

Run the packaged application:

```sh
java -jar services/control-plane/target/quarkus-app/quarkus-run.jar
```

This increment only starts the HTTP runtime. Business endpoints, database,
authentication and AI integrations are not implemented. Unknown routes return
404. No provider keys or other secrets are needed for build or startup.
