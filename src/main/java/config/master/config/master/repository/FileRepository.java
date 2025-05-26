package config.master.config.master.repository;

import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import config.master.config.master.model.FileEntity;

@Repository
public interface FileRepository extends JpaRepository<FileEntity, Long> {
    FileEntity findAllByRoomId(Long roomId);
    
}
