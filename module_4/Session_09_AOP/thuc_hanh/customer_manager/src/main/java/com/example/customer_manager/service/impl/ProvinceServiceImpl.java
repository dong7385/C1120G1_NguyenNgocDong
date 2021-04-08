package com.example.customer_manager.service.impl;

import com.example.customer_manager.model.Province;
import com.example.customer_manager.repository.ProvinceRepository;
import com.example.customer_manager.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProvinceServiceImpl implements ProvinceService {
    @Autowired
    ProvinceRepository provinceRepository;
    @Override
    public List<Province> findAll() {
        return provinceRepository.findAll();
    }
}
