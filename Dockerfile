# FROM ubuntu:20.04

# #Installe l'environnement d'éxecution de Java 13
# RUN apt update && apt -y install openjdk-13-jre

# COPY MESIKABP-0.0.1-SNAPSHOT.jar /tmp/MESIKABP.jar

# #Port du serveur web
# EXPOSE 5366

# ENTRYPOINT [ "java", "-jar", "/tmp/MESIKABP.jar" ]
FROM openjdk:13-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]