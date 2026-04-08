# # ── Stage 1: Build ───────────────────────────────────────
# FROM eclipse-temurin:17-jdk-alpine AS builder
# WORKDIR /app

# # Copy Maven wrapper and pom first (layer cache)
# COPY mvnw .
# COPY .mvn .mvn
# COPY pom.xml .
# RUN ./mvnw dependency:go-offline -q

# # Copy source and build
# COPY src src
# RUN ./mvnw package -DskipTests -q

# # ── Stage 2: Runtime ─────────────────────────────────────
# FROM eclipse-temurin:17-jre-alpine
# WORKDIR /app

# # Create log directory
# RUN mkdir -p /var/log/nameapi

# # Copy built jar
# COPY --from=builder /app/target/NameApi-1.0.0.jar app.jar

# EXPOSE 8080

# ENTRYPOINT ["java", "-jar", "app.jar"]

FROM eclipse-temurin:21-jre
WORKDIR /app
RUN mkdir /logs
COPY target/NameApi-0.0.1.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]