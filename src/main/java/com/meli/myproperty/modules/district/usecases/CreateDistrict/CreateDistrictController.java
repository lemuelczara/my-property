package com.meli.myproperty.modules.district.usecases.CreateDistrict;

import javax.validation.Valid;

import com.meli.myproperty.modules.district.dto.DistrictInput;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/districts")
public class CreateDistrictController {
    private CreateDistrictUseCase createDistrictUseCase;

    public CreateDistrictController(CreateDistrictUseCase createDistrictUseCase) {
        this.createDistrictUseCase = createDistrictUseCase;
    }
    
    @PostMapping
    public ResponseEntity<Object> save(@Valid @RequestBody DistrictInput districtInput) {
        return new ResponseEntity<>(createDistrictUseCase.execute(districtInput), HttpStatus.CREATED);
    }
}
