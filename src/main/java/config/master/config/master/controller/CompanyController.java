package config.master.config.master.controller;

import config.master.config.master.model.Company;
import config.master.config.master.service.CompanyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
@RequestMapping("/companies")
public class CompanyController {
    private final CompanyService service;

    @Autowired
    public CompanyController(CompanyService service) {
        this.service = service;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("companies", service.findAll());
        return "companies";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("company", new Company());
        return "company-form";
    }

    @PostMapping
    public String create(@ModelAttribute Company company) {
        service.save(company);
        return "redirect:/companies";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("company", service.findById(id));
        return "company-form";
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
