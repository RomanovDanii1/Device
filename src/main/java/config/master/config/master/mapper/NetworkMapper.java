package config.master.config.master.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import config.master.config.master.dto.network.NetworkDto;
import config.master.config.master.model.Network;
import config.master.config.master.model.Room;

@Mapper(componentModel = "spring")
public interface NetworkMapper {
    @Mapping(source = "room.id", target = "roomId")
    NetworkDto toDto(Network network);

    @Mapping(source = "roomId", target = "room")
    Network toEntity(NetworkDto networkDto);

    default Room map(Long roomId) {
        if (roomId == null) {
            return null;
        }
        Room r = new Room();
        r.setId(roomId);
        return r;
    }
}
