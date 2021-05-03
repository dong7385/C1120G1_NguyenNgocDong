package com.test_module_4.service.request;

import com.test_module_4.model.request.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(Integer id);
}
