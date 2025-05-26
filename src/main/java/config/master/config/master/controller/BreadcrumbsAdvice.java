package config.master.config.master.controller;

import config.master.config.master.model.Branch;
import config.master.config.master.model.Company;
import config.master.config.master.model.Room;
import config.master.config.master.service.BranchService;
import config.master.config.master.service.CompanyService;
import config.master.config.master.service.RoomService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.*;

@ControllerAdvice
public class BreadcrumbsAdvice {

    private final CompanyService companyService;
    private final BranchService  branchService;
    private final RoomService    roomService;

    public BreadcrumbsAdvice(CompanyService companyService,
                             BranchService branchService,
                             RoomService roomService) {
        this.companyService = companyService;
        this.branchService  = branchService;
        this.roomService    = roomService;
    }

    @ModelAttribute("breadcrumbs")
    public List<Map<String, String>> breadcrumbs(HttpServletRequest request) {
        String uri        = request.getRequestURI();
        String companyId  = request.getParameter("companyId");
        String branchId   = request.getParameter("branchId");
        String roomId     = request.getParameter("roomId");

        List<Map<String, String>> crumbs = new ArrayList<>();

        // 1) Корневая страница /companies — хлебных крошек нет
        if (uri.equals("/companies")) {
            return crumbs;
        }

        // 2) Компания
        if (companyId != null) {
            Optional<Company> oc = Optional.ofNullable(
                companyService.findById(Long.valueOf(companyId))
            );
            oc.ifPresent(c -> crumbs.add(Map.of(
                "label", c.getName(),
                "url",   "/branches?companyId=" + c.getId()
            )));
        }

        // 3) Филиал
        if (uri.startsWith("/branches") && branchId != null) {
            Optional<Branch> ob = Optional.ofNullable(
                branchService.findById(Long.valueOf(branchId))
            );
            ob.ifPresent(b -> crumbs.add(Map.of(
                "label", b.getName(),
                "url",   "/rooms?branchId=" + b.getId()
            )));
        }

        // 4) Комната
        if (uri.startsWith("/rooms") && roomId != null) {
            Optional<Room> or = Optional.ofNullable(
                roomService.findById(Long.valueOf(roomId))
            );
            or.ifPresent(r -> crumbs.add(Map.of(
                "label", r.getName(),
                "url",   "/equipment?roomId=" + r.getId()
            )));
        }

        // 5) Текущий экран — просто текст, без ссылки
        String lastLabel;
        if (uri.contains("/new")) {
            lastLabel = "Neu";
        } else if (uri.contains("/update") || uri.contains("/edit")) {
            lastLabel = "Bearbeiten";
        } else {
            // основной список текущего уровня: «Filialen», «Räume» или «Geräte»
            if (uri.startsWith("/branches")) {
                lastLabel = "Filialen";
            } else if (uri.startsWith("/rooms")) {
                lastLabel = "Räume";
            } else if (uri.startsWith("/equipment")) {
                lastLabel = "Geräte";
            } else {
                lastLabel = "";
            }
        }
        if (!lastLabel.isEmpty()) {
            crumbs.add(Map.of("label", lastLabel));
        }

        return crumbs;
    }
}
