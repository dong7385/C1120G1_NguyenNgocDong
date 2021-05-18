package com.student.service;
import com.student.model.Ground;

import java.util.List;


public interface GroundService {
    List<Ground> findAll();
    Ground findById(Integer id);
}
