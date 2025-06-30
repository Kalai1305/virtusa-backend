# Use OpenJDK 17 as the base image
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the built JAR file into the container
COPY target/virtusa_backend_main-0.0.1-SNAPSHOT.jar app.jar

# Start the Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]
