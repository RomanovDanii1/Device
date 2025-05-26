package config.master.config.master.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import config.master.config.master.model.Room;
import config.master.config.master.repository.RoomRepository;
import config.master.config.master.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository repo;

    @Autowired
    public RoomServiceImpl(RoomRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Room> findAll() {
        return repo.findAll();
    }

    @Override
    public Room findById(Long id) {
        return repo.findById(id)
                   .orElseThrow(() -> new RuntimeException("Room not found: " + id));
    }

    @Override
    public Room save(Room room) {
        return repo.save(room);
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<Room> findAllByBranchId(Long branchId) {
        return repo.findAllByBranchId(branchId);
    }
    
}
