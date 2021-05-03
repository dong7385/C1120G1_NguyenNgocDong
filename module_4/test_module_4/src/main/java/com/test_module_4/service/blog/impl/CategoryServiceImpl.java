package com.test_module_4.service.impl;

import com.test_module_4.model.blog.Category;
import com.test_module_4.repository.CategoryRepository;
import com.test_module_4.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
