package config.master.config.master.mapper;

import config.master.config.master.dto.room.RoomDto;
import config.master.config.master.model.Branch;
import config.master.config.master.model.Room;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {EquipmentMapper.class})
public interface RoomMapper {
    @Mapping(source = "branch.id", target = "branchId")
    RoomDto toDto(Room room);

    @Mapping(source = "branchId", target = "branch")
    Room toEntity(RoomDto room);

    default Branch map(Long BranchId) {
        if (BranchId == null) {
            return null;
        }
        Branch b = new Branch();
        b.setId(BranchId);
        return b;
    }
}