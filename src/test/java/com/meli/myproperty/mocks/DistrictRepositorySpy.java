package com.meli.myproperty.mocks;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;

import com.meli.myproperty.modules.district.domain.District;
import com.meli.myproperty.modules.district.infra.repository.DistrictRepository;

public class DistrictRepositorySpy implements DistrictRepository {
    public static Object findByIdParams;
    public static District findByIdResult = new District(1L, "validName", BigDecimal.valueOf(1), Date.from(Instant.now()));

    @Override
    public void save(District district) {
    }

    @Override
    public District findById(Long id) {
        DistrictRepositorySpy.findByIdParams = id;
        
        return findByIdResult;
    }
}
