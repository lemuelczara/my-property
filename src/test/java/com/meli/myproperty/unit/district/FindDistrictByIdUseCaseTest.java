package com.meli.myproperty.unit.district;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.spy;

import com.meli.myproperty.modules.district.infra.repository.DistrictRepository;
import com.meli.myproperty.modules.district.usecases.FindDistrictById.FindDistrictByIdUseCase;
import com.meli.myproperty.unit.district.mocks.DistrictRepositorySpy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FindDistrictByIdUseCaseTest {
    private DistrictRepository districtRepository;
    private FindDistrictByIdUseCase sut;

    @BeforeEach()
    public void setup() {
        districtRepository = createDistrictRepository();
        sut = new FindDistrictByIdUseCase(districtRepository);
    }

    @Test()
    public void shouldBeThrowIfRepositoryThrows() {
        doAnswer(answer -> new Exception()).when(districtRepository).findById(anyString());

        assertThrows(Exception.class, () -> sut.execute("validId"));
    }

    private DistrictRepository createDistrictRepository() {
        DistrictRepositorySpy mock = spy(DistrictRepositorySpy.class);

        return mock;
    }
}
