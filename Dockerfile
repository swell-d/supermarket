FROM openjdk:14-jdk-alpine
COPY *.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]