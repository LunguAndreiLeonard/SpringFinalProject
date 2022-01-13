package ro.carro.main.service;

import org.springframework.stereotype.Service;
import ro.carro.main.dto.cars.AddCarRequest;
import ro.carro.main.dto.cars.AddCarRessponse;
import ro.carro.main.dto.cars.CarCollection;
import ro.carro.main.dto.dealerships.CreateDealershipResponse;
import ro.carro.main.dto.dealerships.CreateRequestDealership;
import ro.carro.main.dto.dealerships.ReadDealershipResponse;
import ro.carro.main.dto.owners.OwnerCollection;
import ro.carro.main.model.Car;
import ro.carro.main.model.Dealership;
import ro.carro.main.repository.CarRepository;
import ro.carro.main.repository.DealershipRepository;

import java.util.Optional;

@Service
public class DealershipServiceImpl implements DealershipService{

    private final DealershipRepository dealershipRepo;
    private final CarRepository carRepo;

    public DealershipServiceImpl(DealershipRepository dealershipRepo, CarRepository carRepo) {
        this.dealershipRepo = dealershipRepo;
        this.carRepo = carRepo;
    }

    @Override
    public CreateDealershipResponse addDealership(CreateRequestDealership request) {
        final var dealership = new Dealership();
        dealership.setName(request.name());
        dealership.setCity(request.city());
        final var inserted = dealershipRepo.insert(dealership);
        return new CreateDealershipResponse(inserted.getId());
    }

    @Override
    public Optional<ReadDealershipResponse> readDealership(String id) {
        return dealershipRepo.read(id)
                .map(dealership -> {
                    final var cars = carRepo.findByDealershipId(dealership.getId()).stream()
                            .map(car -> new CarCollection(car.getName(),car.getBrand(),car.getPlate()))
                            .toList();
                    return new ReadDealershipResponse(dealership.getName(),dealership.getCity(),dealership.getAddress());
                });
    }

    @Override
    public AddCarRessponse addCar(String dealershipId, AddCarRequest request) {
        if (!dealershipRepo.exists(dealershipId)) {
            throw new IllegalArgumentException("No dealership for id" + dealershipId);
        }
        final var car = new Car();
        car.setName(request.name());
        car.setBrand(request.brand());
        car.setPlate(request.plate());
        car.setDealershipId(dealershipId);
        car.setOwnerId(car.getOwnerId());

        final var inserted = carRepo.insert(car);
        return new AddCarRessponse(inserted.getId());

        }


    @Override
    public void removeCar(String dealershipId, String carId) {
        if (!dealershipRepo.exists(dealershipId)) {
            throw new IllegalArgumentException("No dealership for id" + dealershipId);
        }

        carRepo.delete(carId);
    }
}
