package com.meli.myproperty.unit.district;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import com.meli.myproperty.modules.district.infra.repository.DistrictRepository;
import com.meli.myproperty.modules.district.usecases.FindDistrictById.FindDistrictByIdUseCase;
import com.meli.myproperty.shared.exception.NotFoundElementException;
import com.meli.myproperty.unit.district.mocks.DistrictRepositorySpy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

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

    @Test()
    public void shouldBeThrowIfRepositoryReturnsNull() {
        doReturn(null).when(districtRepository).findById(anyString());

        NotFoundElementException exception = assertThrows(NotFoundElementException.class, () -> sut.execute("validId"));

        assertTrue(exception.getMessage().contains("District not found!"));
    }

    @Test()
    public void shouldBeCallRepositoryWithCorrectValues() {
        ArgumentCaptor<String> arg0 = ArgumentCaptor.forClass(String.class);

        doCallRealMethod().when(districtRepository).findById(arg0.capture());

        sut.execute("validId");

        assertEquals(arg0.getValue(), "validId");
    }

    private DistrictRepository createDistrictRepository() {
        DistrictRepositorySpy mock = spy(DistrictRepositorySpy.class);

        return mock;
    }
}
