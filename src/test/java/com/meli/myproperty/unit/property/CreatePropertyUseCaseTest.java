package com.meli.myproperty.unit.property;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.spy;

import com.meli.myproperty.modules.district.infra.repository.DistrictRepository;
import com.meli.myproperty.modules.property.domain.Property;
import com.meli.myproperty.modules.property.dto.PropertyOutput;
import com.meli.myproperty.modules.property.infra.repository.PropertyRepository;
import com.meli.myproperty.modules.property.usecases.CreateProperty.CreatePropertyUseCase;
import com.meli.myproperty.shared.exception.NotFoundElementException;
import com.meli.myproperty.unit.district.mocks.DistrictRepositorySpy;
import com.meli.myproperty.unit.district.mocks.MockProperty;
import com.meli.myproperty.unit.district.mocks.PropertyRepositorySpy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

public class CreatePropertyUseCaseTest {
    private PropertyRepository propertyRepository;
    private DistrictRepository districtRepository;
    private CreatePropertyUseCase sut;

    @BeforeEach()
    public void setup() {
        propertyRepository = createPropertyRepository();
        districtRepository = creatDistrictRepository();
        sut = new CreatePropertyUseCase(propertyRepository, districtRepository);
    }

    @Test
    public void shouldBeThrowIfDistrictRepositoryThrows() {
        doThrow(RuntimeException.class).when(districtRepository).findById(anyString());

        assertThrows(RuntimeException.class, () -> sut.execute(MockProperty.mockPropertyParams()));
    }

    @Test
    public void shouldBeThrowIfPropertyRepositoryThrows() {
        doThrow(RuntimeException.class).when(propertyRepository).save(any());

        assertThrows(RuntimeException.class, () -> sut.execute(MockProperty.mockPropertyParams()));
    }

    @Test
    public void shouldBeThrowIfDistrictRepositoryReturnsNull() {
        doReturn(null).when(districtRepository).findById(anyString());

        NotFoundElementException exception = assertThrows(NotFoundElementException.class, () -> sut.execute(MockProperty.mockPropertyParams()));

        assertEquals(exception.getClass(), NotFoundElementException.class);
        assertEquals(exception.getMessage(), "District not found!");
    }

    @Test
    public void shouldBeCallDistrictRepositoryWithCorrectValues() {
        ArgumentCaptor<String> arg0 = ArgumentCaptor.forClass(String.class);

        doCallRealMethod().when(districtRepository).findById(arg0.capture());

        sut.execute(MockProperty.mockPropertyParams());

        assertEquals(arg0.getValue(), DistrictRepositorySpy.findByIdParams);
    }

    @Test
    public void shouldBeCallPropertyRepositoryWithCorrectValues() {
        ArgumentCaptor<Property> arg0 = ArgumentCaptor.forClass(Property.class);

        doCallRealMethod().when(propertyRepository).save(arg0.capture());

        sut.execute(MockProperty.mockPropertyParams());

        assertEquals(arg0.getValue(), PropertyRepositorySpy.saveParams);
    }

    @Test
    public void shouldBeCreateProperty() {
        PropertyOutput output = sut.execute(MockProperty.mockPropertyParams());

        System.out.println(output.toString());
        assertNotNull(output);
    }

    private PropertyRepository createPropertyRepository() {
        PropertyRepositorySpy propertyRepositorySpy = spy(PropertyRepositorySpy.class);

        return propertyRepositorySpy;
    }

    private DistrictRepository creatDistrictRepository() {
        DistrictRepositorySpy districtRepositorySpy = spy(DistrictRepositorySpy.class);

        return districtRepositorySpy;
    }
}
