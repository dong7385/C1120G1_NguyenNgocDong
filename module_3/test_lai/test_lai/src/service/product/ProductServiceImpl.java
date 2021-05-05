package service.product;

import model.Product;
import repository.product.ProductRepository;
import repository.product.ProductRepositoryImpl;

import java.util.List;

public class ProductServiceImpl implements ProductService{
    ProductRepository productRepository=new ProductRepositoryImpl();
    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
