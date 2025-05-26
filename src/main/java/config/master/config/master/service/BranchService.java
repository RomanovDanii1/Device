package config.master.config.master.service;

import java.util.List;
import config.master.config.master.model.Branch;

public interface BranchService {
    List<Branch> findAll();
    List<Branch> findAllByCompanyId(Long companyId);
    Branch findById(Long id);
    Branch save(Branch branch);
    void deleteById(Long id);
    
}
