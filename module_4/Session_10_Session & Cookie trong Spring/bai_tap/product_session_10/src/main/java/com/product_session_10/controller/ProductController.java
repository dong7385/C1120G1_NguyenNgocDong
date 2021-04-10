package com.product_session_10.controller;

import com.product_session_10.model.Product;
import com.product_session_10.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;
@GetMapping
    public String getPageHome(Model model){
    List<Product>productList=productService.findAll();
    model.addAttribute("productList",productList);
    return "home";
    }
}
