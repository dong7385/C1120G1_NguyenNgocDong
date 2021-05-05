package service.product;

import model.Product;

import java.util.List;

public interface ProductService {
    Product findById(int id);
    List<Product> findAll();
}
