package com.meli.myproperty.modules.district.usecases.CreateDistrict;

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
    
    @PostMapping(path = "")
    public ResponseEntity<Object> save(@RequestBody DistrictInput districtInput) {
        return new ResponseEntity<>(createDistrictUseCase.execute(districtInput), HttpStatus.CREATED);
    }
}
