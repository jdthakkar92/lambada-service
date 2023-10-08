FROM public.ecr.aws/lambda/java:8.2023.09.29.13
EXPOSE 8080
ADD target/lambada-service-0.0.1-SNAPSHOT-aws.jar lambada-service-0.0.1-SNAPSHOT-aws.jar
ENTRYPOINT ["java" , "-jar", "/lambada-service-0.0.1-SNAPSHOT-aws.jar"]
