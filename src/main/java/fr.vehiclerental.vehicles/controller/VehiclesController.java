package fr.vehiclerental.vehicles.controller;

import fr.vehiclerental.vehicles.entity.Vehicle;
import fr.vehiclerental.vehicles.service.VehiclesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehiclesController {

    private final VehiclesService vehicleService;

    public VehiclesController(VehiclesService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("/vehicles")
    public ResponseEntity<List<Vehicle>> displayVehicles() {
        return ResponseEntity.ok().body(vehicleService.getVehicles());
    }

    @GetMapping("/vehicles/{id}")
    public ResponseEntity<Vehicle> displayVehicle(@PathVariable(value = "id") int VehicleId) {
        return ResponseEntity.ok().body(vehicleService.getVehicle(VehicleId));
    }

    @PostMapping("/vehicles")
    public ResponseEntity<Vehicle> addingVehicle(@Validated @RequestBody Vehicle Vehicle) {
        vehicleService.addingVehicle(Vehicle);
        return ResponseEntity.status(HttpStatus.CREATED).body(Vehicle);
    }

    @PutMapping("/vehicles/{id}")
    public ResponseEntity<Vehicle> toModifyVehicle(@PathVariable(value = "id") int VehicleId, @Validated @RequestBody Vehicle Vehicle) {
        Vehicle VehicleUpdated = vehicleService.toModifyVehicle(VehicleId, Vehicle);
        return ResponseEntity.ok(VehicleUpdated);
    }

    @DeleteMapping("/vehicles/{id}")
    public ResponseEntity deleteVehicle(@PathVariable(value = "id") int VehicleId) {
        vehicleService.deleteVehicle(VehicleId);
        return ResponseEntity.ok("The Vehicle are deleted");
    }
}
