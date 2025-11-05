package fr.vehiclerental.vehicles.service;

import fr.vehiclerental.vehicles.entity.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehiclesService {

    @Autowired
    VehiclesRepository vehicleRepository;

    //initialisation de la liste des Vehicles
    static List<Vehicle> vehicles = new ArrayList<>();


    //méthode pour fournir la liste des Vehicles
    public List<Vehicle> getVehicles() {
        return vehicleRepository.findAll();
    }

    //méthode pour fournir la liste d'un Vehicle selon son id
    public Vehicle getVehicle(int id) {
        return vehicleRepository.findById(id);
    }

    //méthode pour ajouter un Vehicle
    public void addingVehicle(Vehicle vehicle) {
        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = "http://localhost:8081/licenses/vehicleId=" + vehicle.getId();
        boolean result = restTemplate.getForObject(apiUrl, Boolean.class);
        if (result) {
            System.out.println(vehicle);
            vehicleRepository.save(vehicle);
        } else {
            throw new IllegalArgumentException("The drivingLicense is not valid !");
        }
    }

    //méthode pour modifier un Vehicle
    public Vehicle toModifyVehicle(int idVehicleActual, Vehicle vehicleBodyRequest) {
        Vehicle existingVehicle = vehicleRepository.findById(idVehicleActual);
        existingVehicle.setId(idVehicleActual);
        existingVehicle.setType(vehicleBodyRequest.getType());
        existingVehicle.setModel(vehicleBodyRequest.getModel());
        existingVehicle.setColor(vehicleBodyRequest.getColor());
        existingVehicle.setRegistration(vehicleBodyRequest.getRegistration());
        existingVehicle.setHorsePower(vehicleBodyRequest.getHorsePower());
        existingVehicle.setCylinder(vehicleBodyRequest.getCylinder());
        existingVehicle.setVolume(vehicleBodyRequest.getVolume());
        existingVehicle.setPrice(vehicleBodyRequest.getPrice());
        existingVehicle.setReservationFee(vehicleBodyRequest.getReservationFee());
        vehicleRepository.save(existingVehicle);
        return existingVehicle;
    }


    //méthode pour supprimer un Vehicle
    public void deleteVehicle(int id) {
        vehicleRepository.deleteById(id);
    }
}
