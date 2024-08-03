FROM alpine/java:21-jre

RUN mkdir /app

COPY target/e2e-*.jar /app/e2e.jar

WORKDIR /app

CMD ["java", "-cp", "e2e.jar", "dev.graczykmateusz.e2e.WaitForServer"]
