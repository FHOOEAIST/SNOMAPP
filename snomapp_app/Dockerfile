FROM openjdk:11
FROM maven:3.6.3-jdk-11
COPY pom.xml /tmp/
COPY src /tmp/src/
WORKDIR /tmp/
ARG JAR_FILE=target/snomapp-1.0.0.jar
RUN mvn package
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar", "/app.jar"]