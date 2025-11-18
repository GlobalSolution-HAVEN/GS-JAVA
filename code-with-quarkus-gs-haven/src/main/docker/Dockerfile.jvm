FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app

COPY pom.xml .
COPY .mvn .mvn
COPY mvnw .
COPY mvnw.cmd .

RUN mvn dependency:go-offline -B

COPY src ./src

RUN mvn package -B -DskipTests -Dquarkus.package.type=fast-jar

FROM registry.access.redhat.com/ubi9/openjdk-21:1.23
USER 185
WORKDIR /deployments

COPY --from=build --chown=185:0 /app/target/quarkus-app/ .

EXPOSE 8080
CMD ["java", "-jar", "quarkus-run.jar"]
