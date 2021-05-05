package com.phonemanagement.service;

import com.phonemanagement.model.Smartphone;


public interface SmartphoneService {
    Iterable<Smartphone> findAll();
    Smartphone findById(Integer id);
    Smartphone save(Smartphone phone);
    void remove(Integer id);
}
