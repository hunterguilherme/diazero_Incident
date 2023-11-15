FROM openjdk:11-jre-slim

WORKDIR /src/main/java/com/diazero/incidentAPI

COPY target/incidentAPI-2.4.0.jar /app/incidentAPI-2.4.0.jar

# Expose the port that the application will run on
EXPOSE 8080

# Specify the command to run on container startup
CMD ["java", "-jar", "/app/incidentAPI-2.4.0.jar"]
