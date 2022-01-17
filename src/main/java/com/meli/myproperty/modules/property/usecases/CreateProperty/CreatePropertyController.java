package com.meli.myproperty.modules.property.usecases.CreateProperty;

import javax.validation.Valid;

import com.meli.myproperty.modules.property.dto.PropertyInput;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/properties")
public class CreatePropertyController {
    private CreatePropertyUseCase createPropertyUseCase;

    public CreatePropertyController(CreatePropertyUseCase createPropertyUseCase) {
        this.createPropertyUseCase = createPropertyUseCase;
    }

    @PostMapping
    public ResponseEntity<Object> save(@Valid @RequestBody PropertyInput propertyInput) {
        return new ResponseEntity<>(createPropertyUseCase.execute(propertyInput), HttpStatus.CREATED);
    }
}
