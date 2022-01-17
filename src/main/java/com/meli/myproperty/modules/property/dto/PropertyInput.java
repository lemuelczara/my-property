package com.meli.myproperty.modules.property.dto;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.meli.myproperty.modules.room.dto.RoomInput;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PropertyInput {
    @NotNull(message = "The name field cannot be null!")
    @NotEmpty(message = "The name field cannot be empty!")
    private String name;

    @NotNull(message = "The districtId field cannot be null!")
    @NotEmpty(message = "The districtId field cannot be empty!")
    private String districtId;
    
    @Valid
    private List<RoomInput> roomsInput;
}
