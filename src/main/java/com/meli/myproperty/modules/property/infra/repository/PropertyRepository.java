package com.meli.myproperty.modules.property.infra.repository;

import com.meli.myproperty.modules.property.domain.Property;

public interface PropertyRepository {
    void save(Property property);
}
