package com.test_module_4.service;

import com.test_module_4.model.blog.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService {
    List<Blog> findAll();

    Page<Blog> findAll(Pageable pageable);

    Blog findById(Integer id);

    void deleteById(Integer id);

    void save(Blog blog);

    Page<Blog> findByTitleAndQuestions(String name, Pageable pageable);

    Page<Blog> findByOrderByBlogTitle(Pageable pageable);
}
