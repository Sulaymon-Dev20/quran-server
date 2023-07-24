FROM maven:3-sapmachine-17 AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package
FROM openjdk:17-oracle
MAINTAINER quran.sulaymonyahyo.com
COPY target/quran-0.0.1-SNAPSHOT.jar holybook.jar
ENTRYPOINT ["java","-jar","/holybook.jar"]
