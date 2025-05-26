package config.master.config.master.repository;

import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import config.master.config.master.model.Network;

@Repository
public interface NetworkRepository extends JpaRepository<Network, Long> {
    Network findByRoomId(Long roomId);
}
