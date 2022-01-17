package com.meli.myproperty.modules.district.usecases.FindDistrictById;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/districts")
public class FindDistrictByIdController {
    private FindDistrictByIdUseCase findDistrictByIdUseCase;

    public FindDistrictByIdController(FindDistrictByIdUseCase findDistrictByIdUseCase) {
        this.findDistrictByIdUseCase = findDistrictByIdUseCase;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Object> findById(@PathVariable String id) {
        return new ResponseEntity<>(findDistrictByIdUseCase.execute(id), HttpStatus.OK);
    }
}
