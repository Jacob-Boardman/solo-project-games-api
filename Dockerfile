FROM maven:latest as maven-build
WORKDIR /build
COPY . .
RUN mvn clean package
FROM jboss/wildfly as wildfly-build
WORKDIR /opt/jboss/wildfly/standalone/deployments
COPY --from=maven-build /build/target/solo-project-games-api.war .
