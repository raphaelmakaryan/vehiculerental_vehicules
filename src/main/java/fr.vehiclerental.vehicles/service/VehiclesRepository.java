package fr.vehiclerental.vehicles.service;

import fr.vehiclerental.vehicles.entity.Vehicle;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VehiclesRepository extends CrudRepository<Vehicle, Integer> {
    List<Vehicle> findAll();
    Vehicle findById(int id);
}
