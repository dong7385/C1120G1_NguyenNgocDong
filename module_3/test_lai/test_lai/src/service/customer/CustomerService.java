package service.customer;

import model.Customer;

import java.util.List;

public interface CustomerService {
    Customer findById(int id);
    List<Customer> findAll();
}
