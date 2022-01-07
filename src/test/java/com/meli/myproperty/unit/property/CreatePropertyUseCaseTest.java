package com.meli.myproperty.unit.property;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import com.meli.myproperty.modules.district.domain.District;
import com.meli.myproperty.modules.district.infra.repository.DistrictRepository;
import com.meli.myproperty.modules.property.domain.Property;
import com.meli.myproperty.modules.property.dto.PropertyInput;
import com.meli.myproperty.modules.property.dto.PropertyOutput;
import com.meli.myproperty.modules.property.infra.repository.PropertyRepository;
import com.meli.myproperty.modules.property.usecases.CreateProperty.CreatePropertyUseCase;
import com.meli.myproperty.modules.room.domain.Room;
import com.meli.myproperty.modules.room.dto.RoomInput;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class CreatePropertyUseCaseTest {
    @Mock
    private CreatePropertyUseCase useCase;

    @Mock
    private PropertyRepository propertyRepository;

    @Mock
    private DistrictRepository districtRepository;

    public PropertyInput makeFakePropertyData() {
        return new PropertyInput("validName", "1", Arrays.asList(new RoomInput("validRoomName", 2.0, 2.0)));
    }

    public Property makeFakeProperty() {
        return new Property("validId", "validName", new District(), Arrays.asList(new Room()));
    }

    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.openMocks(this);

        useCase = new CreatePropertyUseCase(propertyRepository, districtRepository);
    }

    @Test
    public void shouldBeCreateProperty() {
        PropertyOutput output = new PropertyOutput("validId", "validName");

        Mockito.doNothing().when(propertyRepository).save(makeFakeProperty());

        PropertyOutput createdProperty = useCase.execute(makeFakePropertyData());

        assertEquals(createdProperty.getId().getClass(), String.class);
        assertEquals(createdProperty.getName(), output.getName());
    }
}
