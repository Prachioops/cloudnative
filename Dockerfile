FROM openjdk:8
ADD target/trainingService-0.0.1-SNAPSHOT.jar trainingService-0.0.1-SNAPSHOT.jar
EXPOSE 8089

ENTRYPOINT ["java","-jar","trainingService-0.0.1-SNAPSHOT.jar"]