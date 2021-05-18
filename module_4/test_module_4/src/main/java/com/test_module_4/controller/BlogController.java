package com.test_module_4.controller;

import com.test_module_4.model.blog.Blog;
import com.test_module_4.service.blog.BlogService;
import com.test_module_4.service.blog.CategoryService;
import com.test_module_4.service.blog.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    BlogService blogService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    UserService userService;

    @GetMapping("")
    public String index(@PageableDefault(value = 2) Pageable pageable, Model model) {
        Page<Blog> blogs = blogService.findByOrderByBlogTitle(pageable);
        model.addAttribute("blogs", blogs);
        return "blog/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("categorys", categoryService.findAll());
        model.addAttribute("users", userService.findAll());
        model.addAttribute("blogs", new Blog());
        return "blog/create";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute(name = "blog") Blog blog, BindingResult bindingResult, Model model) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("categorys", categoryService.findAll());
            model.addAttribute("users", userService.findAll());
            model.addAttribute("blogs", blog);
            return "blog/create";
        }
        blogService.save(blog);
        return "redirect:/blog/";
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("categorys", categoryService.findAll());
        model.addAttribute("users", userService.findAll());
        model.addAttribute("blogs", blogService.findById(id));
        return "blog/edit";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Integer id) {
        blogService.deleteById(id);
        return "redirect:/blog/";
    }

    @GetMapping("/search")
    public String searchByName(@PageableDefault(value = 2) Pageable pageable, @RequestParam String name, Model model) {
        Page<Blog> blogs = blogService.findByTitleAndQuestions(name, pageable);
        if (blogs.isEmpty()) {
            model.addAttribute("blogs", blogService.findAll(pageable));
        } else {
            model.addAttribute("blogs", blogs);
            model.addAttribute("name", name);
        }
        return "blog/index";
    }
}
