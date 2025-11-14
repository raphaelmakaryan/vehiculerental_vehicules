package fr.vehiclerental.vehicles.service;

import fr.vehiclerental.vehicles.entity.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class VehiclesService {

    @Autowired
    VehiclesRepository vehicleRepository;

    /**
     * Méthode pour fournir la liste des Vehicles
     *
     * @return la liste des véhicules
     */
    public List<Vehicle> getVehicles() {
        return vehicleRepository.findAll();
    }

    /**
     * Méthode pour fournir la liste d'un Vehicle selon son id
     *
     * @param id ID du véhicule
     * @return un véhicule selon son ID
     */
    public List<Vehicle> getVehicle(int id) {
        return vehicleRepository.findById(id);
    }


    /**
     * Méthode pour ajouter un Vehicle
     *
     * @param vehicle un véhicule
     */
    public void addingVehicle(Vehicle vehicle) {
        vehicleRepository.save(vehicle);
    }

    /**
     * Méthode pour modifier un Vehicle
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
        vehicle.setModel("Yamaha MT-07");
        vehicle.setColor("Black");
        vehicle.setRegistration("BT-605-CX");
        vehicle.setHorsePower(74);
        vehicle.setCylinder(690);
        vehicle.setVolume(0);
        vehicle.setPricePerKilometer(10);
        vehicle.setDefaultPrice(new Random().nextInt(0, 500));
        vehicleRepository.save(vehicle);
    }

    public void createMoto2() {
        Vehicle vehicle = new Vehicle();
        vehicle.setType("motorcycle");
        vehicle.setModel("Honda X-ADV");
        vehicle.setColor("Black");
        vehicle.setRegistration("BG-74-DTC");
        vehicle.setHorsePower(58);
        vehicle.setCylinder(745);
        vehicle.setVolume(0);
        vehicle.setPricePerKilometer(10);
        vehicle.setDefaultPrice(new Random().nextInt(0, 500));
        vehicleRepository.save(vehicle);
    }

    public void createUtility() {
        Vehicle vehicle = new Vehicle();
        vehicle.setType("utility");
        vehicle.setModel("Mercedes Sprinter");
        vehicle.setColor("Black");
        vehicle.setRegistration("JM-00-MRC");
        vehicle.setHorsePower(190);
        vehicle.setCylinder(0);
        vehicle.setVolume(17);
        vehicle.setPricePerKilometer(20);
        vehicle.setDefaultPrice(new Random().nextInt(0, 500));
        vehicleRepository.save(vehicle);
    }

    public void createUtility2() {
        Vehicle vehicle = new Vehicle();
        vehicle.setType("utility");
        vehicle.setModel("Renault Trafic");
        vehicle.setColor("Black");
        vehicle.setRegistration("DT-580-CL");
        vehicle.setHorsePower(150);
        vehicle.setCylinder(0);
        vehicle.setVolume(9);
        vehicle.setPricePerKilometer(20);
        vehicle.setDefaultPrice(new Random().nextInt(0, 500));
        vehicleRepository.save(vehicle);
    }

    public void createCar() {
        Vehicle vehicle = new Vehicle();
        vehicle.setType("car");
        vehicle.setModel("Mercedes CLA");
        vehicle.setColor("Black and orange");
        vehicle.setRegistration("GG-605-BB");
        vehicle.setHorsePower(220);
        vehicle.setCylinder(0);
        vehicle.setVolume(0);
        vehicle.setPricePerKilometer(10);
        vehicle.setDefaultPrice(new Random().nextInt(0, 500));
        vehicleRepository.save(vehicle);
    }

    public void createCar2() {
        Vehicle vehicle = new Vehicle();
        vehicle.setType("car");
        vehicle.setModel("Renault Clio 5");
        vehicle.setColor("Red");
        vehicle.setRegistration("BB-241-GH");
        vehicle.setHorsePower(150);
        vehicle.setCylinder(0);
        vehicle.setVolume(0);
        vehicle.setPricePerKilometer(30);
        vehicle.setDefaultPrice(new Random().nextInt(0, 500));
        vehicleRepository.save(vehicle);
    }

    /**
     * Méthode pour créer des véhicules fictifs
     */
    public void saveInitialData() {
        createMoto();
        createMoto2();
        createUtility();
        createUtility2();
        createCar();
        createCar2();
    }

}
