package com.example.ecommerce.service;

import com.example.ecommerce.model.CategoryProduct;
import com.example.ecommerce.repository.CategoryProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryProductImpl implements CategoryProductService {
    @Autowired
    CategoryProductRepository categoryProductRepository;

    @Override
    public List<CategoryProduct> listcategory() {
        return categoryProductRepository.findAll();
    }

    @Override
    public CategoryProduct addCategory(CategoryProduct categoryProduct) {
        return categoryProductRepository.save(categoryProduct);
    }

    @Override
    public Optional<CategoryProduct> showcategory(int id) {
        return categoryProductRepository.findById(id);
    }

    @Override
    public void deletecategory(int i) {

    }
}
