package ro.carro.main.repository;

import ro.carro.main.model.Car;

import java.util.List;

public interface CarRepository {

    Car insert(Car car);

    void delete(String carId);

    List<Car> findByDealershipId(String dealershipId);
   List<Car> findByOwnerId(String ownerId);

}
