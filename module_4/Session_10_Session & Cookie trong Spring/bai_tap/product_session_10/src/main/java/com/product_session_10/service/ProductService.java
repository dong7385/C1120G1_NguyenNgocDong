package com.product_session_10.service;
import com.product_session_10.model.Product;
import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(Integer id);
    void deleteById(Integer id);
    void save(Product product);
}
