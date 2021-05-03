package com.test_module_4.repository;

import com.test_module_4.model.blog.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Integer> {
    Page<Blog> findAll(Pageable pageable);
    @Query(value = "select *" +
            " from blog " +
            "where concat(blog_title, blog_questions) like %?1%", nativeQuery = true)
    Page<Blog> findAllByBlogTitleContaining(String name, Pageable pageable);
    Page<Blog> findByOrderByBlogTitle(Pageable pageable);
}
