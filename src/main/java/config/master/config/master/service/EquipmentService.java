package config.master.config.master.service;

import java.util.List;

import org.springframework.stereotype.Service;

import config.master.config.master.model.Equipment;

@Service
public interface EquipmentService {
    List<Equipment> findAll();
    Equipment findById(Long id);
    Equipment save(Equipment equipment);
    void deleteById(Long id);
    List<Equipment> findAllByRoomId(Long roomId);
    
}
