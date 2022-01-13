
package ro.carro.main.service;


import org.springframework.stereotype.Service;
import ro.carro.main.dto.cars.AddCarRequest;
import ro.carro.main.dto.cars.AddCarRessponse;
import ro.carro.main.dto.cars.CarCollection;
import ro.carro.main.dto.dealerships.CreateDealershipResponse;
import ro.carro.main.dto.dealerships.CreateRequestDealership;
import ro.carro.main.dto.dealerships.ReadDealershipResponse;
import ro.carro.main.dto.owners.AddOwnerRequest;
import ro.carro.main.dto.owners.AddOwnerResponse;
import ro.carro.main.dto.owners.OwnerCollection;
import ro.carro.main.dto.payments.AddPaymentRequest;
import ro.carro.main.dto.payments.AddPaymentResponse;
import ro.carro.main.dto.payments.PaymentCollection;
import ro.carro.main.model.Car;
import ro.carro.main.model.Dealership;
import ro.carro.main.model.Owner;
import ro.carro.main.model.Payment;
import ro.carro.main.repository.CarRepository;
import ro.carro.main.repository.DealershipRepository;
import ro.carro.main.repository.OwnerRepository;
import ro.carro.main.repository.PaymentRepository;

import java.util.Optional;

@Service
public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepository ownerRepo;
    private final CarRepository carRepo;
    private final PaymentRepository paymentRepo;
    private final DealershipRepository dealershipRepo;

    public OwnerServiceImpl(OwnerRepository ownerRepo, CarRepository carRepo, PaymentRepository paymentRepo, DealershipRepository dealershipRepo) {
        this.ownerRepo = ownerRepo;
        this.carRepo = carRepo;
        this.paymentRepo = paymentRepo;
        this.dealershipRepo = dealershipRepo;
    }
    @Override
    public AddOwnerResponse addOwner(AddOwnerRequest request) {
        final var owner = new Owner();
        owner.setName(request.name());
        owner.setPhone(request.phone());
        final var inserted = ownerRepo.insert(owner);
        return new AddOwnerResponse(inserted.getId());
    }

    @Override
    public Optional<OwnerCollection> readOwner(String id) {
        return ownerRepo.read(id)
                .map(owner -> {
                    final var cars = carRepo.findByOwnerId(owner.getId()).stream()
                            .map(car -> new CarCollection(car.getName(),car.getBrand(),car.getPlate()))
                            .toList();

                    final var payments = paymentRepo.findByOwnerId(owner.getId()).stream()
                            .map(payment -> new PaymentCollection(payment.getTitle(), payment.getDebt(), payment.getDetails()))
                            .toList();

                    final var dealerships = dealershipRepo.findByOwnerId(owner.getId()).stream()
                            .map(dealership -> new ReadDealershipResponse(dealership.getName(), dealership.getCity(), dealership.getAddress()))
                            .toList();
                    return new OwnerCollection(owner.getName(),owner.getPhone(), cars, payments, dealerships);
                });
    }

    @Override
    public AddCarRessponse addCar(String ownerId, AddCarRequest request) {
        if (!ownerRepo.exists(ownerId)) {
            throw new IllegalArgumentException("No owner for id" + ownerId);
        }
        final var car = new Car();
        car.setName(request.name());
        car.setBrand(request.brand());
        car.setPlate(request.plate());
        car.setOwnerId(ownerId);

        final var inserted = carRepo.insert(car);
        return new AddCarRessponse(inserted.getId());

    }


    @Override
    public void removeCar(String ownerId, String carId) {
        if (!ownerRepo.exists(ownerId)) {
            throw new IllegalArgumentException("No owner for id" + ownerId);
        }

        carRepo.delete(carId);
    }

    @Override
    public AddPaymentResponse addPayment(String ownerId, AddPaymentRequest request) {
        if(!ownerRepo.exists(ownerId)) {
            throw new IllegalArgumentException("No owner for id" + ownerId);
        }
        final var  payment = new Payment();
        payment.setTitle(request.title());
        payment.setDebt(request.debt());
        payment.setDetails(request.details());
        payment.setOwnerId(ownerId);

        final var inserted = paymentRepo.insert(payment);
        return new AddPaymentResponse(inserted.getId());
    }

    @Override
    public void removePayment(String ownerId,String paymentId) {
        if (!ownerRepo.exists(ownerId)) {
            throw new IllegalArgumentException("No owner for id" + ownerId);
        }

        paymentRepo.delete(paymentId);

    }

    @Override
    public CreateDealershipResponse createDealership(String ownerId, CreateRequestDealership request) {
        if(!ownerRepo.exists(ownerId)) {
            throw new IllegalArgumentException("No owner for id" + ownerId);
        }
        final var dealership = new Dealership();
        dealership.setName(request.name());
        dealership.setCity(request.city());
        dealership.setAddress(request.address());
        dealership.setOwnerId(ownerId);

        final var inserted = dealershipRepo.insert(dealership);
        return new CreateDealershipResponse(inserted.getId());
    }

    @Override
    public void removeDealership(String ownerId, String dealershipId) {
        if (!ownerRepo.exists(ownerId)) {
            throw new IllegalArgumentException("No owner for id" + ownerId);
        }

        dealershipRepo.delete(dealershipId);
    }


}

