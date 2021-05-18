package com.test_module_4.service.blog.impl;

import com.test_module_4.model.blog.Blog;
import com.test_module_4.repository.blog.BlogRepository;
import com.test_module_4.service.blog.BlogService;
import com.test_module_4.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class BlogServiceImpl implements BlogService {

    @Autowired
    BlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

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
        if(blog.getBlogId()==null){
            blog.setDateCreate(DateUtil.getCurrentDate());
        }
        blogRepository.save(blog);
    }

    @Override
    public Page<Blog> findByTitleAndQuestions(String name, Pageable pageable) {
        return blogRepository.findAllByBlogTitleContaining(name, pageable);
    }

    @Override
    public Page<Blog> findByOrderByBlogTitle(Pageable pageable) {
        return blogRepository.findByOrderByBlogTitle(pageable);
    }
}
