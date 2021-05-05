package service.customer.impl;

import model.customer.CustomerType;
import repository.customer.CustomerTypeRepository;
import repository.customer.CustomerTypeRepositoryImpl;
import service.customer.CustomerTypeService;

import java.util.List;

public class CustomerTypeServiceImpl implements CustomerTypeService {
CustomerTypeRepository customerTypeRepository=new CustomerTypeRepositoryImpl();
    @Override
    public CustomerType findById(int id) {
        return customerTypeRepository.findById(id);
    }

    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }
}
