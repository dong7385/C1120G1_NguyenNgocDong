package com.test_module_4.controller;

import com.test_module_4.model.blog.Blog;
import com.test_module_4.model.request.Product;
import com.test_module_4.model.request.ProductType;
import com.test_module_4.model.request.Request;
import com.test_module_4.service.request.ProductService;
import com.test_module_4.service.request.ProductTypeService;
import com.test_module_4.service.request.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/request")
public class RequestController {
    @Autowired
    RequestService requestService;
    @Autowired
    ProductService productService;
    @Autowired
    ProductTypeService productTypeService;

    @GetMapping("")
    public String index(@PageableDefault(value = 2) Pageable pageable, Model model) {
        Page<Request> requests = requestService.findAll(pageable);
        model.addAttribute("request", requests);

        return "request/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("productTypes", productTypeService.findAll());
        model.addAttribute("products", productService.findAll());
        model.addAttribute("request", new Request());
        return "request/create";
    }

    @PostMapping("/save")
    public String save(Request request) {
        requestService.save(request);
        return "redirect:/request/";
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("productTypes", productTypeService.findAll());
        model.addAttribute("products", productService.findAll());
        model.addAttribute("request", requestService.findById(id));
        return "request/edit";
    }

    @GetMapping("/search")
    public String searchByName(@PageableDefault(value = 2) Pageable pageable,
                               @RequestParam(name = "start") String startDate,
                               @RequestParam(name = "end") String endDate,
                               Model model) {
        Page<Request> requests = requestService.searchByDate(startDate, endDate, pageable);
        if (requests.isEmpty()) {
            model.addAttribute("request", requestService.findAll(pageable));
        } else {
            model.addAttribute("request", requests);
        }
        return "request/index";
    }

    @GetMapping("/top")
    public String searchByTop(@RequestParam(name = "top") Integer top,
                              Model model) {
        List<Request> requests = requestService.searchByTop(top);
        if (requests.isEmpty()) {
            model.addAttribute("request", requestService.findAll());
        } else {
            model.addAttribute("request", requests);
        }
        return "request/top";
    }
}
