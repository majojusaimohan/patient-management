# Stage 1: Build the application using Maven and Java 17
FROM maven:3.9.9-eclipse-temurin-17 AS builder

WORKDIR /app

# Copy only the pom.xml first to leverage Docker layer caching
COPY pom.xml .

# Download dependencies (this layer is cached unless pom.xml changes)
RUN mvn dependency:go-offline -B

# Copy source code and build the package
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Create the lightweight runtime image
FROM eclipse-temurin:17-jre AS runner

WORKDIR /app

# Copy the built jar from the builder stage
# Ensure the filename matches your actual pom.xml artifactId/version
COPY --from=builder /app/target/patient-service-0.0.1-SNAPSHOT.jar ./app.jar

# Your service is configured for port 4000
EXPOSE 4000

ENTRYPOINT ["java", "-jar", "app.jar"]