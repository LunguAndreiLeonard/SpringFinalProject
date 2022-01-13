package ro.carro.main.model;

import java.util.Objects;

public final class Car {

    private String id;
    private String name;
    private Brand brand;
    private String plate;
    private String dealershipId;
    private String ownerId;

    public Car() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return Objects.equals(id, car.id) && Objects.equals(name, car.name) && brand == car.brand && Objects.equals(plate, car.plate) && Objects.equals(dealershipId, car.dealershipId)  && Objects.equals(ownerId, car.ownerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, brand, plate, dealershipId, ownerId);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getDealershipId() {
        return dealershipId;
    }
    public String getOwnerId() { return ownerId; }

    public void setDealershipId(String dealershipId) {
       this.dealershipId = dealershipId;
    }
    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }
    @Override
    public String toString() {
        return "Car{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", brand=" + brand +
                ", plate='" + plate + '\'' +
                ", dealershipId='" + dealershipId + '\'' +
                ", ownerId='" + ownerId + '\'' +
                '}';
    }
}
