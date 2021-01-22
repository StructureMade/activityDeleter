FROM openjdk:15
ADD target/activitydeleter.jar activitydeleter.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "activitydeleter.jar"]
