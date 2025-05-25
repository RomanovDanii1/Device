package config.master.config.master.dto.company;

import config.master.config.master.dto.branch.BranchDto;

import java.util.ArrayList;
import java.util.List;

public class CompanyDto {
    private Long id;
    private String name;
    private List<BranchDto> branches = new ArrayList<>();

    public CompanyDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BranchDto> getBranches() {
        return branches;
    }

    public void setBranches(List<BranchDto> branches) {
        this.branches = branches;
    }
}
