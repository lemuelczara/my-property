package com.meli.myproperty.modules.district.infra.repository.memory;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import com.meli.myproperty.modules.district.domain.District;
import com.meli.myproperty.modules.district.infra.repository.DistrictRepository;

@Named(value = "districtRepositoryInMemory")
public class DistrictRepositoryInMemory implements DistrictRepository {
    private List<District> districts = new ArrayList<>();

    @Override
    public void save(District district) {
        this.districts.add(district);
    }

    @Override
    public District findById(String id) {
        return this.districts.stream().filter(d -> d.getId().equalsIgnoreCase(id)).findFirst().orElse(null);
    }    
}
