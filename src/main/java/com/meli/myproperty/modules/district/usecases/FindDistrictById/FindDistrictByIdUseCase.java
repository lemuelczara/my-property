package com.meli.myproperty.modules.district.usecases.FindDistrictById;

import java.util.NoSuchElementException;

import com.meli.myproperty.modules.district.domain.District;
import com.meli.myproperty.modules.district.infra.repository.DistrictRepository;

public class FindDistrictByIdUseCase {
    private DistrictRepository districtRepository;

    public FindDistrictByIdUseCase(DistrictRepository districtRepository) {
        this.districtRepository = districtRepository;
    }

    public District execute(String id) {
        District district = this.districtRepository.findById(id);

        if (district == null) {
            throw new NoSuchElementException("District not found!");
        }

        return district;
    }
}
