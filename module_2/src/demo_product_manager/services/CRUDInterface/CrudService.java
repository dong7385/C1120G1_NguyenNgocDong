package demo_product_manager.services.CRUDInterface;

import java.util.List;

public interface CrudService<T> {
    List<T> findAll();
    T findById(int id);
    void save(T t);
    void edit(T t, int id);
    void remove(T t);
}
