package service.customer.impl;

import model.customer.Customer;
import repository.customer.CustomerRepository;
import repository.customer.CustomerRepositoryImpl;
import service.customer.CustomerService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    CustomerRepository customerRepository = new CustomerRepositoryImpl();

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer findById(String id) {
        return customerRepository.findById(id);
    }

    @Override
    public void update(String id, Customer customer) {
        customerRepository.update(id, customer);
    }

    @Override
    public void remove(String id) {
        customerRepository.remove(id);
    }

    @Override
    public List<Customer> searchCustomer(String name) {
        return customerRepository.searchCustomer(name);
    }
}
