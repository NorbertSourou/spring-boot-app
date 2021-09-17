package com.example.ecommerce.service;

import com.example.ecommerce.model.Product;


import java.util.List;
import java.util.Optional;

public interface ProductService {

    public List<Product> listProducts(int id);

    public Product addProducts(Product product);

    public Optional<Product> showproducts(int id);

    public Product checkIfNull(Product product);

    public void deleteproducts(int i);
}
