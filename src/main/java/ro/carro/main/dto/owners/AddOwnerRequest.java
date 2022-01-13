package ro.carro.main.dto.owners;


import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotBlank;

public record AddOwnerRequest(
        @NotBlank String name,
        @NumberFormat String phone) {



}
