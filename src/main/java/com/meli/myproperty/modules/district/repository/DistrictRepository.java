package com.meli.myproperty.modules.district.repository;

import com.meli.myproperty.modules.district.domain.District;

public interface DistrictRepository {
    void save(District district);
    
    District findById(String id);
}
