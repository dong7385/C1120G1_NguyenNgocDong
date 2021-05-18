package case_study.furuma.repository.customer;
import case_study.furuma.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,String> {
    Page<Customer> findAll(Pageable pageable);
    @Query(value = "select *" +
            " from customer " +
            "where concat(customer_name, customer_address) like %?1%", nativeQuery = true)
    Page<Customer> findAllByCustomerNameContaining(String name ,Pageable pageable);
    Page<Customer> findByOrderByCustomerName(Pageable pageable);
}
