package ro.carro.main.model;

import java.util.Objects;

public class Dealership {

    private String id;
    private String name;
    private String city;
    private String address;
    private String ownerId;

    public Dealership() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
       if (!(o instanceof  Dealership)) return false;
       Dealership dealership = (Dealership) o;
       return Objects.equals(id, dealership.id) && Objects.equals(name, dealership.name) && Objects.equals(city, dealership.city) && Objects.equals(ownerId, dealership.ownerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, city, ownerId);
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public String getOwnerId() { return ownerId;
    }
    public void setOwnerId(String ownerId)
    {
        this.ownerId = ownerId;

    }

    @Override
    public String toString() {
        return "Dealership{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", ownerId='" + ownerId + '\'' +
                '}';
    }
}
