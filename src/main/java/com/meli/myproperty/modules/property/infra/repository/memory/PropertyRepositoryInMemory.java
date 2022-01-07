package com.meli.myproperty.modules.property.infra.repository.memory;

import java.util.ArrayList;
import java.util.List;

import com.meli.myproperty.modules.property.domain.Property;
import com.meli.myproperty.modules.property.infra.repository.PropertyRepository;

public class PropertyRepositoryInMemory implements PropertyRepository {
    private List<Property> properties = new ArrayList<>();

    @Override
    public void save(Property property) {
        this.properties.add(property);
    }   
}
