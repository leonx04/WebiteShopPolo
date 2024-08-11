package com.example.app.controller;

import com.example.app.entity.ProductEntity;
import com.example.app.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author dungn
 */
@Controller
public class HomeController {
    @Autowired
    ProductRepo productRepo;


    @GetMapping("/home")
    public String home(Model model) {
        List<ProductEntity> featuredProducts = productRepo.findAll();

        List<ProductEntity> newProducts = productRepo.findAll();

        model.addAttribute("featuredProducts", featuredProducts);
        model.addAttribute("newProducts", newProducts);
        return "client/index";
    }


}
