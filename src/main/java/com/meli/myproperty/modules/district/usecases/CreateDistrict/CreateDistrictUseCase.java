package com.meli.myproperty.modules.district.usecases.CreateDistrict;

import javax.inject.Named;

import com.meli.myproperty.modules.district.domain.District;
import com.meli.myproperty.modules.district.dto.DistrictInput;
import com.meli.myproperty.modules.district.dto.DistrictOutput;
import com.meli.myproperty.modules.district.infra.repository.DistrictRepository;

import org.springframework.stereotype.Service;

@Service
public class CreateDistrictUseCase {
    private DistrictRepository districtRepository;

    public CreateDistrictUseCase(@Named(value = "MySqlDistrictRepository") DistrictRepository districtRepository) {
        this.districtRepository = districtRepository;
    }

    public DistrictOutput execute(DistrictInput input) {
        District district = new District();
        district.setName(input.getName());
        district.setSquareMeterPrice(input.getSquareMeterPrice());

        this.districtRepository.save(district);

        DistrictOutput output = new DistrictOutput(district.getId(), district.getName());

        return output;
    }
}
