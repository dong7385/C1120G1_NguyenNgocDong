package com.test_module_4.service.request.impl;


import com.test_module_4.model.request.ProductType;
import com.test_module_4.repository.request.ProductTypeRepository;
import com.test_module_4.service.request.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {

    @Autowired
    ProductTypeRepository productTypeRepository;

    @Override
    public List<ProductType> findAll() {
        return productTypeRepository.findAll();
    }
}
