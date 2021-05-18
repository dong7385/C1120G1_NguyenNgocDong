package com.example.spring_security.repository;

import com.example.spring_security.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository <Blog, Integer>{
//    Page<Blog> findAll(Pageable pageable);
    Page<Blog> findByTitle(String title, Pageable pageable);
    Page<Blog> findByOrderByTitleAsc(Pageable pageable);
}
