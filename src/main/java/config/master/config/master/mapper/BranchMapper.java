package config.master.config.master.mapper;

import config.master.config.master.dto.branch.BranchDto;
import config.master.config.master.model.Branch;
import config.master.config.master.model.Company;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {RoomMapper.class})
public interface BranchMapper {
    // Entity → DTO: company.id → companyId
    @Mapping(source = "company.id", target = "companyId")
    BranchDto toDto(Branch branch);

    // DTO → Entity: companyId → Company stub
    @Mapping(source = "companyId", target = "company")
    Branch toEntity(BranchDto dto);

    // MapStruct подхватит этот метод, чтобы из Long сделать Company
    default Company map(Long companyId) {
        if (companyId == null) {
            return null;
        }
        Company c = new Company();
        c.setId(companyId);
        return c;
    }
}
