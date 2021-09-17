package com.example.ecommerce.service;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServicempl implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryProductService categoryProductService;

    @Override
    public List<Product> listProducts(int id) {
        return null;
    }

    @Override
    public Product addProducts(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> showproducts(int id) {
        return Optional.empty();
    }

    @Override
    public Product checkIfNull(Product product) {
        return null;
    }

    @Override
    public void deleteproducts(int i) {

    }
}
