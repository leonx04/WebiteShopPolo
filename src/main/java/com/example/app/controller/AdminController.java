package com.example.app.controller;

import com.example.app.entity.ProductEntity;
import com.example.app.repository.BrandRepo;
import com.example.app.repository.CategoryRepo;
import com.example.app.repository.ProductDetailRepo;
import com.example.app.repository.ProductRepo;
import com.example.app.service.CloudinaryService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Date;

/**
 * @author dungn
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private CloudinaryService cloudinaryService;
    @Autowired
    private BrandRepo brandRepo;
    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private ProductDetailRepo productDetailRepo;
    @Autowired
    HttpServletRequest request;

    @GetMapping("/index")
    public String dashboard() {
        return "admin/index";
    }

    @GetMapping("/products")
    public String products(Model model,
                           @RequestParam(name = "page", defaultValue = "0") int page,
                           @RequestParam(name = "size", defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ProductEntity> productPage = productRepo.findAll(pageable);

        model.addAttribute("brands", brandRepo.findAll());
        model.addAttribute("categories", categoryRepo.findAll());
        model.addAttribute("products", productPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", productPage.getTotalPages());
        model.addAttribute("size", size);

        return "admin/products/list";
    }

    @GetMapping("/products/search")
    public String searchProducts(@RequestParam(required = false) String code,
                                 @RequestParam(required = false) String name,
                                 @RequestParam(required = false) Integer brandId,
                                 @RequestParam(required = false) Integer categoryId,
                                 @RequestParam(name = "page", defaultValue = "0") int page,
                                 @RequestParam(name = "size", defaultValue = "10") int size,
                                 Model model) {
        code = code != null ? code.trim() : null;
        name = name != null ? name.trim() : null;

        Pageable pageable = PageRequest.of(page, size);
        Page<ProductEntity> productPage = productRepo.search(code, name, brandId, categoryId, pageable);

        model.addAttribute("products", productPage.getContent());
        model.addAttribute("brands", brandRepo.findAll());
        model.addAttribute("categories", categoryRepo.findAll());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", productPage.getTotalPages());
        model.addAttribute("size", size);
        model.addAttribute("code", code);
        model.addAttribute("name", name);
        model.addAttribute("brandId", brandId);
        model.addAttribute("categoryId", categoryId);

        return "admin/products/list";
    }

    @GetMapping("/products/create")
    public String createProduct(Model model) {

        model.addAttribute("product", new ProductEntity());
        model.addAttribute("brandByBrandId", brandRepo.findAll());
        model.addAttribute("categoryByCategoryId", categoryRepo.findAll());
        return "admin/products/add";
    }

    @PostMapping("/products/save")
    public String saveProduct(@ModelAttribute ProductEntity product, RedirectAttributes redirectAttributes) {
        try {
            if (product.getImageFile() != null && !product.getImageFile().isEmpty()) {
                String imageUrl = cloudinaryService.uploadFile(product.getImageFile());
                product.setImageUrl(imageUrl);
            }
            product.setCreateAt(new Date(System.currentTimeMillis()));
            product.setUpdateAt(new Date(System.currentTimeMillis()));
            productRepo.save(product);

            redirectAttributes.addFlashAttribute("successMessage", "Product saved successfully!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error saving product: " + e.getMessage());
        }
        return "redirect:/admin/products";
    }

    @GetMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        try {
            // Kiểm tra xem sản phẩm có tồn tại không
            if (productRepo.existsById(id)) {
                ProductEntity product = productRepo.findById(id).orElse(null);

                // Xóa ảnh liên quan nếu có
                if (product != null && product.getImageUrl() != null && !product.getImageUrl().isEmpty()) {
                    String publicId = cloudinaryService.getPublicIdFromUrl(product.getImageUrl());
                    cloudinaryService.deleteFile(publicId);
                }

                // Xóa sản phẩm khỏi cơ sở dữ liệu
                productRepo.deleteById(id);
                redirectAttributes.addFlashAttribute("successMessage", "Product deleted successfully!");
            } else {
                redirectAttributes.addFlashAttribute("errorMessage", "Product not found!");
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error deleting product: " + e.getMessage());
        }

        // Điều hướng về trang danh sách sản phẩm
        return "redirect:/admin/products";
    }

    @GetMapping("/products/edit/{id}")
    public String editProduct(@PathVariable("id") Integer id, Model model) {
        ProductEntity product = productRepo.findById(id).orElse(null);
        if (product != null) {
            model.addAttribute("product", product);
            model.addAttribute("brandByBrandId", brandRepo.findAll());
            model.addAttribute("categoryByCategoryId", categoryRepo.findAll());
            return "admin/products/edit";
        } else {
            // Nếu không tìm thấy sản phẩm, chuyển hướng về trang danh sách sản phẩm
            return "redirect:/admin/products";
        }
    }

    @PostMapping("/products/update/{id}")
    public String updateProduct(@PathVariable("id") Integer id, @ModelAttribute ProductEntity updatedProduct, RedirectAttributes redirectAttributes) {
        try {
            ProductEntity existingProduct = productRepo.findById(id).orElse(null);
            if (existingProduct != null) {
                // Cập nhật thông tin sản phẩm
                BeanUtils.copyProperties(updatedProduct, existingProduct, "id", "createAt");

                // Xử lý ảnh sản phẩm
                if (updatedProduct.getImageFile() != null && !updatedProduct.getImageFile().isEmpty()) {
                    // Xóa ảnh cũ (nếu có)
                    if (existingProduct.getImageUrl() != null && !existingProduct.getImageUrl().isEmpty()) {
                        String publicId = cloudinaryService.getPublicIdFromUrl(existingProduct.getImageUrl());
                        cloudinaryService.deleteFile(publicId);
                    }
                    // Tải ảnh mới lên Cloudinary
                    String imageUrl = cloudinaryService.uploadFile(updatedProduct.getImageFile());
                    existingProduct.setImageUrl(imageUrl);
                }

                // Cập nhật thời gian chỉnh sửa
                existingProduct.setUpdateAt(new Date(System.currentTimeMillis()));

                // Lưu thông tin sản phẩm vào cơ sở dữ liệu
                productRepo.save(existingProduct);
                redirectAttributes.addFlashAttribute("successMessage", "Product updated successfully!");
            } else {
                redirectAttributes.addFlashAttribute("errorMessage", "Product not found!");
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error updating product: " + e.getMessage());
        }
        return "redirect:/admin/products";
    }

}
