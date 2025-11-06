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

    /**
     * méthode pour fournir la liste des Vehicles
     * @return la liste des véhicules
     */
    public List<Vehicle> getVehicles() {
        return vehicleRepository.findAll();
    }

    /**
     * méthode pour fournir la liste d'un Vehicle selon son id
     * @param id ID du véhicule
     * @return un véhicule selon son ID
     */
    public List<Vehicle> getVehicle(int id) {
        return vehicleRepository.findById(id);
    }


    /**
     * méthode pour ajouter un Vehicle
     * @param vehicle un véhicule
     */
    public void addingVehicle(Vehicle vehicle) {
        vehicleRepository.save(vehicle);
    }

    /**
     * méthode pour modifier un Vehicle
     * @param idVehicleActual véhicule séléctionné selon son ID
     * @param vehicleBodyRequest le véhicule donné dans la requête
     */
    public void toModifyVehicle(int idVehicleActual, Vehicle vehicleBodyRequest) {
        List<Vehicle> existingVehicle = vehicleRepository.findById(idVehicleActual);
        existingVehicle.get(0).setId(idVehicleActual);
        existingVehicle.get(0).setType(vehicleBodyRequest.getType());
        existingVehicle.get(0).setModel(vehicleBodyRequest.getModel());
        existingVehicle.get(0).setColor(vehicleBodyRequest.getColor());
        existingVehicle.get(0).setRegistration(vehicleBodyRequest.getRegistration());
        existingVehicle.get(0).setHorsePower(vehicleBodyRequest.getHorsePower());
        existingVehicle.get(0).setCylinder(vehicleBodyRequest.getCylinder());
        existingVehicle.get(0).setVolume(vehicleBodyRequest.getVolume());
        existingVehicle.get(0).setpricePerKilometer(vehicleBodyRequest.getpricePerKilometer());
        vehicleRepository.save(existingVehicle.get(0));
    }

    /**
     * méthode pour supprimer un Vehicle
     * @param id ID du véhicule à supprimer
     */
    public void deleteVehicle(int id) {
        vehicleRepository.deleteById(id);
    }
}
