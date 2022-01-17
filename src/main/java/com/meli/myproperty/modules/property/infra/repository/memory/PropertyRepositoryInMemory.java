package com.meli.myproperty.modules.property.infra.repository.memory;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import com.meli.myproperty.modules.property.domain.Property;
import com.meli.myproperty.modules.property.infra.repository.PropertyRepository;

@Named(value = "propertyRepositoryInMemory")
public class PropertyRepositoryInMemory implements PropertyRepository {
    private List<Property> properties = new ArrayList<>();

    @Override
    public void save(Property property) {
        this.properties.add(property);
    }   
}
