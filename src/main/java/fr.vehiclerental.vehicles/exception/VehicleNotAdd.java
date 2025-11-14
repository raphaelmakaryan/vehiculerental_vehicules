package fr.vehiclerental.vehicles.exception;

public class VehicleNotAdd extends RuntimeException {
    public VehicleNotAdd() {
        super("Your vehicle has not been added !");
    }
}
