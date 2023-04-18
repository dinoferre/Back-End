FROM amazoncorretto:17-alpine-jdk

COPY target/backend_dinoferre.jar backend_dinoferre.jar

ENTRYPOINT ["java","-jar","/backend_dinoferre.jar"]