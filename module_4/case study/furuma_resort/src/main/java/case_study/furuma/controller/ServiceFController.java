package case_study.furuma.controller;

import case_study.furuma.model.service.ServiceF;
import case_study.furuma.serrvices.service.RentTypeService;
import case_study.furuma.serrvices.service.ServiceFService;
import case_study.furuma.serrvices.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping({"/service"})
public class ServiceFController {
    @Autowired
    RentTypeService rentTypeService;
    @Autowired
    ServiceTypeService serviceTypeService;
    @Autowired
    ServiceFService serviceFService;

    @GetMapping("")
    public String index( Model model) {
        List<ServiceF> serviceFS = serviceFService.findAll();
        model.addAttribute("serviceFS", serviceFS);
        return "service/index";
    }
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("serviceTypes",serviceTypeService.findAll());
        model.addAttribute("rentTypes",rentTypeService.findAll());
        model.addAttribute("serviceFs", new ServiceF());
        return "service/create";
    }
    @PostMapping("/save")
    public String save(ServiceF serviceF) {
        serviceFService.save(serviceF);
        return "redirect:/service";
    }
    @GetMapping("{id}/edit")
    public String edit( @PathVariable String id,Model model) {
        model.addAttribute("serviceTypes",serviceTypeService.findAll());
        model.addAttribute("rentTypes",rentTypeService.findAll());
        model.addAttribute("serviceFs",serviceFService.findById(id) );
        return "service/edit";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam String id) {
        serviceFService.deleteById(id);
        return "redirect:/service";
    }
}
