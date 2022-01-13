package ro.carro.main.service;

import ro.carro.main.dto.cars.AddCarRequest;
import ro.carro.main.dto.cars.AddCarRessponse;
import ro.carro.main.dto.dealerships.CreateDealershipResponse;
import ro.carro.main.dto.dealerships.CreateRequestDealership;
import ro.carro.main.dto.dealerships.ReadDealershipResponse;
//import ro.carro.main.dto.owners.AddOwnerRequest;
//import ro.carro.main.dto.owners.AddOwnerResponse;

import java.util.Optional;

public interface DealershipService {

    CreateDealershipResponse addDealership(CreateRequestDealership request);

    Optional<ReadDealershipResponse> readDealership(String  id);

    AddCarRessponse addCar(String dealershipId, AddCarRequest request);

    void removeCar(String dealershipId, String carId);

    //AddOwnerResponse addOwner(String carId, AddOwnerRequest request);

    //void removeOwner(String carId, String ownerId);
}
