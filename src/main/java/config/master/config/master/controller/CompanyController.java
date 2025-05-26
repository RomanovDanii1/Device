package config.master.config.master.controller;

import config.master.config.master.model.Company;
import config.master.config.master.service.CompanyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/companies")
public class CompanyController {
    private final CompanyService service;

    public CompanyController(CompanyService service) {
        this.service = service;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("companies", service.findAll());

        return "companies";
    }

    @PostMapping
    public String create(@ModelAttribute Company company) {
        service.save(company);
        return "redirect:/companies";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Company company) {
        company.setId(id);
        service.save(company);
        return "redirect:/companies";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteById(id);
        return "redirect:/companies";
    }
}

