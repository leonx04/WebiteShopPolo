package com.example.app.controller.admin;

import com.example.app.entity.ProductDetailEntity;
import com.example.app.repository.*;
import com.example.app.service.CloudinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author dungn
 */
@Controller
@RequestMapping("/admin")
public class ProductDetailController {
    @Autowired
    ProductRepo productRepo;
    @Autowired
    ProductDetailRepo productDetailRepo;
    @Autowired
    ColorRepo colorRepo;
    @Autowired
    SizeRepo sizeRepo;
    @Autowired
    MaterialRepo materialRepo;
    @Autowired
    CloudinaryService cloudinaryService;

    @GetMapping("/product-details")
    public String productDetail(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "sizepage", defaultValue = "10") int sizepage,
            Model model) {

        Pageable pageable = PageRequest.of(page, sizepage);
        Page<ProductDetailEntity> productDetailPage = productDetailRepo.findAll(pageable);

        model.addAttribute("productDetails", productDetailPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", productDetailPage.getTotalPages());
        model.addAttribute("pageSize", sizepage);
        model.addAttribute("products", productRepo.findAll());
        model.addAttribute("colors", colorRepo.findAll());
        model.addAttribute("sizes", sizeRepo.findAll());
        model.addAttribute("materials", materialRepo.findAll());

        return "admin/products_detail/list";
    }

    @GetMapping("/product-details/search")
    public String productDetailSearch(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "sizepage", defaultValue = "10") int sizepage,
            @RequestParam(name = "productName", required = false) String productName,
            @RequestParam(name = "color", required = false) String color,
            @RequestParam(name = "size", required = false) String size,
            @RequestParam(name = "material", required = false) String material,
            @RequestParam(name = "code", required = false) String code,
            Model model) {

        Pageable pageable = PageRequest.of(page, sizepage);
        Page<ProductDetailEntity> productDetailPage = productDetailRepo.findByFilters(productName, color, size, material, code, pageable);

        model.addAttribute("productDetails", productDetailPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", productDetailPage.getTotalPages());
        model.addAttribute("pageSize", sizepage);
        model.addAttribute("products", productRepo.findAll());
        model.addAttribute("colors", colorRepo.findAll());
        model.addAttribute("sizes", sizeRepo.findAll());
        model.addAttribute("materials", materialRepo.findAll());

        // Add search parameters to model for maintaining state in view
        model.addAttribute("selectedProductName", productName);
        model.addAttribute("selectedColor", color);
        model.addAttribute("selectedSize", size);
        model.addAttribute("selectedMaterial", material);
        model.addAttribute("selectedCode", code);

        // Add a message if no results are found
        if (productDetailPage.getTotalElements() == 0) {
            model.addAttribute("noResultsMessage", "No records found that match what you want!");
        }

        return "admin/products_detail/list";
    }
}
