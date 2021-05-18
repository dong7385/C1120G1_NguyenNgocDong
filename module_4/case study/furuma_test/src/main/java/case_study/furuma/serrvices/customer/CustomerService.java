package case_study.furuma.serrvices.customer;

import case_study.furuma.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;


public interface CustomerService {
    List<Customer> findAll();
    Page<Customer> findAll(Pageable pageable);
    Customer findById(String id);
    void deleteById(String id);
    void save(Customer customer);
    Page<Customer> findAllByCustomerNameContaining(String name, Pageable pageable);
    Page<Customer> findByOrderByCustomerName(Pageable pageable);
}
