#Este código Dockerfile es para crear una imagen Docker basada en el Amazon Corretto 17 Alpine JDK. 
#El código copia el archivo target/portfolio-0.0.1-SNAPSHOT.jar y establece su 
#entrada principal (ENTRYPOINT) como "java -jar /portfolio-0.0.1-SNAPSHOT.jar".
FROM amazoncorretto:11-alpine-jdk 
MAINTAINER DINO FERRE
COPY target/portfolio-0.0.1-SNAPSHOT.jar portfolio-0.0.1-SNAPSHOT.jar
EXPOSE 8080 
ENTRYPOINT ["java","-jar","/portfolio-0.0.1-SNAPSHOT.jar"]