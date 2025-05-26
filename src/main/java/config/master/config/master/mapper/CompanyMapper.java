package config.master.config.master.mapper;

import org.mapstruct.Mapper;

import config.master.config.master.dto.company.CompanyDto;
import config.master.config.master.model.Company;


@Mapper(componentModel = "spring", uses = {BranchMapper.class})
public interface CompanyMapper {
    CompanyDto toDto(Company company);
    
    Company toEntity(CompanyDto companyDto);

}