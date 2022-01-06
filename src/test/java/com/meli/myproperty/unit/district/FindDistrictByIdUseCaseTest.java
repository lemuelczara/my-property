package com.meli.myproperty.unit.district;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import com.meli.myproperty.modules.district.domain.District;
import com.meli.myproperty.modules.district.infra.repository.DistrictRepository;
import com.meli.myproperty.modules.district.usecases.FindDistrictById.FindDistrictByIdUseCase;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class FindDistrictByIdUseCaseTest {
    public FindDistrictByIdUseCase useCase;

    @Mock
    public DistrictRepository districtRepository;

    public District makeFakeDistrict() {
        return new District("1", "Central das Américas", BigDecimal.valueOf(20.0));
    }

    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.openMocks(this);

        useCase = new FindDistrictByIdUseCase(districtRepository);
    }

    @Test
    public void shouldBeFindDistricyById() {
        Mockito.when(districtRepository.findById("validId")).thenReturn(makeFakeDistrict());

        District district = useCase.execute("validId");

        assertEquals(district.getName(), "Central das Américas");
    }
}
