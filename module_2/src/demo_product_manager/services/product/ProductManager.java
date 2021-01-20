package demo_product_manager.services.product;

import demo_product_manager.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductManager implements ProductService {
    private static List<Product> productList;

    static {
        productList = new ArrayList<>();
        productList.add(new Product(1, "A", 2));
        productList.add(new Product(2, "C", 4));
        productList.add(new Product(3, "B", 7));
        productList.add(new Product(4, "E", 8));
    }

    @Override
    public List<Product> SortById() {
        return null;
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public Product findById(int id) {
        return null;
    }

    @Override
    public void save(Product product) {
        productList.add(product);
    }
    @Override
    public void edit(Product product, int id) {
        for (Product product1: productList) {
            if (id == product1.getId()){
                product1.setName(product.getName());
                product1.setPrice(product.getPrice());
            }
        }
    }

    @Override
    public void remove(Product product) {

    }
}
