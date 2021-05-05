package com.example.customer_manager.service;

import com.example.customer_manager.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    Customer findById(Long id);
    void deleteById(Long id);
    void save(Customer customer);
}
