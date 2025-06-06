package config.master.config.master.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import config.master.config.master.dto.equipment.EquipmentDto;
import config.master.config.master.model.Equipment;
import config.master.config.master.model.Room;


@Mapper(componentModel = "spring")
public interface EquipmentMapper {

    @Mapping(source = "room.id",             target = "roomId")
    @Mapping(source = "nameValue",          target = "name.value")
    @Mapping(source = "nameStatus",         target = "name.status")
    @Mapping(source = "descriptionValue",   target = "description.value")
    @Mapping(source = "descriptionStatus",  target = "description.status")
    @Mapping(source = "ipValue",            target = "ip.value")
    @Mapping(source = "ipStatus",           target = "ip.status")
    EquipmentDto toDto(Equipment equipment);

    @Mapping(source = "roomId",              target = "room")
    @Mapping(source = "name.value",          target = "nameValue")
    @Mapping(source = "name.status",         target = "nameStatus")
    @Mapping(source = "description.value",   target = "descriptionValue")
    @Mapping(source = "description.status",  target = "descriptionStatus")
    @Mapping(source = "ip.value",            target = "ipValue")
    @Mapping(source = "ip.status",           target = "ipStatus")
    Equipment toEntity(EquipmentDto equipmentDto);


    default Room map(Long roomId) {
        if (roomId == null) {
            return null;
        }
        Room r = new Room();
        r.setId(roomId);
        return r;
    }
}
