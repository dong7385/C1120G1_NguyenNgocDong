package service;

import model.CustomerType;

import java.util.List;

public interface CustomerTypeService {
    List<CustomerType> findAll();
    CustomerType findById(int id);

}
