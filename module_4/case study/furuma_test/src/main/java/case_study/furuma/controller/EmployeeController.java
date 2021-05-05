package case_study.furuma.controller;

import case_study.furuma.model.customer.Customer;
import case_study.furuma.model.employee.Employee;
import case_study.furuma.serrvices.employee.DivisionService;
import case_study.furuma.serrvices.employee.EducationDegreeService;
import case_study.furuma.serrvices.employee.EmployeeService;
import case_study.furuma.serrvices.employee.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping({"/employee"})
public class EmployeeController {
    @Autowired
    DivisionService divisionService;
    @Autowired
    PositionService positionService;
    @Autowired
    EducationDegreeService educationDegreeService;
    @Autowired
    EmployeeService employeeService;

    @GetMapping("")
    public String index(@PageableDefault(value = 3) Pageable pageable, Model model) {
        Page<Employee> employees = employeeService.sort(pageable);
        model.addAttribute("employees", employees);
        return "employee/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("divisions",divisionService.findAll());
        model.addAttribute("positions",positionService.findAll());
        model.addAttribute("educationDegrees",educationDegreeService.findAll());
        model.addAttribute("employees", new Employee());
        return "employee/create";
    }
    @PostMapping("/save")
    public String save(Employee employee) {
        employeeService.save(employee);
        return "redirect:/employee";
    }
    @GetMapping("{id}/edit")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("divisions",divisionService.findAll());
        model.addAttribute("positions",positionService.findAll());
        model.addAttribute("educationDegrees",educationDegreeService.findAll());
        model.addAttribute("employees", employeeService.findById(id));
        return "employee/edit";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam Integer id) {
        employeeService.deleteById(id);
        return "redirect:/employee";
    }
    @GetMapping("/search")
    public String searchByName(@PageableDefault(value = 2)Pageable pageable, @RequestParam String name, Model model){
        Page<Employee>employees=employeeService.findByName(name,pageable);
        model.addAttribute("employees", employees);
        return "employee/index";
    }
}
