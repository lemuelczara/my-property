package com.meli.myproperty.unit.district;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.meli.myproperty.modules.district.dto.DistrictOutput;
import com.meli.myproperty.modules.district.infra.repository.DistrictRepository;
import com.meli.myproperty.modules.district.usecases.CreateDistrict.CreateDistrictUseCase;
import com.meli.myproperty.unit.district.mocks.DistrictRepositorySpy;
import com.meli.myproperty.unit.district.mocks.MockDistrict;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CreateDistrictUseCaseTest {
    private DistrictRepository districtRepository;
    private CreateDistrictUseCase sut;

    @BeforeEach()
    public void setup() {
        districtRepository = creatDistrictRepository();
        sut = new CreateDistrictUseCase(districtRepository);
    }

    @Test
    public void shouldBeCreateDistrict() {
        DistrictOutput output = sut.execute(MockDistrict.mockDistrictParams());

        assertEquals(output.getName(), "validName");
    }

    private DistrictRepository creatDistrictRepository() {
        DistrictRepositorySpy mock = mock(DistrictRepositorySpy.class);

        return mock;
    }
}
