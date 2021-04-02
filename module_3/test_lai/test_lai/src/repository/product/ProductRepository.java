package repository.product;

import model.Product;

import java.util.List;

public interface ProductRepository {
    Product findById(int id);
    List<Product> findAll();
}
