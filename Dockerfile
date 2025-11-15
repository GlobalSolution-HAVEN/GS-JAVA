FROM maven:3.9-eclipse-temurin-17 AS build
COPY . .
RUN mvn clean install
FROM eclipse-temurin:17-jre
COPY --from=build /workspace/target/quarkus-app/ ./
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "quarkus-run.jar"]

