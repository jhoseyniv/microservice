FROM adoptopenjdk/openjdk11:jdk-11.0.2.9-slim
ARG JAR_FILE=target/eureka-naming-server-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} eureka-naming-server.jar

ENTRYPOINT ["java","-jar","/eureka-naming-server.jar"]