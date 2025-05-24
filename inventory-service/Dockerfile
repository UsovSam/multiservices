# Use OpenJDK 21 as the base image
FROM openjdk:21

# Set working directory
WORKDIR /app

# Copy the JAR file built by Gradle
COPY build/libs/*.jar app.jar

# Expose the port the app runs on
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
