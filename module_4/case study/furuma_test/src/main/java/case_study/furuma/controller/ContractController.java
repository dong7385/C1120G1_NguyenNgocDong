package case_study.furuma.controller;

import case_study.furuma.model.contract.Contract;
import case_study.furuma.serrvices.contract.ContractService;
import case_study.furuma.serrvices.customer.CustomerService;
import case_study.furuma.serrvices.employee.EmployeeService;
import case_study.furuma.serrvices.service.ServiceFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping({"/contract"})
public class ContractController {
    @Autowired
    ContractService contractService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    CustomerService customerService;
    @Autowired
    ServiceFService serviceFService;

    @GetMapping("")
    public String index(@PageableDefault(value = 5) Pageable pageable, Model model) {
        Page<Contract> contracts = contractService.findAll(pageable);
        model.addAttribute("contracts", contracts);
        return "contract/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("customers", customerService.findAll());
        model.addAttribute("employees", employeeService.findAll());
        model.addAttribute("services", serviceFService.findAll());
        model.addAttribute("contract", new Contract());
        return "contract/create";
    }

    @PostMapping("/save")
    public String save(@Validated @ModelAttribute("contract") Contract contract, BindingResult bindingResult, Model model) {
        contract.validate(contract, bindingResult);
        if(bindingResult.hasFieldErrors()){
            model.addAttribute("customers", customerService.findAll());
            model.addAttribute("employees", employeeService.findAll());
            model.addAttribute("services", serviceFService.findAll());
            model.addAttribute("contract", contract);
            return "contract/create";
        }
        contractService.save(contract);
        return "redirect:/contract";
    }
    @GetMapping("{id}/edit")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("customers", customerService.findAll());
        model.addAttribute("employees", employeeService.findAll());
        model.addAttribute("services", serviceFService.findAll());
        model.addAttribute("contracts", contractService.findById(id));
        return "contract/edit";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Integer id) {
        contractService.deleteById(id);
        return "redirect:/contract/";
    }


}
