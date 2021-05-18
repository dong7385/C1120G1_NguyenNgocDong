package demo_product_manager.services.product;

import demo_product_manager.model.Product;
import demo_product_manager.services.CRUDInterface.CrudService;

import java.util.List;

public interface ProductService extends CrudService<Product> {
    List<Product>SortById();

}
