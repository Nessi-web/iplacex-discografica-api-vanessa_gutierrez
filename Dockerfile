FROM gradle:jdk-alpine AS builder
WORKDIR /app
COPY . .
RUN gradle bootJar --no-daemon

FROM openjdk:25-ea-slim
WORKDIR /app
# copia del jar compilado
COPY --from=builder /app/build/libs/discografia-1.jar app.jar

EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]