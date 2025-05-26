package config.master.config.master.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import config.master.config.master.dto.file.FileDto;
import config.master.config.master.model.FileEntity;
import config.master.config.master.model.Room;

@Mapper(componentModel = "spring")
public interface FileMapper {
    @Mapping(source = "room.id", target = "roomId")
    FileDto toDto(FileEntity file);

    @Mapping(source = "roomId", target = "room")
    FileEntity toEntity(FileDto FileDto);
    
    default Room map(Long roomId) {
        if (roomId == null) {
            return null;
        }
        Room r = new Room();
        r.setId(roomId);
        return r;
    }
}
