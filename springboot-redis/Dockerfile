# FROM gradle:6.8.3-jdk11 AS build
# COPY --chown=gradle:gradle . /home/gradle/src
# WORKDIR /home/gradle/src
# RUN ./gradlew build --no-daemon -x test --configure-on-demand

FROM openjdk:11-jdk-slim

LABEL source="https://github.com/GuinaCosta/spring-service" \
      maintainer="@iamguinacosta"

RUN mkdir /app
RUN addgroup --system spring && useradd -g users -G spring spring
USER spring:spring
#ARG JAR_FILE=/home/gradle/src/build/libs/*.jar
ARG JAR_FILE=build/libs/*.jar
#COPY --from=build ${JAR_FILE} /app/app.jar
COPY ${JAR_FILE} /app/app.jar
COPY newrelic /app/newrelic
RUN ls -al /app
ENTRYPOINT ["java","-javaagent:/app/newrelic/newrelic.jar","-jar","/app/app.jar"]
