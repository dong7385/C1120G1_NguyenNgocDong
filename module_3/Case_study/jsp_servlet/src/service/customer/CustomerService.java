package service.customer;

import model.customer.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    void save(Customer customer);
    Customer findById(String id);
    void update(String id, Customer customer);
    void remove(String id);
    List<Customer> searchCustomer(String name);
}
