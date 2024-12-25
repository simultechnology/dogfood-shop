package com.example.dogfoodshop.service;

import com.example.dogfoodshop.model.Product;
import com.example.dogfoodshop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findByActiveTrue();
    }

    public Product getProduct(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public List<Product> getProductsByCategory(Long categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }

    public List<Product> searchProducts(String keyword) {
        return productRepository.search(keyword);
    }

    @Transactional
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Transactional
    public void deleteProduct(Long id) {
        Product product = getProduct(id);
        product.setActive(false);
        productRepository.save(product);
    }

    @Transactional
    public void updateStock(Long productId, int quantity) {
        Product product = getProduct(productId);
        if (product.getStock() < quantity) {
            throw new RuntimeException("Insufficient stock");
        }
        product.setStock(product.getStock() - quantity);
        productRepository.save(product);
    }
}