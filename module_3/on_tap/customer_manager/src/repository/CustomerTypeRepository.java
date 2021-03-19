package repository;

import model.CustomerType;

import java.util.List;

public interface CustomerTypeRepository {
    CustomerType findById(int id);
    List<CustomerType> findAll();
}
