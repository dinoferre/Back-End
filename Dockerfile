FROM amazoncorretto:8-alpine-jdk

COPY target/JAR01.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]