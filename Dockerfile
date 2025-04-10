# Use an official OpenJDK runtime as a parent image
FROM openjdk:11-jre-slim

# Set the working directory in the container
WORKDIR /app

# Copy the application WAR file into the container
COPY target/WebGoat.war /app/WebGoat.war

# Expose the port your application runs on
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "/app/WebGoat.war"]