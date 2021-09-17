package com.example.ecommerce.controllers;

import com.example.ecommerce.model.ExceptionResponse;
import com.example.ecommerce.model.Pays;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.service.CategoryProductService;
import com.example.ecommerce.service.PaysService;
import com.example.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryProductService categoryProductService;

    @GetMapping("/{id}/products")
    public List<Product> productList(@PathVariable int id) {
        return categoryProductService.showcategory(id).get().getProducts();
    }

    @PostMapping("/{id}/products")
    public ResponseEntity<Object> addProduct(@PathVariable int id, @RequestBody Product product) throws Exception {
        product.setCategory(categoryProductService.showcategory(id).get());
        productService.addProducts(product);

        return new ResponseEntity(new ExceptionResponse(new Date(), "Produit ajouté avec succès"), HttpStatus.CREATED);


    }

}
