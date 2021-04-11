package com.product_session_10.controller;

import com.product_session_10.model.Cart;
import com.product_session_10.model.Product;
import com.product_session_10.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes("cart")
public class ProductController {

    @ModelAttribute("cart")
    public Cart setUpCart(){
        return new Cart();
    }

    @Autowired
    ProductService productService;

    @GetMapping("")
    public String getPageHome(Model model) {
        List<Product> productList = productService.findAll();
        model.addAttribute("productList", productList);
        return "home";
    }

    @GetMapping("view/{id}")
    public String view(@PathVariable  Integer id,Model model) {
        model.addAttribute("product",productService.findById(id));
        return "/view";
    }
    @PostMapping("/add")
    public String addToCart(@RequestParam  Integer id, Model model, @ModelAttribute("cart") Cart cart){
        Product product = productService.findById(id);
        cart.addToCart(product);
        model.addAttribute("product", product);
        model.addAttribute("message", "Bạn đã add thành công !");
        return "view";
    }
    @GetMapping("/cart")
    public String getCartPage(@ModelAttribute("cart") Cart cart, Model model){
        Map<Product, Integer>cartProduct = cart.getCart();
        model.addAttribute("cartProduct", cartProduct);
        return "cart";
    }
    @GetMapping("/cart/delete/{id}")
    public String removeItem(@ModelAttribute("cart") Cart cart, @PathVariable("id") Integer id){
        cart.removeProduct(productService.findById(id));
        return "redirect:/cart";
    }
}
