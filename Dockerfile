FROM openjdk:8
VOLUME /tmp
ADD target/demostockapp-0.0.1-SNAPSHOT.jar demostockapp.jar
ENTRYPOINT ["java","-jar","/demostockapp.jar"]