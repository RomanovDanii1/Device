package config.master.config.master.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import config.master.config.master.model.Branch;
import config.master.config.master.repository.BranchRepository;
import config.master.config.master.service.BranchService;

@Service
public class BranchServiceImpl implements BranchService {
    private final BranchRepository repo;

    @Autowired
    public BranchServiceImpl(BranchRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Branch> findAll() {
        return repo.findAll();
    }

    @Override
    public List<Branch> findAllByCompanyId(Long companyId) {
        return repo.findAllByCompanyId(companyId);
    }

    @Override
    public Branch findById(Long id) {
        return repo.findById(id)
                   .orElseThrow(() -> new RuntimeException("Branch not found: " + id));
    }

    @Override
    public Branch save(Branch branch) {
        return repo.save(branch);
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}