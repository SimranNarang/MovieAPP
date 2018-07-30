FROM java:8-jre
ADD ./target/movie-app-0.0.1-SNAPSHOT.jar /usr/src/movie-app-0.0.1-SNAPSHOT.jar
WORKDIR usr/src
RUN sh -c 'touch /app.jar'
ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://admiring_mayer/test", "-Djava.security.egd=file:/dev/./urandom","-jar","/movie-app-0.0.1-SNAPSHOT.jar"]