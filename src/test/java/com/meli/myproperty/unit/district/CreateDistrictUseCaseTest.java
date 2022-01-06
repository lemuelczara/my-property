package com.meli.myproperty.unit.district;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import com.meli.myproperty.modules.district.dto.DistrictInput;
import com.meli.myproperty.modules.district.dto.DistrictOutput;
import com.meli.myproperty.modules.district.repository.DistrictRepository;
import com.meli.myproperty.modules.district.repository.memory.DistrictRepositoryInMemory;
import com.meli.myproperty.modules.district.usecases.CreateDistrict.CreateDistrictUseCase;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CreateDistrictUseCaseTest {
    private CreateDistrictUseCase useCase;
    private DistrictRepository repository;

    public DistrictInput makeFakeDistrictInput() {
        return new DistrictInput("Central das Américas", BigDecimal.valueOf(20.0));
    }

    @BeforeEach
    public void beforeEach() {
        repository = new DistrictRepositoryInMemory();
        useCase = new CreateDistrictUseCase(repository);
    }
    
    @Test
    public void shouldBeCreateDistrict() {
        DistrictOutput output = useCase.execute(makeFakeDistrictInput());

        assertEquals(output.getName(), "Central das Américas");
    }
}
