package repository.customer;

import model.customer.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> findAll();
    void save(Customer customer);
    Customer findById(String id);
    void update(String id, Customer customer);
    void remove(String id);
    List<Customer> searchCustomer(String name);
}
