package config.master.config.master.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import config.master.config.master.model.Equipment;

import config.master.config.master.repository.EquipmentRepository;
import config.master.config.master.service.EquipmentService;

@Service
public class EquipmentServiceImpl implements EquipmentService {
    private final EquipmentRepository repository;

    @Autowired
    public EquipmentServiceImpl(EquipmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Equipment> findAll() {
        return repository.findAll();
    }

    @Override
    public Equipment findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipment not found: " + id));
    }

    @Override
    public Equipment save(Equipment equipment) {
        return repository.save(equipment);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Equipment> findAllByRoomId(Long roomId) {
        return repository.findAllByRoomId(roomId);
    }
    
}
