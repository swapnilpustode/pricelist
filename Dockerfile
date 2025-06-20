# --- Stage 1: Build the JAR ---
FROM maven:3.9.6-eclipse-temurin-21 as builder

WORKDIR /app

# Copy everything and build the JAR inside Docker (if not already built)
COPY . .
RUN mvn clean package -DskipTests

# --- Stage 2: Create the runtime image ---
FROM eclipse-temurin:21-jdk-jammy

WORKDIR /app

# Copy only the built jar from previous stage
COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
