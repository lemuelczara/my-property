package com.meli.myproperty.modules.room.dto;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RoomInput {
    @NotNull(message = "The name field cannot be null!")
    @NotEmpty(message = "The name field cannot be empty!")
    private String name;

    @NotNull(message = "The width field cannot be null!")
    @DecimalMax(value = "25.0", message = "The width field must be a maximum of 25m")
    private Double width;

    @NotNull(message = "The width field cannot be null!")
    @DecimalMax(value = "50.0", message = "The length field must be a maximum of 25m")
    private Double length;
}
