#Baseimage /it has to be in any Dockerfile. When we type openjdk:17 OS already came with it
FROM openjdk:17-jdk
#jar file. copy it and paste it -> /usr/app/
COPY ./target/spring-25-Docker-0.0.1-SNAPSHOT.jar  /usr/app/
#now since our app is in /usr/app/ folder we need to direct here
WORKDIR /usr/app
#we need to execute this jar file
ENTRYPOINT ["java","-jar","spring-25-Docker-0.0.1-SNAPSHOT.jar"]
