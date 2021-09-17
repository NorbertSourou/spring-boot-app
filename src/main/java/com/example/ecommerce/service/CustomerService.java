package com.example.ecommerce.service;

import com.example.ecommerce.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    public Customer addCustomer(Customer customer);

    public Optional<Customer> get(int id);

    public List<Customer> listCustomer();
}
