FROM openjdk:21

RUN mkdir /app

COPY delivery/target/delivery-*.jar /app/delivery.jar

RUN echo "Contents of /app directory after copying JAR file:" && ls -l /app

WORKDIR /app

RUN echo "Current working directory:" && pwd

RUN echo "Files in the working directory:" && ls -l

CMD ["java", "-jar", "delivery.jar"]

