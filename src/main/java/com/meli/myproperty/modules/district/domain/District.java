package com.meli.myproperty.modules.district.domain;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class District {
    private String id;
    private String name;
    private BigDecimal priceSquareMeter;
}
