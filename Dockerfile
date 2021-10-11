
FROM openjdk:8-jdk-alpine
EXPOSE 9021
COPY /target/pcks-roadway-location-core-0.0.1-SNAPSHOT.jar pcks-roadway-location-core-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/pcks-roadway-location-core-0.0.1-SNAPSHOT.jar"]