package com.meli.myproperty.modules.district.infra.repository;

import com.meli.myproperty.modules.district.domain.District;

public interface DistrictRepository {
    void save(District district);
    
    District findById(Long id);
}
