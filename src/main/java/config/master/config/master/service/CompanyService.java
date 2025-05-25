package config.master.config.master.service;

import config.master.config.master.model.Company;
import java.util.List;

public interface CompanyService {
    List<Company> findAll();

    Company findById(Long id);

    Company save(Company company);

    void deleteById(Long id);
}
