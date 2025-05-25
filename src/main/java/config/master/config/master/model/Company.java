package config.master.config.master.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Название компании не может быть пустым")
    @Size(min = 2, max = 100, message = "Длина названия должна быть от 2 до 100 символов")
    private String name;

    @OneToMany(mappedBy = "company", cascade = jakarta.persistence.CascadeType.ALL)
    private List<Branch> branches = new ArrayList<>();

    public Company() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBranches(List<Branch> branches) {
        this.branches = branches;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Branch> getBranches() {
        return branches;
    }

    public void addBranch(Branch branch) {
        if (branch != null) {
            branches.add(branch);
            branch.setCompany(this);
        }
    }

    public void removeBranch(Branch branch) {
        if (branch != null) {
            branches.remove(branch);
            branch.setCompany(null);  // "отвязываем" филиал от компании
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(id, company.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
