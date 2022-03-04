FROM adoptopenjdk/openjdk11:jdk-11.0.2.9-slim
ARG JAR_FILE=target/atm-management-service-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} bank-management-service.jar

ENTRYPOINT ["java","-jar","/atm-management-service.jar"]