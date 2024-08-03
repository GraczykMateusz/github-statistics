FROM alpine/java:21-jre

RUN mkdir /app

COPY target/test-classes /app/test-classes
COPY target/dependency /app/dependency

WORKDIR /app

CMD ["java", "-cp", "/app/dependency/*:/app/test-classes", "org.testng.TestNG", "-testclass", "dev.graczykmateusz.e2e.HomePageIT", "-d", "/app/test-output"]
