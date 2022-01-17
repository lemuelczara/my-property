package com.meli.myproperty.unit.district;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.meli.myproperty.mocks.DistrictRepositorySpy;
import com.meli.myproperty.mocks.MockDistrict;
import com.meli.myproperty.modules.district.domain.District;
import com.meli.myproperty.modules.district.dto.DistrictOutput;
import com.meli.myproperty.modules.district.infra.repository.DistrictRepository;
import com.meli.myproperty.modules.district.usecases.CreateDistrict.CreateDistrictUseCase;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.ArgumentCaptor;

public class CreateDistrictUseCaseTest {
    private DistrictRepository districtRepository;
    private CreateDistrictUseCase sut;

    @BeforeEach()
    public void setup() {
        districtRepository = creatDistrictRepository();
        sut = new CreateDistrictUseCase(districtRepository);
    }

    @Test
    public void shouldBeCallsRepositoryWithCorrectValues() {
        ArgumentCaptor<District> arg0 = ArgumentCaptor.forClass(District.class);

        doNothing().when(districtRepository).save(arg0.capture());

        sut.execute(MockDistrict.mockDistrictParams());

        assertEquals(arg0.getValue().getName(), MockDistrict.mockDistrictParams().getName());
    }

    @Test
    public void shouldBeThrowIfRepositoryThrows() {
        doThrow(RuntimeException.class).when(districtRepository).save(any());

        assertThrows(RuntimeException.class, () -> {
            sut.execute(MockDistrict.mockDistrictParams());
        });
    }

    @Test
    public void shouldBeCreateDistrict() {
        DistrictOutput output = sut.execute(MockDistrict.mockDistrictParams());

        assertNotNull(output);
        assertEquals(output.getName(), MockDistrict.mockDistrictParams().getName());
    }

    private DistrictRepository creatDistrictRepository() {
        DistrictRepositorySpy mock = spy(DistrictRepositorySpy.class);

        return mock;
    }
}
