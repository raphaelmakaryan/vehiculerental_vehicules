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
     *
     * @return la liste des véhicules
     */
    public List<Vehicle> getVehicles() {
        return vehicleRepository.findAll();
    }

    /**
     * méthode pour fournir la liste d'un Vehicle selon son id
     *
     * @param id ID du véhicule
     * @return un véhicule selon son ID
     */
    public List<Vehicle> getVehicle(int id) {
        return vehicleRepository.findById(id);
    }


    /**
     * méthode pour ajouter un Vehicle
     *
     * @param vehicle un véhicule
     */
    public void addingVehicle(Vehicle vehicle) {
        vehicleRepository.save(vehicle);
    }

    /**
     * méthode pour modifier un Vehicle
     *
     * @param idVehicleActual    véhicule séléctionné selon son ID
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
        existingVehicle.get(0).setPricePerKilometer(vehicleBodyRequest.getPricePerKilometer());
        vehicleRepository.save(existingVehicle.get(0));
    }

    public void createMoto() {
        Vehicle vehicle = new Vehicle();
        vehicle.setType("motorcycle");
        vehicle.setModel("Harley-Davidson Street 750");
        vehicle.setColor("Noir métallique");
        vehicle.setRegistration("75-AB-2025");
        vehicle.setHorsePower(750);
        vehicle.setCylinder(2);
        vehicle.setVolume(0);
        vehicle.setPricePerKilometer(10);
        vehicleRepository.save(vehicle);
    }

    public void createUtility() {
        Vehicle vehicle = new Vehicle();
        vehicle.setType("utility");
        vehicle.setModel("Ford Transit Custom");
        vehicle.setColor("Blanc");
        vehicle.setRegistration("92-CD-2024");
        vehicle.setHorsePower(170);
        vehicle.setCylinder(0);
        vehicle.setVolume(2000);
        vehicle.setPricePerKilometer(20);
        vehicleRepository.save(vehicle);
    }

    public void createCar() {
        Vehicle vehicle = new Vehicle();
        vehicle.setType("car");
        vehicle.setModel("BMW 320i");
        vehicle.setColor("Bleu océan");
        vehicle.setRegistration("75-EF-2023");
        vehicle.setHorsePower(184);
        vehicle.setCylinder(0);
        vehicle.setVolume(0);
        vehicle.setPricePerKilometer(10);
        vehicleRepository.save(vehicle);
    }

    public void createCar2() {
        Vehicle vehicle = new Vehicle();
        vehicle.setType("car");
        vehicle.setModel("Renault Clio 5");
        vehicle.setColor("Rouge vif");
        vehicle.setRegistration("13-GH-2024");
        vehicle.setHorsePower(110);
        vehicle.setCylinder(0);
        vehicle.setVolume(0);
        vehicle.setPricePerKilometer(30);
        vehicleRepository.save(vehicle);
    }

    public void saveInitialData() {
        createMoto();
        createUtility();
        createCar();
        createCar2();
    }

}
