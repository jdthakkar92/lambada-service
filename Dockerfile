FROM openjdk:8
EXPOSE 8080
ADD target/lambada-service-0.0.1-SNAPSHOT-aws.jar lambada-service-0.0.1-SNAPSHOT-aws.jar
ENTRYPOINT ["java" , "-jar", "/lambada-service-0.0.1-SNAPSHOT-aws.jar"]