package fr.vehiclerental.vehicles.controller;

import fr.vehiclerental.vehicles.entity.Vehicle;
import fr.vehiclerental.vehicles.service.VehiclesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Home page")
    @RequestMapping("/")
    public String index() {
        return "Hello People HElLoOO";
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
            ),
            @ApiResponse(
                    responseCode = "405",
                    description = "Operation failed",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    "{\"error\" : \"invalid entry\"}"
                            )
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
            ),
            @ApiResponse(
                    responseCode = "405",
                    description = "Operation failed",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = "{\"error\" : \"invalid entry\"}"
                            )
                    )
            )
    })

    @GetMapping("/vehicles/{id}")
    public ResponseEntity<Vehicle> displayVehicle(@PathVariable(value = "id") int VehicleId) {
        return ResponseEntity.ok().body(vehicleService.getVehicle(VehicleId));
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
    public ResponseEntity<Vehicle> addingVehicle(@Validated @RequestBody Vehicle Vehicle) {
        vehicleService.addingVehicle(Vehicle);
        return ResponseEntity.status(HttpStatus.CREATED).body(Vehicle);
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
    public ResponseEntity<Vehicle> toModifyVehicle(@PathVariable(value = "id") int VehicleId, @Validated @RequestBody Vehicle Vehicle) {
        Vehicle VehicleUpdated = vehicleService.toModifyVehicle(VehicleId, Vehicle);
        return ResponseEntity.ok(VehicleUpdated);
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
    public ResponseEntity deleteVehicle(@PathVariable(value = "id") int VehicleId) {
        vehicleService.deleteVehicle(VehicleId);
        return ResponseEntity.ok("The Vehicle are deleted");
    }
}
