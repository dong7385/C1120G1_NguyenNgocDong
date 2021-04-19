package case_study.furuma.serrvice.customer.impl;

import case_study.furuma.model.customer.CustomerType;
import case_study.furuma.repository.customer.CustomerTypeRepository;
import case_study.furuma.serrvice.customer.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeServiceImpl implements CustomerTypeService {
    @Autowired
    CustomerTypeRepository customerTypeRepository;

    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }
}
