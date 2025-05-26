package config.master.config.master.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import config.master.config.master.dto.room.RoomDto;
import config.master.config.master.model.Branch;
import config.master.config.master.model.Room;

@Mapper(componentModel = "spring", uses = {
    EquipmentMapper.class,
    NetworkMapper.class,
    FileMapper.class
})
public interface RoomMapper {
    @Mapping(source = "branch.id", target = "branchId")
    RoomDto toDto(Room room);

    @Mapping(source = "branchId", target = "branch")
    Room toEntity(RoomDto roomDto);

    default Branch map(Long BranchId) {
        if (BranchId == null) {
            return null;
        }
        Branch b = new Branch();
        b.setId(BranchId);
        return b;
    }
}