
FROM openjdk:8-jdk-alpine
EXPOSE 9021
COPY /target/pcks-roadbrewa-location-core-0.0.1-SNAPSHOT.jar pcks-roadbrewa-location-core-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/pcks-roadbrewa-location-core-0.0.1-SNAPSHOT.jar"]