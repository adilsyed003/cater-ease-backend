# Stage 1: Build the application using JDK 24 (if available)
FROM openjdk:24-jdk AS build
WORKDIR /app
COPY pom.xml .
COPY src src

# Copy Maven wrapper
COPY mvnw .
COPY .mvn .mvn

# Set execution permission for the Maven wrapper
RUN chmod +x ./mvnw

# Build the application without running tests
RUN ./mvnw clean package -DskipTests

# Stage 2: Create the final Docker image using OpenJDK 24
FROM openjdk:24-jdk
VOLUME /tmp

# Copy the JAR from the build stage
COPY --from=build /app/target/*.jar app.jar

# Run the application
ENTRYPOINT ["java", "-jar", "/app.jar"]

# Expose port for Spring Boot application
EXPOSE 8081
