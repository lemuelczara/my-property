package com.meli.myproperty.unit.district.mocks;

import com.meli.myproperty.modules.property.domain.Property;
import com.meli.myproperty.modules.property.infra.repository.PropertyRepository;

public class PropertyRepositorySpy implements PropertyRepository {

    @Override
    public void save(Property property) {
    }
}
