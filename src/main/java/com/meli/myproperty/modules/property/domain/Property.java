package com.meli.myproperty.modules.property.domain;

import java.util.List;

import com.meli.myproperty.modules.district.domain.District;
import com.meli.myproperty.modules.room.domain.Room;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Property {
    private String id;
    private String name;
    private District district;
    private List<Room> rooms;
}
