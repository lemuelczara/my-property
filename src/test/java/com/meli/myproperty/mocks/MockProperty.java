package com.meli.myproperty.mocks;

import java.util.Arrays;

import com.meli.myproperty.modules.property.dto.PropertyInput;
import com.meli.myproperty.modules.room.dto.RoomInput;

public class MockProperty {
    public static PropertyInput mockPropertyParams() {
        return new PropertyInput("validName", "validDistrictId", Arrays.asList(new RoomInput("validName", 1.0, 1.0)));
    }
}
