package com.meli.myproperty.modules.district.usecases.CreateDistrict;

import java.util.UUID;

import com.meli.myproperty.modules.district.domain.District;
import com.meli.myproperty.modules.district.dto.DistrictInput;
import com.meli.myproperty.modules.district.dto.DistrictOutput;
import com.meli.myproperty.modules.district.infra.repository.DistrictRepository;

public class CreateDistrictUseCase {
    private DistrictRepository districtRepository;

    public CreateDistrictUseCase(DistrictRepository districtRepository) {
        this.districtRepository = districtRepository;
    }

    public DistrictOutput execute(DistrictInput input) {
        District district = new District(UUID.randomUUID().toString(), input.getName(), input.getSquareMeterPrice());
        
        this.districtRepository.save(district);

        DistrictOutput output = new DistrictOutput(district.getId(), district.getName());

        return output;
    }
}
