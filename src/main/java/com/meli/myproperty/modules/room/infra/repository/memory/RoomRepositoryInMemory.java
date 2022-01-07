package com.meli.myproperty.modules.room.infra.repository.memory;

import java.util.ArrayList;
import java.util.List;

import com.meli.myproperty.modules.room.domain.Room;
import com.meli.myproperty.modules.room.infra.repository.RoomRepository;

public class RoomRepositoryInMemory implements RoomRepository {
    private List<Room> rooms = new ArrayList<>();

    @Override
    public void save(Room room) {
        this.rooms.add(room);
    }
}
