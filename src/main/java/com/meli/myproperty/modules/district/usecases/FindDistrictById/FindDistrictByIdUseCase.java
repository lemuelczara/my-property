package com.meli.myproperty.modules.district.usecases.FindDistrictById;

import com.meli.myproperty.modules.district.domain.District;
import com.meli.myproperty.modules.district.infra.repository.DistrictRepository;
import com.meli.myproperty.shared.exception.NotFoundElementException;

public class FindDistrictByIdUseCase {
    private DistrictRepository districtRepository;

    public FindDistrictByIdUseCase(DistrictRepository districtRepository) {
        this.districtRepository = districtRepository;
    }

    public District execute(String id) {
        District district = this.districtRepository.findById(id);

        if (district == null) {
            throw new NotFoundElementException("District not found!");
        }

        return district;
    }
}
