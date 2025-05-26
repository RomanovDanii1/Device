package config.master.config.master.mapper;

import org.mapstruct.Mapper;

import config.master.config.master.dto.status.StatusDto;
import config.master.config.master.model.Status;

@Mapper(componentModel = "spring")
public interface StatusMapper {

    default StatusDto toDto(Status status) {
        if (status == null) {
            return StatusDto.NEED;
        }
        return StatusDto.valueOf(status.name());
    }

    default Status toEntity(StatusDto statusDto) {
        if (statusDto == null) {
            return Status.NEED;
        }
        return Status.fromString(statusDto.name());
    }
}
