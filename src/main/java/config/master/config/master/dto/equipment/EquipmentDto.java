package config.master.config.master.dto.equipment;

import config.master.config.master.dto.parameter.ParameterDto;

public class EquipmentDto {
    private Long id;
    private ParameterDto name = new ParameterDto();
    private ParameterDto description = new ParameterDto();
    private ParameterDto ip = new ParameterDto();
    private Long roomId;

    public EquipmentDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ParameterDto getName() {
        return name;
    }

    public void setName(ParameterDto name) {
        this.name = name;
    }

    public ParameterDto getDescription() {
        return description;
    }

    public void setDescription(ParameterDto description) {
        this.description = description;
    }

    public ParameterDto getIp() {
        return ip;
    }

    public void setIp(ParameterDto ip) {
        this.ip = ip;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }
}
