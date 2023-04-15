FROM amazoncorretto:8-alpine-jdk

COPY target/dinobc.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]
