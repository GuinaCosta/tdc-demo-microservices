FROM openjdk:15-jdk-slim

LABEL source="https://github.com/GuinaCosta/spring-service" \
      maintainer="@iamguinacosta"

RUN mkdir /app
RUN addgroup --system spring && useradd -g users -G spring spring
USER spring:spring
#ARG JAR_FILE=/home/gradle/src/build/libs/*.jar
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} /app/app.jar
COPY newrelic /app/newrelic
RUN ls -al /app
ENTRYPOINT ["java","-javaagent:/app/newrelic/newrelic.jar","-jar","/app/app.jar"]
