package com.meli.myproperty.modules.district.usecases.CreateDistrict;

import java.util.UUID;

import javax.inject.Named;

import com.meli.myproperty.modules.district.domain.District;
import com.meli.myproperty.modules.district.dto.DistrictInput;
import com.meli.myproperty.modules.district.dto.DistrictOutput;
import com.meli.myproperty.modules.district.infra.repository.DistrictRepository;

import org.springframework.stereotype.Service;

@Service
public class CreateDistrictUseCase {
    private DistrictRepository districtRepository;

    public CreateDistrictUseCase(@Named(value = "districtRepositoryInMemory") DistrictRepository districtRepository) {
        this.districtRepository = districtRepository;
    }

    public DistrictOutput execute(DistrictInput input) {
        District district = new District(UUID.randomUUID().toString(), input.getName(), input.getSquareMeterPrice());

        this.districtRepository.save(district);

        DistrictOutput output = new DistrictOutput(district.getId(), district.getName());

        return output;
    }
}
