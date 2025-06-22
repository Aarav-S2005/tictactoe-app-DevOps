# Use Maven to build the project
FROM maven:3.9.6-eclipse-temurin-17 AS build

# Set working directory inside container
WORKDIR /app

# Copy project files
COPY pom.xml .
COPY src ./src

# Build and run tests
RUN mvn clean package

# Final runtime image (optional if you want to run the compiled app)
FROM eclipse-temurin:17
WORKDIR /app
COPY --from=build /app/target/tictactoe-app-1.0-SNAPSHOT.jar app.jar

# Default run command
CMD ["java", "-jar", "app.jar"]
