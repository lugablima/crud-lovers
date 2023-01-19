package com.crudlover.api.dto;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
// import jakarta.validation.constraints.Pattern;

public record CarDTO(

    @NotBlank String model,

    @NotBlank String manufacturer,

    @Past Date manufacturingDate,

    @NotNull double price,

    @NotNull int modelYear) {
    
}
