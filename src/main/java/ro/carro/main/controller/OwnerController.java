package ro.carro.main.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.carro.main.dto.cars.AddCarRequest;
import ro.carro.main.dto.cars.AddCarRessponse;
import ro.carro.main.dto.cars.CarCollection;
import ro.carro.main.dto.dealerships.CreateDealershipResponse;
import ro.carro.main.dto.dealerships.CreateRequestDealership;
import ro.carro.main.dto.owners.AddOwnerRequest;
import ro.carro.main.dto.owners.AddOwnerResponse;
import ro.carro.main.dto.owners.OwnerCollection;
import ro.carro.main.dto.payments.AddPaymentRequest;
import ro.carro.main.dto.payments.AddPaymentResponse;
import ro.carro.main.service.OwnerService;

@RequestMapping("/owners")
@RestController
@Api(value = "/owners",
    tags = "Owners")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @PostMapping
    @ApiOperation(value = "Create an Owner",
                    notes = "Creates a new Owner based on the information received in the request")
    public AddOwnerResponse addOwner(@RequestBody AddOwnerRequest request) {
        return ownerService.addOwner(request);
    }


    @ApiOperation(value = "Return owner",
            notes = "Return owner by id ")
    @GetMapping("/{ownerId}")
    public ResponseEntity<OwnerCollection>  ownerCollection(@PathVariable("ownerId") String ownerId) {
        return ResponseEntity.of(ownerService.readOwner(ownerId));
    }


    @ApiOperation(value = "Create a car",
            notes = "Create a car for ownerId ")
    @PostMapping("/{ownerId}/cars")
    public AddCarRessponse addCar(@PathVariable("ownerId") String ownerId, @RequestBody AddCarRequest request){
        return ownerService.addCar(ownerId, request);
    }
    @ApiOperation(value = "Delete a car",
            notes = "Delete a car for ownerId ")
    @DeleteMapping("/{ownerId}/cars/{carId}")
    public void removeCar(@PathVariable("ownerId") String ownerId,@PathVariable("carId") String carId){
        ownerService.removeCar(ownerId, carId);
    }
    @ApiOperation(value = "Create a payment",
            notes = "Create a payment for ownerId ")
    @PostMapping("/{ownerId}/payments")
    public AddPaymentResponse addPayment(@PathVariable("ownerId") String ownerId, @RequestBody AddPaymentRequest request){
        return ownerService.addPayment(ownerId, request);
    }

    @ApiOperation(value = "Delete a paymnet",
            notes = "Delete a payment for ownerId ")
    @DeleteMapping("/{ownerId}/payments/{paymentId}")
    public void removePayment(@PathVariable("ownerId") String ownerId,@PathVariable("paymentId") String paymentId){
        ownerService.removePayment(ownerId, paymentId);
    }

    @ApiOperation(value = "Create a dealership",
            notes = "Create a dealership for ownerId ")
    @PostMapping("/{ownerId}/dealerships")
    public CreateDealershipResponse createDealership(@PathVariable("ownerId") String ownerId, @RequestBody CreateRequestDealership request){
        return ownerService.createDealership(ownerId, request);
    }

    @ApiOperation(value = "Delete a dealership",
           notes = "Delete a dealership for ownerId ")
    @DeleteMapping("/{ownerId}/dealerships/{dealershipId}")
    public void removeDealership(@PathVariable("ownerId") String ownerId,@PathVariable("dealershipId") String dealershipId){
        ownerService.removeDealership(ownerId, dealershipId);
    }
}
