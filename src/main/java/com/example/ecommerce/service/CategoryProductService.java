package com.example.ecommerce.service;

import com.example.ecommerce.model.CategoryProduct;


import java.util.List;
import java.util.Optional;

public interface CategoryProductService {
    public List<CategoryProduct> listcategory();

    public CategoryProduct addCategory(CategoryProduct categoryProduct);

    public Optional<CategoryProduct> showcategory(int id);

    public void deletecategory(int i);


}
