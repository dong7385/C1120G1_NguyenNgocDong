package com.example.customer_manager.controller;

import com.example.customer_manager.model.Customer;
import com.example.customer_manager.service.CustomerService;
import com.example.customer_manager.service.ProvinceService;
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

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @Autowired
    ProvinceService provinceService;
@GetMapping("/search")
    public String searchByName(@PageableDefault(value = 2)Pageable pageable, @RequestParam String name, Model model){
        Page<Customer>customerList=customerService.searchByName(name,pageable);
        model.addAttribute("customerList", customerList);
        return "index";
    }

    @GetMapping
    public String index(@PageableDefault(value = 2) Pageable pageable, Model model) {
        Page<Customer> customerList = customerService.findAll(pageable);
        model.addAttribute("customerList", customerList);
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("provinces",provinceService.findAll());
        model.addAttribute("customer", new Customer());
        return "/create";
    }

    @PostMapping("/save")
    public String save(Customer customer) {
        customerService.save(customer);
        return "redirect:/";
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("provinces",provinceService.findAll());
        model.addAttribute("customer", customerService.findById(id));
        return "edit";
    }

//    @PostMapping("/update")
//    public String update(Customer customer) {
//        customerService.save(customer);
//        return "redirect:/";
//    }

    @GetMapping("{id}/view")
    public String view(@PathVariable Long id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "view";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Long id) {
        customerService.deleteById(id);
        return "redirect:/";
    }
}
