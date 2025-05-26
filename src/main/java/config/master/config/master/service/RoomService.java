package config.master.config.master.service;

import java.util.List;

import config.master.config.master.model.Room;

public interface RoomService {
    List<Room> findAll();
    Room findById(Long id);
    Room save(Room room);
    void deleteById(Long id);
    List<Room> findAllByBranchId(Long branchId);
    
}
