package com.meli.myproperty.mocks;

import java.math.BigDecimal;

import com.meli.myproperty.modules.district.dto.DistrictInput;

public class MockDistrict {
    public static DistrictInput mockDistrictParams() {
        return new DistrictInput("validDistrictName", BigDecimal.valueOf(1));
    }
}
