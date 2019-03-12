FROM  openjdk:10-jre-slim
ADD target/taxi-spring-boot-app.jar taxi-spring-boot-app.jar
MAINTAINER BorisKezikov
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "taxi-spring-boot-app.jar"]