package ro.carro.main.dto.owners;

import ro.carro.main.dto.cars.CarCollection;
import ro.carro.main.dto.dealerships.ReadDealershipResponse;
import ro.carro.main.dto.payments.PaymentCollection;

import java.util.Collection;

public record OwnerCollection(String name, String phone, Collection<CarCollection> cars, Collection<PaymentCollection> payments, Collection<ReadDealershipResponse> dealerships) {
}
