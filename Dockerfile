FROM amazoncorretto:8-alpine-jdk

COPY target/backend_dinoferre.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]