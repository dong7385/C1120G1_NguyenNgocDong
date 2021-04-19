package case_study.furuma.serrvice.customer.impl;

import case_study.furuma.model.customer.Customer;
import case_study.furuma.repository.customer.CustomerRepository;
import case_study.furuma.serrvice.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Customer findById(Integer id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        customerRepository.deleteById(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Page<Customer> findByCustomerName(String name, Pageable pageable) {
        return customerRepository.findByCustomerName(name, pageable);
    }

    @Override
    public Page<Customer> findByOrderByCustomerName(Pageable pageable) {
        return customerRepository.findByOrderByCustomerName(pageable);
    }
}
