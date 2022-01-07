package com.meli.myproperty.modules.room.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RoomInput {
    private String name;
    private Double width;
    private Double length;
}
