package config.master.config.master.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import config.master.config.master.model.Equipment;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
    public List<Equipment> findAllByRoomId(Long roomId);
    
}
