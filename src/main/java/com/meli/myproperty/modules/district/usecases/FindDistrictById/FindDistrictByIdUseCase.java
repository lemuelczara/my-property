package com.meli.myproperty.modules.district.usecases.FindDistrictById;

import com.meli.myproperty.modules.district.domain.District;
import com.meli.myproperty.modules.district.infra.repository.DistrictRepository;

public class FindDistrictByIdUseCase {
    private DistrictRepository districtRepository;

    public FindDistrictByIdUseCase(DistrictRepository districtRepository) {
        this.districtRepository = districtRepository;
    }

    public District execute(String id) {
        return this.districtRepository.findById(id);
    }
}
