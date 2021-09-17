package com.example.ecommerce.controllers;

import com.example.ecommerce.model.CategoryProduct;
import com.example.ecommerce.model.ExceptionResponse;
import com.example.ecommerce.model.Pays;
import com.example.ecommerce.service.CategoryProductService;
import com.example.ecommerce.service.PaysService;
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

public class CategoryProductController {
    @Autowired
    private CategoryProductService categoryProductService;

    @GetMapping("/category")
    public List<CategoryProduct> categoryProductList() {
        return categoryProductService.listcategory();
    }

    @PostMapping("/category")
    public ResponseEntity<Object> addcategory(@RequestBody CategoryProduct categoryProduct) throws Exception {
//        if (paysService.checkIfNull(pays) == null) {
//            throw new Exception("Tous les champs sont requis");
//        } else {
        CategoryProduct newcategorys = categoryProductService.addCategory(categoryProduct);
        return new ResponseEntity(new ExceptionResponse(new Date(), "Category ajoutée avec succès"), HttpStatus.CREATED);

//        }
    }

}
