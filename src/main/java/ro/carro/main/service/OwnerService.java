package ro.carro.main.service;

import ro.carro.main.dto.cars.AddCarRequest;
import ro.carro.main.dto.cars.AddCarRessponse;
import ro.carro.main.dto.dealerships.CreateDealershipResponse;
import ro.carro.main.dto.dealerships.CreateRequestDealership;
import ro.carro.main.dto.owners.AddOwnerRequest;
import ro.carro.main.dto.owners.AddOwnerResponse;
import ro.carro.main.dto.owners.OwnerCollection;
import ro.carro.main.dto.payments.AddPaymentRequest;
import ro.carro.main.dto.payments.AddPaymentResponse;

import java.util.Optional;

public interface OwnerService {

    AddOwnerResponse addOwner(AddOwnerRequest request);
    Optional<OwnerCollection> readOwner(String id);
    AddCarRessponse addCar(String ownerId, AddCarRequest request);
    void removeCar(String ownerId, String carId);
    AddPaymentResponse addPayment(String ownerId, AddPaymentRequest request);
    void removePayment(String ownerId, String paymentId);
    CreateDealershipResponse createDealership(String ownerId, CreateRequestDealership request);
    void removeDealership(String ownerId, String dealershipId);
}
