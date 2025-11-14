package fr.vehiclerental.vehicles.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(VehicleNotFindException.class)
    public ResponseEntity<ErrorEntity> clientNotFoundHandler(VehicleNotFindException exception) {
        ErrorEntity error = new ErrorEntity(LocalDateTime.now(), exception.getMessage(), HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(error);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorEntity> badRequestHandler(BadRequestException exception) {
        ErrorEntity error = new ErrorEntity(LocalDateTime.now(), exception.getMessage(), HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(error);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorEntity> runtimeExceptionHandler(RuntimeException exception) {
        ErrorEntity error = new ErrorEntity(LocalDateTime.now(), exception.getMessage(), HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.FORBIDDEN.value()).body(error);
    }

    @ExceptionHandler(VehicleNotAdd.class)
    public ResponseEntity<ErrorEntity> vehicleNotAdd(VehicleNotAdd exception) {
        ErrorEntity error = new ErrorEntity(LocalDateTime.now(), exception.getMessage(), HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.FORBIDDEN.value()).body(error);
    }

    @ExceptionHandler(VehicleNotEdit.class)
    public ResponseEntity<ErrorEntity> vehicleNotEdit(VehicleNotEdit exception) {
        ErrorEntity error = new ErrorEntity(LocalDateTime.now(), exception.getMessage(), HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.FORBIDDEN.value()).body(error);
    }
}
