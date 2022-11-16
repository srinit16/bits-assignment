#Start with a base image containing Java runtime
FROM openjdk:11-slim as build

#Information around who maintains the image
MAINTAINER javaoursoul

# Add the application's jar to the container
COPY target/CustomerService-1.0.jar CustomerService.jar

#execute the application
ENTRYPOINT ["java","-jar","/CustomerService.jar"]