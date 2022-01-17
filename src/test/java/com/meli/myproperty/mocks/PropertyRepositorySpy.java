package com.meli.myproperty.mocks;

import com.meli.myproperty.modules.property.domain.Property;
import com.meli.myproperty.modules.property.infra.repository.PropertyRepository;

public class PropertyRepositorySpy implements PropertyRepository {
    public static Object saveParams;

    @Override
    public void save(Property property) {
        PropertyRepositorySpy.saveParams = property;
    }
}
