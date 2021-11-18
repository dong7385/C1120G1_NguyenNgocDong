package fast_food.fast_food_be.repository;

import fast_food.fast_food_be.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query(value = " select * " +
            " from customer " +
            " join gender on customer.gender_id = gender.gender_id " +
            " join account on customer.account_id = account.account_id " +
            " where account.`username`= ?1 ", nativeQuery = true)
    Customer getInfoCustomer(String username);
}
