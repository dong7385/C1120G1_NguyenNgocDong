package fast_food.fast_food_be.service.impl;

import fast_food.fast_food_be.dto.CustomerDto;
import fast_food.fast_food_be.entity.Customer;
import fast_food.fast_food_be.repository.CustomerRepository;
import fast_food.fast_food_be.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer getInfoCustomer(String username) {
        return customerRepository.getInfoCustomer(username);
    }
}
