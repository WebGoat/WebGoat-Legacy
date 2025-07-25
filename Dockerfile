 FROM openjdk:8-jdk-alpine
WORKDIR /app
COPY target/WebGoat-6.0.1-war-exec.jar webgoat.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "webgoat.jar"]

