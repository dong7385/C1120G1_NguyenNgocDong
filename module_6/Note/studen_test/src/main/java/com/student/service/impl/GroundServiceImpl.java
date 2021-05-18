package com.student.service.impl;

import com.student.model.Ground;
import com.student.repository.GroundRepository;
import com.student.service.GroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroundServiceImpl implements GroundService {
    @Autowired
    GroundRepository groundRepository;


    @Override
    public List<Ground> findAll() {
        return groundRepository.findAll();
    }

    @Override
    public Ground findById(Integer id) {
        return groundRepository.findById(id).orElse(null);
    }
}
