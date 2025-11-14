FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /workspace

COPY pom.xml .
COPY . .
RUN mvn -B -q package -DskipTests

FROM eclipse-temurin:17-jre
WORKDIR /work

COPY --from=build /workspace/target/quarkus-app/ ./

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "quarkus-run.jar"]
