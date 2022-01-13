package ro.carro.main.dto.payments;

import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

public record AddPaymentRequest(
        @NotBlank String title,
        @NotBlank
        @NumberFormat
         int debt,
        String details) {
}
