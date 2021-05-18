package repository.customer;

import model.Customer;

import java.util.List;

public interface CustomerRepository {
    Customer findById(int id);
    List<Customer> findAll();
}
