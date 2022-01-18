package com.meli.myproperty.modules.district.infra.repository.mysql;

import javax.inject.Named;

import com.meli.myproperty.modules.district.domain.District;
import com.meli.myproperty.modules.district.infra.repository.DistrictRepository;
import com.meli.myproperty.modules.district.infra.repository.JpaDistrictRepository;

import org.springframework.beans.factory.annotation.Autowired;

@Named(value = "MySqlDistrictRepository")
public class MySQLDistrictRepository implements DistrictRepository {

    @Autowired
    private JpaDistrictRepository repository;

    @Override
    public void save(District district) {
        repository.save(district);
    }

    @Override
    public District findById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
