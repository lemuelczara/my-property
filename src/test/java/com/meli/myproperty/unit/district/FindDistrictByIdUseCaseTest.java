package com.meli.myproperty.unit.district;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.spy;

import com.meli.myproperty.mocks.DistrictRepositorySpy;
import com.meli.myproperty.modules.district.infra.repository.DistrictRepository;
import com.meli.myproperty.modules.district.usecases.FindDistrictById.FindDistrictByIdUseCase;
import com.meli.myproperty.shared.exception.BusinessException;
import com.meli.myproperty.shared.exception.NotFoundElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

public class FindDistrictByIdUseCaseTest {
    private DistrictRepository districtRepository;
    private FindDistrictByIdUseCase sut;
    private Long districtId;

    @BeforeEach()
    public void setup() {
        districtId = 1L;
        districtRepository = createDistrictRepository();
        sut = new FindDistrictByIdUseCase(districtRepository);
    }

    @Test()
    public void shouldBeThrowIfRepositoryThrows() {
        doThrow(BusinessException.class).when(districtRepository).findById(anyLong());

        assertThrows(BusinessException.class, () -> sut.execute(districtId));
    }

    @Test()
    public void shouldBeThrowIfRepositoryReturnsNull() {
        doReturn(null).when(districtRepository).findById(anyLong());

        NotFoundElementException exception = assertThrows(NotFoundElementException.class, () -> sut.execute(districtId));

        assertTrue(exception.getMessage().contains("District not found!"));
    }

    @Test()
    public void shouldBeCallRepositoryWithCorrectValues() {
        ArgumentCaptor<Long> arg0 = ArgumentCaptor.forClass(Long.class);

        doCallRealMethod().when(districtRepository).findById(arg0.capture());

        sut.execute(districtId);

        assertEquals(arg0.getValue(), districtId);
    }

    @Test()
    public void shouldBeReturnDistrict() {
        var districtResult = sut.execute(districtId);

        assertEquals(districtResult, DistrictRepositorySpy.findByIdResult);
    }

    private DistrictRepository createDistrictRepository() {
        DistrictRepositorySpy mock = spy(DistrictRepositorySpy.class);

        return mock;
    }
}
