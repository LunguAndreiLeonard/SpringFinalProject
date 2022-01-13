package ro.carro.main.dto.cars;

import ro.carro.main.dto.owners.OwnerCollection;
import ro.carro.main.model.Brand;

import java.util.Collection;

public record CarCollection(String name, Brand brand, String plate) {
}
