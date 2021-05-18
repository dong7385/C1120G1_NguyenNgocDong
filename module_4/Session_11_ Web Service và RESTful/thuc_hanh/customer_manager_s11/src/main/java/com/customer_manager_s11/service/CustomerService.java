package com.customer_manager_s11.service;

import com.customer_manager_s11.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    Customer findById(Long id);

    void save(Customer customer);

    void deleteById(Long id);
}
