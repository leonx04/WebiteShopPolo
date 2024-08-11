package com.example.app.controller.admin;

import com.example.app.entity.CustomerEntity;
import com.example.app.repository.AccountRepo;
import com.example.app.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author dungn
 */
@Controller
@RequestMapping("/admin")
public class CustomerController {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    AccountRepo accountRepo;

    @RequestMapping("/customer")
    public String customer(
            Model model,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<CustomerEntity> customerPage = customerRepository.findAll(pageable);
        model.addAttribute("customers", customerPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", customerPage.getTotalPages());
        model.addAttribute("size", size);

        return "admin/customer/list";
    }

    @GetMapping("/customer/search")
    public String searchCustomer(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String phone,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size,
            Model model
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<CustomerEntity> customerPage = customerRepository.search(name, email, phone, pageable);

        model.addAttribute("customers", customerPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", customerPage.getTotalPages());
        model.addAttribute("totalItems", customerPage.getTotalElements());
        model.addAttribute("size", size);
        model.addAttribute("name", name);
        model.addAttribute("email", email);
        model.addAttribute("phone", phone);

        return "admin/customer/list";
    }

    @GetMapping("/customer/create")
    public String addCustomer(Model model) {
        model.addAttribute("customer", new CustomerEntity());
        model.addAttribute("accounts", accountRepo.findAll());
        return "admin/customer/add";
    }
    @PostMapping("/customer/save")
    public String saveCustomer(CustomerEntity customerEntity) {
        customerRepository.save(customerEntity);
        return "redirect:/admin/customer";
    }

}
