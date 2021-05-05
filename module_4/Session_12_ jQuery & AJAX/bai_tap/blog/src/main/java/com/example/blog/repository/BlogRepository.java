package com.example.blog.repository;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository <Blog, Integer>{
    List<Blog> findAll();
    Page<Blog> findAll(Pageable pageable);
    Page<Blog> findByTitle(String title ,Pageable pageable);
    Page<Blog> findByOrderByTitleAsc(Pageable pageable);
}
