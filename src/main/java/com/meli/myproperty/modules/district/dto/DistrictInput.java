package com.meli.myproperty.modules.district.dto;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DistrictInput {
    
    @NotNull(message = "The name field cannot be null!")
    @NotEmpty(message = "The name field cannot be empty!")
    @Size(min = 1, max = 45, message = "The name field cannot be longer than 45 characters!")
    private String name;

    @NotNull(message = "The squareMeterPrice field cannot be null!")
    @DecimalMax(value = "13.0", message = "The squareMeterPrice field must have a maximum of 13 digits!")
    private BigDecimal squareMeterPrice;
}
