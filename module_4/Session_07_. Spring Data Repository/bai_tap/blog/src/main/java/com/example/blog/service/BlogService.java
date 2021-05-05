package com.example.blog.service;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BlogService {
//    Page<Blog> findAll(Pageable pageable);
    Blog findById(Integer id);
    void deleteById(Integer id);
    void save(Blog blog);
    Page<Blog>searchByName(String title,Pageable pageable);
    Page<Blog> sort(Pageable pageable);
}
