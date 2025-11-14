package fr.vehiclerental.vehicles.controller;

import fr.vehiclerental.vehicles.entity.Vehicle;
import fr.vehiclerental.vehicles.exception.VehicleNotAdd;
import fr.vehiclerental.vehicles.exception.VehicleNotEdit;
import fr.vehiclerental.vehicles.exception.VehicleNotFindException;
import fr.vehiclerental.vehicles.service.VehiclesRepository;
import fr.vehiclerental.vehicles.service.VehiclesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class VehiclesController {

    private final VehiclesService vehicleService;
    private final VehiclesRepository vehiclesRepository;

    public VehiclesController(VehiclesService vehicleService, VehiclesRepository vehiclesRepository) {
        this.vehicleService = vehicleService;
        this.vehiclesRepository = vehiclesRepository;
    }

    @Operation(summary = "Home page")
    @RequestMapping("/")
    public String index() {
        return "Welcome to the Vehicle Rental company's Vehicle API!";
    }

    @Operation(
            summary = "View all vehicle in the database",
            description = "Query to retrieve all vehicle from the database"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Operation successful",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Vehicle.class)
                    )
            )
    })

    @GetMapping("/vehicles")
    public ResponseEntity<List<Vehicle>> displayVehicles() {
        return ResponseEntity.ok().body(vehicleService.getVehicles());
    }

    @Operation(
            summary = "View a specific vehicle from the database",
            description = "Query to retrieve a vehicle from the database"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Operation successful",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Vehicle.class)
                    )
            )
    })

    @GetMapping("/vehicles/{id}")
    public ResponseEntity<List<Vehicle>> displayVehicle(@PathVariable(value = "id") int VehicleId) {
        try {
            return ResponseEntity.ok().body(vehicleService.getVehicle(VehicleId));
        } catch (Exception exception) {
            throw new VehicleNotFindException(VehicleId);
        }
    }

    @Operation(
            summary = "Creates a new vehicle in the database",
            description = "Query to create/add vehicle in the database"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Operation successful",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = "{\n" +
                                            " \"success\": true, \n" +
                                            " \"message\": \"Your vehicle has been added!\"\n" +
                                            "}"
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "405",
                    description = "Operation failed ",
                    content = @Content(
                            mediaType = "application/json",
                            examples = {
                                    @ExampleObject(
                                            name = "License error",
                                            value = "{\n" +
                                                    " \"success\": false, \n" +
                                                    " \"message\": \"this vehicle already exists !\"\n" +
                                                    "}"),
                                    @ExampleObject(
                                            name = "General error",
                                            value = "{\n" +
                                                    " \"success\" : false, \n" +
                                                    " \"message\" : \"Your vehicle has not been added!\"\n" +
                                                    "}"
                                    )
                            }
                    )
            )
    })

    @PostMapping("/vehicles")
    public ResponseEntity<Map<String, Object>> addingVehicle(@Validated @RequestBody Vehicle Vehicle) {
        try {
            Map<String, Object> response = new HashMap<>();
            vehicleService.addingVehicle(Vehicle);
            response.put("success", true);
            response.put("message", "Your vehicle has been added !");
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            throw new VehicleNotAdd();
        }
    }

    @Operation(
            summary = "Update a vehicle in the database",
            description = "Query to update a vehicle in the database"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Operation successful",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = "{\n" +
                                            " \"success\": true, \n" +
                                            " \"message\": \"Your vehicle has been updated!\"\n" +
                                            "}"
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "405",
                    description = "Operation failed ",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = "{\n" +
                                            "    \"success\": true,\n" +
                                            "    \"message\": \"Your vehicle has been modified!\"\n" +
                                            "}"
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "405",
                    description = "Operation failed !",
                    content = @Content(
                            mediaType = "application/json",
                            examples = {
                                    @ExampleObject(
                                            name = "General error !",
                                            value = "{\n" +
                                                    "  \"localDateTime\": \"2025-11-03T08:25:00\",\n" +
                                                    "  \"message\": \"Vehicle not found with ID : 1\",\n" +
                                                    "  \"status\": 404\n" +
                                                    "}"
                                    )

                            }
                    )
            )
    })

    @PutMapping("/vehicles/{id}")
    public ResponseEntity<Map<String, Object>> toModifyVehicle(@PathVariable(value = "id") int VehicleId,
                                                               @Validated @RequestBody Vehicle Vehicle) {
        try {
            List<Vehicle> vehicleVerification = vehiclesRepository.findById(VehicleId);
            Map<String, Object> response = new HashMap<>();
            if (vehicleVerification == null || vehicleVerification.isEmpty()) {
                throw new VehicleNotFindException(VehicleId);
            } else {
                vehicleService.toModifyVehicle(VehicleId, Vehicle);
                response.put("success", true);
                response.put("message", "Your vehicle has been modified !");
                return ResponseEntity.ok(response);
            }
        } catch (Exception e) {
            throw new VehicleNotEdit();
        }
    }

    @Operation(
            summary = "Remove a vehicle from the database",
            description = "Query to delete a vehicle from the database"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Operation successful",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = "{\n" +
                                            "    \"success\": true,\n" +
                                            "    \"message\": \"Your vehicle has been removed!\"\n" +
                                            "}"
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "405",
                    description = "Operation failed ",
                    content = @Content(
                            mediaType = "application/json",
                            examples = {
                                    @ExampleObject(
                                            name = "General error",
                                            value = "{\n" +
                                                    "  \"localDateTime\": \"2025-11-03T08:25:00\",\n" +
                                                    "  \"message\": \"Vehicle not found with ID : 1 \",\n" +
                                                    "  \"status\": 404\n" +
                                                    "}"
                                    )

                            }
                    )
            )
    })

    @DeleteMapping("/vehicles/{id}")
    public ResponseEntity<Map<String, Object>> deleteVehicle(@PathVariable(value = "id") int VehicleId) {
        List<Vehicle> vehicleVerification = vehiclesRepository.findById(VehicleId);
        if (vehicleVerification == null || vehicleVerification.isEmpty()) {
            throw new VehicleNotFindException((VehicleId));
        } else {
            vehiclesRepository.delete(vehicleVerification.get(0));
            Map<String, Object> response = new HashMap<>();
            response.put("sucess", true);
            response.put("message", "The Vehicle are deleted");
            return ResponseEntity.ok(response);
        }
    }
}
