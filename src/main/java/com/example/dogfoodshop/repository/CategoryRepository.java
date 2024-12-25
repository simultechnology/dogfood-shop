package com.example.dogfoodshop.repository;

import com.example.dogfoodshop.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}