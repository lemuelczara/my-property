package com.meli.myproperty.modules.property.usecases.CreateProperty;

import java.util.UUID;
import java.util.stream.Collectors;

import com.meli.myproperty.modules.district.domain.District;
import com.meli.myproperty.modules.district.infra.repository.DistrictRepository;
import com.meli.myproperty.modules.property.domain.Property;
import com.meli.myproperty.modules.property.dto.PropertyInput;
import com.meli.myproperty.modules.property.dto.PropertyOutput;
import com.meli.myproperty.modules.property.infra.repository.PropertyRepository;
import com.meli.myproperty.modules.room.domain.Room;
import com.meli.myproperty.shared.exception.NotFoundElementException;

public class CreatePropertyUseCase {
    private PropertyRepository propertyRepository;
    private DistrictRepository districtRepository;

    public CreatePropertyUseCase(PropertyRepository propertyRepository, DistrictRepository districtRepository) {
        this.propertyRepository = propertyRepository;
        this.districtRepository = districtRepository;
    }

    public PropertyOutput execute(PropertyInput input) {
        Property property = new Property();

        District district = this.districtRepository.findById(input.getDistrictId());

        if (district == null) {
            throw new NotFoundElementException("District not found!");
        }

        property.setId(UUID.randomUUID().toString());
        property.setName(input.getName());
        property.setDistrict(district);
        property.setRooms(input.getRoomsInput().stream().map(roomInput -> {
            return new Room(roomInput.getName(), roomInput.getLength(), roomInput.getWidth());
        }).collect(Collectors.toList()));

        this.propertyRepository.save(property);

        PropertyOutput output = new PropertyOutput(property.getId(), property.getName());

        return output;
    }
}
