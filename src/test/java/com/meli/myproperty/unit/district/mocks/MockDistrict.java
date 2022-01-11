package com.meli.myproperty.unit.district.mocks;

import java.math.BigDecimal;

import com.meli.myproperty.modules.district.domain.District;
import com.meli.myproperty.modules.district.dto.DistrictInput;

public class MockDistrict {
    public static District mockDistrictModel() {
        return new District("validId", "validName", BigDecimal.valueOf(1));
    }

    public static DistrictInput mockDistrictParams() {
        return new DistrictInput("Lemuel Coelho Zara", BigDecimal.valueOf(2.67));
    }
}
