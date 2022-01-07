package com.meli.myproperty.modules.property.dto;

import java.util.List;

import com.meli.myproperty.modules.room.dto.RoomInput;

public class PropertyInput {
    private String name;

    private String districtId;
    private List<RoomInput> roomsInput;

    public PropertyInput(String name, String districtId, List<RoomInput> roomsInput) {
        this.name = name;
        this.districtId = districtId;
        this.roomsInput = roomsInput;
    }

    public String getName() {
        return name;
    }

    public String getDistrictId() {
        return districtId;
    }

    public List<RoomInput> getRoomsInput() {
        return roomsInput;
    }
}
