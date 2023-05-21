FROM openjdk:17-jdk-slim
ARG JAR_FILE=*.jar
COPY ${JAR_FILE} todo-api-01.jar
ENTRYPOINT ["java", "-jar", "todo-api-01.jar"]
EXPOSE 8080