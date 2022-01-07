package com.meli.myproperty.modules.room.infra.repository;

import com.meli.myproperty.modules.room.domain.Room;

public interface RoomRepository {
    void save(Room room);
}
