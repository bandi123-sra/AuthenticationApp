# Use a lightweight Java 17 image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the target directory to the container
COPY target/agri-0.0.1-SNAPSHOT.jar app.jar

# Expose the application port (matches your docker-compose file)
EXPOSE 8082

# Set environment variables (optional fallback values)
ENV SPRING_DATASOURCE_URL=jdbc:mysql://mysql:3306/agri \
    SPRING_DATASOURCE_USERNAME=root \
    SPRING_DATASOURCE_PASSWORD=S@07!#s@07!# \
    SPRING_DATASOURCE_DRIVER-CLASS-NAME=com.mysql.cj.jdbc.Driver \
    SPRING_JPA_HIBERNATE_DDL-AUTO=update \
    SPRING_JPA_SHOW-SQL=true \
    demo.openapi.dev-url=https://agri.atparui.com \
    SPRING_JPA_PROPERTIES_HIBERNATE_FORMAT-SQL=true

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
