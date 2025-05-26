package config.master.config.master.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import config.master.config.master.dto.branch.BranchDto;
import config.master.config.master.model.Branch;
import config.master.config.master.model.Company;

@Mapper(componentModel = "spring", uses = {RoomMapper.class})
public interface BranchMapper {
    @Mapping(source = "company.id", target = "companyId")
    BranchDto toDto(Branch branch);

    @Mapping(source = "companyId", target = "company")
    Branch toEntity(BranchDto branchDto);

    default Company map(Long companyId) {
        if (companyId == null) {
            return null;
        }
        Company c = new Company();
        c.setId(companyId);
        return c;
    }
}
