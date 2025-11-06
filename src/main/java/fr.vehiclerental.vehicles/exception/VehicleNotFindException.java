package fr.vehiclerental.vehicles.exception;

public class VehicleNotFindException extends RuntimeException {
    public VehicleNotFindException(Integer VehicleId) {
        super("Vehicle not found with ID : " +VehicleId);
    }
}
