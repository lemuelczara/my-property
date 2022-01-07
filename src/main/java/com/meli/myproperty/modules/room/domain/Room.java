package com.meli.myproperty.modules.room.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    private String name;
    private Double width;
    private Double length;
}
