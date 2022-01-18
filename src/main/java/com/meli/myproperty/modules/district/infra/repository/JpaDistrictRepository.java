package com.meli.myproperty.modules.district.infra.repository;

import com.meli.myproperty.modules.district.domain.District;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaDistrictRepository extends JpaRepository<District, Long> {
}
