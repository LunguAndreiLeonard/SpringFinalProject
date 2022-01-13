package ro.carro.main.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.carro.main.dto.cars.AddCarRequest;
import ro.carro.main.dto.cars.AddCarRessponse;
import ro.carro.main.dto.dealerships.CreateDealershipResponse;
import ro.carro.main.dto.dealerships.CreateRequestDealership;
import ro.carro.main.dto.dealerships.ReadDealershipResponse;
import ro.carro.main.dto.owners.AddOwnerRequest;
import ro.carro.main.dto.owners.AddOwnerResponse;
import ro.carro.main.service.DealershipService;

@RequestMapping("/dealerships")
@RestController
public class DealershipController {

    private final DealershipService dealershipService;

    public DealershipController(DealershipService dealershipService){
        this.dealershipService = dealershipService;
    }


    @PostMapping
    public CreateDealershipResponse createDealership(@RequestBody CreateRequestDealership request) {
        return  dealershipService.addDealership(request);

    }
@GetMapping("/{dealershipId}")
public ResponseEntity<ReadDealershipResponse> readDealership(@PathVariable("dealershipId") String dealershipId) {
        return ResponseEntity.of(dealershipService.readDealership(dealershipId));
}

@PostMapping("/{dealershipId}/cars")
public AddCarRessponse addCar(@PathVariable("dealershipId") String dealershipId,@RequestBody AddCarRequest request) {
        return dealershipService.addCar(dealershipId, request);
}
@DeleteMapping("/{dealershipId}/cars/{carId}")
public void removeCar(@PathVariable("dealershipId") String dealershipId,@PathVariable("carId") String carId){
        dealershipService.removeCar(dealershipId, carId);
}

}
