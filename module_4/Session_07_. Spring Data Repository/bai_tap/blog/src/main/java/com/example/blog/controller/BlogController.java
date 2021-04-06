package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.service.BlogService;
import com.example.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BlogController {

    @Autowired
    BlogService blogService;
    @Autowired
    CategoryService categoryService;

    @GetMapping
    public String index(@PageableDefault(value = 2) Pageable pageable,Model model) {
        Page<Blog> blogList = blogService.findAll(pageable);
        model.addAttribute("blogList", blogList);
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("catagorys",categoryService.findAll());
        model.addAttribute("blog", new Blog());
        return "/create";
    }

    @PostMapping("/save")
    public String save(Blog blog) {
        blogService.save(blog);
        return "redirect:/";
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("catagorys",categoryService.findAll());
        model.addAttribute("blog", blogService.findById(id));
        return "edit";
    }

    @GetMapping("{id}/view")
    public String view(@PathVariable Integer id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "view";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Integer id) {
        blogService.deleteById(id);
        return "redirect:/";
    }
}

