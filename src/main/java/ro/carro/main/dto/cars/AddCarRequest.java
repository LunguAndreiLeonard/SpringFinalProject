package ro.carro.main.dto.cars;

import ro.carro.main.model.Brand;

import javax.validation.constraints.NotBlank;

public record AddCarRequest(
        @NotBlank String name,
        @NotBlank Brand brand, String plate ) {
}
