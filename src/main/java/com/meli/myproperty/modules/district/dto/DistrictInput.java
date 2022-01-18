package com.meli.myproperty.modules.district.dto;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class DistrictInput {
    
    @NotNull(message = "O nome não pode ser nulo!")
    @NotEmpty(message = "O nome não pode estar vazio!")
    @Size(min = 1, max = 45, message = "O nome deve ter entre 1 e 45 caracteres!")
    private String name;

    @NotNull(message = "O preço do metro quadrado não pode ser nulo!")
    @DecimalMax(value = "50.0", message = "O preço do metro quadrado não pode ser maior que 50!")
    private BigDecimal squareMeterPrice;

    public DistrictInput(String name, BigDecimal squareMeterPrice) {
        this.name = name;
        this.squareMeterPrice = squareMeterPrice;
    }

    public String getName() {
        return this.name;
    }

    public BigDecimal getSquareMeterPrice() {
        return this.squareMeterPrice;
    }
}
