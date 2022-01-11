package com.meli.myproperty.unit.district.mocks;

import java.math.BigDecimal;

import com.meli.myproperty.modules.district.domain.District;
import com.meli.myproperty.modules.district.infra.repository.DistrictRepository;

public class DistrictRepositorySpy implements DistrictRepository {
    private District findByIdResult = new District("validId", "validName", BigDecimal.valueOf(1));

    @Override
    public void save(District district) {
    }

    @Override
    public District findById(String id) {
        return findByIdResult;
    }
}
