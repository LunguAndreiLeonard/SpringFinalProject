package ro.carro.main.dto.dealerships;

import javax.validation.constraints.NotBlank;

public record CreateRequestDealership(
        @NotBlank String name,
        @NotBlank String city, String address) {
}
