FROM adoptopenjdk/openjdk11:jdk-11.0.2.9-slim
ARG JAR_FILE=target/bank-management-service-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} bank_service.jar

ENTRYPOINT ["java","-jar","/bank_service.jar"]