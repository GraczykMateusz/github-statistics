FROM openjdk:21

RUN mkdir /app

COPY delivery/target/delivery-*.jar /app/delivery.jar

WORKDIR /app

CMD ["java", "-jar", "delivery.jar"]

