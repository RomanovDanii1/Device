package config.master.config.master.controller;

import config.master.config.master.model.Branch;
import config.master.config.master.service.BranchService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/branches")
public class BranchController {
    private final BranchService service;

    public BranchController(BranchService service) {
        this.service = service;
    }

    @GetMapping
    public String list(@RequestParam(required = false) Long companyId, Model model) {
        var branches = companyId == null
            ? service.findAll()
            : service.findAllByCompanyId(companyId);
        model.addAttribute("branches", branches);
        model.addAttribute("companyId", companyId);

        return "branches";
    }

    @PostMapping
    public String create(@ModelAttribute Branch branch) {
        Branch saved = service.save(branch);
        Long cid = saved.getCompany()!=null
                   ? saved.getCompany().getId()
                   : null;
        return "redirect:/branches?companyId=" + cid;
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Branch branch) {
        branch.setId(id);
        Branch saved = service.save(branch);
        Long cid = saved.getCompany()!=null
                   ? saved.getCompany().getId()
                   : null;
        return "redirect:/branches?companyId=" + cid;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        Long cid = service.findById(id).getCompany().getId();
        service.deleteById(id);
        return "redirect:/branches?companyId=" + cid;
    }
}

