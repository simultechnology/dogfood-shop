package com.example.dogfoodshop.controller;

import com.example.dogfoodshop.model.Product;
import com.example.dogfoodshop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public String listProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products/list";
    }

    @GetMapping("/{id}")
    public String showProduct(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.getProduct(id));
        return "products/detail";
    }

    @GetMapping("/category/{categoryId}")
    public String listProductsByCategory(@PathVariable Long categoryId, Model model) {
        model.addAttribute("products", productService.getProductsByCategory(categoryId));
        return "products/list";
    }

    @GetMapping("/search")
    public String searchProducts(@RequestParam String keyword, Model model) {
        model.addAttribute("products", productService.searchProducts(keyword));
        return "products/list";
    }
}