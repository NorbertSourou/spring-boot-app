package com.example.ecommerce.controllers;

import com.example.ecommerce.model.CategoryProduct;
import com.example.ecommerce.model.Customer;
import com.example.ecommerce.model.ExceptionResponse;
import com.example.ecommerce.service.CategoryProductService;
import com.example.ecommerce.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customer")
    public List<Customer> customerList() {
        return customerService.listCustomer();
    }

    @PostMapping("/customer")
    public ResponseEntity<Object> addcategory(@RequestBody Customer customer) throws Exception {
        Customer newCustomer = customerService.addCustomer(customer);
        return new ResponseEntity(new ExceptionResponse(new Date(), "Nouvel Utilisateur ajouté avec succès"), HttpStatus.CREATED);

//        }
    }
}
