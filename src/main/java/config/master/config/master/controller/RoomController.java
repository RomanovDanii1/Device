package config.master.config.master.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import config.master.config.master.model.Room;
import config.master.config.master.service.RoomService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/rooms")
public class RoomController {
    private final RoomService service;

    public RoomController(RoomService service) {
        this.service = service;
    }

    @GetMapping
    public String list(@RequestParam(required = false) Long branchId, Model model) {
        
        var rooms = branchId == null
            ? service.findAll()
            : service.findAllByBranchId(branchId);
        model.addAttribute("rooms", rooms);
        model.addAttribute("branchId", branchId);

        return "rooms";
    }

    @PostMapping
    public String create(@ModelAttribute Room room) {
        Room saved = service.save(room);
        Long bid = saved.getBranch() != null
                    ? saved.getBranch().getId()
                    : null;

        return "redirect:/rooms?branchId=" + bid;
    }

    @PostMapping("/update/{id}")
    public String update(@RequestParam Long id, @ModelAttribute Room room) {
        room.setId(id);
        Room saved = service.save(room);
        Long bid = saved.getBranch() != null
                    ? saved.getBranch().getId()
                    : null;

        return "redirect:/rooms?branchId=" + bid;
    }

    @GetMapping("/delete/{id}")
    public String delete(@RequestParam Long id) {
        Long bid = service.findById(id).getBranch().getId();
        service.deleteById(id);
        return "redirect:/rooms?branchId=" + bid;
    }
    
}
