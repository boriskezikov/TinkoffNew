FROM openjdk:8
ADD /target/taxi-spring-boot-app.jar app.jar
MAINTAINER BorisKezikov
ENV JAVA_OPTS="-Duser.timezone=GMT -Dfile.encoding=UTF-8 -Denvironment.type=production"
CMD exec java $JAVA_OPTS -jar /app.jar