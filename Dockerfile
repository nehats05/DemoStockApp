FROM openjdk:11-jre
VOLUME /tmp
ADD target/demostockapp-0.0.1-SNAPSHOT.jar demostockapp.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/demostockapp.jar"]