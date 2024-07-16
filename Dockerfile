FROM openjdk:21

RUN mkdir /opt/app

COPY delivery/target/delivery-*.jar /opt/app/delivery.jar

WORKDIR /opt/app

CMD ["java", "-jar", "delivery.jar"]

