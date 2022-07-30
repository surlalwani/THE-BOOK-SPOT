FROM openjdk:11
EXPOSE 8080
ADD target/favourite_service_mongo_docker.jar favourite_service_mongo_docker.jar
ENTRYPOINT ["java", "-jar", "/favourite_service_mongo_docker.jar"]