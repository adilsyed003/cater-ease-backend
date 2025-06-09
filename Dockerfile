# Stage 1: Build the application using a Maven image with JDK
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

# Copy only pom.xml and download dependencies (cacheable layer)
COPY pom.xml .
RUN mvn dependency:go-offline

# Now copy the full source
COPY src ./src

# Package the application
RUN mvn clean package -DskipTests

# Stage 2: Use a lightweight JRE for running the app
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copy only the built JAR from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose application port
EXPOSE 8081

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
