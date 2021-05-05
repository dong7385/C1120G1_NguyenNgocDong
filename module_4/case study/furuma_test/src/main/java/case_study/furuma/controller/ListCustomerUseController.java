package case_study.furuma.controller;

import case_study.furuma.model.contract.Contract;

import case_study.furuma.serrvices.contract.AttachServiceService;
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
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping({"/use_customer"})
public class ListCustomerUseController {
    @Autowired
    ContractService contractService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    CustomerService customerService;
    @Autowired
    ServiceFService serviceFService;
    @Autowired
    AttachServiceService attachServiceService;

    @GetMapping("")
    public String index(@PageableDefault(value = 5) Pageable pageable, Model model) {
        String inputDay = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        Page<Contract> listCustomerUse = contractService.getClientEndStart(inputDay, pageable);
        model.addAttribute("listCustomerUse", listCustomerUse);
        return "use_customer/index";
    }
}
