package ro.carro.main.dto.dealerships;

import ro.carro.main.dto.cars.CarCollection;

import java.util.Collection;

public record ReadDealershipResponse(String name, String city, String address) {
}
