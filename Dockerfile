FROM openjdk:26-ea-slim-trixie
WORKDIR /app
COPY ./target/vehicleRentalVehicle-0.0.1-SNAPSHOT.jar /app/vehicleRentalVehicle-0.0.1-SNAPSHOT.jar
EXPOSE 8082
CMD ["java", "-jar", "/app/vehicleRentalVehicle-0.0.1-SNAPSHOT.jar"]