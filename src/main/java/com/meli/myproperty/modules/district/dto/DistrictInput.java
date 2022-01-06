package com.meli.myproperty.modules.district.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DistrictInput {
    private String name;
    private BigDecimal squareMeterPrice;
}
