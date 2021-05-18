package com.example.spring_security.service.impl;

import com.example.spring_security.model.Blog;
import com.example.spring_security.repository.BlogRepository;
import com.example.spring_security.service.BlogService;
import com.example.spring_security.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogRepository blogRepository;


//    @Override
//    public Page<Blog> findAll(Pageable pageable) {
//        return blogRepository.findAll(pageable);
//    }

    @Override
    public Blog findById(Integer id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        blogRepository.deleteById(id);
    }

    @Override
    public void save(Blog blog) {
        if (blog.getId() == null) {
            blog.setPostDate(DateUtil.getCurrentDate());
        }
        blogRepository.save(blog);
    }

    @Override
    public Page<Blog> searchByName(String title, Pageable pageable) {
        return blogRepository.findByTitle(title,pageable);
    }

    @Override
    public Page<Blog> sort(Pageable pageable) {
        return blogRepository.findByOrderByTitleAsc(pageable);
    }
}
