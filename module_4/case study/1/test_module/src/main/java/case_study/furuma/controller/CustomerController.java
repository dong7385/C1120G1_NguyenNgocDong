package case_study.furuma.controller;

import case_study.furuma.model.customer.Customer;
import case_study.furuma.serrvice.customer.CustomerService;
import case_study.furuma.serrvice.customer.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping({"/customer"})
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @Autowired
    CustomerTypeService customerTypeService;

    @GetMapping("")
    public String index(@PageableDefault(value = 5) Pageable pageable, Model model) {
        Page<Customer> customers = customerService.findByOrderByCustomerName(pageable);
        model.addAttribute("customers", customers);
        return "customer/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("customerTypes",customerTypeService.findAll());
        model.addAttribute("customer", new Customer());
        return "customer/create";
    }
    @PostMapping("/save")
    public String save(Customer customer) {
        customerService.save(customer);
        return "redirect:/customer";
    }
    @GetMapping("{id}/edit")
    public String edit(@PathVariable String id, Model model) {
        model.addAttribute("customerTypes",customerTypeService.findAll());
        model.addAttribute("customer", customerService.findById(id));
        return "customer/edit";
    }

    @GetMapping("{id}/view")
    public String view(@PathVariable String id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "customer/view";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam String id) {
        customerService.deleteById(id);
        return "redirect:/customer";
    }
    @GetMapping("/search")
    public String searchByName(@PageableDefault(value = 2)Pageable pageable, @RequestParam String name, Model model){
        Page<Customer>customers=customerService.findAllByCustomerNameContaining(name,pageable);
        model.addAttribute("customers", customers);
        return "customer/index";
    }
}
