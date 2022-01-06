package com.meli.myproperty.modules.district.repository.memory;

import java.util.ArrayList;
import java.util.List;

import com.meli.myproperty.modules.district.domain.District;
import com.meli.myproperty.modules.district.repository.DistrictRepository;

public class DistrictRepositoryInMemory implements DistrictRepository {
    private List<District> districts = new ArrayList<>();

    @Override
    public void save(District district) {
        this.districts.add(district);
    }
}
