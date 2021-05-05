package com.example.spring_security.controller;

import com.example.spring_security.model.Blog;
import com.example.spring_security.service.BlogService;
import com.example.spring_security.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping({"","/blog"})
public class BlogController {
    @Autowired
    BlogService blogService;
    @Autowired
    CategoryService categoryService;
    @GetMapping("/search")
    public String searchByName(@PageableDefault(value = 2)Pageable pageable, @RequestParam String name, Model model){
        Page<Blog>blogList=blogService.searchByName(name,pageable);
        model.addAttribute("blogList", blogList);
        return "blog/index";
    }

    @GetMapping("")
    public String index(@PageableDefault(value = 5) Pageable pageable,Model model) {
        Page<Blog> blogList = blogService.sort(pageable);
        model.addAttribute("blogList", blogList);
        return "blog/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("catagorys",categoryService.findAll());
        model.addAttribute("blog", new Blog());
        return "blog/create";
    }

    @PostMapping("/save")
    public String save(Blog blog) {
        blogService.save(blog);
        return "redirect:/blog";
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("catagorys",categoryService.findAll());
        model.addAttribute("blog", blogService.findById(id));
        return "blog/edit";
    }

    @GetMapping("{id}/view")
    public String view(@PathVariable Integer id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "blog/view";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Integer id) {
        blogService.deleteById(id);
        return "redirect:/blog";
    }
}

