package com.example.spring_security.service;


import com.example.spring_security.model.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryService{
    List<Category> findAll();
    Category findById(Integer id);
    void deleteById(Integer id);
    void save(Category category);
}
