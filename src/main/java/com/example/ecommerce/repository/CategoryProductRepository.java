package com.example.ecommerce.repository;

import com.example.ecommerce.model.CategoryProduct;
import com.example.ecommerce.model.Ville;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryProductRepository extends JpaRepository<CategoryProduct, Integer> {
}
