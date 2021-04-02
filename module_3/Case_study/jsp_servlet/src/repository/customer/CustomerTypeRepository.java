package repository.customer;

import model.customer.CustomerType;

import java.util.List;

public interface CustomerTypeRepository {
    CustomerType findById(int id);
    List<CustomerType> findAll();
}
