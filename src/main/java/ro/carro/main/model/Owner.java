package ro.carro.main.model;

import org.springframework.format.annotation.NumberFormat;

import java.util.Objects;
import javax.validation.constraints.*;

public final class Owner {


    private String id;
    @NotBlank
    private String name;
    @NumberFormat
    @NotNull
    private String phone;
    private String carId;
    private String paymentId;

    public Owner() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Owner owner = (Owner) o;
        return Objects.equals(id, owner.id) && Objects.equals(name, owner.name) && Objects.equals(phone, owner.phone) && Objects.equals(carId, owner.carId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, phone, carId);
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymeentId(String paymentId) {
        this.paymentId = paymentId;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", carId='" + carId + '\'' +
                ", paymentId='" + paymentId + '\'' +
                '}';
    }
}
