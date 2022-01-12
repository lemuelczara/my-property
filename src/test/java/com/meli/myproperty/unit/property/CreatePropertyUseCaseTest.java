package com.meli.myproperty.unit.property;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.spy;

import com.meli.myproperty.modules.district.infra.repository.DistrictRepository;
import com.meli.myproperty.modules.property.infra.repository.PropertyRepository;
import com.meli.myproperty.modules.property.usecases.CreateProperty.CreatePropertyUseCase;
import com.meli.myproperty.unit.district.mocks.DistrictRepositorySpy;
import com.meli.myproperty.unit.district.mocks.MockProperty;
import com.meli.myproperty.unit.district.mocks.PropertyRepositorySpy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        doAnswer(answer -> new Exception()).when(districtRepository).findById(anyString());

        assertThrows(Exception.class, () -> sut.execute(MockProperty.mockPropertyParams()));
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
