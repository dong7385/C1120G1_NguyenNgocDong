package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import com.example.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BlogRestController {
    @Autowired
    BlogService blogService;
    @RequestMapping(value = "/blogService/", method = RequestMethod.GET)
    public ResponseEntity<List<Blog>> listAllBlog() {
        List<Blog> blogs = blogService.findAll();
        if (blogs.isEmpty()) {
            return new ResponseEntity<List<Blog>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Blog>>(blogs, HttpStatus.OK);
    }
    @RequestMapping(value = "/blogService/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Blog> getBlog(@PathVariable("id") Integer id) {
        System.out.println("Fetching Blog with id " + id);
        Blog blog = blogService.findById(id);
        if (blog == null) {
            System.out.println("Customer with id " + id + " not found");
            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Blog>(blog, HttpStatus.OK);
    }
}
