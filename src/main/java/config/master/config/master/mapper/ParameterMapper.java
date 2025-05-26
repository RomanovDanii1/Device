package config.master.config.master.mapper;

import org.mapstruct.Mapper;

import config.master.config.master.dto.parameter.ParameterDto;
import config.master.config.master.model.Parameter;

@Mapper(componentModel = "spring")
public interface ParameterMapper {
    ParameterDto toDto(Parameter parameter);
    Parameter toEntity(ParameterDto parameterDto);
    
}
