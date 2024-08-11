package com.example.app.controller.admin;

import com.example.app.entity.RoleEntity;
import com.example.app.repository.AccountRepo;
import com.example.app.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class RoleController {
    @Autowired
    RoleRepo roleRepo;

    @Autowired
    AccountRepo accountRepo;

    @GetMapping("/role")
    public String role(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size,
            @RequestParam(name = "name", required = false) String name,
            Model model
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<RoleEntity> rolePage;

        if (name != null && !name.isEmpty()) {
            rolePage = roleRepo.findByNameContaining(name, pageable);
        } else {
            rolePage = roleRepo.findAll(pageable);
        }

        model.addAttribute("roles", rolePage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", rolePage.getTotalPages());
        model.addAttribute("totalItems", rolePage.getTotalElements());
        model.addAttribute("size", size);
        model.addAttribute("name", name);

        Map<Integer, Long> accountCounts = new HashMap<>();
        for (RoleEntity role : rolePage.getContent()) {
            accountCounts.put(role.getId(), roleRepo.countAccountsByRoleId(role.getId()));
        }
        model.addAttribute("accountCounts", accountCounts);

        return "admin/role/list";
    }
}