package fr.vehiclerental.vehicles.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Random;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected int id;
    protected String type;
    protected String model;
    protected String color;
    protected String registration;
    protected int horsePower;
    protected Integer cylinder;
    protected Integer volume;
    protected int pricePerKilometer;
    protected int defaultPrice;


    public Vehicle(int id, String type, String model, String color, String registration, int horsePower, int cylinder, int volume, int pricePerKilometer) {
        this.id = id;
        this.type = type;
        this.model = model;
        this.color = color;
        this.registration = registration;
        this.horsePower = horsePower;
        this.cylinder = cylinder;
        this.volume = volume;
        this.pricePerKilometer = pricePerKilometer;
        this.defaultPrice = new Random().nextInt(0,500);
    }

    public Vehicle() {
    }

    // GETTER

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }
    public String getRegistration() {
        return registration;
    }
    public int getHorsePower() {
        return horsePower;
    }
    public int getCylinder() {
        return cylinder;
    }
    public int getVolume() {
        return volume;
    }
    public int getpricePerKilometer() {
        return pricePerKilometer;
    }
    public int getDefaultPrice() {
        return defaultPrice;
    }



    // SETTER
    public void setId(int id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }
    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }
    public void setCylinder(int cylinder) {
        this.cylinder = cylinder;
    }
    public void setVolume(int volume) {
        this.volume = volume;
    }
    public void setpricePerKilometer(int pricePerKilometer) {
        this.pricePerKilometer = pricePerKilometer;
    }
    public void setDefaultPrice(int defaultPrice) {
        this.defaultPrice = defaultPrice;
    }
}
