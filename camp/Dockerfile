FROM adoptopenjdk/openjdk11
VOLUME /tmp
ADD target/camp-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/urandom", "-jar", "/app.jar"]