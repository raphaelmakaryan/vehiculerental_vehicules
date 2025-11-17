package fr.vehiclerental.vehicles.entity;

import jakarta.persistence.*;

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
    protected int horse_power;
    protected int cylinder;
    protected int volume;
    protected int price_per_kilometer;
    protected int default_price;

    public Vehicle() {
    }

    public Vehicle(int id, String type, String model, String color, String registration, int horse_power, int cylinder, int volume, int price_per_kilometer) {
        this.id = id;
        this.type = type;
        this.model = model;
        this.color = color;
        this.registration = registration;
        this.horse_power = horse_power;
        this.cylinder = cylinder;
        this.volume = volume;
        this.price_per_kilometer = price_per_kilometer;
        this.default_price = new Random().nextInt(0, 500);
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
        return horse_power;
    }

    public int getCylinder() {
        return cylinder;
    }

    public int getVolume() {
        return volume;
    }

    public int getPricePerKilometer() {
        return price_per_kilometer;
    }

    public int getDefaultPrice() {
        return default_price;
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

    public void setHorsePower(int horse_power) {
        this.horse_power = horse_power;
    }

    public void setCylinder(int cylinder) {
        this.cylinder = cylinder;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void setPricePerKilometer(int price_per_kilometer) {
        this.price_per_kilometer = price_per_kilometer;
    }

    public void setDefaultPrice(int default_price) {
        this.default_price = default_price;
    }

    public int createDefaultPrice() {
        return new Random().nextInt(0, 500);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", registration='" + registration + '\'' +
                ", horse_power=" + horse_power +
                ", cylinder=" + cylinder +
                ", volume=" + volume +
                ", price_per_kilometer=" + price_per_kilometer +
                ", default_price=" + default_price +
                '}';
    }
}
