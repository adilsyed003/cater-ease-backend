# Stage 1: Build the app using Maven + JDK 21
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

# Optimize layer caching
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy app source
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Minimal runtime using JRE 21
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copy built JAR
COPY --from=build /app/target/*.jar app.jar

# Expose port
EXPOSE 8081

# Start app
ENTRYPOINT ["java", "-jar", "app.jar"]
