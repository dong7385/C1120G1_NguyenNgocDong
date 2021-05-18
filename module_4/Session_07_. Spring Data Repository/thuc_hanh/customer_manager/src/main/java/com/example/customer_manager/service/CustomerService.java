package com.example.customer_manager.service;

import com.example.customer_manager.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService {
    Page<Customer> findAll(Pageable pageable);
    Customer findById(Long id);
    void deleteById(Long id);
    void save(Customer customer);
   Page<Customer>searchByName(String lastName,Pageable pageable);
}
