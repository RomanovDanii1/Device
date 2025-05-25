package config.master.config.master.service.impl;

import config.master.config.master.model.Company;
import config.master.config.master.repository.CompanyRepository;
import config.master.config.master.service.CompanyService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository repository;

    @Autowired
    public CompanyServiceImpl(CompanyRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Company> findAll() {
        return repository.findAll();
    }

    @Override
    public Company findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Company not found: " + id));
    }

    @Override
    public Company save(Company company) {
        return repository.save(company);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
