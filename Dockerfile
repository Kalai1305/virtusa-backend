# Stage 1: Build JAR
FROM maven:3.8.5-openjdk-17-slim AS build
WORKDIR /app
COPY . /app
WORKDIR /app/virtusa_backend-main
RUN mvn clean package -DskipTests

# Stage 2: Run JAR
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/virtusa_backend-main/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
