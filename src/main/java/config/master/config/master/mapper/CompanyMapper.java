package config.master.config.master.mapper;

import config.master.config.master.dto.company.CompanyDto;
import config.master.config.master.model.Company;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring", uses = {BranchMapper.class})
public interface CompanyMapper {
    // Метод для преобразования Company в CompanyDto
    CompanyDto toDto(Company company);
    
    // Метод для преобразования CompanyDto в Company
    Company toEntity(CompanyDto companyDto);

}