# 1️⃣ Build stage
FROM maven:3.9.6-eclipse-temurin-21 AS build

WORKDIR /app

# Copy pom and source code
COPY pom.xml .
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests

# 2️⃣ Run stage
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copy jar from build stage
COPY --from=build /app/target/*.jar app.jar

# Expose port (Railway will override with PORT env variable)
EXPOSE 8080

# Start the app
ENTRYPOINT ["java", "-jar", "app.jar"]
